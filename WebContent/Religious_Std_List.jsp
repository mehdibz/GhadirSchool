<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*" import="javax.servlet.*"
	import="javax.sql.*" import="java.util.*" import="jbean.Main_db"%>
	
	
	<jsp:useBean id="db" scope="request" class="jbean.Main_db"/>
  		<jsp:setProperty name="db" property="*" />
	
	
<!-- <jsp:useBean id="GH" scope="application" class="jbean.Main_db" />-->


<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset=UTF-8>
<title>View Page</title>
<link rel="stylesheet" href="css/ScoresEntry.css">
<script type="text/javascript" src="Script/StudentCorse_Angular.js"></script>
<script type="text/javascript" src="Script/Script.js"></script>
</head>
<body onload=pageload1() id="pview">

	<form name="registrationForm" method="post">
		<div id="ViewBody">
			<input type=hidden name="ini" value="view">
			<input type=hidden id="isvalid" name="val" value="invalid">
			<%
		 		String Std_Id,TextUser,text,temp,checkUser,level;
		 		checkUser=null;
		     
				Vector<String> List,course;
				List= db.getList();
				Enumeration<String> enum1=List.elements();
		 	%>
			<div id="view_combo_div">
				<input disabled maxlength="22" size="15" value=" کاراکتر باقی مانده = 1000" id="count">
				<br><br>
				<table>
					<tr>
						<th class="id_col">کد دانش آموز</th><th class="name_col">نام خانوادگی  و &nbsp;نام</th><th class="score_col">کلاس</th><th class="score_col">نام درس</th><th class="score_col">نمره</th><th class="score_col">انضباط</th><th>ملاحظات</th>
					</tr>
					<%
					while(enum1.hasMoreElements())
					{
						Std_Id=enum1.nextElement().toString();
			  		   	TextUser=(enum1.nextElement().toString()+" "+enum1.nextElement().toString());
			  		  	level=enum1.nextElement().toString();
						%>
						<tr>
							<td class="id_col">
								<input name="userid" disabled size="4" value="<%=Std_Id%>">
							</td>
							<td class="name_col view_combo_stdName">
								<input name="userid" disabled size="17" value="<%=TextUser%>">
							</td>
							<td class="">
								<input name="userid" disabled size="1" value="<%=level%>">
							</td>
							<td>
								<select id="view_combo_MainCourse" name="course_name" onchange="show_sub_farsi()">
									<option value="-">نام درس</option>
									<option value="Farsi">فارسی</option>
									<option value="Religion">دینی</option>
									<option value="Quran">قرآن</option>
									<option value="Salat">نماز</option>
								</select>
							</td>	
							<td class="score_col">
								<select id="total_score"
									class="view_combo_final" name="tot_score">
									<option value="+A">+A</option>
									<option value="A">A</option>
									<option value="-A">-A</option>
									<option value="+B">+B</option>
									<option value="B">B</option>
									<option value="-B">-B</option>
									<option value="C">C</option>
									<option value="I">I</option>
								</select>
							</td>
							<td class="score_col">
								<select>
									<option value="-">- I -</option>
									<% for(short i=10;i<21;i++)
										{
											%>
											<option class="" value=""><%=i%></option>
											<%	
										}
									%>
								</select>
							</td>
							<td>
								<label class="details_caption"> 
									
										<textarea
											class="text_area" name="description2" maxlength="2000"
											spellcheck="false" onkeyup="textCounter(this,'count',1000);"
											onchange="textCounter(this,'count',1000);" onresize="false">
										</textarea>
								</label> 
							</td>
						</tr>
						<%	
					}
					%>
				</table>
				



				
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

	<jsp:useBean id="db" scope="request" class="jbean.Main_db" >
  		<jsp:setProperty name="db" property="Name" value='<%=request.getParameter("userid")%>'/>
   		<jsp:setProperty name="db" property="Family" value='<%=request.getParameter("pass")%>'/>
 	</jsp:useBean>
	<jsp:forward page="Religious_Std_List.jsp">
  		<jsp:param name="std_list" value="<%=db.getList()%>" />
	</jsp:forward> 


	<input type="number" min="14" max="20" step="0.5" value="18" required>
	
		<label >ملاحظات : <textarea class="text_area" name="description" maxlength="1500" spellcheck="false" ></textarea></label>
		<label >ملاحظات : <textarea class="text_area" name="description2" maxlength="1500" spellcheck="false" readonly><%=request.getAttribute("TextValue")%></textarea></label>
	<input type="button"  class="curve button" value="نمایش" onclick="exit" />
 --%>
