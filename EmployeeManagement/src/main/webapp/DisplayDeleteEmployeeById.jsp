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
			String empy =request.getParameter("empy");
		
			if(empy=="1"){
		%>
			
				<h3>Employee not deleted successfully</h3>
		
		<%
			}else{
		%>
			
			<h3>Employee deleted successfully</h3>
		
		<%
			}
		%>		

		<%-- Scriptlet tag <% %>
		Expression tag <%= %>
		Declarative tag <%! %> --%>
		Main content here
	</body>
</html>
<%@ include file="footer.jsp" %>