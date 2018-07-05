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

import Model.StudentCourses;
import Model.StudentModel;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




/**
 * Servlet implementation class RegisterServlet
@WebServlet(value="/StudentCoursesServlet")
*/

public class StudentCoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
    public StudentCoursesServlet() {
        super();
    }*/
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentCourses");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	int count = 1;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String fname,lname,BirthDate,email,address,PostalCode,City,details,Gender,Restriction,Password;
	    long id,Carecard,phone,emergency;
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


			    	id = Long.parseLong(request.getParameter("userid").toString());
			    	fname = request.getParameter("userid").toString();
	/*			    lname = (String) joUser.get("Family");
				    FarsiGrade = Integer.parseInt((String)joUser.get("FarsiGrade"));
				    details = (String) joUser.get("Details");
				    Restriction = (String) joUser.get("Restriction");
				    Gender = (String) joUser.get("sex");
				    
				    StudentCourses Std_Crs=new StudentCourses();
		
				    Std_Crs.f1_setStdID(id);
				    Std_Crs.f2_setName(fname);
				    Std_Crs.f3_setFamily(lname);
				    Std_Crs.f4_setClassLevel(FarsiGrade);
				    Std_Crs.setRestriction(Restriction);
				    Std_Crs.setDetails(details);
				    Std_Crs.setDateTime(formattedDate); 
		    
		*/		    
				    if ((session.getAttribute("recordInsertedPermission") == null )||(session.getAttribute("recordInsertedPermission") == "true" ))
				    {
				    	Query query = em.createNativeQuery("SELECT COUNT(*) FROM StudentModel WHERE Carecard = :id ");
//				    	query.setParameter("id", Carecard);
				    	int res = Integer.parseInt(query.getSingleResult().toString());
		
				    	//int res = query.executeUpdate();
				    	//Query q = em.createNativeQuery("SELECT StudentModel.Fname, StudentModel.Lname FROM StudentModel WHERE StudentModel.Carecard = :id");
				    	System.out.println("COUNT(*) FROM StudentModel = "+ res);
				    	
				    	if(res>0){
					        try{
						    	 query = em.createNativeQuery("SELECT Std_ID FROM StudentModel WHERE Carecard = :id ");
//						    	 query.setParameter("id", Carecard);
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
	//					    em.persist(Std_Crs);
						    em.flush();
						    em.clear();
						    tx.commit();
						    
						       session.setAttribute("recordInsertedPermission","false");
						    	System.out.println("Success, Values inserted = ");
						        try{
//						        	 String str=String.format("Student ID: "+Std_Crs.f1_getStdID()+"@\n Submitted Date: "+formattedDate +"\n Please save the student ID \nfor future references");
//						             String json = new Gson().toJson(str);
						             response.setContentType("application/json");
//						             response.getWriter().write(json);
						          }
						          catch (Exception e) {
						             e.printStackTrace();
						             String json = new Gson().toJson("failed!");
						             response.setContentType("application/json");
						             response.getWriter().write(json);
						          }
				    	}
				    }	
			     
    	session.setMaxInactiveInterval(20*60);
	}
}
