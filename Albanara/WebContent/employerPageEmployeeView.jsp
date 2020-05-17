<%@page import="kosta.albanara.model.Employer"%>
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
<link rel="stylesheet" type="text/css" href="/Albanara/css/style.css">
<link rel="stylesheet" type="text/css"
	href="/Albanara/css/employerPage.css">

<script src="/Albanara/js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="/Albanara/js/jquery-ui.js" type="text/javascript"></script>
<script src="/Albanara/js/bootstrap.js" type="text/javascript"></script>
<script src="/Albanara/js/Chart.js" type="text/javascript"></script>
<script src="/Albanara/js/Chart.bundle.js" type="text/javascript"></script>

<jsp:include page="header.html" ></jsp:include>
<jsp:include page="nav.html" ></jsp:include>


<script>
$(function() {
	$(".accordion").accordion({
		heightStyle : "content"
	});
});
</script>



</head>
<body>

	<header></header>
	<nav></nav>

	<div class="container">

		<div class="employer">
			<h1>기업 마이페이지(구직자관점)</h1>
			<br> <br>
			<div class="row">
				<div class="col-md-4">
					<img class="employerFile" src="/Albanara/images/employerPage/noImage.png"
						style="width: 300px; height: 300px; margin-top: 10px;"><br>
					<br>
				</div>
				<br>
				<div class="col-md-4">
					<div class="employerInfo">
						<ul>
							<li>기업명 :</li>
							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b> ${employer.employerName}</b></li>
							<li>기업주소:</li>
							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>${employer.employerAddress }</b></li>
							<li>홈페이지 :<li>
							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
								class="homepageAddress" href="employer.employerHomePage">홈페이지 바로가기</a></li>
							<li>전화번호:</li>
							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>${employer.employerNumber}</b></li>
							<li>분야 :</li>
							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>
							${employer.employerField}
							<c:if test="${employer.employerField == 'strength' }">
								<img class="typeIcon" src="/Albanara/images/icons/strength.png"
									alt="힘">
							</c:if>
							<c:if test="${employer.employerField == 'intelligence' }">
								<img class="typeIcon"
									src="/Albanara/images/icons/intelligence.png" alt="지능">
							</c:if>
							<c:if test="${employer.employerField == 'kindness' }">
								<img class="typeIcon" src="/Albanara/images/icons/kindness.png"
									alt="친절">
							</c:if>
							<c:if test="${employer.employerField == 'patience' }">
								<img class="typeIcon" src="/Albanara/images/icons/patience.png"
									alt="끈기">
							</c:if>
							</b></li>
							<br>
							<li><b><img class="evalIcon"
									onclick="insertEmployerPage.do?seq=${employer.employerSeq}"
									src="/Albanara/images/employerPage/like.png" name="좋아요"
									value="like">좋아요 ${employer.likeCount} <img
									class="evalIcon"
									onclick="insertEmployerPage.do?seq=${employer.employerSeq}"
									src="/Albanara/images/employerPage/unlike.png" name="별로예요"
									value="unlike">별로예요 ${employer.unlikeCount}</b></li>
						</ul>
					</div>
				</div>
				<div class="col-md-4">
					<div id="map"
						style="width: 300px; height: 300px; margin-top: 10px;"></div>
				</div>
			</div>
			<br> <br>
		</div>
		<h3>현재 진행중인 공고목록</h3>
		<div id="wrap">
			<div class="accordion recruitmentList">
				<!-- 전체공고목록 -->
				<c:forEach var="list" items="${nowRecruinmentList}"
					varStatus="status">

					<div id="accordion-title">
						<ul class="recruitmentUp">
							<li>공고제목 : ${list.recruitmentTitle}</li>
							<li>접수마감 : ${list.closingDate}</li>

						</ul>
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
						</ul>
						<input type="button" class="btn btn-light"
							onclick="location.href='../recruitment/showRecruitmentAction.do?seq=${list.recruitmentSeq}'"
							value="상세 보기">

						<!-- 지원하기 modal-->
						<button class="btn btn-primary"
							data-target="#layerpop${status.index}" data-toggle="modal">지원하기</button>

						<br />
						<div class="modal fade" id="layerpop${status.index}">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">X</button>
										<h4 class="modal-title">이 공고에 지원하겠습니다!</h4>
									</div>
									<form
										action="../recruitment/insertApplication.do?recruitmentSeq=${list.recruitmentSeq}&employerSeq=${list.employerSeq}"
										method="post">
										<div class="modal-body">
											<h4>사장님의 질문</h4>
											<div id="requirementQuestion">
												<ul>
													<li class="question">질문 1 :
														${list.requirementQuestion1}</li>
													<li class="answer"><input type="radio" name="answer1"
														value="1">Yes <input type="radio" name="answer1"
														value="0">No</li>
												</ul>
												<br>
												<ul>
													<li class="question">질문 2 :
														${list.requirementQuestion2}</li>
													<li class="answer"><input type="radio" name="answer2"
														value="1">Yes <input type="radio" name="answer2"
														value="0">No</li>
												</ul>
												<br>
												<ul>
													<li class="question">질문 3 :
														${list.requirementQuestion3}</li>
													<li class="answer"><input type="radio" name="answer3"
														value="1">Yes <input type="radio" name="answer3"
														value="0">No</li>
												</ul>
											</div>
										</div>
										<div class="modal-footer">
											<input type="submit" class="btn btn-primary" value="지원하기">

										</div>
									</form>
								</div>
							</div>
						</div>


					</div>
				</c:forEach>
			</div>
		</div>



		<br> <br>

		<h3>마감된 공고목록</h3>
		<div id="wrap">
			<div class="accordion recruitmentList">

				<!-- 마감공고목록 -->
				<c:forEach var="list" items="${endRecruitmentList}"
					varStatus="status">
					<div id="accordion-title">
						<ul class="recruitmentUp">
							<li>공고제목 : ${list.recruitmentTitle}</li>
							<li>접수마감 : ${list.closingDate}</li>
						</ul>
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
							<li><input type="button" class="btn btn-light"
								onclick="location.href='../recruitment/showRecruitmentAction.do?seq=${list.recruitmentSeq}'"
								value="상세 보기">
						</ul>


					</div>
				</c:forEach>
			</div>
		</div>
	<br>
