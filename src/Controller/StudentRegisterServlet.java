package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB_Connection.DB_Connection;
import Model.StudentModel;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/StudentRegisterServlet")

public class StudentRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String userID,query,fname,lname,BirthDate,email,phone,emergency,address,details;
		request.setCharacterEncoding("UTF8");
	    
		userID= request.getParameter("userid"); 
		fname = request.getParameter("Name");
		lname = request.getParameter("Family");    
		BirthDate = request.getParameter("BirthDate");
		email = request.getParameter("Primary_Email");
		phone = request.getParameter("Primary_Phone");
	    emergency = request.getParameter("Emergency_Contact");
	    address = request.getParameter("Address");
	    details = request.getParameter("Details");
	    
	    
	    StudentModel m=new StudentModel();
	    
	    m.setUserid(userID);
	    m.setFname(fname);
	    m.setLname(lname);
	    m.setBirthDate(BirthDate);
	    m.setEmail(email);
	    m.setEmergency(emergency);
	    m.setPhone(phone);
	    m.setAddress(address);
	    m.setDetails(details);
	    
	    //query="insert into student(Id, Name, Family, BirthDate, Primary_Email, Primary_Phone, Emergency_Contact, Address, Others) values ('" + userID + "','" + fname + "','" + lname + "','" + BirthDate + "','" + email +"','"+ phone +"','"+ emergency +"','"+ address +"','"+ Others +"' )";
	    query="insert into teachers values(?,?,?,?,?,?,?,?,?)";
	    int i = DB_Connection.StudentRegister(m,query);
	    
	    if(i!=0)
	    {
	    	System.out.println("Success, Values inserted");
	    }else
	    {
	    	System.out.println("Error, Values not inserted");
	    }

	}

}
