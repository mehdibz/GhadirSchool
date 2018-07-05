
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

import Model.VolunteerModel;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




/**
 * Servlet implementation class RegisterServlet
@WebServlet(value="/VolunteerRegisterServlet")
*/

public class VolunteerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
    public StudentRegisterServlet() {
        super();
    }*/
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("VolunteerRegisterDB");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String fname,lname,BirthDate,email,address,PostalCode,City,Gender,Restriction,Password,hidden,Resume;
	    long phone;

	    HttpSession session;
	    session=null;
	    
	    
		request.setCharacterEncoding("UTF8");
		response.setCharacterEncoding("UTF-8");
		hidden=request.getParameter("ini");
		session=request.getSession();
	    
	    Date d1 = new Date();
	    SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY HH:mm a");
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
	    	//userid = (String) joUser.get("userid");
	    	fname = (String) joUser.get("Name");
		    lname = (String) joUser.get("Family");
		    BirthDate = ((String) joUser.get("MonthSelected")) +","+((String) joUser.get("DaysSelected")) +","+ ((String) joUser.get("YearSelected")) ;
		    email = (String) joUser.get("Primary_Email");
		    PostalCode = (String) joUser.get("PostalCode");
		    City = (String) joUser.get("City");
		    phone = Long.parseLong((String) joUser.get("Primary_Phone"));
		    address = (String) joUser.get("Address");
		    Password = (String) joUser.get("Password");
		    Resume = (String) joUser.get("Details");
		    Restriction = (String) joUser.get("Restriction");
		    Gender = (String) joUser.get("sex");
		    
		    VolunteerModel volunteer=new VolunteerModel();

		    volunteer.setFname(fname);
		    volunteer.setLname(lname);
		    volunteer.setBirthDate(BirthDate);
		    volunteer.setPostalCode(PostalCode);
		    volunteer.setCity(City);
		    volunteer.setEmail(email);
		    volunteer.setPhone(phone);
		    volunteer.setAddress(address);
		    volunteer.setGender(Gender);
		    volunteer.setResume(Resume);
		    volunteer.setPassword(Password);
		    volunteer.setSubmittedDate(formattedDate); 
    
		    
		    if ((session.getAttribute("recordInsertedPermission") == null )||(session.getAttribute("recordInsertedPermission") == "true" ))
		    {
		    	Query query = em.createNativeQuery("SELECT COUNT(*) FROM VolunteerModel WHERE Email = :id ");
		    	query.setParameter("id", email);
		    	int res = Integer.parseInt(query.getSingleResult().toString());

		    	//int res = query.executeUpdate();
		    	//Query q = em.createNativeQuery("SELECT StudentModel.Fname, StudentModel.Lname FROM StudentModel WHERE StudentModel.Carecard = :id");
		    	System.out.println("COUNT(*) FROM VolunteerModel = "+ res);
		    	
		    	if(res>0){
			        try{
			             String json = new Gson().toJson("duplicate!");
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
				    em.persist(volunteer);
				    em.flush();
				    em.clear();
				    tx.commit();
				    
				       session.setAttribute("recordInsertedPermission","false");
				    	System.out.println("Success, Values inserted = ");
				        try{
				        	 String str=String.format("Volunteer ID: "+volunteer.getUserid()+"@ Submited Date: "+formattedDate);
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








/*
public class VolunteerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
/*	EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentRegisterDB");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String userID,query,fname,lname,email,phone,details,pass,authority,farsi,religion,quran,salat;
	    
		request.setCharacterEncoding("UTF8");
	    
		userID= request.getParameter("userid"); 
		fname = request.getParameter("Name");
		lname = request.getParameter("Family");
		phone = request.getParameter("Phone");
		email = request.getParameter("Email");
		pass = request.getParameter("Pass");    
		authority = request.getParameter("Authority");    
		farsi = request.getParameter("Farsi");    
		religion = request.getParameter("Religion");    
		quran = request.getParameter("Quran");    
		salat = request.getParameter("Salat");    
		details = request.getParameter("Details");
	    
	    
	    VolunteerModel m=new VolunteerModel();
	    
	    m.setUserid(userID);
	    m.setFname(fname);
	    m.setLname(lname);
	    m.setPhone(phone);
	    m.setEmail(email);
	    m.setPass(pass);
	    m.setAuthority(authority);
	    m.setFarsi(farsi);
	    m.setReligion(religion);
	    m.setQuran(quran);
	    m.setSalat(salat);
	    m.setDetails(details);
	    
	    //query="insert into teachers(ID, Name, Family, Phone, Email, Password, Authority, Farsi, Religion, Quran, Salat, Details) values ('" + userID + "','" + fname + "','" + lname + "','" + email +"','"+ phone +"','"+ details +"' )";
	    query="insert into teachers values(?,?,?,?,?,?,?,?,?,?,?,?)";
	    int i = DB_Connection.TeacherRegister(m,query);
	    
	    if(i!=0)
	    {
	    	System.out.println("Success, Values inserted");
	    }else
	    {
	    	System.out.println("Error, Values not inserted");
	    }

	}

}
*/