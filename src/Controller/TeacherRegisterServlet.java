package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DB_Connection.DB_Connection;
import Model.TeacherModel;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/TeacherRegisterServlet")

public class TeacherRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
	    
	    
	    TeacherModel m=new TeacherModel();
	    
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
