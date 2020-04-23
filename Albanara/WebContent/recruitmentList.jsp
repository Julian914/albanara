<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/Albanara/css/jquery-ui.css">
<link rel="stylesheet" href="/Albanara/css/bootstrap.css">
<link rel="stylesheet" href="/Albanara/css/bootstrap-theme.css">
<script src="/Albanara/js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="/Albanara/js/jquery-ui.js" type="text/javascript"></script>
<script src="/Albanara/js/bootstrap.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function(){
		$('#accordion').accordion();
	});

	
	
	
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>진행중인 공고</h3>
	<div id="wrap">
		<div id="accordion">			
			<c:forEach var="recruitmentList" items="${recruitmentList}">
			<div id="accordion-title">
				<ul class="recruitmentUp" >
					<li>접수마감 : ${recruitmentList.closingDate}</li>
					<li>공고제목 : ${recruitmentList.recruitmentTitle}</li>
				</ul>
			</div>
			<div id="accordion-contents">
				<ul class="recruitmentDown">
					<li>기업이름 : ${recruitmentList.employerSeq}</li>
					<li>총 근무시간 : ${recruitmentList.totalWorkingTime}</li>
					<li>연령제한 : ${recruitmentList.minAge}~${list.maxAge}</li>
					<li>시급 : ${recruitmentList.wage}</li>
					<li>근무지 주소 : ${recruitmentList.workingPlaceAddress}</li>
					<li>근무일자 :<fmt:parseDate var="startdate" value="${recruitmentList.startingWorkingDate}" pattern="yyyy-MM-dd"/>
        					   <fmt:formatDate value="${startdate}" pattern="yyyy.MM.dd"/> 
								~<fmt:parseDate var="enddate" value="${recruitmentList.endingWorkingDate}" pattern="yyyy-MM-dd"/>
        					   <fmt:formatDate value="${enddate}" pattern="yyyy.MM.dd"/></li>
				</ul>
			</div>
			</c:forEach>
		</div>
	</div>

</body>
</html>