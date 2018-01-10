package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.StudentModel;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




/**
 * Servlet implementation class RegisterServlet
@WebServlet(value="/StudentRegisterServlet")
*/

public class StudentRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
    public StudentRegisterServlet() {
        super();
    }*/
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentRegisterDB");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	int count = 1;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String fname,lname,BirthDate,email,address,PostalCode,City,details,Gender,Restriction,Password;
	    long Carecard,phone,emergency;
	    int FarsiGrade;
	    HttpSession session;
	    session=null;
	    
	    
		request.setCharacterEncoding("UTF8");
		response.setCharacterEncoding("UTF-8");
//		hidden=request.getParameter("ini");
		session=request.getSession();
		
/*		
		Date now = new Date();
		SimpleDateFormat sdf = null;
		DateFormat locale = DateFormat.getDateInstance();
        sdf = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM);
        String t = locale.toString();
        t = sdf.format("MMM d, yyyy HH:mm a");
        System.out.println(t);
*/
		
		Date d1 = new Date();
//	    SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY HH:mm a");
	    SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy HH:mm a");
	    String formattedDate = df.format(d1);


		    StringBuffer sb = new StringBuffer();
			    
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
						        	 String str=String.format("Student ID: "+std.getId()+"@\n Submitted Date: "+formattedDate +"\n Please save the student ID \nfor future references");
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
				    	}
				    }	
			  }	    
    	session.setMaxInactiveInterval(20*60);
	}
}
