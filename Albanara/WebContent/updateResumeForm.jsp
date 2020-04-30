<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="updateResumeAction.do" method="post"
		enctype="multipart/form-data">
		<h3>이력서</h3>
		<div>사진 첨부</div>
		<input type="file" name="pictureFilename"><br>
		<div>이력서 제목</div>
		<input type="text" name="resumeTitle" placeholder="이력서 제목 등록"><br>
		<div>이력서 제목</div>
		<textarea cols="100" rows="10" name="resumeContents"
			placeholder="자기소개" style="overflow-x: hidden; overflow-y: auto"></textarea>
		<br>
		<div>희망 근무 지역</div>
		<input type="text" name="desiredWorkingArea" placeholder="희망 근무 지역"><br>
		<div>관심직종<br>
			<input type="radio" name="favoriteField" value="힘">힘<br>
			<input type="radio" name="favoriteField" value="지능">지능<br>
			<input type="radio" name="favoriteField" value="끈기">끈기<br>
			<input type="radio" name="favoriteField" value="친절">친절<br>
		</div>
		<br> <br> <input type="submit" value="등록">
	</form>


</body>
</html>