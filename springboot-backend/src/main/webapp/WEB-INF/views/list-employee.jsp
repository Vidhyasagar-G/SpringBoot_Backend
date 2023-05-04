<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page isELIgnored="false"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div class="container">
		<h3 class="center">Employee-Crud</h3>
		
		
			<input type="button" value="Add address"
				   onclick="window.location.href='showFormForAdd'; return false;"
				  class="btn btn-primary"
			/>
		
			
		<div class="row">
			<div class="col-md-12">
				<form action="/search" method="get">
					<input type="text" name="q" placeholder="Search">
					<button type="submit">Search</button>
				  </form>

			<table border="1"   >
			
				<tr>
					<th>Name</th>
					<th>DOB</th>
					<th>City</th>
					<th>Zipcode</th>
					<th>Action</th>
				</tr>
				
				
				<c:forEach var="tEmployee" items="${employee}">
				
				
					<c:url var="updateLink" value="/showFormForUpdate">
						<c:param name="employeeId" value="${tEmployee.id}" />
					</c:url>					

				
					<c:url var="deleteLink" value="/delete">
						<c:param name="employeeId" value="${tEmployee.id}" />
					</c:url>					
					
					
					<tr>
						<td> ${tEmployee.name} </td>
						<td> ${tEmployee.dob} </td>
						<td> ${tEmployee.city} </td>
						<td> ${tEmployee.zipcode} </td>
						<td>
							
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">Delete</a>
						</td>
						
					</tr>
						</c:forEach>
					
			</table>
			</div>	
		</div>	
			</div>
			

</body>
</html>