<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@include file="menu.html" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
		<%
		String info = this.getServletInfo();
		out.println(info);
			
		%>
	
</body>
</html>