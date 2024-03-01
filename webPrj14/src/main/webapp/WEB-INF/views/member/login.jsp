<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
	<hr>
	<form action="${pageContext.request.contextPath}/member/login" method="post">  
        <table>
            <tbody>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" name="memberId"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" name="memberPwd"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" style="width:100%;"  value="로그인 "></td>
                </tr>
            </tbody>
        </table>
    </form>
</body>
</html>