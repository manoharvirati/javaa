<%@page import="com.harman.dto.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Display All Employees</title>
	</head>
	<body>
		<%
			ArrayList<Employee>  employees = (ArrayList<Employee>) request.getAttribute("emps");
		%>
		
		<table border="4">
			<tr>
				<th>ID</th><th>Name</th><th>Salary</th><th>Age</th><th>Email</th>
			</tr>
			
			<%
				for(Employee employee:employees){
				
			%>
			
				<tr>
					<td><%= employee.getEmpId() %></td>
					<td><%= employee.getName() %></td>
					<td><%= employee.getSalary() %></td>
					<td><%= employee.getAge() %></td>
					<td><%= employee.getEmail() %></td>
				</tr>
			
			<%	
				}
			
			%>
			
		</table>
		
	</body>
</html>