<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPEhtml>
<html>
<head>
<style>
#bg {
	background-image: linear-gradient(to right, rgba(255, 0, 0, 0),
		rgba(255, 0, 0, 1));
}

html {
	background-image: linear-gradient(to left, rgba(0, 60, 60, 60),
		rgba(0, 0, 0, 1));
}

h1 {
	font-size: 40px;
	font-family: Arial, Helvetica, sans-serif;
	background: linear-gradient(to right, #f32170, #ff6b08, #cf23cf, #eedd44);
	-webkit-text-fill-color: transparent;
	-webkit-background-clip: text;
}
</style>
<meta charset="ISO-8859-1">
<h1 align="center">Welcome To Shubham's Page</h1>
<hr>
</head>
<body>
	<div id="bg">
		<form action="log">
			<table width="40%" align="center">
				<tr>
					<td colspan=8 align="center"><font size=6><b>Login
								Here</b></font> <br></td>
				</tr>
				<br>
				<tr>
					<td>Username :</td>
					<td><input type="text" size=40 name="username"></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="Password" size=40 name="password"></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr align="center">
					<td><input type="Reset"></td>
					<td><input type="submit" value="Login"></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
			</table>
		</form>
	</div>
</body>
</html>
