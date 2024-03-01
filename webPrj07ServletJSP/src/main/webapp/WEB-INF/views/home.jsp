<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String a = (String) (request.getAttribute("k01"));
    	String color = (String) (request.getAttribute("color"));
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>홈 jsp</h1>
	<h2><%= color %></h2>
</body>
</html>