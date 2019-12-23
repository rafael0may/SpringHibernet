<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All States</title>
</head>
<body>
	<br>
	<br>
	<br>
	<a href="${pageContext.request.contextPath}/addState">Add State</a>
	<br>
	<h3>List of all states</h3>
	${message}
	<br>
	<br>
	<table border="1px" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th>Id</th>
				<th>description</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="state" items="${stateList}">
				<tr>
					<td>${state.id}</td>
					<td>${state.description}</td>
					<td><a
						href="${pageContext.request.contextPath}/editState/${state.id}">Edit</a></td>
					<td><a
						href="${pageContext.request.contextPath}/deleteState/${state.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>


	</table>
</body>
</html>