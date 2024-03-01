<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
</head>
<body>
	<h1>${title }</h1>
	<h2>${session.getAttribute("uesrData")}</h2>
	<h1><%= request.getContextPath() %></h1>
	<h1>${pageContext.request.contextPath}</h1>
	<h1>${pageContext.request}</h1>
	<h1>${pageContext}</h1>
	<hr>
	<a href="${pageContext.request.contextPath}/member/join">회원가입</a>
	<br>
	<a href="${pageContext.request.contextPath}/member/login">로그인</a>
	<br>
	<a href="${pageContext.request.contextPath}/member/quit">회원탈퇴</a>
</body>
</html>