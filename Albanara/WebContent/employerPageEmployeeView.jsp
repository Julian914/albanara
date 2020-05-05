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
<link rel="stylesheet" type="text/css" href="/Albanara/css/header.css">
<link rel="stylesheet" type="text/css" href="/Albanara/css/nav.css">
<link rel="stylesheet" type="text/css" href="/Albanara/css/footer.css">
<link rel="stylesheet" type="text/css"	href="/Albanara/css/employerPage.css">
<script src="/Albanara/js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="/Albanara/js/jquery-ui.js" type="text/javascript"></script>
<script src="/Albanara/js/bootstrap.js" type="text/javascript"></script>
<script src="/Albanara/js/Chart.js" type="text/javascript"></script>
<script src="/Albanara/js/Chart.bundle.js" type="text/javascript"></script>
<script src="/Albanara/js/employerPage.js" type="text/javascript"></script>




<jsp:include page="header.html"></jsp:include>
<jsp:include page="nav.html"></jsp:include>



</head>
<body>

	<header></header>
	<nav></nav>

	<div class="container">


		<h1>기업 마이페이지(구직자관점)</h1>
		<br>
		<br>
		<div class="row">
			<div class="col-md-4">
				<img class="employerFile" src="/Albanara/images/employerPage/coupang.png" style="width:300px; height:300px; margin-top:10px;"><br>
			 <br>
			</div>
			<br>
			<div class="col-md-4">
				<div class="employerInfo">
				<ul>
					<li>기업명 : ${employer.employerName}</li>
					<li>기업주소:${employer.employerAddress }</li>
					<li>홈페이지 주소 :<button type="button" class="btn btn-link">${employer.employerHomePage}</button></li>
					<li>전화번호:${employer.employerNumber}</li>
					<li>분야	:${employer.employerField} </li>
					<br>
					<li><b><img	class="evalIcon" onclick="insertEmployerEval.do?seq=${employer.employerSeq}"
						src="/Albanara/images/employerPage/like.png" name="좋아요" value="like">좋아요 ${employer.likeCount}
					<img class="evalIcon" onclick="insertEmployerEval.do?seq=${employer.employerSeq}"
							src="/Albanara/images/employerPage/unlike.png" name="별로예요"	value="unlike">별로예요 ${employer.unlikeCount}</b></li>
				</ul>
				</div>
			</div>
			<div class="col-md-4">
				기업지도
				<div id="map" style="width: 300px; height: 300px; margin-top: 10px;"></div>
			</div>
		</div>
		<br> <br>

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
													<li class="question">질문 1 : ${list.requirementQuestion1}</li>
													<li class="answer"><input type="radio" name="answer1" value="1">Yes
														<input type="radio" name="answer1" value="0">No</li>
												</ul>
												<br>
												<ul>
													<li class="question">질문 2 : ${list.requirementQuestion2}</li>
													<li class="answer"><input type="radio" name="answer2" value="1">Yes
														<input type="radio" name="answer2" value="0">No</li>
												</ul>
												<br>
												<ul>
													<li class="question">질문 3 : ${list.requirementQuestion3}</li>
													<li class="answer"><input type="radio" name="answer3" value="1">Yes
														<input type="radio" name="answer3" value="0">No</li>
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
	</div>

<div id="map" style="width: 300px; height: 300px; margin-top: 10px;"></div>
<canvas id="employerGender" width="800"></canvas>



	<footer></footer>
</body>


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
<jsp:include page="footer.html"></jsp:include>
</html>