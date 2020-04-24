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
	<div>${Resume.pictureFilename }</div>
	
	<div>이력서 제목</div>
	<div>${Resume.resumeTitle }</div>
	
	<div>이력서 내용</div>
	<div>${Resume.resumeContents }</div>
	
	<div>희망근무지역</div>
	<div>${Resume.desiredWorkingArea }</div>
	
	<div>관심직종</div>
	<div>${Resume.favoriteField }</div>
	
	<div>마지막 수정날짜</div>
	<div>${Resume.lastModifyDate }</div>
	
	<button type="button" onclick="location.href='/index.jsp' ">확인하기</button>
	
</body>
</html>