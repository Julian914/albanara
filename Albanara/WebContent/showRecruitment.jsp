<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
</style>
<link rel="stylesheet" href="Albanara/css/jquery-ui.css">
<link rel="stylesheet" href="Albanara/css/bootstrap.css">
<link rel="stylesheet" href="Albanara/css/bootstrap-theme.css">
<link rel="stylesheet" href="/Albanara/css/Chart.css">
<script src="/Albanara/js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="/Albanara/js/jquery-ui.js" type="text/javascript"></script>
<script src="/Albanara/js/bootstrap.js" type="text/javascript"></script>
<script src="/Albanara/js/Chart.js" type="text/javascript"></script>
<script src="/Albanara/js/Chart.bundle.js" type="text/javascript"></script>
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=814861f68a4b2c5498535e608555d96a&libraries=services"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>모집 공고</h1>
		<div>모집 공고</div>
		<input type="hidden" name="recruitmentSeq"
			value="${recruitment.recruitmentSeq }"> <input type="hidden"
			name="employerSeq" value="${recruitment.employerSeq }">
		<div>
			<input type="text" name="recruitmentTitle"
				value="${recruitment.recruitmentTitle }">
		</div>
		<div>분류</div>
		<input type="radio" id="strength" name="recruitmentType"
			value="strength"
			<c:if test="${recruitment.recruitmentType == 'strength' }">checked</c:if>>
		<label for="strength">힘</label> <input type="radio" id="intelligence"
			name="recruitmentType" value="intelligence"
			<c:if test="${recruitment.recruitmentType == 'intelligence' }">checked</c:if>>
		<label for="intelligence">지능</label> <input type="radio" id="kindness"
			name="recruitmentType" value="kindness"
			<c:if test="${recruitment.recruitmentType == 'kindness' }">checked</c:if>>
		<label for="kindness">친절</label> <input type="radio" id="patience"
			name="recruitmentType" value="patience"
			<c:if test="${recruitment.recruitmentType == 'patience' }">checked</c:if>>
		<label for="patience">끈기</label>

		<div>모집 인원</div>
		<div>
			<input type="number" name="recruitmentSize"
				value="${recruitment.recruitmentSize }">
		</div>
		<div>근무 시작일</div>
		<input type="date" name="startingWorkingDate"
			value="${recruitment.startingWorkingDate }">
		<div>근무 종료일</div>
		<input type="date" name="endingWorkingDate"
			value="${recruitment.endingWorkingDate }">
		<div>총 근무일수</div>
		<input type="number" name="totalWorkingDay"
			value="${recruitment.totalWorkingDay }">
		<div>근무 시간</div>
		<div>시작 시간</div>
		<input type="number" name="startingWorkingTime"
			value="${recruitment.startingWorkingTime }">
		<div>종료 시간</div>
		<input type="number" name="endingWorkingTime"
			value="${recruitment.endingWorkingTime }">
		<div>총 시간</div>
		<input type="number" name="totalWorkingTime"
			value="${recruitment.totalWorkingTime }">
		<div>급여</div>
		<select id="wageType" name="wageType">
			<option value="hourlyWage"
				<c:if test="${recruitment.wageType == 'hourlyWage' }">selected</c:if>>시급</option>
			<option value="dailyWage"
				<c:if test="${recruitment.wageType == 'dailyWage' }">selected</c:if>>일급</option>
		</select> <input type="number" name="wage" value="${recruitment.wage }">
		<div>성별</div>
		<input type="radio" id="other" name="gender" value="other"> <label
			for="other">성별무관</label> <input type="radio" id="male" name="gender"
			value="male"
			<c:if test="${recruitment.gender == 'male' }">checked</c:if>>
		<label for="male">남자</label> <input type="radio" id="female"
			name="gender" value="female"
			<c:if test="${recruitment.gender == 'female' }">checked</c:if>>
		<label for="female">여자</label>
		<div>연령</div>
		<input type="radio" id="other" name="age" value="other"> <label
			for="other">연령무관</label> <input type="radio" id="age" name="age"
			value="age"> <label for="age">연령제한 있음</label> <input
			type="number" name="minAge" value="${recruitment.minAge }">세
		이상 <input type="number" name="maxAge" value="${recruitment.maxAge }">세
		이하
		<div>우대 조건</div>
		<input type="text" name="requirementQuestion1"
			value="${recruitment.requirementQuestion1 }"> <input
			type="text" name="requirementQuestion2"
			value="${recruitment.requirementQuestion2 }"> <input
			type="text" name="requirementQuestion3"
			value="${recruitment.requirementQuestion3 }">
		<div>모집 종료일</div>
		<input type="date" name="closingDate"
			value="${recruitment.closingDate }">
		<div>상세 정보</div>
		<textarea name="recruitmentContents" rows="4" cols="50">
			${recruitment.recruitmentContents }
			</textarea>
		<div>근무지 주소</div>

		<input type="text" id="sample5_address" placeholder="주소"
			name="workingPlaceAddress"
			value="${recruitment.workingPlaceAddress }"> <input
			type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
		<div id="map"
			style="width: 300px; height: 300px; margin-top: 10px; display: none"></div>
		<br>

		<canvas id="applicationGender" width="800"></canvas>
		<canvas id="myChart8" width="800">
	
	</div>
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

	function sample5_execDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				var addr = data.address; // 최종 주소 변수

				// 주소 정보를 해당 필드에 넣는다.
				document.getElementById("sample5_address").value = addr;
				// 주소로 상세 정보를 검색
				geocoder.addressSearch(data.address, function(results, status) {
					// 정상적으로 검색이 완료됐으면
					if (status === daum.maps.services.Status.OK) {

						var result = results[0]; //첫번째 결과의 값을 활용

						// 해당 주소에 대한 좌표를 받아서
						var coords = new daum.maps.LatLng(result.y, result.x);
						// 지도를 보여준다.
						mapContainer.style.display = "block";
						map.relayout();
						// 지도 중심을 변경한다.
						map.setCenter(coords);
						// 마커를 결과값으로 받은 위치로 옮긴다.
						marker.setPosition(coords)
					}
				});
			}
		}).open();
	}
	
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