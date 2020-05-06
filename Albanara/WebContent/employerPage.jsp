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
<link rel="stylesheet" type="text/css" href="/Albanara/css/employerPage.css">

<script src="/Albanara/js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="/Albanara/js/jquery-ui.js" type="text/javascript"></script>
<script src="/Albanara/js/bootstrap.js" type="text/javascript"></script>
<script src="/Albanara/js/Chart.js" type="text/javascript"></script>
<script src="/Albanara/js/Chart.bundle.js" type="text/javascript"></script>
<script src="/Albanara/js/employerPage.js" type="text/javascript"></script>

<script>
   $(function() {
      $(".accordion").accordion({
         heightStyle : "content"
      });
   });
</script>

<jsp:include page="header.html"></jsp:include>
<jsp:include page="nav.html"></jsp:include>



</head>
<body>


	<header></header>
	<nav></nav>

	<div class="container">
	<div class="employer">
		<h1>기업 마이페이지(기업관점)</h1>
		
		<div class="row">
			<div class="col-md-4">
				<img class="employerFile" src="/Albanara/images/employerPage/noImage.png" style="width: 300px; height: 300px; margin-top: 10px;"><br>
				<br>
			</div>
			<br>
			<div class="col-md-4">
				<div class="employerInfo">
				<ul>
					<li>기업명 :</li>
					<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b> ${employer.employerName}</b></li> 
					<li>주소:	</li>
					<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>${employer.employerAddress }</b></li> 
					<li>전화번호 :	</li>
					<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>${employer.employerNumber}</b> </li> 
					<li>홈페이지:</li>
					<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="homepageAddress" href="employer.employerHomePage">${employer.employerHomePage}</a></li>
					<li>분야 :</li>
					<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>${employer.employerField}</b></li>
				</ul>
				<br>
				<br>
				<br>
				<br>
				<input type="button" class="btn btn-primary updatebutton"
						onclick="location.href='UpdateEmployersForm.do?seq=${employer.employerSeq}'"
						value="정보수정하기">
				
				</div>
			</div>
			<div class="col-md-4">
				<div id="map" style="width: 300px; height: 300px; margin-top: 10px;"></div>
			</div>
		</div>
	</div>
	<br> <br>
	<div id="wrap">
		<h3>현재 진행중인 공고목록</h3>

		<div class="accordion recruitmentList">

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
						<br>
						<input type="button" class="btn btn-light" 
								onclick="location.href='../recruitment/showRecruitmentAction.do?seq=${list.recruitmentSeq}'"value="공고 상세 보기"> 
						<input type="button" class="btn btn-secondary" 
								onclick="location.href='../recruitment/updateRecruitmentForm.do?seq=${list.recruitmentSeq}'"value="수정"> 
						<input type="button" class="btn btn-secondary" 
								onclick="location.href='../recruitment/deleteRecruitmentAction.do?seq=${list.recruitmentSeq}'" value="삭제">
						<br><br>
						

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
											<input type="button" class="btn btn-light"
												onclick="location.href='showEmployee.do?seq=${employeeList.employeeSeq}'"
												value="지원자 상세 보기"><input type="button"
												class="btn btn-primary"
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



		<br> <br>

		<h3>마감된 공고목록</h3>
		<div id="wrap">
			<div class="accordion recruitmentList">

				<!-- 마감공고목록 -->
				<c:forEach var="endlist" items="${endRecruitmentList}"
					varStatus="status">
					<div id="accordion-title">
						<ul class="recruitmentUp">
							<li>공고제목 : ${endlist.recruitmentTitle}</li>
							<li>접수마감 : ${endlist.closingDate}</li>
						</ul>
					</div>
					<div id="accordion-contents">
						<ul class="recruitmentDown">
							<li>총 근무시간 : ${endlist.totalWorkingTime} 시간</li>
							<li>연령제한 : ${endlist.minAge} 세 ~${endlist.maxAge} 세</li>
							<li>시급 : ${endlist.wage} 원</li>
							<li>근무지 주소 : ${endlist.workingPlaceAddress}</li>
							<li>근무일자 :<fmt:parseDate var="startdate"
									value="${endlist.startingWorkingDate}" pattern="yyyy-MM-dd" />
								<fmt:formatDate value="${startdate}" pattern="yyyy.MM.dd" /> ~<fmt:parseDate
									var="enddate" value="${endlist.endingWorkingDate}"
									pattern="yyyy-MM-dd" /> <fmt:formatDate value="${enddate}"
									pattern="yyyy.MM.dd" /></li>
							<li><input type="button" class="btn btn-light"
								onclick="location.href='../recruitment/showRecruitmentAction.do?seq=${endlist.recruitmentSeq}'"
								value="상세 보기"> <input type="button" class="btn btn-secondary"
								onclick="location.href='../recruitment/deleteRecruitmentAction.do?seq=${endlist.recruitmentSeq}'"
								value="삭제"></li>
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
											<input type="button" class="btn btn-light"
												onclick="location.href='showEmployee.do?seq=${hiredEmployeeList.employeeSeq}'"
												value="채용자 상세 보기">
											<input type="button" class="btn btn-primary"
												onclick="location.href='insertProposal.do?seq=${endlist.recruitmentSeq}&seq2=${employeeList.employeeSeq}'"
												value="일자리 제안하기">
										</div>
									</c:forEach>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>


		<canvas id="employerGrade" width="800"></canvas>
		<canvas id="employerGender" width="800"></canvas>


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

