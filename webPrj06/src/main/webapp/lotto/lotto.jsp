<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Integer number = (int) (Math.random()*6 + 10);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>10 ~ 15 사이의 숫자: <%out.println(number); %></p>
</body>
</html>