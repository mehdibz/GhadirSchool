<!DOCTYPE html>
		<%@ page 
		language="java"
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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html"  charset=UTF-8>
        	<title>Tool Page</title>
        <link rel="stylesheet" href="css/FirstMenu.css">
     
    </head>
    <body id="ToolPage">
    	<span id="digitalclock" class="styling2"></span>
	
    <form method="post" action="ControllerProfile" >
	   	<div id="ViewBody">
	   		<input type=hidden name="ini"  value="ToolPage">
	   		
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
	     
		Vector Result,List;
		List= GH.getList();
		Enumeration enum1=List.elements();

		//Result = GH.getResult();
	 	%>
		<div id="view_combo_div">
			<select id="view_combo_stdName" name="std_name" onchange="">
				<option  value="-">لیست دانش آموزان</option>
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
	</div>
		<label>محاسبه و نمایش انضباط کل<input type="submit" value="نمایش و ثبت"/></label>
	</div>
	<div >
	${Result_Note}
	</div>
	</form>
</body>
</html>

