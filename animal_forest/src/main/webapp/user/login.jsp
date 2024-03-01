<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp"/>
<div class="jumbotron">
	<h1>Login</h1>
	<p>Login, Filter/HttpSession</p>
	<p>
		<a class="btn btn-primary btn-lg">Learn more</a>
	</p>
</div>
<div class="bg-warning p-5 mb-3">
<c:choose>
	<c:when test="${empty loginUser}">
		<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/front">
			<input type="hidden" name="key" value = "user" /> 
			<input type="hidden" name="methodName" value = "login" /> 
			<fieldset>
				<legend>로그인</legend>
				<div class="form-group">
					<label for="userId" class="col-lg-2 control-label">아이디</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="userId" name="userId"
							placeholder="아이디를 입력하세요">
					</div>
				</div>
				<div class="form-group">
					<label for="pwd" class="col-lg-2 control-label">비밀번호</label>
					<div class="col-lg-10">
						<input type="password" class="form-control" id="pwd" name="pwd"
							placeholder="비밀번호">
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-10 col-lg-offset-2">
						<button type="button" class="btn btn-secondary" onclick="location.href='${pageContext.request.contextPath}/user/signUp.jsp' ">회원가입하기</button>
						<button type="submit" class="btn btn-success" >로그인</button>
					</div>
				</div>
			</fieldset>
		</form>
	</c:when>
	<c:otherwise>
			<legend>Login</legend>
			<blockquote>
				<p>My Shopping Mall!</p>

				<div class="alert alert-dismissible alert-warning">
					<button type="button" class="close" data-dismiss="alert">Ã</button>
					<h4>Welcome!</h4>
					<p>
						<a href="#" class="alert-link">${loginUser} / ${loginName}</a>.
					</p>
				</div>
			</blockquote>
	</c:otherwise>
</c:choose>
</div>


<jsp:include page="../common/footer.jsp"/>

