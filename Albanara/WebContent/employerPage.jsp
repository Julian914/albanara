<%@page import="kosta.albanara.model.Employers"%>
<%@page import="kosta.albanara.dao.EmployerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Albanara/css/jquery-ui.css">
<link rel="stylesheet" href="/Albanara/css/bootstrap.css">
<link rel="stylesheet" href="/Albanara/css/bootstrap-theme.css">
<link rel="stylesheet" href="/Albanara/css/Chart.css">
<link rel="stylesheet" href="/Albanara/css/employerPage.css">
<script src="/Albanara/js/employerPage.js" type="text/javascript"></script>
<script src="/Albanara/js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="/Albanara/js/jquery-ui.js" type="text/javascript"></script>
<script src="/Albanara/js/bootstrap.js" type="text/javascript"></script>
<script src="/Albanara/js/Chart.js" type="text/javascript"></script>
<script src="/Albanara/js/Chart.bundle.js" type="text/javascript"></script>




<script type="text/javascript">
	//공고목록에 아코디언 적용
	(function($) {
		$(function() {
			$('.accordion').accordion();
		});
	})(jQuery);




jQuery(document).ready(function ($) { 
	$(".accordion-title").click(function(){
		$("accordion-contents").addClass
	})
	});




</script>














<style type="text/css">
.application {
	color: black;
}

.accordion .child {
	height: 155px;
}
</style>





 


</head>
<body>
	<div class="container">


		<h1>기업 마이페이지(기업관점)</h1>
		기업명 : ${employer.employerName} <br> 기업주소
		:${employer.employerAddress } <br> 기업홈페이지 주소
		:${employer.employerHomePage} <br>





		<h3>현재 진행중인 공고목록</h3>
		<div id="wrap">
			<div class="accordion recruitmentList">
			
				<c:forEach var="list" items="${nowRecruinmentList}"
					varStatus="status">

					<div id="accordion-title">
						<ul class="recruitmentUp">
							<li>접수마감 : ${list.closingDate}</li>
							<li>공고제목 : ${list.recruitmentTitle}</li>
						</ul>
						<input type="button" onclick="location.href='../recruitment/updateRecruitmentForm.do?seq=${list.recruitmentSeq}'" value="수정">
						<input type="button" onclick="location.href='../recruitment/deleteRecruitmentAction.do?seq=${list.recruitmentSeq}'" value="삭제">
					</div>
					<div id="accordion-contents">
						<ul class="recruitmentDown">
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
						</ul>

				
						<div class="accordion employeesList">
							<!-- index: ${status.index} 공고의 인덱스 구하기-->

							<!--진행중인 공고 지원자 목록  -->
							<c:forEach var="employeeListMap" items="${employeeListMapList}">
								<!--//for:${employeeListMap.key }, ${status.index } -->
								<c:if test="${status.index eq employeeListMap.key}">
									<!--if : ${employeeListMap.employeeList}-->
									<c:forEach var="employeeList"
										items="${employeeListMap.employeeList}">

										<div class="accordion-title2">
											<ul class="recruitmentUp2">
												<li>지원자 ${employeeList.employeeSeq}</li>
											</ul>
										</div>
										<div class="accordion-contents2 child">
											<ul class="recruitmentDown2">
												<li>이름 : ${employeeList.employeeName}</li>
												<li>생년월일 :${employeeList.employeeBirthday}</li>
												<li>성별 : ${employeeList.employeeGender}</li>
												<li>주소 : ${employeeList.employeeAddress}</li>
												<li>번호 : ${employeeList.employeePhone}</li>
											</ul>
											<input type="button"
												onclick="location.href='../recruitment/insertProposal.do?recruitmentSeq=${list.recruitmentSeq}&employeeSeq=${employeeList.employeeSeq}'"
												value="일자리 제안하기"> <input type="button"
												onclick="location.href='../recruitment/insertHiredHistory.do?recruitmentSeq=${list.recruitmentSeq}&employeeSeq=${employeeList.employeeSeq}'"
												value="채용하기">
										</div>
									</c:forEach>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>





		<h3>마감된 공고목록</h3>
		<div id="wrap">
			<div class="accordion recruitmentList">

				<!-- 마감공고목록 -->
				<c:forEach var="list" items="${endRecruitmentList}"
					varStatus="status">
					<div id="accordion-title">
						<ul class="recruitmentUp">
							<li>접수마감 : ${list.closingDate}</li>
							<li>공고제목 : ${list.recruitmentTitle}</li>
						</ul>
						<input type="button" onclick="location.href='../recruitment/deleteRecruitmentAction.do?seq=${list.recruitmentSeq}'" value="삭제">
					</div>
					<div id="accordion-contents">
						<ul class="recruitmentDown">
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
						</ul>

					

						<div class="accordion employeesList">
							<!--마감된 공고의 채용자 목록  -->
							<c:forEach var="hiredEmployeeListMap"
								items="${hiredEmployeeListMapList}">
								<c:if test="${status.index eq hiredEmployeeListMap.key}">
									<c:forEach var="hiredEmployeeList"
										items="${hiredEmployeeListMap.employeeList}">

										<div class="accordion-title2">
											<ul class="recruitmentUp2">
												<li>지원자 ${hiredEmployeeList.employeeSeq}</li>
											</ul>
										</div>
										<div class="accordion-contents2 child">
											<ul class="recruitmentDown2">
												<li>이름 : ${hiredEmployeeList.employeeName}</li>
												<li>생년월일 :${hiredEmployeeList.employeeBirthday}</li>
												<li>성별 : ${hiredEmployeeList.employeeGender}</li>
												<li>주소 : ${hiredEmployeeList.employeeAddress}</li>
												<li>번호 : ${hiredEmployeeList.employeePhone}</li>
											</ul>
											<input type="button"
												onclick="location.href='insertProposal.do?seq=${list.recruitmentSeq}&seq2=${employeeList.employeeSeq}'"
												value="일자리 제안하기"> <input type="button"
												onclick="location.href='insertHiredHistory.do?seq=${list.recruitmentSeq}&seq2=${employeeList.employeeSeq}'"
												value="채용하기">
										</div>
									</c:forEach>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>



<div id="map" style="width: 300px; height: 300px; margin-top: 10px;"></div>
<canvas id="employerGender" width="800"></canvas>


<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=814861f68a4b2c5498535e608555d96a&libraries=services"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=814861f68a4b2c5498535e608555d96a&libraries=services,clusterer,drawing"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<script>

var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
mapOption = { 
    center: new kakao.maps.LatLng(37.4849665053325, 127.034757121285), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨 
};
var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다


<c:forEach items="${mapList}" var="item">
	console.log('${item}')
	//마커를 생성합니다
	var marker = new kakao.maps.Marker({
	 position: new kakao.maps.LatLng(parseFloat("${item.longitude}"), parseFloat("${item.latitude}")) //마커가 표시될 위치입니다 
	});
	
	//마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);
</c:forEach>



//아래 코드는 지도 위의 마커를 제거하는 코드입니다
//marker.setMap(null);    


var employerGender = $('#employerGender');
var myDoughnutChart = new Chart(employerGender, {
    type: 'pie',
    data: {
        labels: ['여자', '남자'],
        datasets: [{
            label: '채용자 성별 현황',
            data: [${woman}, ${man}],
            backgroundColor: [
            	'rgba(255, 99, 132, 0.2)',
            	'rgba(54, 162, 235, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {}
});
</script>
</html>