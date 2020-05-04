<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/jquery-ui.css">
<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="./css/bootstrap-theme.css">
<script src="/Albanara/js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="/Albanara/js/jquery-ui.js" type="text/javascript"></script>
<script src="/Albanara/js/bootstrap.js" type="text/javascript"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=814861f68a4b2c5498535e608555d96a&libraries=services"></script>
<script type="text/javascript">
	function deleteBtn_onClick(employerId) {
		alert('회원탈퇴 하시겠습니까?');
		document.location.href="deleteEmployers.do?employerId=bbbb";
	}
</script>
</head>
<body>
<form action="UpdateEmployers.do" id="employerUpdate" method="post">
		<h1>기업 정보 수정 </h1>
		<div>
			<div class="employerId" valign=top>* 아이디 </div>
			<div><input id="employerIdInput" name="employerId" type="text" maxlength="16"
				required="required" readonly value="${login.employerId }" />
		</div>
		<div>
			<div class="employerPw" valign=top>* 새 비밀번호 </div>
			<div><input id="employerPassInput" name="employerPw" type="password"
				maxlength="16" required="required"
				placeholder="&nbsp;&nbsp;&nbsp;비밀번호를 입력해주세요." />
				<p class="employerPwGuide1">10자 이상 입력</p>
				<p class="employerPwGuide2">영문/숫자/특수문자 조합으로 입력</p></div>
		</div>
		<div>
			<div class="employerPwCheck" valign=top>* 비밀번호 확인 </div>
			<div><input id="employerPwCheckInput" type="password" maxlength="16" name="employerPw2"
				required="required" placeholder="&nbsp;&nbsp;&nbsp;비밀번호를 한번 더 입력해주세요." />
				<p class="employerPwCheckGuide">동일한 비밀번호를 입력해주세요.</p></div>
		</div>
		<div>
			<div class="employerName" valign=top>* 기업명 </div>
			<div><input id="employerNameInput" name="employerName" type="text" maxlength="10"
				readonly value="${login.employerName }"  /></div>
		</div>
		<div>
			<div class="employerNumber" valign=top>*사업자 번호</div>
			<div valign=top>
				<div class="employerNo">
					<input id="employerNoInput" type="text" name="employerNumber" value="${login.employerNumber }" readonly/>
				</div>
			</div>
		</div>
		<div class="employeeAddressClass">
			<div class="employeeAddress" valign=top>* 사업장 주소 </div>
		</div>
		<div>
			<input type="text" id="sample5_address" placeholder="주소" name = "employerAddress">
			<input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
			<div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>


			<script>
			    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
			        mapOption = {
			            center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
			            level: 5 // 지도의 확대 레벨
			        };
			
			    //지도를 미리 생성
			    var map = new daum.maps.Map(mapContainer, mapOption);
			    //주소-좌표 변환 객체를 생성
			    var geocoder = new daum.maps.services.Geocoder();
			    //마커를 미리 생성
			    var marker = new daum.maps.Marker({
			        position: new daum.maps.LatLng(37.537187, 127.005476),
			        map: map
			    });
			
			
			    function sample5_execDaumPostcode() {
			        new daum.Postcode({
			            oncomplete: function(data) {
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
			</script>
		</div>
		<div>
			<div class="employerField" valign=top>* 사업장 분야</div>
			<div>
			 	<input id="fields" name="employerField" readonly value="${login.employerField }">
			</div>
		</div>
		<div>
			<div class="employerHomePage" valign=top>* 홈페이지</div>
			<div><input id="employerHomePageInput" type="text" name="employerHomePage" value="${login.employerHomePage}"/></div>
		</div>
		<div>
			<div class="ownerName" valign=top>* 대표자 이름</div>
			<div><input id="ownerNameInput" type="text" name="ownerName" value="${login.ownerName }"/></div>
		</div>
		<div class="ownerPhoneClass">
			<div class="ownerPhone" valign=top>* 핸드폰번호</div>
			<div valign=top>
				<div class="ownerPhoneNo">
					<input id="owner_phone_010" type="text" size="4" value="010" name ="ownerPhoneNo1" readonly/>&nbsp;-	
					<input id="owner_phone_first" type="text" size="4" maxlength="4" pattern="[0-9]*" name="ownerPhoneNo2"/>
					<span> - </span> 	
					<input id="owner_phone_second" type="text" size="4" maxlength="4" pattern="[0-9]*" name="ownerPhoneNo3"/>
				</div>
			</div>
		</div>
		<input id="updatebutton" type="submit" value="기업 정보 수정"/>
		<input type="button" id="deletebutton" onclick="deleteBtn_onClick(this.form.employerIdInput.value);" value="회원탈퇴"/>
	</form>
</body>
</html>