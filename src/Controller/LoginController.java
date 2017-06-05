package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB_Connection.DB_Connection;

/**
 * Servlet implementation class ControllerProfile
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private int count;

	
	private Connection con=DB_Connection.db_connection();
	 PrintWriter out;
	 ResultSet rs0;
	 HttpSession session;

	 private String checkUser,Loginmsg,hidden,Currentuser,uname,ItemSelected;
	 private String password,query;
	 String target;
	 PreparedStatement pstmt=null,pstmt2=null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setCharacterEncoding("UTF-8");
		 request.setCharacterEncoding("UTF-8");
		 
		 uname=request.getParameter("userid");
		 password=request.getParameter("pass");
		 hidden=request.getParameter("ini");
		 session=request.getSession();
	     response.setContentType("text/html");
	     count=0; 
	     try{
	          Statement s = con.createStatement();
	          query="select * from teachers where ID='"+uname+"' and Password='"+password+"'";
	          s.executeQuery (query);
	      
	          rs0 = s.getResultSet();
	          while (rs0.next ())
	          {
	        	  count+=2;
	          }
	          checkUser=request.getSession().getAttribute("currentUser").toString();
	     }
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
	    	 //response.sendRedirect("login.jsp");
	     }
     
		if((count>1)||checkUser==Currentuser)
		{	
			Currentuser="Valid";
			session.setAttribute("currentUser", Currentuser);
			session.setMaxInactiveInterval(20*60);
			count=0;
			
			if(hidden.equals("LoginPage"))
			{
				try 
				{
					ItemSelected=request.getSession().getAttribute("ItemChoose").toString();
					switch(ItemSelected){
						case  "StdInfoEdit": target="View.jsp";
							break;
						case  "NewStd":		 target="StudentReg.jsp";
							break;
						case  "EnScore":	 target="ToolPage.jsp";
							break;
						case  "RepPrint":	 target="Profile.jsp";
							break;
						case  "ToolPage":	 target="ToolPage.jsp";
							break;
						default: 			 target="MainPage.jsp";
					}
					response.sendRedirect(target);
					//request.getRequestDispatcher(target).forward(request, response);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
					//out.println("خطا ! <br> کد کاربری و یا رمز ورود اشتباه است"+"-"+request.getSession().getAttribute("result"));
					destroy();
				}		
			}
			if(hidden.equals("ToolPage"))
			{
				try 
				{
					response.sendRedirect("ToolPage.jsp");
					request.getRequestDispatcher("ToolPage.jsp").forward(request, response);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
					response.sendRedirect("login.jsp");
					destroy();
				}		
			}
			if(hidden.equals("Profile"))
			{
				try 
				{
					response.sendRedirect("Profile.jsp");
					request.getRequestDispatcher("Profile.jsp").forward(request, response);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
					response.sendRedirect("login.jsp");
					destroy();
				}		
			}
			if(hidden.equals("NewStd"))
			{
				try 
				{
					response.sendRedirect("StudentReg.jsp");
					request.getRequestDispatcher("StudentReg.jsp").forward(request, response);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
					response.sendRedirect("login.jsp");
					destroy();
				}		
			}
			if(hidden.equals("view"))
			{
				try 
				{
					response.sendRedirect("View.jsp");
					request.getRequestDispatcher("View.jsp").forward(request, response);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
					response.sendRedirect("login.jsp");
					destroy();
				}		
			}

			try
			{
				//con.close();
				//out.close();
				rs0.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				Loginmsg="error";
				request.getSession().setAttribute("lableMessage", Loginmsg);
				request.getSession().setAttribute("result", count);
				request.getRequestDispatcher("login.jsp").forward(request, response);
				destroy();
			}
			catch(Exception e)
			{
				response.sendRedirect("login.jsp");
				destroy();
			}
		}
	}
}

