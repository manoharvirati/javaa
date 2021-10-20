<%@page import="com.harman.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
 <!-- JSP Scripting Tags 4-->
		<%-- Directive tag <%@ %> --%>  <!-- Metadata tag of Java code -->
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Employee Details By Id</title>
	</head>
	<body>

		<%
			Employee employee = (Employee) request.getAttribute("emp");
		%>
		
		<table border="4">
			<tr>
				<th>ID</th><th>Name</th><th>Salary</th><th>Age</th><th>Email</th>
			</tr>
			<tr>
				<td><%= employee.getEmpId() %></td>
				<td><%= employee.getName()%></td>
				<td><%= employee.getSalary() %></td>
				<td><%= employee.getAge()%></td>
				<td><%= employee.getEmail() %></td>
			</tr>
		</table>

		<%-- Scriptlet tag <% %>
		Expression tag <%= %>
		Declarative tag <%! %> --%>
		Main content here
	</body>
</html>
<%@ include file="footer.jsp" %>