var employerGrade = $('#employerGrade');
var employerGrade = new Chart(employerGrade, {
    type: 'doughnut',
    data: {
        labels: ["매우 불량", "불량", "평균", "우수", "최우수"],
        datasets: [{
            label: '기업 등급',
            data: [30, 20, 20, 20, 10],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)'
            ],
            borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        rotation: 1 * Math.PI,
        circumference: 1 * Math.PI,
        plugins: {
        	textPie : true,
        	datalabels: {
                color: '#111',
                textAlign: 'center',
                font: {
                    lineHeight: 1.6
                },
                formatter: function(value, ctx) {
                    return ctx.chart.data.labels[employerGrade.dataIndex] + 'n' + value + '%';
                }
            }
        },
        tooltips: {
            enabled: false
   		}
    }
});

var employerScore = 66;
var employerScoreGrade = '';
if (employerScore >= 90) {
	employerScoreGrade = '최우수';
} else if(employerScore >= 70) {
	employerScoreGrade = '우수';
}  else if(employerScore >= 50) {
	employerScoreGrade = '양호';
}  else if(employerScore >= 30) {
	employerScoreGrade = '불량';
}  else {
	employerScoreGrade = '매우 불량';
} 

Chart.pluginService.register({
	id: 'textPie',
	beforeDraw: function(chart) {
		var width = chart.chart.width,
		height = chart.chart.height,
		ctx = chart.chart.ctx;
		
		ctx.restore();
		var fontSize = 30;
		ctx.font = fontSize + "px sans-serif";
		ctx.textBaseline = "middle";
		ctx.fontWeight = "bold";
		
		var text = employerScoreGrade + " " + employerScore + "점",
		    textX = Math.round((width - ctx.measureText(text).width) / 2),
		    textY = height - 80;
		
		ctx.fillText(text, textX, textY);
		ctx.save();
	}
});
	
	

var employeeGender = $('employeeGender');
var employeeGender = new Chart(employeeGender, {
    type: 'pie',
    data: {
        labels: ['여자', '남자'],
        datasets: [{
            label: '채용자 성별 현황',
            data: [1,2],//[${woman}, ${man}],
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
    options: {
    	plugins: {
 	   		textPie : false
 	 	}
    }
   
});


</script>
<jsp:include page="footer.html"></jsp:include>
</html>