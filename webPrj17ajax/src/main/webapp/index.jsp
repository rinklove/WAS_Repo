<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>홈페이지</h1>
	<button onclick="ajaxRest();">ajax 방식으로 요청 보내기</button>
</body>

<script type="text/javascript">

	const ajaxRest = async () => {
		//fetch(경로, 옵션)
		const result = await fetch("http://localhost:8888/app17/test", {
			method: "put"
		});
		const text = await result.json();

		console.log(text);
	} 
</script>
</html>