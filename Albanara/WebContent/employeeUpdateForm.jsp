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
	document.location.href="deleteEmployees.do?employeeId=ggggg";
}
</script>
</head>
<body>
<div class="container">
	<form action="updateEmployees.do" method="post" >
		<h1> 구직자 회원정보 수정 </h1>
		<div>
			<div class="employeeId" valign=top>* 아이디 </div>
			<div><input id="employeeIdInput" name="employeeId" type="text" maxlength="16" value="${employees.employeeId }"
				 placeholder="&nbsp;&nbsp;&nbsp;아이디를 입력해주세요." />
						
				<p class="employeeIdGuide">6자 이상의 영문 혹은 영문과 숫자를 조합</p>
				<p class="employeeIdCheck">이미 있는 아이디 입니다.</p></div>
		</div>
		<div>
			<div class="employeePw" valign=top>* 새 비밀번호 </div>
			<div><input id="employeePassInput" name="employeePw" type="password"
				maxlength="16" required="required"
				placeholder="&nbsp;&nbsp;&nbsp;비밀번호를 입력해주세요." />
				<p class="employeePwGuide1">10자 이상 입력</p>
				<p class="employeePwGuide2">영문/숫자/특수문자 조합으로 입력</p></div>
		</div>
		<div>
			<div class="employeePwCheck" valign=top>* 비밀번호 확인</div>
			<div><input id="employeePwCheckInput" type="password" maxlength="16"
				required="required"
				placeholder="&nbsp;&nbsp;&nbsp;비밀번호를 한번 더 입력해주세요." />
				<p class="employeePwCheckGuide">동일한 비밀번호를 입력해주세요.</p></div>
		</div>
		<div>
			<div class="employeeName" valign=top>* 이름 </div>
			<div><input id="employeeNameInput" name="employeeName" type="text" maxlength="10"
				readonly placeholder="&nbsp;&nbsp;&nbsp;이름을 입력해주세요." /></div>
		</div>
		<div class="employee_birth_div">
			<div class="employeeBirth" valign=top>* 생년월일</div>
			<div valign=top>
				<div class="employeeBirthDiv" name="employeeBirth">
					<input id="employeeBirthYear" name = "employeeBirthYear" type="text" size="4" maxlength="4" 
						placeholder="YYYY" pattern="[0-9]*"  /> 
					<span>/</span> 								
					<input id="employeeBirthMonth" name = "employeeBirthMonth" type="text" size="2" maxlength="2"
						placeholder="MM" pattern="[0-9]*" />
					<span>/</span> 
					<input id="employeeBirthDay" name = "employeeBirthDay" type="text" size="2" maxlength="2"
						placeholder="DD" pattern="[0-9]*"  />
				</div>
			</div>
		</div>
		<div>
			<div class="employeeEmail" valign=top>* 변경할 이메일 </div>
			<div>
				<input type="text" id="employeeEmailInput" name ="employeeEmailInput1">
					 @
				<select name = "employeeEmailInput2">
					<option value="@naver.com">naver.com</option>
					<option value="@gmail.com">gmail.com</option>
					<option value="@hanmail.net">hanmail.net</option>
					<option value="@nate.com">nate.com</option>
				</select>
			</div>
			
		<div class="employeeGenderClass">
			<div class="employeeGender" name="employeeGender" valign=top>* 성별</div>
			<div valign=top><input type="radio" name="employeeGender" value="man" />남자&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="employeeGender" value="woman" />여자&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</div>
		<div class="employeePhoneClass">
			<div class="employeePhone" valign=top>* 변경할 핸드폰 번호</div>
			<div valign=top>
				<div class="employeePhoneNo" name="employeePhone">
					<input id="employee_phone_010" type="text" size="4" value="010" name ="employeePhone1" readonly/>&nbsp;-
					<input id="employee_phone_first" type="text" size="4" maxlength="4" pattern="[0-9]*" name ="employeePhone2"/>
					<span> - </span> 	
					<input id="employee_phone_second" type="text" size="4" maxlength="4" pattern="[0-9]*" name ="employeePhone3"/>
				</div>
			</div>
		</div>
		<div class="employeeAddressClass">
			<div class="employeeAddress" valign=top>* 변경할 주소 </div>
		</div>
		<input type="text" id="sample5_address" placeholder="주소" name = "employeeAddress">
		<input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
		<div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>
		<input type="hidden" id="latitude" placeholder="위도" name="latitude">
		<input type="hidden" id="longitude" placeholder="경도" name="longitude">
		<input type="button" onclick="getLatlng()" value="주소 등록"><br>

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
    };
    
    function getLatlng() {
    	var query = document.getElementById('sample5_address').value;
    	var totalUrl = 'https://dapi.kakao.com/v2/local/search/address.json?query=' + query;
    	$.ajax({
    		url : 'https://dapi.kakao.com/v2/local/search/address.json' ,
    		headers : { 'Authorization' : 'KakaoAK e8a788b4cc661ab86dff50abd5c61f6c'	},
    		type : 'get',
    		dataType:'text',
    		data: {
    			"query" : query 
    		},
    		success: function(data){
    			console.log('성공했다');
    			var obj = JSON.parse(data);
    			var x = obj.documents[0].x;
    			var y = obj.documents[0].y;
    			document.getElementById("latitude").value = x;
    			document.getElementById("longitude").value = y;
    			
    		},
    		error : function(request, status, error){
    			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
    		}		
    	});	
    };
</script>

		<br> <input id="updatebutton" type="submit" value="정보수정완료" />
		<input type="button" id="deletebutton" onclick="deleteBtn_onClick(this.form.employeeIdInput.value);" value="회원탈퇴"/>
		
	</form>
</div>

</body>
</html>