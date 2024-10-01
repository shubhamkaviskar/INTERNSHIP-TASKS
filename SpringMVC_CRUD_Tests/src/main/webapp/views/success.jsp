<%@page import="com.Initializer.ModelClasses.Student" %>
<%@page import="java.util.List" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPEhtml>
<html>
<head>
<meta charset="ISO-8859-1">

<style >
h1{
	font-size: 40px;
	font-family: Arial, Helvetica, sans-serif;
	background: linear-gradient(to right, white, lime, cyan, blue);
	-webkit-text-fill-color: transparent;
	-webkit-background-clip: text;
	text-shadow: 8px 8px 10px #0000008c;
}
.bg-image{
 	background-image: url("https://r4.wallpaperflare.com/wallpaper/999/511/622/8k-uhd-3d-digital-art-abstract-art-wallpaper-c3db530ded39cb45af669217782b08e8.jpg");
	background-size: cover;
	background-position: center;
	background-attachment: fixed;
}
.bg-text {
  background-color: rgb(0,0,0.3); /* Fallback color */
  background-color: rgba(0,0,0,0.2); /* Black w/opacity/see-through */
  color: white;
  font-weight: bold;
  border: 2px solid #f1f1f1;
  padding: 20px;
  text-align: center;
}
body{
backdrop-filter: blur(5px);
}
</style>

<title>Student Data</title>

<script type="text/javascript">
function addStudent(){
	alert("Adding New Student ?")
	document.myForm.action="regPage";
	document.myForm.submit();
}
</script>
<script type="text/javascript">
function deleteStudent(){
	alert("Deleting Selected Student Data!")
	document.myForm.action="delete";
	document.myForm.submit();
}
function editStudent(){
	alert("Edit Values of Selected Student Data!")
	document.myForm.action="edit";
	document.myForm.submit();
}
</script>

</head>


<body class="bg-image" align="center">
<h1>Welcome To Success Page</h1>
<div class="bg-text" >
<% List<Student>stulist = (List<Student>)request.getAttribute("data");%>
<form name="myForm">
<table class="table-wrapper" border="3px" width="60%" bgcolor="" align="center" cellspacing="6px">
<thead>
<tr>
<th>Select</th>
<th>RollNo</th>
<th>Name</th>
<th>Marks</th>
<th>MobileNo</th>
<th>Address</th>
</tr>
</thead>
<tbody>
<%for(Student stu:stulist) { %>
<tr> 
<td><input type="radio" name="rollno" value="<%=stu.getRollno()%>"></td>
<td><%=stu.getRollno()%></td>
<td><%=stu.getName()%></td>
<td><%=stu.getMarks()%></td>
<td><%=stu.getMobileno()%></td>
<td><%=stu.getAddress()%></td>
</tr>
<%}%>
</tbody>
</table><br>
<input type="submit" value="ADD" onclick="addStudent()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" value="UPDATE" onclick="editStudent()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" value="DELETE" onclick="deleteStudent()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</form>
</div>
</body>
</html>