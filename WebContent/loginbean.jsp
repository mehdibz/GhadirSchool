<%@ page 
	language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" 
	import="java.sql.*" 
	import="javax.servlet.*" 
	import="javax.sql.*" 
	import="java.util.*" 
	%>

<HTML> 
<HEAD><TITLE>DataBase Search</TITLE></HEAD>  
<BODY>
	<jsp:useBean id="db" scope="request" class="jbean.LoginBean" >
  		<jsp:setProperty name="db" property="userName" value='<%=request.getParameter("userid")%>'/>
   		<jsp:setProperty name="db" property="password" value='<%=request.getParameter("pass")%>'/>
 	</jsp:useBean>
	<jsp:forward page="login">
  		<jsp:param name="username" value="<%=db.getUserName()%>" />
  		<jsp:param name="password" value="<%=db.getPassword()%>" />
	</jsp:forward> 
</body>
</html>