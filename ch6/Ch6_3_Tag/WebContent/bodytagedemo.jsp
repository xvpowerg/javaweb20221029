<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
    <!--prefix�O  h uri �θ��|�覡���w  -->
    <%@taglib  prefix="h" uri="/WEB-INF/tld/customtag.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
	<%
	   String message = "Hello World";
	//�u��b�o�ӭ����ϥΪ�
	//��EL Ū����${message}	
	pageContext.setAttribute("message", message);	
	%>

</head>
<body>
		<div>
				<h:mybody message="${message}">
					<h2 style="font-size:48px;color:red">�A�n!!${message}</h2>
				</h:mybody>
		
		</div>
</body>
</html>