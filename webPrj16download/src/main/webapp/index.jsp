<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>홈페이지</h1>
	<h2>다운로드</h2>
	<a href="${pageContext.request.contextPath }/file/download")>다운로드</a>
	<br>
	<a download href="${pageContext.request.contextPath }/resources/profile/abc.png">사진파일 보기</a>
</body>
</html>