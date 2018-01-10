<%
session.setAttribute("StudentINFO", null);
session.setAttribute("StdId", null);
session.setAttribute("msg", null);
session.invalidate();
response.sendRedirect("MainPage.jsp");
%>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="2; url=MainPage.jsp">
<script type="text/javascript">
            window.location.href = "MainPage.jsp"
        </script>
<title>Page Redirection</title>
</head>
<body>
	<!-- Note: don't tell people to `click` the link, just tell them that it is a link. -->
	Thank you ! You've been signed out <br><br>
	If You are not redirected automatically, follow the	<a href='MainPage.jsp'>Home Page</a>
</body>
</html>