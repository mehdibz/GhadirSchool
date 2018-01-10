package Controller;

import java.io.*;
import javax.persistence.EntityManager;
import javax.servlet.*;
import javax.servlet.http.*;


import Model.StudentModel;

public class LoginServlet extends HttpServlet{ 

	private static final long serialVersionUID = 1L;

	StudentModel std;
	EntityManager em;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

	  response.setContentType("application/json");
	  String username="",userpass="";
	  HttpSession session = request.getSession(true);
	
	  try {
		  if(request.getParameter("userid")!=null && request.getParameter("pass")!=null)
		  	{
			  username = request.getParameter("userid").toString();
			  userpass = request.getParameter("pass").toString();
			  transaction em = new transaction();
		      std = em.doRead(username);
		      if(std!=null){
				  if (std.getPassword().equals(userpass)){
					  	
				    	request.getSession().setAttribute("UserValidation", "Valid");
						session.setMaxInactiveInterval(10*60);
						
				        try{
					             request.getSession().setAttribute("StdId",std.getId());
					             request.getRequestDispatcher("StudentProfileServlet").forward(request, response);
				          }
				          catch (Exception e) {
					             e.printStackTrace();
				          } 
				  }  
				  else
				  {
				      std=null;
				      request.getSession().setAttribute("UserValidation", "Unknown");
					  request.getSession().setAttribute("msg","Student ID or Password is wrong !");
					  response.sendRedirect("login.jsp");
				  }
		      }
		      else{
			      request.getSession().setAttribute("UserValidation", "Unknown");
				  request.getSession().setAttribute("msg","Student ID or Password is wrong !");
		    	  response.sendRedirect("login.jsp");
		      }
			}
		  	else
		  	{
			    request.getSession().setAttribute("UserValidation", "Unknown");
		  		request.getSession().setAttribute("msg","Please fill the fields !");
		  		response.sendRedirect("login.jsp");
		  	}

	  } catch (Exception e) {
	  e.printStackTrace();
	  }
  }
}

/*
try{
   //    response.sendRedirect("StudentProfile.jsp");	
         request.setAttribute("StdId",std.getId());
         request.getRequestDispatcher("StudentProfileServlet").forward(request, response);
          //	 String json = new Gson().toJson(str);
		
		JsonObject json=Json.createObjectBuilder()
           .add("id", std.getId())
           .build();

		response.setContentType("application/json"); 
		//response.getWriter().write(json);
		PrintWriter out = response.getWriter();
	
		out.print(json);
		out.flush(); 
  }
  catch (Exception e) {
         e.printStackTrace();
         String json = new Gson().toJson("failed!");
         response.setContentType("application/json");
         response.getWriter().write(json);
  }*/
//=========================================================================================
//=========================================================================================

//}
//else
//{

