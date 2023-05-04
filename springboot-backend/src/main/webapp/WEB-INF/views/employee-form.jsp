<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>ERM - Employee Relationship Management</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Employee</h3>
	
		<form:form action="saveemployee" modelAttribute="employee" method="POST">

		
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="name" /></td>
					</tr>
				
					<tr>
					<p>
						<td><label>Date of Birth:</label></td>
						<td><form:input path="dob" type="date" /></td>
					</p>
				</tr>
					<tr>
						<td><label>City:</label></td>
						<td><form:input path="city" /></td>
					</tr>
					
					<tr>
						<td><label>Zipcode:</label></td>
						<td><form:input path="zipcode" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/">Back to List</a>
		</p>
	
	</div>

</body>

</html>










