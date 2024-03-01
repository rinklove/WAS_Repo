<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${result }: 실패</h1>
	<a href="javascript:history.back();">뒤로 이동하기</a>
	<script type="text/javascript">
		alert(`${reason }`);
	</script>
</body>
</html>