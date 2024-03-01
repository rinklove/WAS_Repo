<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board/list.css">
</head>
<body>
    <div id="wrap">
        <%@ include file="/WEB-INF/views/common/header.jsp" %>
        
        <main>
            <h1>게시글 목록</h1>
            
            <div class="search-area">
	            <form action="${pageContext.request.contextPath }/board/search" method="get">
		            <select name="searchType">
		            	<option value="title">제목</option>
		            	<option value="content">내용</option>
		            </select>
		            <input type="text" name="searchValue" placeholder="검색할 내용을 입력하세요.">
		            <input type="submit" value="검색">
	            </form>
            </div>
            <table align="center" border="1">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>조회수</th>
                        <th>작성일시</th>
                        <th>카테고리</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="board"  items="${boardList }">
                    <tr>
                        <td>${board.no}</td>
                        <td>${board.title}</td>
                        <td>${board.writerNick}</td>
                        <td>${board.hit}</td>
                        <td>${board.enrollDate}</td>
                        <td>${board.categoryName}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <button onclick="location.href=`${pageContext.request.contextPath}/board/write`">작성하기</button>
            <div class="page-area">
            <c:if test="${pageVo.startPage gt 1 }">
            	<a href="${pageContext.request.contextPath}/board/search?searchType=${searchMap['searchType'] }&searchValue=${searchMap['searchValue'] }&pno=${pageVo.startPage-1}" }>이전</a>	            
            </c:if>
            <c:forEach var="i"  begin="${pageVo.startPage }" end="${pageVo.endPage }">
            <c:choose>
            <c:when test="${pageVo.currentPage eq i}">
            	<span>${i }</span>                        	
            </c:when>
            <c:otherwise>
            	<a href="${pageContext.request.contextPath}/board/search?searchType=${searchMap['searchType'] }&searchValue=${searchMap['searchValue'] }&pno=${i}" }>${i }</a>            
            </c:otherwise>
            </c:choose>
            </c:forEach>
            <c:if test="${pageVo.endPage ne pageVo.maxPage }">
	            <a href="${pageContext.request.contextPath}/board/search?searchType=${searchMap['searchType'] }&searchValue=${searchMap['searchValue'] }&pno=${pageVo.endPage+1}" }>다음</a>	
            </c:if>
            </div>
        </main>
    </div>
    <script>
        const allTr = document.querySelectorAll("main > table > tbody > tr");
        const currentPage = document.querySelector(".page-area span").innerText;
        for (let index = 0; index < allTr.length; index++) {
            allTr[index].addEventListener("click", (e) => {
            	const target = e.currentTarget;
                const no = target.children[0].innerText;
                
                location.href = '/app99/board/detail?no='+no + '&currentPage='+currentPage;
            })
            
        }
        
        const setPageArea = () => {
        	const aTagArr = document.querySelector(".page-area a")
        	for(let i = 0; i < aTagArr.length; i++) {
        		aTagArr[i].href = aTagArr[i].href.replace("list", "search");
        		aTagArr[i].href += "%searchType=${searchMap['searchType'] }";
        		aTagArr[i].href += "%searchValue=${searchMap['searchValue'] }";
       		}
        }
        
    </script>
</body>
</html>