 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*" import="javax.servlet.*"
	import="javax.sql.*" import="java.util.*" import="jbean.*" %>
<jsp:useBean id="Main_db" scope="application" class="jbean.Main_db"  />
<jsp:setProperty property="*" name="Main_db" /> 

<!DOCTYPE html>
<html ng-app = "RepostCheck">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Student Profile</title>
	
<!--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.css" /> -->	
	<link rel="stylesheet" href="css/StudentRegForm.css">
<!-- <script type="text/javascript"  src="Script/angular.min.js"></script>  -->
	<script type="text/javascript"  src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.6/angular.min.js"></script>
    <script type="text/javascript"  src="Script/Student_Profile.js"></script>
    <script type="text/javascript"  src="Script/Script.js"></script >
    <script type="text/javascript" type="text/javascript">
			function removeSpaces(string) {
 			return string.split(' ').join('');
			}
	</script>
</head>
<body onload=profileForm()>
	<form name="registrationForm" method="post"  ng-controller="ReportController" ng-submit="createUser(registrationForm.$valid)">
		<input type=hidden name="ini" value="StdReg">
		<input type=hidden id="isvalid" name="val" value="invalid">
		<input type="hidden" ng-model="regex" id="regex" />
		<input type=hidden id="isvalid1" name="AppSubmit" value="">
		<br><br><br><br>
		<%

	     String text;
	     String[] Years = {"Year","1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013"};
	     String[] Days = {"Day","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	     String[] Months = {"Month","January", "February", "March", "April", "May", "Jun", "July", "August", "September", "October", "November", "December"};
	     String[] FarsiGrade = {"---","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		 %>
		<table class="curve tbl_reg">
			<tr>
				<th class="curve-top" colspan="4">Student Information</th>
				<td class="curve-top" colspan="4" ><span id="digitalclock" class="styling2"></span></td>
			</tr>
		</table>
		<table class="curve tbl_reg">
			<tr>
				
			</tr>
			<tr>
				<td colspan="1"><label>Application status:</label>
				</td>
				<td colspan="3">
					<div>
					 	<span class="Status" >{{user.status}}</span>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="1">Result: </td>
				<td colspan="3">
					<div>
				 	 <pre><span class="SuccessSubmit" ng-model="user.Result" >{{user.Result}}</span></pre>  		
					</div>
				</td>
			</tr>
		</table>
		<div id="swap1">
		  <table class="curve tbl_reg">
			<tr>
				<td colspan="1">First Name</td>
				<td colspan="3"><input class="fix" type="text" id="Name" name="Name" ng-model="user.Name" value="" required="required" placeholder=" *" ng-disabled="isDisabled"/></td>
		<!-- 	<td colspan="3"><input class="fix" type="text" id="Name" name="Name" ng-model="user.Name" value= //session.getAttribute("username").toString() required="required" placeholder=" *" ng-disabled="isDisabled"/></td> -->
			</tr>
			<tr>
				<td colspan="1">Last Name</td>
				<td colspan="3"><input class="fix" type="text" name="Family" ng-model="user.Family" value="" required="required" placeholder=" *" ng-disabled="isDisabled"/></td>
			</tr>
			<tr>
				<td colspan="1">
					Date of Birth
				</td>
				<td colspan="3" >
					<select class="fixMonths" style="background: white" name="MonthSelected" ng-change="birthDateCheck()" ng-init="user.MonthSelected = 'Month'" ng-model="user.MonthSelected" ng-style="BirthdateStyle" ng-disabled="isDisabled"> <%
	     				for(int i=0;i<Months.length;i++)
	     				{
	      					text=Months[i];
	      				%>
	      					<option value="<%=Months[i]%>"><%=text%></option>
	      				<%
	     				}	    	 
				        %>
        			</select>
					<select class="fixDays" style="background: white" name="DaysSelected" ng-change="birthDateCheck()" ng-init="user.DaysSelected = 'Day'" ng-model="user.DaysSelected" ng-style="BirthdateStyle" ng-disabled="isDisabled"> <%
	     				for(int i=0;i<Days.length;i++)
	     				{
	      					text=Days[i];
	      				%>
	      					<option value="<%=Days[i]%>"><%=text%></option>
	      				<%
	     				}	    	 
				        %>
        			</select>
					<select class="fixYears" style="background: white" name="YearSelected" ng-change="birthDateCheck()" ng-init="user.YearSelected = 'Year'" ng-model="user.YearSelected" ng-style="BirthdateStyle" ng-disabled="isDisabled"> <%
	     				for(int i=0;i<Years.length;i++)
	     				{
	      					text=Years[i];
	      				%>
	      					<option value="<%=Years[i]%>"><%=text%></option>
	      				<%
	     				}	    	 
				        %>
        			</select>
				</td>
			</tr>
			<tr>
				<td colspan="1">Care Card Number</td>
				<td colspan="3"><input class="fix"  name="CareCardNo" type="text" maxlength="10" ng-model="user.CareCardNo" ng-change="carecardCheck()" valid-number required="required" ng-disabled="isDisabled"  placeholder=" *" /></td>
			</tr>
			<tr>
				<td colspan="1">Primary Phone</td>
				<td colspan="3"><input class="fix" type="text" name="Primary_Phone" maxlength="10" ng-model="user.Primary_Phone" ng-change="phoneCheck()" valid-number required="required" ng-disabled="isDisabled" placeholder=" *" /></td>
			</tr>
			<tr>
				<td colspan="1">Emergency Phone</td>
				<td colspan="3"><input class="fix" type="text" name="Emergency_Phone" maxlength="10" ng-model="user.Emergency_Phone" ng-change="emergencyCheck()" valid-number required="required" ng-disabled="isDisabled" placeholder=" *" /></td>
			</tr>
			<tr>
				<td colspan="1">Email</td>
				<td colspan="3"><input class="fix" type="email" name="Primary_Email" ng-change="EmailCheck()" ng-model="user.Primary_Email" required="required" ng-disabled="isDisabled" placeholder=" *" /></td>
			</tr>
			<tr>
				<td colspan="1">
					Farsi Grade
				</td>
				<td colspan="1">
					<select class="fix" style="background: white" name="FarsiGrade" ng-change="FarsiGradeCheck()" ng-init="user.FarsiGrade = '---'" ng-model="user.FarsiGrade" ng-style="FarsiGradeStyle" ng-disabled="isDisabled"> <%
	     				for(int i=0;i<FarsiGrade.length;i++)
	     				{
	      					text=FarsiGrade[i];
	      				%>
	      					<option value="<%=FarsiGrade[i]%>"><%=text%></option>
	      				<%
	     				}	    	 
				        %>
        			</select>
				</td>
				<td colspan="1">
					&nbsp; Food Allergies
				</td>
				<td colspan="1" >
					<select class="fix" style="background: white" name="Restriction" ng-init="user.Restriction = 'No'" ng-disabled="isDisabled" ng-model="user.Restriction" >
						<option value="No">------</option>
						<option value="Nuts">Nuts</option>
						<option value="Dairy">Dairy</option>
						<option value="Wheat">Wheat</option>
						<option value="Soy">Soy</option>
						<option value="Fish">Fish</option>
						<option value="Eggs">Eggs</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="1">Address</td>
				<td colspan="3"><input class="fix" type="text" name="Address" ng-model="user.Address" required="required" ng-disabled="isDisabled" placeholder=" *" /></td>
			</tr>
			<tr>
				<td colspan="1">
					City
				</td>
				<td colspan="3">
					<select class="fix" style="background: white" name="City" ng-init="user.City = 'No'" ng-change="cityCheck()" ng-disabled="isDisabled" ng-style="CityStyle" ng-model="user.City" >
						<option value="No">-----------</option>
						<option value="North-Vancouver">North-Vancouver</option>
						<option value="West-Vancouver">West-Vancouver</option>
						<option value="Vancouver">Vancouver</option>
						<option value="Richmond">Richmond</option>
						<option value="Burnaby">Burnaby</option>
						<option value="New-Westminster">New Westminster</option>
						<option value="surrey">Surrey</option>
						<option value="Coquitlam">Coquitlam</option>
						<option value="Port-Coquitlam">Port-Coquitlam</option>
						<option value="Port-Moody">Port-Moody</option>
						<option value="Langley">Langley</option>
						<option value="Abbotsford">Abbotsford</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="1">Postal Code</td>
				<td colspan="3"><input class="fix" type="text" name="PostalCode" maxlength="6" ng-model="user.PostalCode" ng-change="postalcodeCheck()" onchange="this.value=removeSpaces(this.value);" required="required" ng-disabled="isDisabled" placeholder=" *" /></td>
			</tr>
			<tr>
				<td colspan="1">Password</td>
				<td colspan="3"><input class="fix" type="password" name="Password" maxlength="10" ng-model="user.Password" ng-change="passCheck()" required="required" ng-disabled="isDisabled" placeholder=" *" /><div ng-messages="registrationForm.password.$error" ng-messages-include="Messages.html"></div></td>
			</tr>
			<tr>
				<td colspan="1">Retype Password</td>
				<td colspan="3"><input class="fix" type="password" name="RePass" maxlength="10" ng-model="user.RePass" ng-change="passCheck()" compare-to="user.Password" ng-disabled="isDisabled" required="required" placeholder=" *" /><div ng-messages="registrationForm.RePass.$error" ng-messages-include="Messages.html"></div></td>
			</tr>
			<tr>
				<td colspan="1">Gender</td>
				<td colspan="3">
					<div ng-init="user.sex='male'" >
						<label>&nbsp; &nbsp; <input type="radio" name="sex" ng-model="user.sex" ng-disabled="isDisabled" value="male"> Male</label> 
						<label>&nbsp; &nbsp; <input type="radio" name="sex" ng-model="user.sex" ng-disabled="isDisabled" value="female" > Female</label>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="1">Details</td>
				<td colspan="3"><textarea class="text_area" name="Details" ng-disabled="isDisabled" ng-model="user.Details"></textarea></td>
			</tr>
			<tr>
				<td colspan="4"><label><input type="checkbox" name="term" ng-model="user.Term" ng-change="TermCheck()" ng-disabled="isDisabled" style="text-shadow: 3px 3px 8px #252525; outline: 1px solid #1e5180" che> &nbsp; To review terms and conditions <a target="_blank" href="Terms_Conditions.html"> click here!</a></label></td>
			</tr>
			<tr>
				<td class="curve-bottom" colspan="4">
					<input type="submit"  class="button"  value="Submit" ng-disabled="isSubDisabled" ng-click="SubmitDisable()" />
					<button type="button" class="button" ng-click="Reset()">Reset</button>
					<button type="button" class="button" ng-click="SubmitEnable()" ng-disabled="isDisabled" >Edit</button>
					<button type="button" class="button" onclick="goBack()">Back</button>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<div class="red_star" >
						<label>* &nbsp; = &nbsp; (Required field)</label>
					</div>
				</td>
			</tr>
		</table>
		</div>
	</form>
</body>
</html>