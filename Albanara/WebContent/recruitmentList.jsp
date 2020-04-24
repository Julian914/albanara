<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


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
	$(function() {
		$('.accordion').accordion();
	});

	/* 	$(function() {
	 $('.employeesList recruitmentUp').click(event)
	 {
	 event.stopPropagation();
	 }
	 }); */
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>진행중인 공고</h3>
	<div id="wrap">
		<div class="accordion" class="recruitmentList">
			<c:forEach var="list" items="${recruitmentList}">
				<div id="accordion-title">
					<ul class="recruitmentUp">
						<li>접수마감 : ${list.closingDate}</li>
						<li>공고제목 : ${list.recruitmentTitle}</li>
					</ul>
				</div>
				<div id="accordion-contents">
					<ul class="recruitmentDown">
						<li>기업이름 : ${list.employerSeq} 이름 들어올 예정</li>
						<li>총 근무시간 : ${list.totalWorkingTime} 시간</li>
						<li>연령제한 : ${list.minAge} 세 ~${list.maxAge} 세</li>
						<li>시급 : ${list.wage} 원</li>
						<li>근무지 주소 : ${list.workingPlaceAddress}</li>
						<li>근무일자 :<fmt:parseDate var="startdate"
								value="${list.startingWorkingDate}" pattern="yyyy-MM-dd" /> <fmt:formatDate
								value="${startdate}" pattern="yyyy.MM.dd" /> ~<fmt:parseDate
								var="enddate" value="${list.endingWorkingDate}"
								pattern="yyyy-MM-dd" /> <fmt:formatDate value="${enddate}"
								pattern="yyyy.MM.dd" /></li>
					</ul>
					<div class="accordion employeesList">
						<c:forEach var="applicantList" items="${applicantListList}">
						<c:forEach var="applicant" items="${applicantList}">
						
							<div id="accordion-title2">
								<ul class="recruitmentUp">
									<li>지원자 </li>
								</ul>
							</div>
							<div ="accordion-contents2">
								<ul class="recruitmentDown">
									<li>이름 : ${applicant.employeeName}</li>
									<li>생년월일 :${applicant.employeeBirthday}</li>
									<li>성별 : ${applicant.employeeGender}</li>
									<li>주소 : ${applicant.employeeAddress}</li>
								</ul>
							</div> 
						</c:forEach>
						</c:forEach>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>
</body>
</html>