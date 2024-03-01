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
    <form action="/app10/member/join" method="post">
        아이디 : <input type="text" name="memberId">
        <br>
        비밀번호 : <input type="password" name="memberPwd">
        <br>
        비밀번호 확인 : <input type="password" name="memberPwd2">
        <br>
        닉네임 : <input type="text" name="memberNick">
        <br>
        <input type="submit" value="회원가입">
    </form>
    <c:if test="${not empty member}">
        <p>아이디: ${member.get(0)}</p>
        <p>비밀번호: ${member.get(1)}</p>
        <p>비밀번호 확인: ${member.get(2)}</p>
        <p>닉네임: ${member.get(3)}</p>
    </c:if>
</body>
</html>