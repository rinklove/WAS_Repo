<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/app99/resources/css/board/detail.css">
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
			<h1>게시글 상세 조회</h1>

			<table border="1">
				<tbody>
					<tr>
						<td>${board.title}</td>
						<td>${board.writerNick}</td>
					</tr>
					<tr>
						<td>${board.enrollDate}</td>
						<td>${board.hit}</td>
					</tr>
					<tr>
						<td colspan="2">${board.content}</td>
					</tr>
				</tbody>
			</table>
			<div class="btn-area">
			<c:if test="${loginMember.no eq board.writerNo }">
				<button onclick="location.href='/app99/board/edit?no=${board.no}'">수정</button>
				<button onclick="location.href='/app99/board/delete?no=${board.no}'">삭제</button>			
			</c:if>
			<button onclick="location.href='/app99/board/list?pno=${currentPage}'">목록으로 가기</button>			
			</div>
		</main>
	</div>
</body>
</html>