<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

/* css단 */
</style>

</head>
<body>

		<form action="member/insertResume.do" method="post" enctype="multipart/form-data">
			<h3>이력서</h3>
			<div>사진 첨부</div>
			<input type="file" name="pictureFilename"><br>
			<div>이력서 제목</div>
			<input type="text" name="resumeTitle" placeholder="이력서 제목 등록"><br>
			<div>이력서 제목</div>
			<textarea cols="100" rows="10" name="resumeContents"
				placeholder="자기소개" style="overflow-x: hidden; overflow-y: auto"></textarea><br>
			<div>희망 근무 지역</div>
			<input type="text" name="desiredWorkingArea" placeholder="희망 근무 지역"><br>
			<div>관심직종</div>
			<input type="text" name="favoriteField" placeholder="관심 직종"><br>
			<br>
			<br>

			<input type="submit" value="등록">
		</form>

</body>
</html>