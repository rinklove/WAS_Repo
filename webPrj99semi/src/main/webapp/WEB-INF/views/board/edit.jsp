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
		
		<form action="${pageContext.request.contextPath}/board/edit" method="post">
		<main>
			<h1>게시글 수정</h1>
			<input type="text" name="no" value="${no }" style="display: none;">
			카테고리:
			<select name="category" id="" >
			<c:forEach var="element" items="${list }">
				<option value="${element.no }" <c:if test="${board.categoryNo eq element.no}">selected</c:if>>${element.categoryName }</option>
			</c:forEach>
			</select>
			제목: <input type="text" name="title" id="" placeholder="제목을 입력하세요" value="${board.title }">
			내용: <textarea name="content"  id="" cols="30" rows="10">${board.content }</textarea>
			
			<input type="submit" value="수정하기">
		</main>
		</form>
	</div>
</body>
</html>