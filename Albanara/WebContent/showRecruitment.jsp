<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/Albanara/css/jquery-ui.css">
<link rel="stylesheet" href="/Albanara/css/bootstrap.css">
<link rel="stylesheet" href="/Albanara/css/bootstrap-theme.css">
<link rel="stylesheet" href="/Albanara/css/Chart.css">
<link rel="stylesheet" href="/Albanara/css/style.css">
<script src="/Albanara/js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="/Albanara/js/jquery-ui.js" type="text/javascript"></script>
<script src="/Albanara/js/bootstrap.js" type="text/javascript"></script>
<script src="/Albanara/js/Chart.js" type="text/javascript"></script>
<script src="/Albanara/js/Chart.bundle.js" type="text/javascript"></script>
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=814861f68a4b2c5498535e608555d96a&libraries=services"></script>
<title>공고 상세</title>
<style type="text/css">
.container {
	max-width: 960px;
}

.bg-light {
	background-color: #f8f9fa !important;
}

.typeIcon {
	width: 30px;
	height: 30px;
	margin-bottom: 6px;
}

.labelStyle {
	font-size: 20px;
	color: grey;
}

.valueStyle {
	font-size: 20px;
}
</style>
<script>
$(document).ready(function() {
    $("header").load("/Albanara/header.html")
    $("nav").load("/Albanara/nav.html")
    $("footer").load("/Albanara/footer.html")
 });
</script>
</head>
<body class="bg-light">
	<header></header>
	<nav></nav>
	<div class="container">
		<div class="row">
			<div>
				<h2>${recruitment.recruitmentTitle }
					<c:if test="${recruitment.recruitmentType == 'strength' }">
						<img class="typeIcon" src="/Albanara/images/icons/strength.png"
							alt="힘">
					</c:if>
					<c:if test="${recruitment.recruitmentType == 'intelligence' }">
						<img class="typeIcon"
							src="/Albanara/images/icons/intelligence.png" alt="지능">
					</c:if>
					<c:if test="${recruitment.recruitmentType == 'kindness' }">
						<img class="typeIcon" src="/Albanara/images/icons/kindness.png"
							alt="친절">
					</c:if>
					<c:if test="${recruitment.recruitmentType == 'patience' }">
						<img class="typeIcon" src="/Albanara/images/icons/patience.png"
							alt="끈기">
					</c:if>
				</h2>
			</div>
			<hr style="border: solid 1px grey;">
			<div class="col-md-6">
				<div class="col-md-12">
					<h2>모집 조건</h2>
					<div>
						<div>
							<div class="labelStyle col-md-4">마감일</div>
							<div class="valueStyle col-md-8">${recruitment.closingDate }</div>
						</div>
						<div>
							<div class="labelStyle col-md-4">모집인원</div>
							<div class="valueStyle col-md-8">${recruitment.recruitmentSize }</div>
						</div>
						<div>
							<div class="labelStyle col-md-4">성별</div>
							<div class="valueStyle col-md-8">
								<c:if test="${recruitment.gender == 'male' }">남자</c:if>
								<c:if test="${recruitment.gender == 'female' }">여자</c:if>
							</div>
						</div>
						<div>
							<div class="labelStyle col-md-4">연령제한</div>
							<div class="valueStyle col-md-8">${recruitment.minAge }세이상~${recruitment.maxAge }세이하</div>
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<h2>근무 조건</h2>
					<div>
						<div>
							<div class="labelStyle col-md-4">시작일</div>
							<div class="valueStyle col-md-8">${recruitment.startingWorkingDate }</div>
						</div>
						<div>
							<div class="labelStyle col-md-4">종료일</div>
							<div class="valueStyle col-md-8">${recruitment.endingWorkingDate }</div>
						</div>
						<div>
							<div class="labelStyle col-md-4">총일수</div>
							<div class="valueStyle col-md-8">${recruitment.totalWorkingDay }</div>
						</div>
						<div>
							<div class="labelStyle col-md-4">시작시간</div>
							<div class="valueStyle col-md-8">${recruitment.startingWorkingTime }</div>
						</div>
						<div>
							<div class="labelStyle col-md-4">종료시간</div>
							<div class="valueStyle col-md-8">${recruitment.endingWorkingTime }</div>
						</div>
						<div>
							<div class="labelStyle col-md-4">총시간</div>
							<div class="valueStyle col-md-8">${recruitment.totalWorkingTime }</div>
						</div>
						<div>
							<div class="labelStyle col-md-4">급여</div>
							<div class="valueStyle col-md-8">
								<c:if test="${recruitment.wageType == 'hourlyWage' }">시급</c:if>
								<c:if test="${recruitment.wageType == 'dailyWage' }">일급</c:if>
								${recruitment.wage }
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="col-md-12">
					<h2>근무지역</h2>
					<p class="valueStyle">${recruitment.workingPlaceAddress }</p>
					<div id="map"
						style="width: 300px; height: 300px; margin: 10px 0px 0px 0px; display: none"></div>
					<div class="col-md-12" style="height: 20px;"></div>
				</div>
			</div>
			<div class="col-md-12">
				<h2>요구조건</h2>
				<ol>
					<li class="valueStyle">${recruitment.requirementQuestion1 }</li>
					<li class="valueStyle">${recruitment.requirementQuestion2 }</li>
					<li class="valueStyle">${recruitment.requirementQuestion3 }</li>
				</ol>
			</div>
			<div class="col-md-12">
				<h2>상세모집요강</h2>
				<p class="valueStyle">${recruitment.recruitmentContents }</p>
			</div>
			<div class="col-md-12">
				<div class="col-md-6">
					<canvas id="applicationGender"></canvas>
				</div>
				<div class="col-md-6">
					<canvas id="myChart8"></canvas>
				</div>
			</div>
		</div>

	</div>
	<footer></footer>
