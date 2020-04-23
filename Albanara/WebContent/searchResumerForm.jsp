<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div>사진</div>
	<div>${resume.pictureFilename }</div>
	
	<div>이력서 제목</div>
	<div>${resume.resumeTitle }</div>
	
	<div>이력서 내용</div>
	<div>${resume.resumeContents }</div>
	
	<div>희망근무지역</div>
	<div>${resume.desired_workingArea }</div>
	
	<div>관심직종</div>
	<div>${resume.favoriteField }</div>
	
	<div>마지막 수정날짜</div>
	<div>${resume.lastModifyDate }</div>
	
	<button type="button" onclick="location.href='' ">확인하기</button>
	
</body>
</html>