/*		    StringBuffer sb = new StringBuffer();
  
  try 
  {
    BufferedReader reader = request.getReader();
    String line = null;
    while ((line = reader.readLine()) != null)
    {
      sb.append(line);
    }
  } catch (Exception e) { e.printStackTrace(); }
  
  JSONParser parser = new JSONParser();
  JSONObject joUser = null;
  try
  {
    joUser = (JSONObject) parser.parse(sb.toString());
  } catch (ParseException e) { e.printStackTrace(); }

  if((joUser.get("ReSubPermission").toString()).equals("OK"))
  {
  	session.setAttribute("recordInsertedPermission","true");

  }else if(((joUser.get("ReSubPermission").toString()).equals("false"))&&(session.getAttribute("recordInsertedPermission")!="true")){
  	
  	
      try {
           String json = new Gson().toJson("Proccess failed! Continue by New Form");
           response.setContentType("application/json");
           response.getWriter().write(json);
        }
        catch (Exception e) {
           e.printStackTrace();
           String json = new Gson().toJson("Application failed!");
           response.setContentType("application/json");
           response.getWriter().write(json);
        }
  }
  else
  {

  	fname = (String) joUser.get("Name");
	    lname = (String) joUser.get("Family");
	    BirthDate = ((String) joUser.get("MonthSelected")) +","+((String) joUser.get("DaysSelected")) +","+ ((String) joUser.get("YearSelected")) ;
	    Carecard = Long.parseLong((String) joUser.get("CareCardNo"));
	    email = (String) joUser.get("Primary_Email");
	    PostalCode = (String) joUser.get("PostalCode");
	    City = (String) joUser.get("City");
	    FarsiGrade = Integer.parseInt((String)joUser.get("FarsiGrade"));
	    phone = Long.parseLong((String) joUser.get("Primary_Phone"));
	    emergency = Long.parseLong((String) joUser.get("Emergency_Phone"));
	    address = (String) joUser.get("Address");
	    Password = (String) joUser.get("Password");
	    details = (String) joUser.get("Details");
	    Restriction = (String) joUser.get("Restriction");
	    Gender = (String) joUser.get("sex");
	    
	    StudentModel std=new StudentModel();

	    std.setFname(fname);
	    std.setLname(lname);
	    std.setBirthDate(BirthDate);
	    std.setCarecard(Carecard);
	    std.setPostalCode(PostalCode);
	    std.setCity(City);
	    std.setFarsiGrade(FarsiGrade);
	    std.setEmail(email);
	    std.setPhone(phone);
	    std.setEmergency(emergency);
	    std.setAddress(address);
	    std.setRestriction(Restriction);
	    std.setGender(Gender);
	    std.setDetails(details);
	    std.setPassword(Password);
	    std.setDateTime(formattedDate); 

	    
	    if ((session.getAttribute("recordInsertedPermission") == null )||(session.getAttribute("recordInsertedPermission") == "true" ))
	    {
	    	Query query = em.createNativeQuery("SELECT COUNT(*) FROM StudentModel WHERE Carecard = :id ");
	    	query.setParameter("id", Carecard);
	    	int res = Integer.parseInt(query.getSingleResult().toString());

	    	//int res = query.executeUpdate();
	    	//Query q = em.createNativeQuery("SELECT StudentModel.Fname, StudentModel.Lname FROM StudentModel WHERE StudentModel.Carecard = :id");
	    	System.out.println("COUNT(*) FROM StudentModel = "+ res);
	    	
	    	if(res>0){
		        try{
			    	 query = em.createNativeQuery("SELECT Std_ID FROM StudentModel WHERE Carecard = :id ");
			    	 query.setParameter("id", Carecard);
		        	 String json = new Gson().toJson("duplicate!@" + query.getSingleResult().toString());
		             response.setContentType("application/json");
		             response.getWriter().write(json);
		          }
		          catch (Exception e) {
		             e.printStackTrace();
		             String json = new Gson().toJson("failed!");
		             response.setContentType("application/json");
		             response.getWriter().write(json);
		          }
	    	}
	    	else{
		    	tx.begin();
			    em.persist(std);
			    em.flush();
			    em.clear();
			    tx.commit();
			    
			       session.setAttribute("recordInsertedPermission","false");
			    	System.out.println("Success, Values inserted = ");
			        try{
			        	 String str=String.format("Student ID: "+std.getId()+"@ Submitted Date: "+formattedDate +  "\n Please save the Student Id for future use");
			             String json = new Gson().toJson(str);
			             response.setContentType("application/json");
			             response.getWriter().write(json);
			          }
			          catch (Exception e) {
			             e.printStackTrace();
			             String json = new Gson().toJson("failed!");
			             response.setContentType("application/json");
			             response.getWriter().write(json);
			          }
			          
		                		
	JsonObject json=Json.createObjectBuilder()
          .add("id", std.getId())
          .add("name", std.getFname())
          .add("family", std.getLname())		
          .build(); */
	
 //  PrintWriter out = response.getWriter();
 //  response.setContentType("application/json");

//  out.print(page);
//  out.flush();	 
//}	
