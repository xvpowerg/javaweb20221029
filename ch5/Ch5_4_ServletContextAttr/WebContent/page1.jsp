<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	value1:<%=application.getAttribute("value1") %>
	value2:<%=application.getAttribute("value2") %>
	
	<hr>
	value1:${value1}
	value2:${value2}
</body>
</html>