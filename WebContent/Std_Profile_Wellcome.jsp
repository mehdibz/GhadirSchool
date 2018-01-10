<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8' import='java.sql.*' import='javax.servlet.*'	import='javax.sql.*' import='java.util.*' import='jbean.*' %>
<jsp:useBean id='Main_db' scope='application' class='jbean.Main_db'/><jsp:setProperty property='*' name='Main_db' />
<!DOCTYPE html><html ng-app = 'RepostCheck'>
<head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<title>Student Profile</title>
<link rel='stylesheet' href='css/StudentRegForm.css'>
	<script type='text/javascript'  src='Script/angular.min.js'></script>
	<script type='text/javascript'  src='https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.6/angular.min.js'></script>
	<script type='text/javascript'  src='Script/Std_Profile_Wellcome.js'></script>
	<script type='text/javascript'  src='Script/Script.js'></script >
	<script type='text/javascript' type='text/javascript'>
		function removeSpaces(string) {
			return string.split(' ').join('');
		}
	</script>
</head>
<body onload='profileForm()'>
		<%
			 String user=null;
			 Object checkUser=null;
		     try
		     {
		    	checkUser=request.getSession().getAttribute("UserValidation");
		    	if(checkUser!=null)
		    	{
			  		if(!(checkUser=="Valid"))
			 		{
				 		request.getSession().setAttribute("UserValidation","check");
				 	//	response.sendRedirect("login.jsp");
				 		request.getRequestDispatcher("login.jsp").forward(request, response);
				 	}
			  		user = session.getAttribute("StudentINFO").toString();
		    	}
		    	else{
			 		request.getSession().setAttribute("UserValidation","check");
			 	//	response.sendRedirect("login.jsp");
			 		request.getRequestDispatcher("login.jsp").forward(request, response);
		    	}
		     }
		     catch(Exception e)
		     {
		    	 out.println(e.toString());
		    	// response.sendRedirect("login.jsp");
		    	 request.getRequestDispatcher("login.jsp").forward(request, response);
		     }
		%>
<form name="registrationForm" method="post" ng-controller='ReportController' ng-submit="createUser(registrationForm.$valid)" >
<input type='hidden' ng-model='regex' id='regex' />
<input type=hidden id='isvalid1' name='AppSubmit' value='' >
<br><br><br><br>
<table class='curve tbl_reg'>
	<tr><th class='curve-top' colspan='4'>Student Information</th>
		<td class='curve-top' colspan='4'>
			<span id='digitalclock' class='styling2'></span>
		</td>
	</tr>
	</table>
<%= user%>
</form>
</body>
</html>