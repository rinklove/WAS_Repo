
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>




<link rel="stylesheet" href="${path}/css/style.css">
<style>
@import url("https://fonts.googleapis.com/css?family=Roboto:400,300");

body {
	color: #2c3e50;
	font-family: 'Roboto', sans-serif;
	font-weight: 400;
}

.title{
	text-decoration:none;
	margin-top: 50px;
	text-align: center;
	font-weight: 400px;
	color: white;
}

.title-sector{
	background-color: #00ab00;
	border-radius:  10px 10px 10px 10px;
}

h1 {
	text-align: center;
	font-size: 2.5rem;
	font-weight: 300;
}

.pagination-container {
	margin: 100px auto;
	text-align: center;
}

.pagination {
	position: relative;
}

.pagination a {
	position: relative;
	display: inline-block;
	color: #2c3e50;
	text-decoration: none;
	font-size: 1.2rem;
	padding: 8px 16px 10px;
}

.pagination a:before {
	z-index: -1;
	position: absolute;
	height: 100%;
	width: 100%;
	content: "";
	top: 0;
	left: 0;
	background-color: #2c3e50;
	border-radius: 24px;
	-webkit-transform: scale(0);
	transform: scale(0);
	transition: all 0.2s;
}

.pagination a:hover, .pagination a .pagination-active {
	color: #fff;
}

.pagination a:hover:before, .pagination a .pagination-active:before {
	-webkit-transform: scale(1);
	transform: scale(1);
}

.pagination .pagination-active {
	color: #fff;
}

.pagination .pagination-active:before {
	-webkit-transform: scale(1);
	transform: scale(1);
}

.pagination-newer {
	margin-right: 50px;
}

.pagination-older {
	margin-left: 50px;
}

img {
	width: 200px;
	height: 350px
}

table td {
	text-align: center;
}
img{width:200px; height:350px}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<jsp:include page="../common/header.jsp"/>


<div class="bg-light  p-3">
	<caption><h2 align="center">게시판</h2></caption>
	<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">

	<colgroup>
		<col width="15%"/>
		<col width="38%"/>
		<col width="16%"/>
		<col width="15%"/>
		<col width="7%"/>
		<col width="7%"/>
	</colgroup>
	<tr>
        <td bgcolor="#00cc00">
            <p align="center">
            <font color="white"><b><span style="font-size:15pt;">작성자</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:15pt;">제목</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:15pt;">날짜</span></b></font></p>
        </td>
        
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:15pt;">첨부파일</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:15pt;">파일용량</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:15pt;">조 회 수</span></b></font></p>
        </td>
    </tr>
    
    <c:choose>
    <c:when test="${empty requestScope.list}">
	   <tr>
        <td colspan="5">
            <p align="center"><b><span style="font-size:15pt;">등록된 상품이 없습니다.</span></b></p>
        </td>
    </tr>
    </c:when>
    <c:otherwise>
	<c:forEach items="${requestScope.list}" var="elecDto">
		    <tr onmouseover="this.style.background='#eaeaea'"
		        onmouseout="this.style.background='white'">
		        <td bgcolor="">
		            <p align="center"><span style="font-size:15pt;">
		            ${elecDto.modelNum}</span></p>
		        </td>
		        <td bgcolor="">
					<p><span style="font-size:15pt;">
					<a href="${path}/front?key=elec&methodName=selectByModelNum&modelNum=${elecDto.modelNum}&pageNo=${pageNo}">
					  ${elecDto.modelName}
					</a>
					</span></p>
		        </td>
		      
		        <td bgcolor="">
		            <p align="center"><span style="font-size:15pt;">
		            ${elecDto.writeday}</span></p>
		        </td>
		         
		         <td bgcolor="">
		            <p align="center"><span style="font-size:15pt;">
		            ${elecDto.fname}</span></p>
		        </td>
		         <td bgcolor="">
		            <p align="center"><span style="font-size:15pt;">
		            <fmt:formatNumber value="${elecDto.fsize}"/> byte</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:15pt;">
		            ${elecDto.readnum}</span></p>
		        </td>
		    </tr>
    </c:forEach>
	</c:otherwise>
    </c:choose>
</table>
<hr>
<div align=right>
<span style="font-size:9pt;">&lt;<a href="${path}/elec/write.jsp">글쓰기</a>&gt;</span>
</div>


<jsp:useBean class="sku.mvc.paging.PageCnt" id="p"/> 
    
  

 
 <!--  블럭당  -->
 <nav class="pagination-container">
		<div class="pagination">
		<c:set var="doneLoop" value="false"/>
		<c:set var="temp" value="${(pageNo-1) % p.blockcount}"/> <!-- (1-1)%2  =0  , (2-1)%2    1 , (3-1)%2  0 -->
		<c:set var="startPage" value="${pageNo - temp}"/> <!--   1- 1 -->
		

	
		  <!-- 
     if( ( 시작페이지 - 한블록당뿌려질[]개수) > 0 ){ // if()
	       [이전]출력한다.	
     } 
     ex) if( ( startPage -blockcount) > 0 ){

          }
		-->
		
		<!-- 
		 시작페이지 구한다(몇번부터 출력할지를 정함 [번호] )
           방법 => int temp=(현재페이지번호-1)% 한블록당 보여질[]개수;
                   int startPage=현재페이지번호 -temp; => 시작번호[]
             
             
					   int temp = (pageNo-1) % p.blockcount ;         //시작 페이지 구하기
				      int startPage = pageNo - temp;
		 -->
		
		  <c:if test="${(startPage-p.blockcount) > 0}"> <!-- (-2) > 0  -->
		      <a class="pagination-newer text-dark" href="${path}/front?key=elec&methodName=select&pageNo=${startPage-1}">PREV</a>
		  </c:if>
		  
		<span class="pagination-inner"> 
		  <c:forEach var='i' begin='${startPage}' end='${(startPage-1)+p.blockcount}'> 
			  <c:if test="${(i-1)>=p.pageCnt}">
			       <c:set var="doneLoop" value="true"/>
			    </c:if> 
			    
			  <c:if test="${not doneLoop}" >
			         <a class="${i==pageNo?'pagination-active':page} text-dark" href="${path}/front?key=elec&methodName=select&pageNo=${i}">${i}</a> 
		     </c:if>
		</c:forEach>
		</span> 
				<!-- 
				[다음]
 
					  if( (시작페이지+한블록당뿌려질[]개수)<= 총페이지수){
					      [다음]출력;
					  }  
					
					  ex)if( (startPage+blockCount) <= pageCount){
					
					      }
				 -->
		 <c:if test="${(startPage+p.blockcount)<=p.pageCnt}">
		     <a class="pagination-older text-dark" href="${path}/front?key=elec&methodName=select&pageNo=${startPage+p.blockcount}">NEXT</a>
		 </c:if>
				 
			
		
		</div>
	</nav> 


<jsp:include page="../common/footer.jsp"/>
</div>































