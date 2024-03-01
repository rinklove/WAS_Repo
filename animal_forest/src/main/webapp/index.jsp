<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>안녕하세요</title>
<link rel="StyleSheet"  href="${pageContext.request.contextPath}/css/index.css" type="text/css">
<link rel="StyleSheet"  href="${pageContext.request.contextPath}/css/background.css" type="text/css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container back-ground">
	<div class="container w-75 title-sector mt-3 mb-3">
		<a href="${pageContext.request.contextPath}/index.jsp" class="title"><h1>동물의 숲 커뮤니티 & 백과 사전</h1></a>
	</div>
 	<div class="container w-75 main-sector mb-4">
		<div class="sector-div mt-2 mb-2"><p class="text-white text">안녕하세요!</p></div>
		<div class="sector-div mt-2 mb-2"><p class="text-white text">하단에서 이용하실 서비스를</p></div>
		<div class="sector-div mt-2 mb-2"><p class="text-white text">선택해주세요</p></div>
	</div>
	<div class="container w-25 select-menu">
		<div class="container"><button type="button" class=" mb-2 btn btn-light btn-outline-warning" onclick="location.href  = ' ${pageContext.request.contextPath}/animalsearch/search.jsp' ">동물 추천 도감 조회</button></div>
		<div class="container"><button type="button" class="mb-2 btn btn-light btn-outline-warning"  onclick="location.href  = ' ${pageContext.request.contextPath}/front' ">게시판 이용하기</button></div>
		<div class="container"><button type="button" class="mb-2 btn btn-light btn-outline-warning"  onclick="location.href  = ' ${pageContext.request.contextPath}/user/login.jsp' ">로그인 하기</button></div>
		
	</div>
</div>
</body>
</html>

