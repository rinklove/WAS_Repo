<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동물주민 도감</title>
<link rel="StyleSheet"  href="${pageContext.request.contextPath}/css/index.css" type="text/css">
<link rel="StyleSheet"  href="${pageContext.request.contextPath}/css/background.css" type="text/css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<center>
<body>

<jsp:include page="../common/header.jsp"/>

<div class="container back-ground">
	
	<div class="container p-2 mb-5">
      <div class="row">
         <form method="post" name="search" action="${pageContext.request.contextPath}/front">
         	<input type="hidden" name="key" value = "animal" /> 
			<input type="hidden" name="methodName" value = "search" /> 
            <table>
               <tr>
                  <td><input type="text" class="form-control me-3"
                     placeholder="검색어 입력" name="searchText" maxlength="100" 
                     style="border-radius:40px; width:400px; height:75px; ">
                  </td>
                  <td><button type="submit" class="btn btn-success"
                  style="width:100px;height:75px;font-size:20px; border-radius: 20px;">검색</button></td>
               </tr>
            </table>
         </form>
         
      </div>
      </div>
      <div class="p-4 bg-light">
	<caption><h2 align="center">동물 정보</h2></caption>
	<table class=" mb-5" align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">

	<colgroup>
		<col width="20%"/>
		<col width="20%"/>
		<col width="20%"/>
		<col width="20%"/>
		<col width="20%"/>
	</colgroup>
	
	<tr>
        <td bgcolor="#00cc00">
            <p align="center">
            <font color="white"><b><span style="font-size:15pt;">이름</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:15pt;">성별</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:15pt;">성격</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:15pt;">말버릇</span></b></font></p>
        </td>
        
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:15pt;">종</span></b></font></p>
        </td>
    </tr>
    
    <c:choose>
    <c:when test="${empty animal}">
	   <tr>
        <td colspan="5">
            <p align="center"><b><span style="font-size:15pt;">없는 주민입니다.</span></b></p>
        </td>
    </tr>
    </c:when>
    <c:otherwise>
		    <tr onmouseover="this.style.background='#eaeaea'"
		        onmouseout="this.style.background='white'">
		        <td bgcolor="">
		            <p align="center"><span style="font-size:15pt;">
		            <b>${animal.name}</b></span></p>
		        </td>
		        <td bgcolor="">
					<p align="center"><span style="font-size:15pt;">
					  <b>${animal.gender}</b>
					</span></p>
		        </td>
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:15pt;">
		            <b>${animal.spicies}</b></span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:15pt;">
		            <b>${animal.habit}</b></span></p>
		        </td>
		         
		         <td bgcolor="">
		            <p align="center"><span style="font-size:15pt;">
		            <b>${animal.animal}</b></span></p>
		        </td>
		    </tr>
	</c:otherwise>
    </c:choose>
</table>

<hr>
 <jsp:include page="../common/footer.jsp"/>     

</div>
</div>



</body>
</center>
</html>