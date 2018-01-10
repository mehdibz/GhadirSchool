<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*" import="javax.servlet.*"
	import="javax.sql.*" import="java.util.*" import="jbean.Main_db"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset=UTF-8>
<title>Login</title>
<link rel="stylesheet" href="css/LoginPageVol.css">
<script type="text/javascript"  src="Script/Script.js"></script >
</head>
<body id="plogin">
	<form name="LoginForm" method="post" action="LoginController">
		<input type=hidden name="ini" value="LoginPage"> <input	type=hidden name="initial"	value="<%=request.getAttribute("lableMessage")%>">
		<div id="sub_page">
			<label id=logMsg> <% 
        			
         	if((request.getSession().getAttribute("currentUser")!="Valid"))
         	{
				
         	}
         	else
         	{
         		out.println("ٍError ! <br> Email address or Password is wrong"+"-"+request.getSession().getAttribute("result"));
         		//out.println("خطا ! <br> کد کاربری و یا رمز ورود اشتباه است"+"-"+request.getSession().getAttribute("currentUser"));
         	}

        	%>
			</label>
			<table class="curve tbl_login">
				<tr>
					<th class="curve-top tbl_title" colspan="2"> Volunteers/Teachers Login </th>
				</tr>
				<tr>
					<td class="tbl_title">Email</td>
					<td><input id=fix type="text" name="userid" value="" required /></td>
				</tr>
				<tr>
					<td class="tbl_title">Password</td>
					<td><input id=fix type="password" name="pass" value="" required /></td>
				</tr>
			</table>
			<br>
			<div class="Center">
				<input class="curve button" type="submit" onsubmit="" value="Sign in" />
				<input class="curve button" type="reset" value="Cancel" onclick="goBack()" />
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