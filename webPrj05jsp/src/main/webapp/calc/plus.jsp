<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	Integer int1 = Integer.parseInt(request.getParameter("n1")) ;
    	Integer int2 = Integer.parseInt(request.getParameter("n2"));
    	
    	Integer result = int1+ int2;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>plus</title>
</head>
<body>
	<h1>결과: <%out.println(result); %></h1>
</body>
</html>