<%@page import="kosta.albanara.model.Employers"%>
<%@page import="kosta.albanara.dao.EmployerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Albanara/css/jquery-ui.css">
<link rel="stylesheet" href="Albanara/css/bootstrap.css">
<link rel="stylesheet" href="Albanara/css/bootstrap-theme.css">
<link rel="stylesheet" href="/Albanara/css/Chart.css">
<script src="/Albanara/js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="/Albanara/js/jquery-ui.js" type="text/javascript"></script>
<script src="/Albanara/js/bootstrap.js" type="text/javascript"></script>
<script src="/Albanara/js/Chart.js" type="text/javascript"></script>
<script src="/Albanara/js/Chart.bundle.js" type="text/javascript"></script>
</head>
<body>
	<h1>기업 마이페이지</h1>
	기업명 : ${employer.employerName} <br>
	기업주소 : ${employer.employerAddress } <br>
	기업홈페이지 주소 : ${employer.employerHomePage} <br>
	
	<div id="map" style="width:300px;height:300px;margin-top:10px;"></div>
	<canvas id="employerGender" width="800"></canvas>
	
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=814861f68a4b2c5498535e608555d96a&libraries=services"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=814861f68a4b2c5498535e608555d96a&libraries=services,clusterer,drawing"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
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
</body>
</html>