</body>

<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div
	mapOption = {
		center : new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
		level : 5
	// 지도의 확대 레벨
	};

	//지도를 미리 생성
	var map = new daum.maps.Map(mapContainer, mapOption);
	//주소-좌표 변환 객체를 생성
	var geocoder = new daum.maps.services.Geocoder();
	//마커를 미리 생성
	var marker = new daum.maps.Marker({
		position : new daum.maps.LatLng(37.537187, 127.005476),
		map : map
	});
	
	
	
	$(document).ready(function() {
		// 지도를 보여준다.
		mapContainer.style.display = "block";
		map.relayout();
		// 지도 중심을 변경한다.
		map.setCenter(new daum.maps.LatLng(37.537187, 127.005476));
		// 마커를 결과값으로 받은 위치로 옮긴다.
		marker.setPosition(new daum.maps.LatLng(37.537187, 127.005476))
     });
	
	var applicationGender = $('#applicationGender');
	var myDoughnutChart = new Chart(applicationGender, {
	    type: 'pie',
	    data: {
	        labels: ['여자', '남자'],
	        datasets: [{
	            label: '지원자 성별 현황',
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
	
	var ctx8 = $('#myChart8');
	var myLineChart8 = new Chart(ctx8, {
				type : 'line',
				data : {
					labels : [ 'Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange' ],
					datasets : [ {
						label : '# of Votes',						
						label : 'stepped',
						steppedLine : true,
						data : [ 12, 19, 3, 5, 2, 3 ],
						backgroundColor : [ 'rgba(255, 159, 64, 0.2)',
								'rgba(255, 99, 132, 0.2)', 'rgba(54, 162, 235, 0.2)',
								'rgba(75, 192, 192, 0.2)', 'rgba(153, 102, 255, 0.2)',
								'rgba(255, 159, 64, 0.2)' ],
						borderColor : [ 'rgba(255, 159, 64, 1)',
								'rgba(255, 99, 132, 1)', 'rgba(54, 162, 235, 1)',
								'rgba(255, 206, 86, 1)', 'rgba(75, 192, 192, 1)',
								'rgba(153, 102, 255, 1)' ],
						borderWidth : 1
					} ]
				},
				options : {}
			});

</script>
</html>