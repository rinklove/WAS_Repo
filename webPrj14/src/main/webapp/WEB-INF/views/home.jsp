<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty userData}">
	    <h1 style="color: tomato;">${userData.memberNick}님 환영합니다~~~</h1>
    </c:if>
	<h1>홈페이지</h1>
	<c:choose>
	<c:when test="${empty userData }">
		<a href="${pageContext.request.contextPath}/member/join">회원가입</a><br>
		<a href="${pageContext.request.contextPath}/member/login">로그인</a><br>	
	</c:when>
	<c:otherwise>
		<a href="${pageContext.request.contextPath}/member/logout">로그아웃</a><br>	
	</c:otherwise>
	</c:choose>

</body>
</html>