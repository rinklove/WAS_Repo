<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 작성</h1>
	<hr>
	<form action="/app12/board/write" method="post">
        <table>
            <thead></thead>
            <tbody>
                <tr>
                    <td>제목</td>
                    <td><input type="text" name="title" id=""></td>
                </tr>
                <tr>
                    <td>내용</td>
                    <td><input type="text" name="content" id=""></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" name="" id=""></td>
                </tr>
            </tbody>
        </table>
    </form>
</body>
</html>