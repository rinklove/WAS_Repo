<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
</head>
<body>
	<h1>${title}</h1>
	<form action="/app08/member/join/processor" method="post">
		아이디: <input type="text" name="memberId" id=""><br>
		비밀번호: <input type="password" name="memberPwd"><br>
		비밀번호2: <input type="password" name="memberPwd2" id=""><br>
		닉네임: <input type="text" name="memberNick" id=""><br>
		<input type="submit" name="" value="회원가입">
	</form>
	<a href="/app08/home">뒤로가기(절대경로)</a><br>
	<a href="../home">뒤로가기(상대경로)</a>
</body>
</html>