<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>동물의 숲 백과사전</title>

<link rel="StyleSheet"  href="${pageContext.request.contextPath}/css/background.css" type="text/css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="StyleSheet"  href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>

</head>
<body>
<div class="container w-75 title-sector mt-4 mb-4">
		<a href="${pageContext.request.contextPath}/index.jsp" class="title"><h1>동물의 숲 커뮤니티 & 백과 사전</h1></a>
	</div>
<div class="navbar navbar-expand-lg navbar-info px-2 ">
  <div class="nav navbar-nav">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">

    </button>
     <a class="navbar-brand text-dark" href="${path}/index.jsp">홈</a>
    <a class="navbar-brand text-dark" href="${path}/user/login.jsp">로그인</a>
  
  </div>
  
  <div class="navbar-collapse collapse navbar-responsive-collapse">
    <ul class="nav navbar-nav">
     
      <li><a href="${pageContext.request.contextPath}/animalsearch/search.jsp" class="navbar-brand text-dark">도감 검색하기</a></li>
      <li><a href="${pageContext.request.contextPath}/front" class="navbar-brand text-dark">게시판</a></li>
     </ul>
     
     <c:if test="${not empty loginUser}">
	     <ul class="nav navbar-nav navbar-right">
	     	<li class="active"><a href="#" class="text-dark">${loginUser.userId}!</a></li>
	      	<li><a href="${pageContext.request.contextPath}/front?key=user&methodName=logout" class="btn btn-danger navbar-brand">Logout</a></li>
	     </ul>
     </c:if>
     
  </div>
</div>



