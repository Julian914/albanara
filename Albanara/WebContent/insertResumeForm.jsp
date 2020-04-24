<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">

/* css단 */
</style>

</head>
<body>

	<div class="resume">
		<form action="insertResume.do" method="post" enctype="multipart/form-data">
			<h3>이력서</h3>
			<div>사진 첨부</div>
			<input type="file" name="pictureFilename"><br>
			<div>이력서 제목</div>
			<input type="text" name="resumeTitle" value="이력서 제목 등록"><br>
			<div>이력서 제목</div>
			<textarea cols="100" rows="10" name="resumeContents"
				placeholder="자기소개" style="overflow-x: hidden; overflow-y: auto"></textarea><br>
			<div>희망 근무 지역</div>
			<input type="text" name="desiredWorkingArea" value="희망 근무 지역"><br>
			<div>관심직종</div>
			<input type="text" name="favoriteField" value="관심 직종"><br>
			<br>
			<br>

			<button type="button"
				onclick="location.href='' ">등록하기</button>
			<button type="button"
				onclick="location.href='' ">취소하기</button>
		</form>
	</div>


</body>
</html>