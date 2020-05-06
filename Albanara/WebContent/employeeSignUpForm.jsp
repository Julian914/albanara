<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Albanara/css/jquery-ui.css">
<link rel="stylesheet" href="/Albanara/css/bootstrap.css">
<link rel="stylesheet" href="/Albanara/css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css" href="/Albanara/css/style.css">
<link rel="stylesheet" href="/Albanara/css/employeeSignUp.css" type="text/css" />
<script src="/Albanara/js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="/Albanara/js/jquery-ui.js" type="text/javascript"></script>
<script src="/Albanara/js/bootstrap.js" type="text/javascript"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=814861f68a4b2c5498535e608555d96a&libraries=services"></script>

<jsp:include page="header.html"></jsp:include>
<jsp:include page="nav.html"></jsp:include>

<script>
$(document).ready(function() {
    $("header").load("header.html")
    $("nav").load("nav.html")
    $("footer").load("footer.html")
 });
</script>

</head>
<body>

	<header></header>
	<nav></nav>
	
<div class="container">
	<form action="insertEmployees.do" id="employeeSignUp" method="post">
		<h1> 구직자 회원가입 </h1>
		<div class="employeeJoin">
		<div>
			<div class="employeeId" valign=top>* 아이디 </div>
			<div><input id="employeeIdInput" name="employeeId" type="text" maxlength="16"
				required="required" placeholder="&nbsp;&nbsp;&nbsp;아이디를 입력해주세요." />
						
				<!-- <p class="employeeIdGuide">6자 이상의 영문 혹은 영문과 숫자를 조합</p>
				<p class="employeeIdCheck">이미 있는 아이디 입니다.</p> -->
			</div>
		</div>
		<div>
			<div class="employeePw" valign=top>* 비밀번호 </div>
			<div><input id="employeePassInput" name="employeePw" type="password"
				maxlength="16" required="required"
				placeholder="&nbsp;&nbsp;&nbsp;비밀번호를 입력해주세요." />
				<!-- <p class="employeePwGuide1">10자 이상 입력</p>
				<p class="employeePwGuide2">영문/숫자/특수문자 조합으로 입력</p> -->
			</div>
		</div>
		<div>
			<div class="employeePwCheck" valign=top>* 비밀번호 확인</div>
			<div><input id="employeePwCheckInput" type="password" maxlength="16"
				required="required"
				placeholder="&nbsp;&nbsp;&nbsp;비밀번호를 한번 더 입력해주세요." />
				<!-- <p class="employeePwCheckGuide">동일한 비밀번호를 입력해주세요.</p> --></div>
		</div>
		<div>
			<div class="employeeName" valign=top>* 이름 </div>
			<div><input id="employeeNameInput" name="employeeName" type="text" maxlength="10"
				required="required"
				placeholder="&nbsp;&nbsp;&nbsp;이름을 입력해주세요." /></div>
		</div>
		<div class="employeeBirthDiv">
			<div class="employeeBirth" valign=top>* 생년월일</div>
				<div class="employeeBirth11" name="employeeBirth">
					<input id="employeeBirthYear" name = "employeeBirthYear" type="text" size="4" maxlength="4" 
						placeholder="YYYY" pattern="[0-9]*" /> 
					<span>/</span> 								
					<input id="employeeBirthMonth" name = "employeeBirthMonth" type="text" size="2" maxlength="2"
						placeholder="MM" pattern="[0-9]*" />
					<span>/</span> 
					<input id="employeeBirthDay" name = "employeeBirthDay" type="text" size="2" maxlength="2"
						placeholder="DD" pattern="[0-9]*" />
				</div>
		</div>
		<div>
			<div class="employeeEmail" valign=top>* 이메일 </div>
			<div>
				<input type="text" id="employeeEmailInput" name ="employeeEmailInput1">
					 @
				<select id="employeeEmailOption"name = "employeeEmailInput2">
					<option value="@naver.com">naver.com</option>
					<option value="@gmail.com">gmail.com</option>
					<option value="@hanmail.net">hanmail.net</option>
					<option value="@nate.com">nate.com</option>
				</select>
			</div>
		</div>
			
		<div class="employeeGenderClass">
			<div class="employeeGender" name="employeeGender" valign=top>* 성별</div>
			<div class="employeeGenderAll" valign=top>
				<input type="radio" name="employeeGender" value="man" />남자&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="employeeGender" value="woman" />여자
			</div>
		</div>
		<div class="employeePhoneClass">
			<div class="employeePhone" valign=top>* 핸드폰 번호</div>
			<div class="employeePhoneNo" name="employeePhone">
					<input id="employeePhone010" type="text" size="4" value="010" name ="employeePhone1" readonly/>
					<span> - </span>
					<input id="employeePhoneFirst" type="text" size="4" maxlength="4" pattern="[0-9]*" name ="employeePhone2"/>
					<span> - </span> 	
					<input id="employeePhoneSecond" type="text" size="4" maxlength="4" pattern="[0-9]*" name ="employeePhone3"/>
			</div>
		</div>
		<div class="employeeAddressClass">
			<div class="employeeAddress" valign=top>* 주소 </div>
		</div>
		<input type="text" id="sample5_address" placeholder="주소" name = "employeeAddress">
		<input id="addressButton" type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
		<div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>
		<input type="hidden" id="latitude" placeholder="위도" name="latitude">
		<input type="hidden" id="longitude"
		 placeholder="경도" name="longitude">
		<input type="button" onclick="addrInsertClick()" value="주소 등록"><br>

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
    
    function addrInsertClick() {
        var location = document.getElementById('sample5_address').value;
        $.ajax({
           url : 'map/kakaoMap.go',
           type : 'get',
           dataType:'text',
           data: {
              "location" : location, 
           },
           success: function(data){
              console.log(data);
              data = JSON.parse(data);
              var latitude = data.documents[0].x;
              var longitude = data.documents[0].y;
	            document.getElementById("latitude").value = latitude;
	           	document.getElementById("longitude").value =longitude;
	           	
           },
           error : function(xhr, status, error){
              console.log('실패?')
              console.log(xhr);
              console.log(error);
           }      
        });   
     }
    
</script>

		<br> <input id="joinbutton" type="submit" value="회원가입" />
		</div>
	</form>
</div>
<footer></footer>
</body>
<jsp:include page="footer.html"></jsp:include>
</html>
