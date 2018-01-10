package jbean;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.servlet.http.HttpServlet;

import DB_Connection.DB_Connection;


public class Main_db extends HttpServlet implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	public String text1,total_score,dictation_score,grammar_score,reading_score,discipline_score,query;
	public Connection con;
	public Vector<String> base_result;
	
	
	public Main_db(){
			con=DB_Connection.db_connection();
	}
	public Vector<String> getList()
	{
		Vector<String> v = new Vector<String>();
		try
		{	
    		PreparedStatement stat = con.prepareStatement("select Std_ID,Fname,Lname,FarsiGrade from studentmodel");
    		ResultSet rs= stat.executeQuery();
    		while(!(rs.isLast())){
    			if(rs.next())
        		{	
        			v.addElement(rs.getString("Std_ID"));
        			v.addElement(rs.getString("Fname"));
        			v.addElement(rs.getString("Lname"));
        			v.addElement(rs.getString("FarsiGrade"));
        		}
    		}
    	}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		this.base_result= v;
		return base_result;
	}

	public Vector<String> getList_ByCourse()
	{
		Vector<String> v = new Vector<String>();
		try
		{	
    		PreparedStatement stat = con.prepareStatement("select Std_ID,Fname,Lname from studentmodel");
    		ResultSet rs= stat.executeQuery();
    		while(!(rs.isLast())){
    			if(rs.next())
        		{	
        			v.addElement(rs.getString("Std_ID"));
        			v.addElement(rs.getString("Fname"));
        			v.addElement(rs.getString("Lname"));
        		}
    		}
    	}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		this.base_result= v;
		return base_result;
	}
	
	
	public Vector<String> course_show(){
		
		Vector<String> v = new Vector<String>();
		try
		{
			PreparedStatement stat = con.prepareStatement("select CourseName from courses");
    		ResultSet rs= stat.executeQuery();
    		while(!(rs.isLast())){
    			if(rs.next())
        		{													
        			v.addElement(rs.getString("CourseName"));
        		}
    		}
    	}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		this.base_result= v;
		return base_result;
	}
	public Vector<String> Discipline_show(){
		
		Vector<String> v = new Vector<String>();
		try
		{
			query="SELECT `F_Discipline`,`R_Discipline`,`Q_Discipline`,`S_Discipline`,`Discipline` FROM `report_16_17_t2`";
			PreparedStatement stat = con.prepareStatement(query);
    		ResultSet rs= stat.executeQuery();

    		while(!(rs.isLast())){
    			if(rs.next())
        		{													
    				v.addElement(rs.getString("F_Discipline"));
    				v.addElement(rs.getString("R_Discipline"));
    				v.addElement(rs.getString("Q_Discipline"));
    				v.addElement(rs.getString("S_Discipline"));
    				v.addElement(rs.getString("Discipline"));
        		}
    		}
    	}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		this.base_result= v;
		return base_result;
	}
}
