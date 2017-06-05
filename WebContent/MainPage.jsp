<!DOCTYPE html>
		<%@ page 
		language="java"
		contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" 
		import="java.sql.*"
		import="javax.servlet.*"
		import="javax.sql.*"
		import="java.util.*"
		
		%>
<html>
	<script type="text/javascript" src="Script.js"></script>
	<script src="react.js"></script>
	<script src="react-dom.js"></script>
	<script src="browser.min.js"></script>
	<head>
		<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
			<title>Ghadir School</title>
		<link rel="stylesheet" href="css/FirstMenu.css">
	</head>
<body class="MainMenuBody">

		<input type=hidden name="Item"  value="Main">
    	<span id="digitalclock" class="styling2"></span>
    	<nav id=ViewNav>
    		<ul>
        		<li></li>
				<li><img id="Ghadir_Logo" alt="GhadirLogo" src="img/School LOGO1.jpg"></li>
				<li></li>
			</ul>
		</nav>

        <div id="adv">
        	<marquee  behavior="scroll" direction="right" scrollamount="4">(نسخه آزمایشی)  - ver: 1.0.0 سامانه آنلاین ارزیابی نمرات مدرسه غدیر </marquee>
        </div >
        <div id="page">  
    <nav id="nav_bar">
      <ul>
        <li><a href="#">مدرسه غدیر</a>
          <ul>
            <li><a href="About.jsp">تماس با ما</a></li>
            <li><a href="#">تاریخچه</a></li>
          </ul>
        </li>
        <li><a href="#">معلمان</a>
          <ul>
            <li><a href="construction.jsp">معلم جدید</a></li>
            <li><a href="construction.jsp" >ویرایش اطلاعات</a></li>
          </ul>
        </li>
        <li><a href="#" class="active"> دانش آموزان</a>
          <ul>
            <li><a href="login.jsp?Item=NewStd">دانش آموز جدید</a></li>
            <li><a href="login.jsp?Item=StdInfoEdit">ویرایش اطلاعات </a></li>
            <li><a href="ToolPage.jsp?Item=EnScore">ثبت نمره انضباط </a></li>
            <li><a href="Profile.jsp?Item=RepPrint">چاپ کارنامه </a></li>
          </ul>
        </li>
        <li><a href="#">خانه</a>
          <ul>
          </ul>
        </li>
      </ul>
    </nav>
		<section>
      		<h2>! سلام  </h2>
      		<p>.همکاران عزیز، این صفحه برای دریافت نمره و اطلاعات دانش آموزان در نظر گرفته شده است</p>
      		<p>.انشالله به مرور زمان از نواقص آن کاسته و بروزرسانی خواهد شد</p>
      		<p>.از صبر و شکیبایی شما سپاسگزاریم</p>
    	</section>
    	</div >
    	<div id="example">
    	</div>
    	<script type="text/babel">
			ReactDOM.render(<h1>Mehdi Salam</h1>,document.getElementbyId('example'));
    	</script>
</body>
</html>