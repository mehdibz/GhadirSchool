package DB_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.*;

import Model.ReportModel;
import Model.StudentModel;
import Model.TeacherModel;

public class DB_Connection extends HttpServlet{

	static int i;
	static Connection con = null;
	static String User,Pass,URL;
	
	private static final long serialVersionUID = 1L;

	public static Connection db_connection(){
		Connection con = null;
		String User,Pass,URL;
			try
			{	
				//URL="jdbc:mysql://mysql18467-nexus.njs.jelastic.vps-host.net/user"; User="user"; Pass="ZWJx57ZfmFpq7r3A";
				//URL="jdbc:mysql://mysql18343-linux.njs.jelastic.vps-host.net/user"; User="user"; Pass="QGzZfmcZPee3cdJ6";
				
				URL="jdbc:mysql://localhost:3306/user"; User="root"; Pass="admin";
				//URL="jdbc:mysql://localhost:3306/test2"; User="root"; Pass="password";

				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(URL, User,Pass);

			}catch(Exception e)
			{
				
			}

			return con;
	 }
	
	public static int TeacherRegister(TeacherModel m,String sql) {
		i=0;
		Connection con=db_connection();
		
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, m.getUserid());
			ps.setString(2, m.getFname());
			ps.setString(3, m.getLname());
			ps.setString(4, m.getPhone());
			ps.setString(5, m.getEmail());
			ps.setString(6, m.getPass());
			ps.setString(7, m.getAuthority());
			ps.setString(8, m.getFarsi());
			ps.setString(9, m.getReligion());
			ps.setString(10, m.getQuran());
			ps.setString(11, m.getSalat());
			ps.setString(12, m.getDetails());
			
			i=ps.executeUpdate();
			
			ps.close();			
			con.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return i;
	}
	public static int StudentRegister(StudentModel m,String sql) {
		i=0;
		Connection con=db_connection();
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, m.getUserid());
			ps.setString(2, m.getFname());
			ps.setString(3, m.getLname());
			ps.setString(4, m.getBirthDate());
			ps.setString(5, m.getEmail());
			ps.setString(6, m.getPhone());
			ps.setString(7, m.getEmergency());
			ps.setString(8, m.getAddress());
			ps.setString(9, m.getDetails());

			
			i=ps.executeUpdate();
			
			ps.close();			
			con.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return i;
	}
	public static int Report(ReportModel m,String sql) {
		
		
		Connection con = null;
		String User,Pass,URL;
			try
			{	
				//URL="jdbc:mysql://mysql18343-linux.njs.jelastic.vps-host.net/user"; User="user"; Pass="QGzZfmcZPee3cdJ6";
				
				//URL="jdbc:mysql://localhost:3306/user"; User="root"; Pass="password";
				URL="jdbc:mysql://localhost:3306/test2"; User="root"; Pass="admin";

				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(URL, User,Pass);

			}catch(Exception e)
			{
				
			}

		i=0;
		
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, "444");
			ps.setString(2, m.getF_description());
			ps.setString(3, m.getGrammar_score());

			i=ps.executeUpdate();
			
			ps.close();			
			con.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return i;
	}
}
