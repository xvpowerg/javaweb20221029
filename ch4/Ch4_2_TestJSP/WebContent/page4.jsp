<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<%@include file="menu.html" %>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<%
	
		String value = "Ken";
		pageContext.setAttribute("value", value);
	%>
	<div>
		<%=pageContext.getAttribute("value") %>
	</div>
</body>
</html>