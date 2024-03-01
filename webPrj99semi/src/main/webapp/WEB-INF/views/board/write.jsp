<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board/write.css">
</head>
<body>

	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<form action="${pageContext.request.contextPath}/board/write" method="post">
		<main>
			<h1>게시글 작성</h1>
			
			카테고리:
			<select name="category" id="">
			<c:forEach var="element" items="${list }">
				<option value="${element.no }">${element.categoryName }</option>
			</c:forEach>
			</select>
			제목: <input type="text" name="title" id="" placeholder="제목을 입력하세요">
			내용: <textarea name="content"  id="" cols="30" rows="10"></textarea>
			
			<input type="submit" value="작성하기">
		</main>
		</form>
	</div>
</body>
</html>