<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import="java.sql.*"
	import="javax.servlet.*"
	import="javax.sql.*"
	import="java.util.*"
	import="jbean.Main_db"
    %>
<jsp:useBean id="GH" scope="application" class="jbean.Main_db"/>
<jsp:setProperty property="*" name="GH"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <title>Registration</title>
        <link rel="stylesheet" href="css/FirstMenu.css">
    </head>
    <body>
        <form method="post" action="registration.jsp">
           			<div>
                		<nav>
                    		<ul>
                        		<li><label id="rd" ><input type="radio" name="sex" value="male" checked>Male</label></li>
                        		<li><label id="rd" ><input type="radio" name="sex" value="female">Female</label></li>
	    	                </ul>
    	            	</nav>
           			</div>
            <table class="curve tbl_reg"  border="1">
	                <tr>
                        <th class="curve-top" colspan="2">Student Information</th>
                    </tr>

                	<tr>
                        <td id="fixlbl" >Student ID</td>
                        <td><input id="fix" type="text" name="userid" value="" /></td>
                    </tr>
                    <tr>
                        <td id="fixlbl" >First Name</td>
                        <td><input id="fix" type="text" name="Name" value="" /></td>
                    </tr>
                    <tr>
                        <td id="fixlbl" >Last Name</td>
                        <td><input id="fix" type="text" name="Family" value="" /></td>
                    </tr>
                    <tr>
                        <td id="fixlbl" >Password</td>
                        <td><input id="fix" type="password" name="Pass" value="" /></td>
                    </tr>
                    <tr>
                        <td id="fixlbl" >RetypePassword</td>
                        <td><input id="fix" type="password" name="RePass" value="" /></td>
                    </tr>
                    <tr>
                        <td id="fixlbl" >Date of Birth</td>
                        <td><input id="fix" type="text" name="BirthDate" value="" /></td>
                    </tr>
                    <tr>
                        <td id="fixlbl" >Primary Email</td>
                        <td><input id="fix" type="text" name="Primary_Email" value="" /></td>
                    </tr>
                    <tr>
                        <td id="fixlbl" >Primary Phone</td>
                        <td><input id="fix" type="text" name="Primary_Phone" value="" /></td>
                    </tr>
                    <tr>
                        <td id="fixlbl" >Emergency Contact</td>
                        <td><input id="fix" type="text" name=Emergency_Contact value="" /></td>
                    </tr>
                    <tr>
                        <td id="fixlbl" >Address</td>
                        <td><input id="fix" type="text" name="Address" value="" /></td>
                    </tr>
                    <tr>
                        <td>Other Details</td>
                        <td><textarea id="text_area" name="Details" ></textarea></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Already registered!! <a href="index.html">Login Here</a></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>