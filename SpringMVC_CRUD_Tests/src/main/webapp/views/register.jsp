<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPEhtml>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<style>  
label {
  padding-top: 10px;
  padding-left: 10px; 
  display:inline-block;
}
input{
  padding-top: 10px;
  padding-right: 50px;
  margin: 5px 40px;
}
.table-wrapper{
background: rgb(255,255,0,0.3);
}
body{
	font: 'Share Tech', sans-serif;
	color: white;
	align-items: center;
	margin: 0;
	text-shadow: 8px 8px 10px #0000008c;
	background-color: #343a40;
	background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='28' height='49' viewBox='0 0 28 49'%3E%3Cg fill-rule='evenodd'%3E%3Cg id='hexagons' fill='%239C92AC' fill-opacity='0.25' fill-rule='nonzero'%3E%3Cpath d='M13.99 9.25l13 7.5v15l-13 7.5L1 31.75v-15l12.99-7.5zM3 17.9v12.7l10.99 6.34 11-6.35V17.9l-11-6.34L3 17.9zM0 15l12.98-7.5V0h-2v6.35L0 12.69v2.3zm0 18.5L12.98 41v8h-2v-6.85L0 35.81v-2.3zM15 0v7.5L27.99 15H28v-2.31h-.01L17 6.35V0h-2zm0 49v-8l12.99-7.5H28v2.31h-.01L17 42.15V49h-2z'/%3E%3C/g%3E%3C/g%3E%3C/svg%3E"), linear-gradient(to right top, #343a40, #2b2c31, #211f22, #151314, #000000);
}

</style>
</head>
<body ><br>
	<h1 align="center">Registration Page</h1>
	<br>
	<br>

	<div align="center">
	<form action="reg" method="post">
	<table class="table-wrapper" border="1" width="50%">
	<tbody>
	<tr>
	<td><br><label> Roll Number : <input type="text" name="rollno" maxlength="50"><br> <br>
	</label></td>
	</tr>

	<tr>
	<td><br><label> Name : <input type="text" name="name" maxlength="50"><br> <br>
	</label></td>
	</tr>
	
	<tr>
	<td><br><label> Mobile Number : <input type="text" name="mobileno" maxlength="50"><br> <br>
	</label></td>
	</tr>
	
	<tr>
	<td><br><label> Marks : <input type="text" name="marks" maxlength="50"><br> <br>
	</label></td>
	</tr>
	
	<tr>
	<td><br><label> Address : <input type="text" name="address" maxlength="50"><br> <br>
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