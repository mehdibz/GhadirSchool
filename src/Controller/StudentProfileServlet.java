package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.StudentModel;


/**
 * Servlet implementation class RegisterServlet
@WebServlet(value="/StudentRegisterServlet")
*/

public class StudentProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
    public StudentRegisterServlet() {
        super();
    }*/
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String uname,MaleCheck = null,FemaleCheck = null;
	    HttpSession session;
	    session=null;
	    
		request.setCharacterEncoding("UTF8");
		response.setCharacterEncoding("UTF-8");
		session=request.getSession();
	    	
			try{
				
				transaction tx = new transaction();
				uname=request.getSession().getAttribute("StdId").toString();
			    StudentModel std = tx.doRead(uname);
        		if(std.getGender().equals("male")){
        			MaleCheck="checked";
        			FemaleCheck="";
        		}else
        		{
        			FemaleCheck="checked";
        			MaleCheck="";
        		}
        		String[] parts = std.getBirthDate().split(",");
        		
            	String page=  "<table class='curve tbl_reg SuccessSubmit'>"
            				+ "<tr><td colspan='1'>Student ID: </td><td colspan='3'>"+std.getId()+"</td></tr>"
            				+ "<tr><td colspan='1'>Submitted Date: </td><td colspan='3'>"+std.getDateTime()+"</td></tr></table>"
							+ "<table class='curve tbl_reg'>"
 							+ "<tr><td colspan='1'>First Name</td><td colspan='3'><input class='fix' type='text' id='Name' name='Name' value='"+std.getFname()+"' required='required' placeholder=' *' disabled/></td></tr>"
							+ "<tr><td colspan='1'>Last Name</td><td colspan='3'><input class='fix' type='text' name='Family' value='"+std.getLname()+"' required='required' placeholder=' *' disabled/></td></tr>"
							+ "<tr><td colspan='1'>Date of Birth</td><td colspan='3'>"
							+ "<select class='fixMonths' style='background: white' name='MonthSelected' ng-change='birthDateCheck()' ng-model='user.MonthSelected' ng-style='BirthdateStyle' disabled/><option value=''>"+parts[0]+"</option></select>"
							+ "<select class='fixDays' style='background: white' name='DaysSelected' ng-change='birthDateCheck()'  ng-model='user.DaysSelected' ng-style='BirthdateStyle' disabled> <option value=''>"+parts[1]+"</option></select>"
							+ "<select class='fixYears' style='background: white' name='YearSelected' ng-change='birthDateCheck()' ng-model='user.YearSelected' ng-style='BirthdateStyle' disabled/> <option value=''>"+parts[2]+"</option></select>"
							+ "</td></tr>"
							+ "<tr><td colspan='1'>Care Card Number</td><td colspan='3'><input class='fix'  name='CareCardNo' type='text' value='"+std.getCarecard()+"' maxlength='10' ng-change='carecardCheck()' valid-number required='required' placeholder=' *' disabled/></td></tr>"
							+ "<tr><td colspan='1'>Primary Phone</td><td colspan='3'><input class='fix' type='text' name='Primary_Phone' value='"+std.getPhone()+"' maxlength='10' ng-change='phoneCheck()' valid-number required='required' placeholder=' *' disabled/></td></tr>"
							+ "<tr><td colspan='1'>Emergency Phone</td><td colspan='3'><input class='fix' type='text' name='Emergency_Phone' maxlength='10' ng-change='emergencyCheck()' valid-number required='required' value='"+std.getEmergency()+"' placeholder=' *' disabled/></td></tr>"
							+ "<tr><td colspan='1'>Email</td><td colspan='3'><input class='fix' type='email' name='Primary_Email' ng-change='EmailCheck()' required='required' value='"+std.getEmail()+"' placeholder=' *' disabled/></td></tr>"
							+ "<tr><td colspan='1'>Farsi Grade</td><td colspan='1'><select class='fix' style='background: white' name='FarsiGrade' ng-change='FarsiGradeCheck()' ng-style='FarsiGradeStyle' disabled/><option value=''>"+std.getFarsiGrade()+"</option></select></td>"
							+ "<td colspan='1'> &nbsp; Food Allergies</td><td colspan='1'><select class='fix' style='background: white' name='Restriction' disabled><option value=''>"+std.getRestriction()+"</option></select></td></tr>"
							+ "<tr><td colspan='1'>Address</td><td colspan='3'><input class='fix' type='text' name='Address' value='"+std.getAddress()+"' required='required' placeholder=' *' disabled/></td></tr>"
							+ "<tr><td colspan='1'>City</td><td colspan='3'><select class='fix' style='background: white' name='City' ng-change='cityCheck()' ng-style='CityStyle' disabled/><option value=''>"+std.getCity()+"</option></select></td></tr>"
							+ "<tr><td colspan='1'>Postal Code</td><td colspan='3'><input class='fix' type='text' name='PostalCode' maxlength='6' ng-change='postalcodeCheck()' onchange='this.value=removeSpaces(this.value);' required='required' value='"+std.getPostalCode()+"' placeholder=' *' disabled/></td></tr>"
							+ "<tr><td colspan='1'>Password</td><td colspan='3'><input class='fix' type='password' name='Password' maxlength='10' ng-change='passCheck()' required='required' value='"+std.getPassword()+"' placeholder=' *' disabled/><div ng-messages='registrationForm.password.$error' ng-messages-include='Messages.html'></div></td></tr>"
							+ "<tr><td colspan='1'>Retype Password</td><td colspan='3'><input class='fix' type='password' name='RePass' maxlength='10' ng-model='user.RePass' ng-change='passCheck()' compare-to='user.Password' value='"+std.getPassword()+"' required='required' placeholder=' *' disabled/></td></tr>"
							+ "<tr><td colspan='1'>Gender</td><td colspan='3'><div><label>&nbsp; &nbsp; <input type='radio' name='sex' ng-model='user.sex' value=''" + MaleCheck +" disabled/>Male </label><label>&nbsp; &nbsp; <input type='radio' name='sex' value='' " + FemaleCheck +" disabled> Female</label></div></td></tr>"
							+ "<tr><td colspan='1'>Details</td><td colspan='3'><textarea class='text_area' name='Details' disabled>"+std.getDetails()+"</textarea></td></tr>"
							+ "<tr><td colspan='4'><label><input type='checkbox' name='term' ng-model='user.Term' ng-change='TermCheck()' style='text-shadow: 3px 3px 8px #252525; outline: 1px solid #1e5180' checked='checked' disabled> &nbsp; To review terms and conditions <a target='_blank' href='Terms_Conditions.html'> click here!</a></label></td></tr>"
							+ "<tr><td class='curve-bottom' colspan='4'><input type='submit'  class='button'  value='Submit' ng-disabled='isSubDisabled' ng-click='SubmitDisable()'/><button type='button' class='button' ng-click='Reset()'>Reset</button>"
							+ "<button type='button' class='button' ng-disabled='isDisabled'/>Edit</button><a href='logout.jsp'><button type='button' class='button'>Log Out!</button></a></td></tr>"
							+ "<tr><td colspan='4'><div class='red_star'><label>* &nbsp; = &nbsp; (Required field)</label></div></td></tr></table>";

        		request.getSession().setAttribute("StudentINFO", page);
        	//	response.sendRedirect("Std_Profile_Wellcome.jsp");
        		request.getRequestDispatcher("Std_Profile_Wellcome.jsp").forward(request, response);
        		
			}catch (Exception e) {
				
			}
    	session.setMaxInactiveInterval(10*60);
	}
}
