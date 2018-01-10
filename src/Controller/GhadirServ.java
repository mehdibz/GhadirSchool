package Controller;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import DB_Connection.DB_Connection;

 public class GhadirServ extends HttpServlet
 {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int i,j,count,tes; 
	 Connection con;
	 PrintWriter out;
	 ResultSet rs0,rs2,rr;
	 HttpSession session;
	 String checkUser,Header,Footer,Send,Loginmsg,TxArea,F_description,R_description,Q_description,S_description;
	 String std_id,std_name,std_family,course_name,dictation_score,grammar_score,reading_score,discipline_score,tot_score;
	 String FarsiRec,ReligionRec,QuranRec,SalatRec,LastFarsi,LastReligion,LastQuran,LastSalat,hidden,Currentuser;
	 String send,query,query2;
	 PreparedStatement pstmt=null,pstmt2=null;
	 public void init()
	 {
		 i=0;
		 j=0;
		 count=0;
		 con=null;
		 out=null;
		 rs0=null;
		 rs2=null;
		 checkUser=null;
		 Send="";
		 Header="";
		 FarsiRec="";
		 ReligionRec="";
		 QuranRec="";
		 SalatRec="";
		 LastFarsi="";
		 LastReligion="";
		 LastQuran="";
		 LastSalat="";

		 Currentuser="invalid";
		 
		 F_description= "";
		 R_description= "";
		 Q_description= "";
		 S_description= "";
		 
		 con=DB_Connection.db_connection();
		 Loginmsg="";
	 }
	 

	 
	 public void doPost (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	 {
		 i++;
		 response.setCharacterEncoding("UTF-8");
		 request.setCharacterEncoding("UTF-8");
		 out=response.getWriter();
		 
		 //request.getSession().getAttribute("StdId").toString();
		 hidden=request.getParameter("ini");
		 session=request.getSession();
		 std_id=request.getParameter("std_name");
		 course_name=request.getParameter("course_name");
		 tot_score=request.getParameter("tot_score");
		 dictation_score=request.getParameter("dictation_score");
		 grammar_score=request.getParameter("grammar_score");
		 reading_score=request.getParameter("reading_score");
		 discipline_score=request.getParameter("discipline_score");
		 
	 
	     response.setContentType("text/html");
	      
	     checkUser=request.getSession().getAttribute("currentUser").toString();
			Currentuser="Valid"; 
			if(hidden.equals("view"))
			{
				try
				 {
					switch(course_name){
			        case "Farsi": 	  	F_description=request.getParameter("description1");
			        					break;

			        case "Religion":  	R_description=request.getParameter("description2");
			        					break;
			        
			        case "Quran": 	  	Q_description=request.getParameter("description3");
			        					break;
			        
			        case "Salat": 	  	S_description=request.getParameter("description4");
			        					break;
			        
			        //default:  "ERROR";
					}
				  
					/******Storing Request*******/
					 


					 query=CourseUpdate(std_id,course_name,tot_score,dictation_score,grammar_score,reading_score,discipline_score,F_description,R_description,Q_description,S_description);
					 //String query4="update report set Fa_Description='سلام سلام'  where Student_ID= '1101645'";
					 pstmt=con.prepareStatement(query);
					 
					 j=pstmt.executeUpdate(query);
					 
					 /******Sending Table*******/

					 //query2="SELECT student.Id, student.Name, student.Family, report.Quran,report.Salat	 FROM student  JOIN report	ON student.Id=report.Student_ID";
					 query2=QueryCourseSelect(std_id,course_name);
					 pstmt2=con.prepareStatement(query2);
					 rs2=pstmt2.executeQuery(query2);
					 
					 //ResultSetMetaData rsmd=rs2.getMetaData();
					 //int colcount=rsmd.getColumnCount();
					 send="<!DOCTYPE html><html lang='en' ><head><meta contentType='text/html' pageEncoding='UTF-8' charset='UTF-8'><title>Ghadir School</title><link rel='stylesheet' href='css/FirstMenu.css'></head><body>";
					 send+="<div class='servlet'>";
					 send+="<table id='" + course_name + "'><tr>";
					
					/* 
					 for(int i=1;i<= colcount;i++)
					 {
						 send+="<tr>";
						 out.println("<th>"+ rsmd.getColumnLabel(i) +"</th>");
						 out.println("<th>"+ rsmd.getColumnName(i) +"</th>");
						 send+="</tr>";
					 }*/
					 //out.println("</tr>");

					 Header= send + HeaderCoursetitle(std_id,course_name);
					 Header+="</tr>";
					 
					 while(rs2.next())
					 {
						 send="<tr>";
						 send+="<td>"+ rs2.getString("Id")+"</td>";
						 send+="<td>"+ rs2.getString("Name")+"</td>";
						 send+="<td>"+ rs2.getString("Family")+"</td>";
						 if(course_name.equals("Farsi")){
							 send+="<td>"+ rs2.getString("Dictation")+"</td>";
							 send+="<td>"+ rs2.getString("Grammar")+"</td>";
							 send+="<td>"+ rs2.getString("Reading")+"</td>";
							 send+="<td>"+ rs2.getString("Farsi")+"</td>";
							 send+="<td>"+ rs2.getString("F_Discipline")+"</td>";
							 send+="<td class='serv_det_col'>"+ rs2.getString("Fa_Description")+"</td>";
				 		 }
						 if(course_name.equals("Religion")){
							 send+="<td>"+ rs2.getString("Religion")+"</td>";
							 send+="<td>"+ rs2.getString("R_Discipline")+"</td>";
							 send+="<td class='serv_det_col'>"+ rs2.getString("Re_Description")+"</td>";
						 }
						 if(course_name.equals("Quran")){
							 send+="<td>"+ rs2.getString("Quran")+"</td>";
							 send+="<td>"+ rs2.getString("Q_Discipline")+"</td>";
							 send+="<td class='serv_det_col'>"+ rs2.getString("Qu_Description")+"</td>";
						 }
						 if(course_name.equals("Salat")){
							 send+="<td>"+ rs2.getString("Salat")+"</td>";
							 send+="<td>"+ rs2.getString("S_Discipline")+"</td>";
							 send+="<td class='serv_det_col'>"+ rs2.getString("Sa_Description")+"</td>";
						 }
						 
						 send+="</tr>";
					 }
					 
				 }
				 catch(Exception e)
				 {
					 out.println(e.toString());
				 }
			try 
			 {
				Footer="</table>";
				Footer+="</div>";
				Footer+="</body>";
				Footer+="</html>";
	    		
	    	
	    			switch(course_name){
	    			        case "Farsi": 	  	FarsiRec+=send;
	    										LastFarsi=Header + send + Footer;
	    			        					request.setAttribute("Result_Farsi", LastFarsi);
	    			        					break;

	    			        case "Religion":  	ReligionRec+=send;
												LastReligion=Header + send + Footer;
	    			        					request.setAttribute("Result_Religion", LastReligion);
	    			        					break;
	    			        
	    			        case "Quran": 	  	QuranRec+=send;
												LastQuran=Header + send + Footer;
	    			        					request.setAttribute("Result_Quran", LastQuran);
	    			        					break;
	    			        
	    			        case "Salat": 	  	SalatRec+=send;
												LastSalat=Header + send + Footer;
	    			        					request.setAttribute("Result_Salat", LastSalat);
	    			        					break;
	    			        
	    			        //default:  "ERROR";
	    			}
			    	
			    	request.setAttribute("TextValue",TxArea);
			    	request.setAttribute("Result_Note","<lable Style='color: #00ff00;	font-size: 1.3em;'>اطلاعات با موفقیت ذخیره شد</lable>");
			    	
			    	request.getRequestDispatcher("View.jsp").forward(request, response);
			    	session.setAttribute("currentUser", Currentuser);
			    	session.setMaxInactiveInterval(20*60);
			 } 
			 catch (Exception e) 
			 {
			    System.out.println("This is finally block editrecord.jsp");
			    e.printStackTrace();
				response.sendRedirect("login.jsp");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				destroy();
			 }		
			count=0;
			
			}
			else
			{
				send="";
				TxArea="";
				request.getSession().setAttribute("currentUser", "Valid");
				response.sendRedirect("View.jsp");
			}
	 }
	 
	 public void destroy()
	 {
		try
		{
			session.invalidate();
			i=0;
			con.close();
			out.close();
			rs0.close();
			rs2.close();
			count=0;
		}
		catch(Exception se)
		{
			out.println(se.toString());
		}
	 }
	 
	 public String CourseUpdate(String std_id,String Course,String total_score,String dictation_score,String grammar_score,String reading_score,String discipline_score,String f_description,String r_description,String q_description,String s_description){

			String query;
			
			switch(Course){
			        case "Farsi": 	  query="update report_16_17_t2 set Farsi= '" + total_score + "', Dictation='" + dictation_score + "', Grammar='" + grammar_score + "', Reading='" + reading_score +"', F_Discipline= '"+ discipline_score +"', Fa_Description='"+ f_description +"'  where Student_ID= '"+std_id+"'";
			        break;

			        case "Religion":  query="update report_16_17_t2 set Religion= '"+ total_score +"', R_Discipline='"+ discipline_score +"', Re_Description='"+ r_description +"' where Student_ID= '"+std_id+"'";
			        break;
			        
			        case "Quran": 	  query="update report_16_17_t2 set Quran= '"+ total_score +"', Q_Discipline='"+ discipline_score +"', Qu_Description='"+ q_description +"' where Student_ID= '"+std_id+"'";
			        break;
			        
			        case "Salat": 	  query="update report_16_17_t2 set Salat= '"+ total_score +"', S_Discipline='"+ discipline_score +"', Sa_Description='"+ s_description +"' where Student_ID= '"+std_id+"'";
			        break;
			        
			        default: query = "ERROR";
			}
			return query;	
	 }
	 
	 public String QueryCourseSelect(String std_id,String Course){
			String query;
			
			switch(Course){
			        case "Farsi": 	  query="select student.Id, student.Name, student.Family, report_16_17_t2.Farsi, report_16_17_t2.Dictation, report_16_17_t2.Grammar, report_16_17_t2.Reading, report_16_17_t2.F_Discipline, report_16_17_t2.Fa_Description FROM student JOIN report_16_17_t2 ON student.Id=report_16_17_t2.Student_ID where student.Id= '"+std_id+"'";
			        break;

			        case "Religion":  query="select student.Id, student.Name, student.Family, report_16_17_t2.Religion, report_16_17_t2.R_Discipline, report_16_17_t2.Re_Description FROM student JOIN report_16_17_t2 ON student.Id=report_16_17_t2.Student_ID where student.Id= '"+std_id+"'";
			        break;
			        
			        case "Quran": 	  query="select student.Id, student.Name, student.Family, report_16_17_t2.Quran, report_16_17_t2.Q_Discipline, report_16_17_t2.Qu_Description FROM student JOIN report_16_17_t2 ON student.Id=report_16_17_t2.Student_ID where student.Id= '"+std_id+"'";
			        break;
			        
			        case "Salat": 	  query="select student.Id, student.Name, student.Family, report_16_17_t2.Salat, report_16_17_t2.S_Discipline, report_16_17_t2.Sa_Description FROM student JOIN report_16_17_t2 ON student.Id=report_16_17_t2.Student_ID where student.Id= '"+std_id+"'";
			        break;
			        
			        default: query = "ERROR";
			}
			return query;	
	}
	 
	 public String HeaderCoursetitle(String std_id,String Course){
			String csName;
			
			switch(Course){
			        case "Farsi": 	  csName="<th>کد دانش آموز</th><th>نام</th><th>نام خانوادگی </th><th>املاء</th><th>دستور زبان و انشاء</th><th>روخوانی</th><th>فارسی</th><th>انضباط</th><th>ملاحظات</th>";
			        break;

			        case "Religion":  csName="<th>کد دانش آموز</th><th>نام</th><th>نام خانوادگی </th><th>دینی</th><th>انضباط</th><th>ملاحظات</th>";
			        break;
			        
			        case "Quran": 	  csName="<th>کد دانش آموز</th><th>نام</th><th>نام خانوادگی </th><th>قرآن</th><th>انضباط</th><th>ملاحظات</th>";
			        break;
			        
			        case "Salat": 	  csName="<th>کد دانش آموز</th><th>نام</th><th>نام خانوادگی </th><th>نماز</th><th>انضباط</th><th>ملاحظات</th>";
			        break;
			        
			        default: csName = "ERROR";
			}
			return csName;	
	}

	 
	 

 }
 
 
/*  
===================================================================================
===================================================================================

	 public String CourseUpdate(String std_id,String Course,String total_score,String dictation_score,String grammar_score,String reading_score,String discipline_score){
			String query;
			
			switch(Course){
			        case "Farsi": 	  query="update report set Farsi= '" + total_score + "', Dictation='" + dictation_score + "', Grammar='" + grammar_score + "', Reading='" + reading_score +"', F_Discipline= '"+ discipline_score +"'  where Student_ID= '"+std_id+"'";
			        break;

			        case "Religion":  query="update report set Religion= '"+ total_score +"', R_Discipline='"+ discipline_score +"' where Student_ID= '"+std_id+"'";
			        break;
			        
			        case "Quran": 	  query="update report set Quran= '"+ total_score +"', Q_Discipline='"+ discipline_score +"' where Student_ID= '"+std_id+"'";
			        break;
			        
			        case "Salat": 	  query="update report set Salat= '"+ total_score +"', S_Discipline='"+ discipline_score +"' where Student_ID= '"+std_id+"'";
			        break;
			        
			        default: query = "ERROR";
			}
			return query;	
	}

===================================================================================
============================ Discipline_Final =====================================
===================================================================================

			    		String Discipline_Final,csName,query3,query4,query5,query6;
			  
			    		query3="select F_Discipline from report where Student_ID=?";
			    		query4="select R_Discipline from report where Student_ID=?";
			    		query5="select Q_Discipline from report where Student_ID=?";
			    		query6="select S_Discipline from report where Student_ID=?";
						pstmt3=con.prepareStatement(query2);
						rs2=pstmt3.executeQuery(query2);
			    		pstmt.setString(1,std_id );
			    		
  */