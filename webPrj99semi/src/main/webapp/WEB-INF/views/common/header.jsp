<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String x = (String) session.getAttribute("alertMsg");
	session.removeAttribute("alertMsg");
%>

<link rel="stylesheet" href="/app99/resources/css/header.css" type="text/css">
<header>
          <div>
          	
          </div>
          <div>
          <a href="/app99/home">
          	 <img width="300px" height="120px" src="/app99/resources/img/main.png" alt="이미지"/>          	
          </a>
          </div>
          <div>
          <c:choose>
          <c:when test="${not empty loginMember}">
			<table>
				<thead>
                    <tr><th>${loginMember.memberNick}님 어서오세요</th></tr>
				</thead>
                <tbody>
                    <tr>
                        <th><button type="button" style="width: 100%;"  onclick="location.href='/app99/member/logout'">로그아웃</button></th>
                    </tr>
                </tbody>
			</table>
          </c:when>
          <c:otherwise>
	          	<form action="/app99/member/login" method="post">
	                  <div class="login-area">
	                      <input type="text" name="memberId" placeholder="아이디">
	                      <input type="password" name="memberPwd" placeholder="비밀번호">
	                      <button type="button"  onclick="location.href='/app99/member/join'">회원가입</button>
	                 <input type="submit" value="로그인" name="" id="">
	             </div>
	         </form>          
          </c:otherwise>
          </c:choose>
     </div>
     <div>
     	<nav>
             <a href="/app99/board/list">게시판</a>
             <a href="/app99/notice/list">공지사항</a>
             <a href="/app99/gallary/list">갤러리</a>
             <a href="/app99/member/edit">마이페이지</a>
         </nav>
     </div>
 </header>
 <c:set var="msg"  value="<%= x %>" />
 <c:if test="${not empty msg}">
	 <script>
	        alert('<%= x %> ');
	</script>
 </c:if>
