<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@page import="com.Initializer.ModelClasses.Student" %>
	
<!DOCTYPEhtml>

<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<h2>UPDATE PAGE</h2>
<hr>
<%Student stu =(Student)request.getAttribute("stu"); %>
<div align="center">
	<form action="update" method="post">
	<table border="1" width="50%" bgcolor="	#FFD700">
	<tbody>
	<tr>
	<td><br><label> Roll Number : <%=stu.getRollno()%> 
	<input type="hidden" name="rollno" value="<%=stu.getRollno()%>"  maxlength="50"><br> <br>
	</label></td>
	</tr>

	<tr>
	<td><br><label> Name : <%=stu.getName()%>
	<input type="text" name="name" value="<%=stu.getName()%>" maxlength="50"><br> <br>
	</label></td>
	</tr>
	
	<tr>
	<td><br><label> Mobile Number : <%=stu.getMobileno()%>
	<input type="text" name="mobileno" value="<%=stu.getMobileno()%>" maxlength="50"><br> <br>
	</label></td>
	</tr>
	
	<tr>
	<td><br><label> Marks : <%=stu.getMarks()%>
	<input type="text" name="marks" value="<%=stu.getMarks()%>" maxlength="50"><br> <br>
	</label></td>
	</tr>
	
	<tr>
	<td><br><label> Address : <%=stu.getAddress()%>
	<input type="text" name="address" value="<%=stu.getAddress()%>" maxlength="50"><br> <br>
	</label></td>
	</tr>


	<tr>
	<td align="center"><br><input type="submit" value="REGISTER"><br>
	<br></td>
	</tr>
      </tbody>
     </table>	
    </form>
  </div>

</body>
</html>