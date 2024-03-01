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
	<h2>파일 업로드</h2>
	<form action="${pageContext.request.contextPath }/file/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="uploadFile">
		<input type="submit" value="파일 업로드">
	</form>
</body>
</html>