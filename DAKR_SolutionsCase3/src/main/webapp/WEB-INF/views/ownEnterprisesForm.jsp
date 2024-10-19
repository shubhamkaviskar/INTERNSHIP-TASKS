<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Own Enterprises Form</title>
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
}

button:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<h2>Own Enterprises Form</h2>
	<form:form modelAttribute="ownEnterprises" action="${pageContext.request.contextPath}/saveOwnEnterprise" method="post">

		<div class="form-group">
			<form:label path="name">Name</form:label>
			<form:input path="name" />
			<form:errors path="name" cssClass="error" />
		</div>

		<div class="form-group">
			<form:label path="employeeCount">Employee Count</form:label>
			<form:input path="employeeCount" />
			<form:errors path="employeeCount" cssClass="error" />
		</div>

		<div class="form-group">
			<form:label path="clientTargets">Client Targets</form:label>
			<form:input path="clientTargets" />
			<form:errors path="clientTargets" cssClass="error" />
		</div>

		<div class="form-group">
			<form:label path="projectQuality">Project Quality</form:label>
			<form:input path="projectQuality" />
			<form:errors path="projectQuality" cssClass="error" />
		</div>

		<div class="form-group">
			<form:label path="clientSatisfaction">Client Satisfaction</form:label>
			<form:input path="clientSatisfaction" />
			<form:errors path="clientSatisfaction" cssClass="error" />
		</div>

		<div class="form-group">
			<button type="submit">Submit</button>
		</div>

	</form:form>
</body>
</html>
