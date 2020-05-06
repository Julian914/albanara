<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
</head>
<body>
	
	<header></header>
	<nav></nav>
	
	<div class="container">
		<div class="page-header text-center">
			<h1>이력서 조회</h1>
		</div>


		<div class="row">
			<form action="insertResume.do" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<div>이력서 사진 </div>
					<div>${Resume.pictureFilename }</div>
				</div>
	
				<div class="form-group">
					<div>이력서 제목</div>
					<div>${Resume.resumeTitle }</div>
				</div>
				
				<div class="form-group">
					<div>이력서 제목</div>
					<div>${Resume.resumeContents }</div>
				</div>
				
				<div class="form-group">
					<div>희망 근무 지역</div>
					<div>${Resume.desiredWorkingArea }</div>		
				</div>
				
				<div class="form-group">
					<div>${Resume.favoriteField }</div>
				</div>
				
				<div class="form-group">
					<button type="button" onclick="location.href='/index.jsp' ">확인하기</button>
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
	
</body>
</html>