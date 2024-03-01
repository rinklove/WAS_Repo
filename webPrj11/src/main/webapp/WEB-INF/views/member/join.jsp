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
    <hr>
    
    <form action="/app11/member/join" method="post">
        <table>
            <thead></thead>
            <tbody>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" name="memberId" id=""></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="text" name="memberPwd" id=""></td>
                </tr>
                <tr>
                    <td>비밀번호 확인</td>
                    <td><input type="text" name="memberPwd2" id=""></td>
                </tr>
                <tr>
                    <td>닉네임</td>
                    <td><input type="text" name="memberNick" id=""></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" name="" id=""></td>
                </tr>
            </tbody>
        </table>
    </form>
</body>
</html>