<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보</h1>
    <table border=1>
        <thead>
            <tr>
                <th>회원번호</th>
                <th>회원아이디</th>
                <th>회원이름</th>
                <th>회원나이</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th>${user.userNo}</th>
                <th>${user.userId}</th>
                <th>${user.userName}</th>
                <th>${user.userAge}</th>
            </tr>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}">메인 페이지로 돌아가기</a>
    <h3>복붙 방지 이름 - 이준호</h3>
</body>
</html>