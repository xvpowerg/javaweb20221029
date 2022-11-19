<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@page import="tw.com.beans.Item" %>
<%@page import="tw.com.beans.User" %>    
<%@page import="java.util.List" %>  
<%@page import="java.util.Map" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<%
	   Item item = (Item)request.getAttribute("item1");
	   User user = (User)session.getAttribute("user1"); 
	   List<User> userList = (List)session.getAttribute("userList");
	   Map<String,User> userMap = (Map<String,User>)session.getAttribute("userMap");
	   
	%>
	<h2>Item</h2>
	<p>name:<%=item.getName()%></p>
	<p>price:<%=item.getPrice()%></p>
	
	<h2>User</h2>
	<p>name:<%=user.getName() %>
	<p>age:<%=user.getAge() %>
	
	<h2>UserList</h2>
	<%for(User u: userList){ %>
		<p>name:<%=u.getName() %></p>
		<p>age:<%=u.getAge() %></p>
	<%} %>
	
	<h2>User Map</h2>
	<%=userMap.get("user1").getName() %>
    <%=userMap.get("my user2").getName() %>
</body>
</html>