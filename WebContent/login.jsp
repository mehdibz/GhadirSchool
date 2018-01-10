<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*" import="javax.servlet.*"
	import="javax.sql.*" import="java.util.*" import="jbean.Main_db"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset=UTF-8>
<title>Login</title>
<link rel="stylesheet" href="css/LoginPage.css">
<script type="text/javascript"  src="Script/Script.js"></script >
</head>
<body id="plogin">
	<form name="LoginForm" method="post" action="LoginServlet">
		<input type=hidden name="ini" value="loginPage">
		<input	type=hidden name="initial" value="<%=request.getAttribute("lableMessage")%>">
		<div id="sub_page">

			<table class="curve tbl_login" id="loginTbl">
				<tr>
					<td colspan='2'>
						<label id=logMsg> &nbsp;
							<%
							Object UserST = request.getSession().getAttribute("UserValidation");
							if(UserST !=null){
								if(UserST.toString() !="check")
								{
										if((request.getSession().getAttribute("UserValidation")!="Valid"))
							         	{
											out.println("Student ID or Password is wrong!!");
							         	}
								}
							}
				         	%>
						</label>
					</td>	
				</tr>
				<tr>
					<th class="curve-top" colspan="2">Students login page</th>
				</tr>
				<tr>
					<td style='text-align: center;'>Student ID</td>
					<td><input class=fix type="text" name="userid" value="" required /></td>
				</tr>
				<tr>
					<td style='text-align: center;'>Password</td>
					<td><input class=fix type="password" name="pass" value="" required /></td>
				</tr>
			</table>
			<br>
			<div class="Center">
				<input class="curve button" type="reset" value="Cancel" onclick="goBack()"/>
			<!--<input class="curve button" type="submit" onsubmit="" value="Sign in"/> -->	
				<input class="curve button" type="submit" name="Submit" onsubmit="" value="Submit"/>
			</div>
		</div>
		<%
 	/*	//		session.setAttribute("currentUser", "userid");
           		String subject=request.getParameter("Item");
           		if(subject==null)
 					session.setAttribute("ItemChoose","");
           		else
           			session.setAttribute("ItemChoose",subject);
  */
			%>
	</form>
</body>
</html>