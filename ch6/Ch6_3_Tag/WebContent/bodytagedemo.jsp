<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
    <!--prefix是  h uri 用路徑方式指定  -->
    <%@taglib  prefix="h" uri="/WEB-INF/tld/customtag.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
	<%
	   String message = "Hello World";
	//只能在這個頁面使用的
	//用EL 讀取時${message}	
	pageContext.setAttribute("message", message);	
	%>

</head>
<body>
		<div>
				<h:mybody message="${message}">
					<h2 style="font-size:48px;color:red">你好!!${message}</h2>
				</h:mybody>
		
		</div>
</body>
</html>