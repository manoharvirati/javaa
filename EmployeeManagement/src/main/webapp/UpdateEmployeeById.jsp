<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ include file="header.jsp" %>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Update Employee By Id</title>
	</head>
	<body>
		<%
		String res = request.getParameter("result");		
			if(res==null){
		%>
			
				<h3>Employee Updated successfully</h3>
		
		<%
			}else{
		%>
			
			<h3>Employee is not Update successfully. Please try again</h3>
		
		<%
			}
		%>
	</body>
</html>

<%@ include file="footer.jsp" %>