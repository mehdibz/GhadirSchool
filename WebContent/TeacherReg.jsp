<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import="java.sql.*"
	import="javax.servlet.*"
	import="javax.sql.*"
	import="java.util.*"
	import="jbean.Main_db"
    %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <title>Registration</title>
        <link rel="stylesheet" href="css/FirstMenu.css">
    </head>
    <body>
        <form method="post" action="TeacherRegisterServlet">
           
            <table class="curve tbl_reg"  border="1">

                    <tr>
                        <th class="curve-top" colspan="2">ثبت اطلاعات معلم جدید</th>
                    </tr>
                	<tr>
                        <td id="fixlbl" >کد کاربری</td>
                        <td><input id="fix" type="text" name="userid" value="" required/></td>
                    </tr>
                    <tr>
                        <td id="fixlbl" >نام</td>
                        <td><input id="fix" type="text" name="Name" value="" required/></td>
                    </tr>
                    <tr>
                        <td id="fixlbl" >نام خانوادگی</td>
                        <td><input id="fix" type="text" name="Family" value="" required/></td>
                    </tr>
                    <tr>
                        <td id="fixlbl" >تلفن</td>
                        <td><input id="fix" type="text" name="Phone" value="" required/></td>
                    </tr>
                    <tr>
                        <td id="fixlbl" >پست الکترونیک</td>
                        <td><input id="fix" type="text" name="Email" value="" required/></td>
                    </tr>
                    <tr>
                        <td id="fixlbl" >پسورد</td>
                        <td><input id="fix" type="password" name="Pass" value="" required/></td>
                    </tr>
                    <tr>
                        <td id="fixlbl" >پسورد مجدد</td>
                        <td><input id="fix" type="password" name="RePass" value="" required/></td>
                    </tr>
                    <tr>
                        <td id="fixlbl" >سطح دسترسی</td>
                        <td><input id="fix" type="text" name="Authority" value="" required/></td>
                    </tr>
                    <tr>
                        <td id="fixlbl" >فارسی</td>
                        <td><input id="fix" type="text" name="Farsi" value="" /></td>
                    </tr>
                    <tr>
                        <td id="fixlbl" >دینی</td>
                        <td><input id="fix" type="text" name="Religion" value="" /></td>
                    </tr>
                    <tr>
                        <td id="fixlbl" >قرآن</td>
                        <td><input id="fix" type="text" name="Quran" value="" /></td>
                    </tr>
                    <tr>
                        <td id="fixlbl" >نماز</td>
                        <td><input id="fix" type="text" name="Salat" value="" /></td>
                    </tr>
                    <tr>
                        <td>ملاحظات</td>
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