<br>
		<div id="chart">
			<div class="row2">
				<div class="col-md-6">
				<h3>기업 등급</h3>
					<canvas id="employerGrade" width="500px"></canvas>	
				</div>
				<div class="col-md-6">	
				<h3>채용자 성별 현황</h3>
					<canvas id="employerGender" width="500px"></canvas>
				</div>
			</div>
		</div>
	</div>
	<footer></footer>
</body>



<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=814861f68a4b2c5498535e608555d96a&libraries=services"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=814861f68a4b2c5498535e608555d96a&libraries=services,clusterer,drawing"></script>
<script>
var employerGender = $('#employerGender');
var employerGender = new Chart(employerGender, {
    type: 'pie',
    data: {
        labels: ['여자', '남자'],
        datasets: [{
            label: '채용자 성별 현황',
            data: [${woman}, ${man}],
            backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
				'rgba(54, 162, 235, 0.2)' ],
		borderColor : [ 'rgba(255, 99, 132, 1)',
				'rgba(54, 162, 235, 1)' ],
		borderWidth : 1
        }]
    },
    options : {
		plugins : {
			textPie : false
		}
	}
});



var employerGrade = $('#employerGrade');
var employerGrade = new Chart(
		employerGrade,
		{
			type : 'doughnut',
			data : {
				labels : [ "매우 불량", "불량", "평균", "우수", "최우수" ],
				datasets : [ {
					label : '기업 등급',
					data : [ 30, 20, 20, 20, 10 ],
					backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
							'rgba(54, 162, 235, 0.2)',
							'rgba(255, 206, 86, 0.2)',
							'rgba(75, 192, 192, 0.2)',
							'rgba(153, 102, 255, 0.2)' ],
					borderColor : [ 'rgba(255,99,132,1)',
							'rgba(54, 162, 235, 1)',
							'rgba(255, 206, 86, 1)',
							'rgba(75, 192, 192, 1)',
							'rgba(153, 102, 255, 1)' ],
					borderWidth : 1
				} ]
			},
			options : {
				rotation : 1 * Math.PI,
				circumference : 1 * Math.PI,
				plugins : {
					textPie : true,
					datalabels : {
						color : '#111',
						textAlign : 'center',
						font : {
							lineHeight : 1.6
						},
						formatter : function(value, ctx) {
							return ctx.chart.data.labels[employerGrade.dataIndex]
									+ 'n' + value + '%';
						}
					}
				},
				tooltips : {
					enabled : false
				}
			}
		});

var employerScore = 66;
var employerScoreGrade = '';
if (employerScore >= 90) {
	employerScoreGrade = '최우수';
} else if (employerScore >= 70) {
	employerScoreGrade = '우수';
} else if (employerScore >= 50) {
	employerScoreGrade = '양호';
} else if (employerScore >= 30) {
	employerScoreGrade = '불량';
} else {
	employerScoreGrade = '매우 불량';
}

Chart.pluginService
		.register({
			id : 'textPie',
			beforeDraw : function(chart) {
				var width = chart.chart.width, height = chart.chart.height, ctx = chart.chart.ctx;

				ctx.restore();
				var fontSize = 30;
				ctx.font = fontSize + "px sans-serif";
				ctx.textBaseline = "middle";
				ctx.fontWeight = "bold";

				var text = employerScoreGrade + " " + employerScore + "점", textX = Math
						.round((width - ctx.measureText(text).width) / 2), textY = height - 80;

				ctx.fillText(text, textX, textY);
				ctx.save();
			}
		});




	var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
	mapOption = {
		center : new kakao.maps.LatLng(37.4849665053325, 127.034757121285), // 지도의 중심좌표
		level : 3
	// 지도의 확대 레벨 
	};
	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

	<c:forEach items="${mapList}" var="item">
	console.log('${item}')
	//마커를 생성합니다
	var marker = new kakao.maps.Marker({
		position : new kakao.maps.LatLng(parseFloat("${item.longitude}"),
				parseFloat("${item.latitude}"))
	//마커가 표시될 위치입니다 
	});

	//마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);
	</c:forEach>

	//아래 코드는 지도 위의 마커를 제거하는 코드입니다
	//marker.setMap(null);    

</script>
</html>