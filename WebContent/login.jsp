<!DOCTYPE html>
		<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" 
		import="java.sql.*"
		import="javax.servlet.*"
		import="javax.sql.*"
		import="java.util.*"
		import="jbean.Main_db"
		%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html"  charset=UTF-8>
        	<title>Login</title>
        	<link rel="stylesheet" href="css/LoginPage.css">
		<script type="text/javascript" src="Script.js"></script>
    </head>
    <body id="plogin">
        <form name="LoginForm" method="post" action="LoginController">
        <input type=hidden name="ini"  value="LoginPage">
        <input type=hidden name="initial"  value="<%=request.getAttribute("lableMessage")%>">
        <div id="adv">
        	<marquee  behavior="scroll" direction="right" scrollamount="4"> سامانه آنلاین ارزیابی نمرات مدرسه غدیر - ver: 1.0.0 (نسخه آزمایشی)</marquee>
        </div >
        <div id="sub_page" > 
        	<label id=logMsg><% 
        			
         	if((request.getSession().getAttribute("currentUser")!="Valid"))
         	{
				
         	}
         	else
         	{
         		out.println("خطا ! <br> کد کاربری و یا رمز ورود اشتباه است"+"-"+request.getSession().getAttribute("result"));
         		//out.println("خطا ! <br> کد کاربری و یا رمز ورود اشتباه است"+"-"+request.getSession().getAttribute("currentUser"));
         	}

        	%></label> 
            <table  class="curve tbl_login" id="loginTbl" >
                  <tr>
                      <th class="curve-top" colspan="2" >سامانه ارزیابی نمرات</th>
                  </tr>
                  <tr>
                      <td style='text-align: center;'>کد کاربر</td>
                      <td><input id=fix type="text" name="userid" value="" required/></td>
                  </tr>
                  <tr>
                      <td style='text-align: center;'>رمز ورود</td>
                      <td><input id=fix type="password" name="pass" value="" required/></td>
                  </tr>
            </table>
  			<br>
  				<div class="Center">
           			<input class="curve button" type="submit" onsubmit="" value="ورود"/>	
   					<input class="curve button" type="reset" value="لغو" onclick=""/>
   				</div>
           </div>
           <%
 				session.setAttribute("currentUser", "userid");
           		String subject=request.getParameter("Item");
           		if(subject==null)
 					session.setAttribute("ItemChoose","");
           		else
           			session.setAttribute("ItemChoose",subject);
  
			%>
        </form>
    </body>
</html>