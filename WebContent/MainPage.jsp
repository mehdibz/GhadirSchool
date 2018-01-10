<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*" import="javax.servlet.*"
	import="javax.sql.*" import="java.util.*"%>
<html>
	<script type="text/javascript" src="Script/Script.js"></script>

	<link rel="shortcut icon" href="favicon.ico" />
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Ghadir School</title>
<link rel="stylesheet" href="css/FirstMenu.css">
</head>
<body class="MainMenuBody">

	<input type=hidden name="Item" value="Main">
	<div>
		<span id="digitalclock" class="styling2" ></span>
		<br>
		<span id="TotalCurrentDate" class="styling2" ></span>
	</div>
	<div class="adv_hdr">
		<img class="GhadirLogo"  />
		<marquee behavior="scroll" direction="left" scrollamount="4" id="adv">Ghadir school online management and evaluation system - ver: 1.0.2</marquee>
	</div>
	<div id="page">
		<nav id="nav_bar">
			<ul>
				<li>
					<a href="#">Home</a>
				</li>
				<li><a href="#" class="active">Students</a>
					<ul>
						<li><a href="StudentRegForm.jsp">New Student</a></li>
						<li><a href="Std_Profile_Wellcome.jsp">Student Profile</a></li>
						<li><a href="login.jsp">Student Login!</a></li>
					</ul>
				</li>
				<li><a href="#">Volunteers</a>
					<ul>
						<li><a href="construction.jsp">New Applicant</a></li>
				<!-- 	<li><a href="VolunteerRegForm.jsp">New Applicant</a></li>	 -->
						<li><a href="construction.jsp">Applicant Login!</a></li>
					</ul>
				</li>
				<li><a href="#">Ghadir School</a>
					<ul>
						<li><a href="About.jsp">About Us</a></li>
						<li><a href="#">Contacts</a></li>
					</ul>
				</li>
			</ul>
		</nav>
<!--	<section>
						<li><a href="ToolPage.jsp?Item=EnScore">ثبت نمره انضباط </a></li>
						<li><a href="Profile.jsp?Item=RepPrint">چاپ کارنامه </a></li>
		</section>  -->		
		<section>
			<br>
			<br>
			<div id="init_link">
				<h5>
					<a href="StudentRegForm.jsp" style="text-shadow: 3px 3px 10px #252525;">فرم ثبت نام دانش آموز </a>
					<!-- <a href="StudentRegForm.jsp?Item=RepPrint">فرم ثبت نام دانش آموز </a> -->	
				</h5>
			</div>
		</section>
	</div>
	<div id="example"></div>
</body>
<footer >
	<div class ="footer">
		©All Rights Reserved to Ghadir Cultural And Education Centre <a target="_blank" href="http://masjedghadir.com/">(GCEC).</a>
	</div>
</footer>
</html>