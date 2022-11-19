<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<h2>Item</h2>
	<p>name:${item1.name}</p>
	<p>price:${item1.price}</p>
	<h2>User</h2>
	 <p>name:${user1.name}</p>
	 <p>age:${user1.age}</p>
	 
	 <h2>UserList</h2>
	 <c:forEach var="myUser" items="${userList}">
	 		<p>name:${myUser.name}</p>
	 		<p>age:${myUser.age}</p>
	 </c:forEach>
	 
	 <h2>Map</h2>
	 <p>${userMap.user1.name}</p>
	 <p>${userMap["my user2"].name}</p>
</body>
</html>