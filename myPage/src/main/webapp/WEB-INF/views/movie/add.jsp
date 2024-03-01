<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/movie/add.css">
</head>
<body>
    <div class="add-form">
        <div class="title-container">
            <span class="title"><strong>영화 등록</strong></span>
            <span>- 공백으로 저장할 경우 api에서 값을 가져옵니다.</span>
        </div>
        <form action="${pageConText.request.contextPath}/admin/movie/add" method="post" onsubmit="return checkInputValue()">
            <table >
                <thead></thead>
                <tbody>
                    <tr>
                        <td class="normal_text">제목<span class="star">*</span></td>
                        <td>
                            <div>
                                <input type="search" name="title" onchange="">
                                <ul id="search-result"></ul>
                            </div>
                        </td>
                        <td class="normal_text">감독</td>
                        <td><input type="text" name="director"></td>
                        <td rowspan="4"><img src="http://file.koreafilm.or.kr/thm/02/00/01/14/tn_DPF000702.jpg" alt=""></td>
                    </tr>
                    <tr>
                        <td class="normal_text">장르</td>
                        <td><input type="text" name="genre"></td>
                        <td class="normal_text">개봉일</td>
                        <td><input type="text" name="releaseDate"></td>
                    </tr>
                    <tr>
                        <td class="normal_text">관람 등급</td>
                        <td>
                            <select name="screenGrade">
                                <option value="">선택하세요</option>
                                <option value="">전체 관람가</option>
                                <option value="">12세 이상 관람가</option>
                                <option value="">15세 이상 관람가</option>
                                <option value="">청소년 관람 불가</option>
                                <option value="">제한 상영가</option>
                            </select>
                        </td>
                        <td class="normal_text">상영 시간</td>
                        <td><input type="text" name="runningTime" placeholder="(단위: 분)"></td>
                    </tr>
                    <tr>
                        <td class="normal_text">출연</td>
                        <td colspan="3"><input type="text" name="actor" placeholder="최대 3명까지 저장 가능(','로 구분 해주세요)"></td>
                    </tr>
                    <tr>
                        <td class="normal_text">별점<span class="star">*</span></td>
                        <td><input type="number" name="rate" ></td>
                    </tr>
                    <tr>
                        <td class="normal_text"><span class="title"><strong>줄거리</strong></span></td>
                    </tr>
                    <tr>
                        <td colspan="5"><textarea name="story" class="story" id="" cols="120" rows="30"></textarea></td>
                    </tr>
                    <tr>
                        <td class="normal_text"><span class="title"><strong>스틸컷</strong></span></td>
                    </tr>
                    <tr>
                        <td class="still-image">
                            <div class="filebox">
                                <input class="upload-name" value="첨부파일" placeholder="첨부파일">
                                <label for="file">파일찾기</label> 
                                <input type="file" id="file">
                            </div>
                            <div class="filebox">
                                <input class="upload-name" value="첨부파일" placeholder="첨부파일">
                                <label for="file">파일찾기</label> 
                                <input type="file" id="file">
                            </div>
                            <div class="filebox">
                                <input class="upload-name" value="첨부파일" placeholder="첨부파일">
                                <label for="file">파일찾기</label> 
                                <input type="file" id="file">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5">
                            <div class="df fd-cr">

                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
           
        </form>

    </div>
    <script>
        
    </script>
</body>
</html>