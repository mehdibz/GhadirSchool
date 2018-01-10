<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*" import="javax.servlet.*"
	import="javax.sql.*" import="java.util.*" import="jbean.Main_db"%>

<jsp:useBean id="GH" scope="application" class="jbean.Main_db" />
<jsp:setProperty property="*" name="GH" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset=UTF-8>
<title>View Page</title>
<link rel="stylesheet" href="css/ViewPage.css">
<script type="text/javascript" src="Script/Script.js"></script>
</head>
<body onload=pageload1() id="pview">
	<span id="digitalclock" class="styling2"></span>
	<nav class="Center" id=ViewNav>
		<ul>
			<li></li>
			<li><img id="Ghadir_Logo" alt="GhadirLogo"	src="img/Ghadir LOGO.jpg"></li>
			<li></li>
		</ul>
	</nav>

	<form method="post" action="GhadirServ">
		<div id="ViewBody">
			<input type=hidden name="ini" value="view"> <input
				type=hidden id="isvalid" name="val" value="invalid">
			<%
 		 String textID,TextUser,text,temp,checkUser;
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
	     
		Vector List,course;
		List= GH.getList();
	
		Enumeration enum1=List.elements();

	 	%>
			<div id="view_combo_div">
				<select id="view_combo_stdName" name="std_name" onchange="">
					<option value="-">لیست دانش آموزان</option>
					<%
				while(enum1.hasMoreElements())
				{
	 	 	   	//String name = rs.getString("name");
	  		   	textID=enum1.nextElement().toString();
	  		   	TextUser=(enum1.nextElement().toString()+" "+enum1.nextElement().toString());
	  		   	text=(textID+"  -  "+TextUser);
				%>
					<option id="std_combo_opt" value="<%=textID%>"><%=text%></option>
					<%	
	
				}
				%>
				</select>
				<select id="view_combo_MainCourse" name="course_name"
					onchange="show_sub_farsi()">
					<option value="-">نام درس</option>
					<option value="Farsi">فارسی</option>
					<option value="Religion">دینی</option>
					<option value="Quran">قرآن</option>
					<option value="Salat">نماز</option>
				</select>

				<div id=Farsi_div>
					<input type="text" class=tx_box_sub_Fa name="userid" value="املاء"
						readonly /> <select id="dictation_score" class="view_combo_Num"
						name="dictation_score">
						<option value="-">-</option>
						<option value="20">20</option>
						<option value="19.5">19.5</option>
						<option value="19">19</option>
						<option value="18.5">18.5</option>
						<option value="18">18</option>
						<option value="17.5">17.5</option>
						<option value="17">17</option>
						<option value="16.5">16.5</option>
						<option value="16">16</option>
						<option value="15.5">15.5</option>
						<option value="15">15</option>
						<option value="14.5">14.5</option>
						<option value="14">14</option>
						<option value="13.5">13.5</option>
						<option value="13">13</option>
						<option value="12.5">12.5</option>
						<option value="12">12</option>
						<option value="11.5">11.5</option>
						<option value=" 11 ">11</option>
						<option value="10.5">10.5</option>
						<option value="10">10</option>
						<option value="I">I</option>
					</select> <br> <input type="text" class=tx_box_sub_Fa name="userid"
						value="دستور زبان و انشاء" readonly /> <select id="grammar_score"
						class="view_combo_Num" name="grammar_score">
						<option value="-">-</option>
						<option value="20">20</option>
						<option value="19.5">19.5</option>
						<option value="19">19</option>
						<option value="18.5">18.5</option>
						<option value="18">18</option>
						<option value="17.5">17.5</option>
						<option value="17">17</option>
						<option value="16.5">16.5</option>
						<option value="16">16</option>
						<option value="15.5">15.5</option>
						<option value="15">15</option>
						<option value="14.5">14.5</option>
						<option value="14">14</option>
						<option value="13.5">13.5</option>
						<option value="13">13</option>
						<option value="12.5">12.5</option>
						<option value="12">12</option>
						<option value="11.5">11.5</option>
						<option value=" 11 ">11</option>
						<option value="10.5">10.5</option>
						<option value="10">10</option>
						<option value="I">I</option>
					</select> <br> <input type="text" class=tx_box_sub_Fa name="userid"
						value="روخوانی" readonly /> <select id="reading_score"
						class="view_combo_Num" name="reading_score">
						<option value="-">-</option>
						<option value="20">20</option>
						<option value="19.5">19.5</option>
						<option value="19">19</option>
						<option value="18.5">18.5</option>
						<option value="18">18</option>
						<option value="17.5">17.5</option>
						<option value="17">17</option>
						<option value="16.5">16.5</option>
						<option value="16">16</option>
						<option value="15.5">15.5</option>
						<option value="15">15</option>
						<option value="14.5">14.5</option>
						<option value="14">14</option>
						<option value="13.5">13.5</option>
						<option value="13">13</option>
						<option value="12.5">12.5</option>
						<option value="12">12</option>
						<option value="11.5">11.5</option>
						<option value=" 11 ">11</option>
						<option value="10.5">10.5</option>
						<option value="10">10</option>
						<option value="I">I</option>
					</select>
				</div>
				<div id=total_score_div>
					<input type="text" class=tx_box_final name="userid"
						value="نمره نهایی" readonly /> <select id="total_score"
						class="view_combo_final" name="tot_score">
						<option value="+A">+A</option>
						<option value="A">A</option>
						<option value="-A">-A</option>
						<option value="+B">+B</option>
						<option value="B">B</option>
						<option value="-B">-B</option>
						<option value="C">C</option>
						<option value="I">I</option>
					</select> <br> <input type="text" class=tx_box_final
						name="tx_Discipline" value="انضباط" readonly /> <select
						id="discipline_score" class="view_combo_final"
						name="discipline_score">
						<option value="20">20</option>
						<option value="19.5">19.5</option>
						<option value="19">19</option>
						<option value="18.5">18.5</option>
						<option value="18">18</option>
						<option value="17.5">17.5</option>
						<option value="17">17</option>
						<option value="16.5">16.5</option>
						<option value="16">16</option>
						<option value="15.5">15.5</option>
						<option value="15">15</option>
					</select>
				</div>

				<label id=description1 class="details_caption">ملاحظات درس
					فارسی : <input disabled maxlength="22" size="22"
					value=" کاراکتر باقی مانده = 1000" id="count"> <textarea
						class="text_area" name="description1" maxlength="2000"
						spellcheck="false" onkeyup="textCounter(this,'count',1000);"
						onchange="textCounter(this,'count',1000);" onresize="false"></textarea>
				</label> <label id=description2 class="details_caption">ملاحظات درس
					دینی : <input disabled maxlength="22" size="22"
					value=" کاراکتر باقی مانده = 1000" id="count"> <textarea
						class="text_area" name="description2" maxlength="2000"
						spellcheck="false" onkeyup="textCounter(this,'count',1000);"
						onchange="textCounter(this,'count',1000);" onresize="false"></textarea>
				</label> <label id=description3 class="details_caption">ملاحظات درس
					قرآن : <input disabled maxlength="22" size="22"
					value=" کاراکتر باقی مانده = 1000" id="count"> <textarea
						class="text_area" name="description3" maxlength="2000"
						spellcheck="false" onkeyup="textCounter(this,'count',1000);"
						onchange="textCounter(this,'count',1000);" onresize="false"></textarea>
				</label> <label id=description4 class="details_caption">ملاحظات درس
					نماز : <input disabled maxlength="22" size="22"
					value=" کاراکتر باقی مانده = 1000" id="count"> <textarea
						class="text_area" name="description4" maxlength="2000"
						spellcheck="false" onkeyup="textCounter(this,'count',1000);"
						onchange="textCounter(this,'count',1000);" onresize="false"></textarea>
				</label>
				<div id="notice">
					<br> همکارارجمند توجه شمارا به موارد ذیل جلب می نماییم:<br>
					درصورتی که نمره دانش آموز بصورت تکراری وارد شود، آخرین نمره وارد
					شده در فرم، در بانک اطلاعاتی ثبت میگردد.<br> برهمین اساس از
					رفرش کردن و بارگذاری مجدد این صفحه خوداری فرمایید.<br>
					<!--  	 بخاطر موارد امنیتی و ساختاری، مدت زمان حضور شما در این صفحه محدود در نظر گرفته شده، چنانچه نیاز به تکمیل کادر ملاحظات دارید،<br>متن مورد نظر خودرا قبلا دربرنامه های ویرایشگر دیگر نوشته و پس از بازنگری، متن نهایی را در کادر ملاحظات کپی فرمایید .<br><br>  -->
					* شایان ذکر است، دانش آموزانی که درلیست فوق قرار ندارند، والدین
					آنها مراحل ثبت نام دانش آموز را تکمیل نکرده اند. <br>
				</div>
				<input type="submit" id="login_btn" class="curve button" value="ذخیره" onclick="del_Tbl()"> <br>
				<div id="Result_Note">
					<br> ${Result_Note}
				</div>
				<div>
					<br> ${Result_Farsi}
				</div>
				<div>
					<br> ${Result_Religion}
				</div>
				<div>
					<br> ${Result_Quran}
				</div>
				<div>
					<br> ${Result_Salat}
				</div>
			</div>
		</div>
	</form>
</body>
</html>
<%--
	<input type="number" min="14" max="20" step="0.5" value="18" required>
	
		<label >ملاحظات : <textarea class="text_area" name="description" maxlength="1500" spellcheck="false" ></textarea></label>
		<label >ملاحظات : <textarea class="text_area" name="description2" maxlength="1500" spellcheck="false" readonly><%=request.getAttribute("TextValue")%></textarea></label>
	<input type="button"  class="curve button" value="نمایش" onclick="exit" />
 --%>
