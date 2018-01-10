package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

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
@WebServlet("/ControllerProfile")
public class ControllerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private int count;

	 PrintWriter out;
	 ResultSet rs0,rs2,rr;
	 HttpSession currectUserSession,session;
	 
	 
	 String checkUser,Loginmsg,hidden,Currentuser,F_Discipline;
	 String std_id,query,R_Discipline,Q_Discipline,S_Discipline;
	 PreparedStatement pstmt=null,pstmt2=null;
	 String report;
	 HttpServletRequest request;
	 HttpServletResponse response;
	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setCharacterEncoding("UTF-8");
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html");
		 out=response.getWriter();
		 
		 report="report_16_17_t2";
		 hidden=request.getParameter("ini");
		 session=request.getSession();
		 
		 try{
			 
			 checkUser=request.getSession().getAttribute("currentUser").toString();
			 Currentuser="Valid"; 
			 std_id=request.getParameter("std_name");
		 }
		 catch(Exception e)
		 {
			 Sent2Login();
		 }

		if(hidden.equals("ToolPage"))
		 {
			try 
			 {
			    	request.setAttribute("Result_Note",Discipline_show(std_id));
			    	request.getRequestDispatcher("ToolPage.jsp").forward(request, response);
			    	session.setAttribute("currentUser", Currentuser);
			    	session.setMaxInactiveInterval(20*60);
			    	
					//con.close();
					//out.close();
					rs2.close();
			 } 
			 catch (Exception e) 
			 {
			    e.printStackTrace();
				response.sendRedirect("login.jsp");
				destroy();
			 }		
			count=0;
			
			}
			else
			{
				Sent2Login();
			}
		
		
	}
public void Sent2Login(){
		try {

			request.getSession().setAttribute("currentUser", "inValid");
			response.sendRedirect("login.jsp");
			
			//request.getRequestDispatcher("login.jsp").forward(request, response);
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
	
}
public static BigDecimal round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);       
        return bd;
    }
public String Discipline_show(String std_id){
	float Fd = 0,Rd = 0,Qd = 0,Sd = 0,Total = 0;
	int i=0;
	String St = null;
	try
	{

		//PreparedStatement stat = DB_Connection.db_connection().prepareStatement("SELECT `F_Discipline`,`R_Discipline`,`Q_Discipline`,`S_Discipline`,`Discipline` FROM `report` where Student_ID=?");
		PreparedStatement stat = DB_Connection.db_connection().prepareStatement("SELECT `F_Discipline`,`R_Discipline`,`Q_Discipline`,`S_Discipline`,`Discipline` FROM `"+report+"` where Student_ID=?");
		stat.setString(1, std_id);
		rs2= stat.executeQuery();
		
		while(!(rs2.isLast())){
			if(rs2.next())
			{													
				F_Discipline=rs2.getString("F_Discipline");
				R_Discipline=rs2.getString("R_Discipline");
				Q_Discipline=rs2.getString("Q_Discipline");
				S_Discipline=rs2.getString("S_Discipline");
			}
		}
		i=0;
		if(F_Discipline!=null){
			Fd=Float.parseFloat(F_Discipline);
			i++;
		}
		if(R_Discipline!=null){
			Rd=Float.parseFloat(R_Discipline);
			i++;
		}
		if(Q_Discipline!=null){
			Qd=Float.parseFloat(Q_Discipline);
			i++;
		}
		if(S_Discipline!=null){
			Sd=Float.parseFloat(S_Discipline);
			i++;
		}
		Total=Fd+Rd+Qd+Sd;
		if(Total!=0){
			Total=Total/i;
		}
		St=new DecimalFormat("##.##").format(round(Total,2));
		query="update "+report+" set Discipline='"+St+"' where Student_ID='"+std_id+"'";
		PreparedStatement SecondStat = DB_Connection.db_connection().prepareStatement(query);
		SecondStat.executeUpdate(query);

	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	return St;
  }
}


/*

public class ControllerProfile extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if ((request.getParameter("accsub") != null)) {
            if (request.getParameter("accuser") != null) {
                Session session = null;

                SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
                session = sessionFactory.openSession();
                org.hibernate.Transaction tx = session.beginTransaction();


                String i = request.getParameter("accuser");
                String Q = " from BeanRegister where userid= :id ";
                Query query = session.createQuery(Q);
                query.setParameter("id", i);

                List<BeanRegister> profile = query.list();
                request.setAttribute("profile", profile);

                tx.commit();
                session.flush();
                session.close();

                RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
                dispatcher.forward(request, response);
            } else {
                System.out.println("error");

                RequestDispatcher dispatcher = request.getRequestDispatcher("viewprofile.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}*/