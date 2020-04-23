<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>진행중인 공고</h3>
		
	<c:forEach var ="list" items="${recruitmentList}">
	
	<ul class = "recruitmentTitle">
		<li>접수마감 : ${list.closingDate}</li>
	<%-- 	<li>${list.recruitmentTitle}</li> --%>
	</ul>
	
	<ul class = "recruitmentContents">	
		<li>기업이름 : ${list.employerSeq.employerName}</li>
		<%-- <li>총 근무시간 : ${list.totalWorkingTime}</li> --%>
		<li>연령제한 : ${list.minAge}~${list.maxAge}</li>
		<li> 시급 : ${list.wage}</li>
		<li>근무지 주소 : ${list.workingPlaceAddress}</li>
	<%-- 	<li>$근무일자 : {list.startingWorkingDate}~${list.endingWorkingDate}</li> --%>
	</ul>
	</c:forEach>



</body>
</html>