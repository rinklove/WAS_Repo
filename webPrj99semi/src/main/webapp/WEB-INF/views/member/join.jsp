<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id=wrap>
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		<main>
			<h1 align=center>회원가입</h1>
            <form action="${pageContext.request.contextPath}/member/join" method="post" onsubmit="return checkValidate();">
                <table>
                    <thead></thead>
                    <tbody>
                        <tr>
                            <th>아이디*</th>
                            <td><input type="text" name="memberId" id=""></td>
                            <td><button type="button" onclick="checkDuplication();">중복 체크</button></td>
                        </tr>
                        <tr>
                            <th>비밀번호*</th>
                            <td><input type="password" name="memberPwd" id=""></td>
                        </tr>
                        <tr>
                            <th>비밀번호 확인*</th>
                            <td><input type="password" name="memberPwd2" id=""></td>
                        </tr>
                        <tr>
                            <th>닉네임*</th>
                            <td><input type="text" name="memberNick" id=""></td>
                        </tr>
                        <tr>
                            <th>전화번호</th>
                            <td><input type="text" name="phone" id=""></td>
                        </tr>
                        <tr>
                            <th>이메일</th>
                            <td><input type="email" name="email" id=""></td>
                        </tr>
                        <tr>
                            <th>주소</th>
                            <td><input type="text" name="address" id=""></td>
                        </tr>
                        <tr>
                            <th>취미</th>
                            <td>
                                <label for="c1">게임</label><input type="checkbox" name="hobbys" id="c1" value="game">
                                <label for="c2">요리</label><input type="checkbox" name="hobbys" id="c2" value="cook">
                                <label for="c3">게임</label><input type="checkbox" name="hobbys" id="c3" value="workout">
                                <br>
                                <label for="c4">자바</label><input type="checkbox" name="hobbys" id="c4" value="java">
                                <label for="c5"> js</label><input type="checkbox" name="hobbys" id="c5" value="js">
                                <label for="c6">sql</label><input type="checkbox" name="hobbys" id="c6" value="sql">
                            </td>
                        </tr>
                        <tr>
                            <th colspan="2" ><input type="submit" value="회원가입"  style="width: 100%;"></th>
                        </tr>
                    </tbody>
                </table>
            </form>
		</main>
	</div>
    <script>
    
    	const checkDuplication = async () => {
    		const inputId = document.querySelector("main input[name=memberId]").value;
    		const result = await fetch("http://192.168.40.65:8888/app99/member/check/id?inputId="+inputId, {
    			method: "get"
    		}); 
			
    		const data = await result.json();
			alert(data.msg)
			window.idOk = data.msg === "사용불가합니다" ? false : true;
        	console.log(window.idOk);
    	};
    
        const checkValidate =  async () => {
        	if(!window.idOk) {
        		alert('아이디가 중복됩니다');
        		document.querySelector("input[name=id]").focus();
        		return false;
        	}

            //아이디 길이, 패스워드 길이, 패스워드 일치여부, 닉네임에 부적절한 단어 
            const memberId = document.querySelector("main input[name=memberId]").value;
            const memberIdRegex = /^[a-z0-9]{4,12}$/; //소문자, 숫자로 이루어진 문자 4자~12자
            const memberPwd2 = document.querySelector("main input[name=memberPwd2]").value;

            if(!memberIdRegex.test(memberId)) {
                alert('아이디를 바르게 입력하세요');
                document.querySelector("input[name=id]").focus();
                return false;
            }

            const memberPwd = document.querySelector("main input[name=memberPwd]").value;
            if(memberPwd.length < 4) {
                alert('비밀번호 길이를 다시 설정하세요');
                document.querySelector("input[name=memberPwd]").focus();
                return false;
            }
            
            if(memberPwd !== memberPwd2) {
                alert('비밀번호란과 확인란의 입력값이 다릅니다');
                document.querySelector("input[name=memberPwd2]").focus();
                return false;
            }

            const memberNick = document.querySelector("input[name=memberNick]").value;
            if(memberNick === "" || memberNick.toLowerCase().includes("admin")){
                alert("부적절한 닉네임입니다.");
                document.querySelector("input[name=memberNick]").focus();
                return false;
            }
            //이메일 형식, 전화번호 형식
            // alert('~ 문제')
            // return false;
            // // return true;
        }
    </script>
</body>
</html>