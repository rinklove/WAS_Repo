<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="${pageContext.request.contextPath}/css/signUp.css" rel="stylesheet" type="text/css" />
<link rel="StyleSheet"  href="${pageContext.request.contextPath}/css/background.css" type="text/css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container w-50 login mt-5 p-5">
	<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/front">
			<input type="hidden" name="key" value = "user" /> <!-- Controller를 찾는 정보 -->
			<input type="hidden" name="methodName" value = "insert" />  <!-- 메소드이름 -->
			<fieldset>
				<legend>회원가입</legend>
				<div class="form-group">
					<label for="userId" class="col-lg-2 control-label">아이디</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="userId" name="userId"
							placeholder="아이디">
					</div>
				</div>
				<div class="form-group mt-3">
					<label for="pwd" class="col-lg-2 control-label">비밀번호</label>
					<div class="col-lg-10">
						<input type="password" class="form-control" id="pwd" name="pwd"
							placeholder="비밀번호">
					</div>
				</div>
				<div class="form-group mb-3 mt-3">
					<label for="userId" class="col-lg-2 control-label">닉네임</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="nickName" name="nickName"
							placeholder="닉네임">
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-10 col-lg-offset-2">
						<button type="button" class="btn btn-secondary"  onclick="history.back();">이전 화면으로</button>
						<button type="submit" class="btn btn-success" onclick="signUpSuccess();">회원등록하기</button>
					</div>
				</div>
			</fieldset>
		</form>
	</div>	
	<script type="text/javascript">
	function signUpSuccess() {
		if(!(${result}==0)) {
			alert(${okMessage});
		}
	}
	</script>
</body>
</html>