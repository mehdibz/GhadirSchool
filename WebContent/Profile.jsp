<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html >
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Student Report</title>
	<link rel="stylesheet" href="css/ReportForm.css">
	<script type="text/javascript" src="Script/Script.js"></script>
</head>
	<body id=ProfilePage>  
        <form action="ReportServlet" method="post" >
        	<input type=hidden name="ini"  value="Profile">
         <%
 		 String text,checkUser;
 		 checkUser=null;
	     try
	     {
	    	checkUser=request.getSession().getAttribute("currentUser").toString();
	  		
	    	if(!(checkUser=="Valid"))
	 		{
		 		response.sendRedirect("login.jsp");
		 	}
	     }
	     catch(Exception e)
	     {
	    	 out.println(e.toString());
	    	 response.sendRedirect("login.jsp");
	     }
	 	%>
           <div >
                <table >
                	<tr>
                	<td>
                	<table>
                        <tr>
                            <td><br><br></td>
                        </tr>
                        <tr>
                            <td><div >کد دانش آموز</div></td>
                            <td><input name="userid" id="userid" type="text" value="" /></td>
                        </tr>
                        <tr>
                            <td><div >نام/ نام خانوادگی</div></td>
                            <td><input name="name" id="name" type="text" value="" readonly="readonly"/></td>
                        </tr>
                        <tr>
                            <td><div >کلاس</div></td>
                            <td><input name="ForClass" id="ForClass" type="text" value="" /></td>
                        </tr>
                        <tr>
                            <td><div >سال تحصیلی</div></td>
                            <td><input name="ForDate" id="ForDate" type="text" value="" /></td>
                        </tr>
                        <tr>
                      </table>
                      </td>
					  <td id=between_tbl>
                     <table>
                        <tr>
                            <td><br><br></td>
                        </tr>
                        <tr>
                            <td ><div >کد دانش آموز</div></td>
                            <td ><input name="userid2" id="userid2" type="text" value="" /></td>
                        </tr>
                        <tr>
                            <td ><div >نام/ نام خانوادگی</div></td>
                            <td ><input name="name" id="name" 	type="text"   value="" readonly="readonly"/></td>
                        </tr>
                        <tr>
                            <td ><div >کلاس</div></td>
                            <td ><input name="ForClass2" id="ForClass2" type="text"   value="" /></td>
                        </tr>
                        <tr>
                            <td ><div >سال تحصیلی</div></td>
                            <td ><input name="ForDate" id="ForDate" type="text"   value="" /></td>
                        </tr>
                        <tr>
                      </table>
                      </td></tr>  
                        <tr>
                        	<td id=between_tbl><br><br><br><br></td>
                            <td >
                            	<div >
                                    <input type="submit" name="updateprof" id="updateprof" value="کارنامه" />
                            	</div>
                            </td>
                        </tr>
                </table>
                ${Result_Note}
            </div>
        </form>
    </body>
</html>



