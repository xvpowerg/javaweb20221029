<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="menu.html" %>
<!DOCTYPE html>
<html>
<head>
<%
String title = request.getParameter("title");
String count = request.getParameter("count");
int countInt = count == null ?0:Integer.parseInt(count);
%>
<meta charset="BIG5">
<title><%=title %></title>
</head>
<body>
		<ol>
			<%
				char c = 'A';
			for (int i = 1; i<= countInt;i++){
			%>
					<li><%=c++ %></li>
			<%} %>
		</ol>		
</body>
</html>