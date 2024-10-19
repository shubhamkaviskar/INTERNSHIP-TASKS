<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DAKR Solutions Form</title>
<style>
.error {
	color: red;
	font-size: 12px;
}

.form-group {
	margin-bottom: 15px;
}

label {
	display: block;
	font-weight: bold;
	padding: 10px 15px;
	font-size: 20px;
}

input {
	width: 50%;
	padding: 8px;
	margin-top: 5px;
	border-radius: 4px;
	border: 1px solid #ccc;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 10px 15px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	padding-right : 50px;
}

button:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<h2>DAKR Solutions Form</h2>
	<!-- Form starts here -->
	<form:form modelAttribute="dakrSolutions"
		action="${pageContext.request.contextPath}/saveForm" method="post">
		
		<div class="form-group">
			<form:label path="id">ID</form:label>
			<form:input path="id" />
			<form:errors path="id" cssClass="error" />
		</div>

		<div class="form-group">
			<form:label path="name">Name</form:label>
			<form:input path="name" />
			<form:errors path="name" cssClass="error" />
		</div>

		<div class="form-group">
			<form:label path="goal">Goal</form:label>
			<form:input path="goal" />
			<form:errors path="goal" cssClass="error" />
		</div>

		<div class="form-group">
			<form:label path="fiveYearRoadmap">Five-Year Roadmap</form:label>
			<form:input path="fiveYearRoadmap" />
			<form:errors path="fiveYearRoadmap" cssClass="error" />
		</div>

		<div class="form-group">
			<button type="submit">Submit</button>
		</div>

	</form:form>
</body>
</html>
