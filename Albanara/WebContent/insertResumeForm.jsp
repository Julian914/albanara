<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/Albanara/css/jquery-ui.css">
<link rel="stylesheet" href="/Albanara/css/bootstrap.css">
<link rel="stylesheet" href="/Albanara/css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css" href="/Albanara/css/style.css">
<script src="/Albanara/js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="/Albanara/js/jquery-ui.js" type="text/javascript"></script>
<script src="/Albanara/js/bootstrap.js" type="text/javascript"></script>

<title>Insert title here</title>
<style type="text/css">

/* css단 */
</style>

</head>
<body>

	<header></header>
	<nav></nav>


	<div class="container">
		<div class="page-header text-center">
			<h1>이력서</h1>
			<h3>아래 양식에 맞게 작성해주시면 됩니다.</h3>
		</div>


		<div class="row">
			<form action="insertResume.do" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<div>사진 첨부</div>
					<input type="file" name="pictureFilename">
				</div>
	
				<div class="form-group">
					<div>이력서 제목</div>
					<input type="text" name="resumeTitle" placeholder="이력서 제목 등록">	
				</div>
				
				<div class="form-group">
					<div>이력서 제목</div>
					<textarea cols="100" rows="10" name="resumeContents"
						placeholder="자기소개" style="overflow-x: hidden; overflow-y: auto"></textarea>
				</div>
				
				<div class="form-group">
					<div>희망 근무 지역</div>
					<input type="text" name="desiredWorkingArea" placeholder="희망 근무 지역">		
				</div>
				
				<div class="form-group">
					<div>관심직종<br> 
						<input type="radio" name="favoriteField" value="힘">힘<br>
						<input type="radio" name="favoriteField" value="지능">지능<br>
						<input type="radio" name="favoriteField" value="끈기">끈기<br>
						<input type="radio" name="favoriteField" value="친절">친절<br>
					</div>
				</div>
				
				<div class="form-group">
					<input type="submit" value="등록">
				</div>

			</form>
		</div>
		
	</div>

	<footer></footer>

<script>
$(document).ready(function() {
    $("header").load("header.html")
    $("nav").load("nav.html")
    $("footer").load("footer.html")
 });
</script>

	<!-- 
		<form action="insertResume.do" method="post"
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
			<div>
				관심직종<br> <input type="radio" name="favoriteField" value="힘">힘<br>
				<input type="radio" name="favoriteField" value="지능">지능<br>
				<input type="radio" name="favoriteField" value="끈기">끈기<br>
				<input type="radio" name="favoriteField" value="친절">친절<br>
			</div>
			<br> <br> <input type="submit" value="등록">
		</form>
		
	 -->
		
</body>
</html>