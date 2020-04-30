<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=814861f68a4b2c5498535e608555d96a&libraries=services"></script>
<title>공고 등록</title>
<style type="text/css">
.container {
	max-width: 960px;
}

.bg-light {
	background-color: #f8f9fa !important;
}

.radioStyle {
	margin: 0px 10px;
}
</style>
</head>
<body class="bg-light">
	<div class="container">
		<div class="py-5 text-center">
			<h1>모집 공고</h1>
			<p class="lead">모집 공고 내용을 입력 후, "등록" 버튼을 눌러주세요.</p>
		</div>
		<div class="row">
			<form action="insertRecruitmentAction.do" method="post">
				<div class="form-group col-md-12">
					<h3>분류</h3>
					<span class="radioStyle"> <input type="radio" id="strength"
						name="recruitmentType" value="strength"> <label
						for="strength">힘</label>
					</span> <span class="radioStyle"> <input type="radio"
						id="intelligence" name="recruitmentType" value="intelligence">
						<label for="intelligence">지능</label>
					</span> <span class="radioStyle"> <input type="radio" id="kindness"
						name="recruitmentType" value="kindness"> <label
						for="kindness">친절</label>
					</span> <span class="radioStyle"> <input type="radio" id="patience"
						name="recruitmentType" value="patience"> <label
						for="patience">끈기</label>
					</span>
				</div>
				<div class="form-group col-md-12">
					<h3>제목</h3>
					<input type="text" class="form-control" name="recruitmentTitle">
				</div>
				<div class="form-group">
					<div class="col-md-4">
						<h3>근무 시작일</h3>
						<input type="date" class="form-control" name="startingWorkingDate">
					</div>
					<div class="col-md-4">
						<h3>근무 종료일</h3>
						<input type="date" class="form-control" name="endingWorkingDate">
					</div>
					<div class="col-md-4">
						<h3>총 근무일수</h3>
						<input type="number" class="form-control" name="totalWorkingDay">
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-4">
						<h3>근무 시작 시간</h3>
						<input type="number" class="form-control"
							name="startingWorkingTime">
					</div>
					<div class="col-md-4">
						<h3>근무 종료 시간</h3>
						<input type="number" class="form-control" name="endingWorkingTime">
					</div>
					<div class="col-md-4">
						<h3>총 근무 시간</h3>
						<input type="number" class="form-control" name="totalWorkingTime">
					</div>
					<div class="col-md-4">
						<h3>모집 인원</h3>
						<input type="number" class="form-control" name="recruitmentSize">
					</div>
					<div class="col-md-4">
						<h3>모집 종료일</h3>
						<input type="date" class="form-control" name="closingDate">
					</div>
					<div class="col-md-4">
						<h3>급여</h3>
						<div class="col-md-6">
							<select id="wageType" class="form-control" name="wageType">
								<option value="hourlyWage" selected>시급</option>
								<option value="dailyWage">일급</option>
							</select>
						</div>
						<div class="col-md-6">
							<input type="number" class="form-control" name="wage">
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-6">
						<h3>연령</h3>
						<div>
							<div>
								<input type="radio" id="other" name="age" value="other">
								<label for="other">연령무관</label>
							</div>
							<div>
								<input type="radio" id="age" name="age" value="age"> <label
									for="age">연령제한 있음</label>
							</div>
							<div class="col-md-12">
								<div class="col-md-5">
									<input type="number" class="form-control" name="minAge">
									<small class="text-muted">세 이상</small>
								</div>
								<div class="col-md-1">~</div>
								<div class="col-md-5">
									<input type="number" class="form-control" name="maxAge">
									<small class="text-muted">세 이하</small>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<h3>성별</h3>
						<div>
							<div>
								<input type="radio" id="other" name="gender" value="other">
								<label for="other">성별무관</label>
							</div>
							<div>
								<input type="radio" id="male" name="gender" value="male">
								<label for="male">남자</label>
							</div>
							<div>
								<input type="radio" id="female" name="gender" value="female">
								<label for="female">여자</label>
							</div>
						</div>
					</div>
				</div>
				<div class="form-group col-md-12">
					<h3>요구 조건</h3>
					<input type="text" class="form-control" name="requirementQuestion1"
						placeholder="요구조건 첫 번째 항목을 입력해주세요."> <input type="text"
						class="form-control" name="requirementQuestion2"
						placeholder="요구조건 두 번째 항목을 입력해주세요."> <input type="text"
						class="form-control" name="requirementQuestion3"
						placeholder="요구조건 세 번째 항목을 입력해주세요.">
				</div>
				<div class="form-group col-md-12">
					<h3>상세 정보</h3>
					<textarea class="form-control" name="recruitmentContents" rows="6">
				</textarea>
				</div>
				<div class="form-group col-md-12">
					<h3>근무지 주소</h3>
					<div class="col-md-10">
						<input type="text" class="form-control" id="sample5_address"
							placeholder="주소" name="workingPlaceAddress">
					</div>
					<div class="col-md-2">
						<input type="button" onclick="sample5_execDaumPostcode()"
							class="btn btn-default btn-block" value="주소 검색">
					</div>
				</div>
				<div class="col-md-12" id="map"
					style="width: 300px; height: 300px; margin: 10px 0px 0px 30px; display: none;"></div>
				<div class="col-md-12" style="height: 20px;"></div>	
				<div class="col-md-12">
					<div class="col-md-6">
						<input type="reset" class="btn btn-default btn-lg btn-block"
							value="초기화">
					</div>
					<div class="col-md-6">
						<input type="submit" class="btn btn-primary btn-lg btn-block"
							value="등록">
					</div>
				</div>
				<input type="hidden" id="latitude" placeholder="위도" name="latitude">
				<input type="hidden" id="longitude" placeholder="경도"
					name="longitude"> <input type="hidden"
					onclick="addrInsertClick()" value="주소 등록">
			</form>
		</div>
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
	};

	function addrInsertClick() {
		var location = document.getElementById('sample5_address').value;
		$.ajax({
			url : 'map/kakaoMap.go',
			type : 'get',
			dataType : 'text',
			data : {
				"location" : location,
			},
			success : function(data) {
				console.log(data);
				data = JSON.parse(data);
				var latitude = data.documents[0].x;
				var longitude = data.documents[0].y;
				document.getElementById("latitude").value = latitude;
				document.getElementById("longitude").value = longitude;
			},
			error : function(xhr, status, error) {
				console.log('실패?')
				console.log(xhr);
				console.log(error);
			}
		});
	}
</script>
</html>