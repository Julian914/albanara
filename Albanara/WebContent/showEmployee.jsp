<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/Albanara/css/jquery-ui.css">
<link rel="stylesheet" href="/Albanara/css/bootstrap.css">
<link rel="stylesheet" href="/Albanara/css/bootstrap-theme.css">
<script src="/Albanara/js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="/Albanara/js/jquery-ui.js" type="text/javascript"></script>
<script src="/Albanara/js/bootstrap.js" type="text/javascript"></script>
<script src="/Albanara/js/Chart.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		$('.accordion').accordion();
	});
</script>
<title>Insert title here</title>
</head>
<body>
	
	<h1>구직자 마이페이지</h1>	
	이름: ${employee.employeeName }<br>
	생년월일: ${employee.employeeBirthday }<br>
	성별: ${employee.employeeGender }<br>
	주소: ${employee.employeeAddress }<br>
	연락처: ${employee.employeePhone }<br>
	이메일: ${employee.employeeEmail }<br>
	
	<h3>제안 받은 공고</h3>
	<div id="wrap">
		<div class="accordion">
			<c:forEach var="list" items="${recruitmentList}" varStatus="status">
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
						<li><input type="button" onclick="location.href='../recruitment/showRecruitmentAction.do?seq=${list.recruitmentSeq}'" value="상세 보기">
						<input type="button" onclick="location.href='../recruitment/acceptProposalAction.do?recruitmentSeq=${list.recruitmentSeq}&employeeSeq=${employee.employeeSeq}'" value="수락하기">
						<input type="button" onclick="location.href='../recruitment/rejectProposalAction.do?recruitmentSeq=${list.recruitmentSeq}&employeeSeq=${employee.employeeSeq}'" value="거절하기">
						</li>
					</ul>
				</div>
			</c:forEach>
		</div>
	</div>
	
	<h3>지원한 공고 목록</h3>
	<div id="applyRecruitment">
		<div class="accordion">
			<c:forEach var="applyItem" items="${applyRecruitment}" varStatus="status">
				<div id="apply_recruitment_accordion_title">
					<ul class="recruitmentUp">
						<li>마감된 날짜 : ${applyItem.closingDate}</li>
						<li>공고 제목 : ${applyItem.recruitmentTitle}</li>
					</ul>
				</div>
				<div id="apply_recruitment_accordion_contents">
					<ul class="recruitmentDown">
						<li>총 근무시간 : ${applyItem.totalWorkingTime} 시간</li>
						<li>연령제한 : ${applyItem.minAge} 세 ~${applyItem.maxAge} 세</li>
						<li>시급 : ${applyItem.wage} 원</li>
						<li>근무지 주소 : ${applyItem.workingPlaceAddress}</li>
						<li>근무일자 :<fmt:parseDate var="startdate"
								value="${applyItem.startingWorkingDate}" pattern="yyyy-MM-dd" /> <fmt:formatDate
								value="${startdate}" pattern="yyyy.MM.dd" /> ~<fmt:parseDate
								var="enddate" value="${applyItem.endingWorkingDate}"
								pattern="yyyy-MM-dd" /> <fmt:formatDate value="${enddate}"
								pattern="yyyy.MM.dd" /></li>
					</ul>
				</div>
			</c:forEach>
		</div>
	</div>
			
	<h3>완료한 일자리 목록</h3>
	<div id="completeRecruitment">
		<div class="accordion">
			<c:forEach var="item" items="${completeRecruitment}" varStatus="status">
				<div id="complete_recruitment_accordion_title">
					<ul class="recruitmentUp">
						<li>마감된 날짜 : ${item.closingDate}</li>
						<li>공고 제목 : ${item.recruitmentTitle}</li>
					</ul>
				</div>
				<div id="complete_recruitment_accordion_contents">
					<ul class="recruitmentDown">
						<li>총 근무시간 : ${item.totalWorkingTime} 시간</li>
						<li>연령제한 : ${item.minAge} 세 ~${item.maxAge} 세</li>
						<li>시급 : ${item.wage} 원</li>
						<li>근무지 주소 : ${item.workingPlaceAddress}</li>
						<li>근무일자 :<fmt:parseDate var="startdate"
								value="${item.startingWorkingDate}" pattern="yyyy-MM-dd" /> <fmt:formatDate
								value="${startdate}" pattern="yyyy.MM.dd" /> ~<fmt:parseDate
								var="enddate" value="${item.endingWorkingDate}"
								pattern="yyyy-MM-dd" /> <fmt:formatDate value="${enddate}"
								pattern="yyyy.MM.dd" /></li>
					</ul>
				</div>
			</c:forEach>
		</div>
	</div>
	<canvas id="myChart1" width="800"></canvas>
	<canvas id="myChart2" width="800"></canvas>
</body>
<script>
var ctx1 = $('#myChart1');
var myChart2 = new Chart(ctx1, {
	type : 'bar',
	data : {
		labels : [ 'Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange' ],
		datasets : [ {
			label : '# of Votes',
			data : [ 12, 19, 3, 5, 2, 3 ],
			backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
					'rgba(54, 162, 235, 0.2)', 'rgba(255, 206, 86, 0.2)',
					'rgba(75, 192, 192, 0.2)', 'rgba(153, 102, 255, 0.2)',
					'rgba(255, 159, 64, 0.2)' ],
			borderColor : [ 'rgba(255, 99, 132, 1)',
					'rgba(54, 162, 235, 1)', 'rgba(255, 206, 86, 1)',
					'rgba(75, 192, 192, 1)', 'rgba(153, 102, 255, 1)',
					'rgba(255, 159, 64, 1)' ],
			borderWidth : 1
		} ]
	},
	options : {
		scales : {
			yAxes : [ {
				ticks : {
					beginAtZero : true
				}
			} ]
		}
	}
});

var ctx2 = $('#myChart2');
var myDoughnutChart = new Chart(ctx2, {
	type : 'doughnut',
	data : {
		labels : [ 'Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange' ],
		datasets : [ {
			label : '# of Votes',
			data : [ 12, 19, 3, 5, 2, 3 ],
			backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
					'rgba(54, 162, 235, 0.2)', 'rgba(255, 206, 86, 0.2)',
					'rgba(75, 192, 192, 0.2)', 'rgba(153, 102, 255, 0.2)',
					'rgba(255, 159, 64, 0.2)' ],
			borderColor : [ 'rgba(255, 99, 132, 1)',
					'rgba(54, 162, 235, 1)', 'rgba(255, 206, 86, 1)',
					'rgba(75, 192, 192, 1)', 'rgba(153, 102, 255, 1)',
					'rgba(255, 159, 64, 1)' ],
			borderWidth : 1
		} ]
	},
	options : {}
});
</script>
</html>