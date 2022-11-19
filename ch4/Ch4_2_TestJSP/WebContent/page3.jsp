<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
   <%@page import="java.util.ArrayList" %>
   <%@page import="tw.com.beans.Item" %>
<%@include file="menu.html" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<%
		String msg = 
		(String)request.getAttribute("reqAttr");
	
	String appValue =(String) application.getAttribute("appValue");
	ArrayList<Item> list = (ArrayList)session.getAttribute("itemList");
	%>
	
		
	<p>msg:<%=msg %></p>
	<p>appValue:<%=appValue %></p>
	<ol>
	<%for(Item it : list){ %>
		<li><%=it.getId()%>:<%=it.getName()%></li>
	<%} %>
	</ol>
</body>
</html>