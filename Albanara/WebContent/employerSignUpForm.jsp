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
</head>
<body>
<div class="container">
	<form action="insertEmployers.do" id="employerSignUp" method="post">
		<h1>기업 회원가입 </h1>
		<div>
			<div class="employerId" valign=top>* 아이디 </div>
			<div><input id="employerIdInput" name="employerId" type="text" maxlength="16"
				required="required" placeholder="&nbsp;&nbsp;&nbsp;아이디를 입력해주세요." />
						
				<p class="employerIdGuide">6자 이상의 영문 혹은 영문과 숫자를 조합</p>
				<p class="employerIdCheck">이미 있는 아이디 입니다.</p></div>
		</div>
		<div>
			<div class="employerPw" valign=top>* 비밀번호 </div>
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
				required="required"
				placeholder="&nbsp;&nbsp;&nbsp;기업명을 입력해주세요." /></div>
		</div>
		<div>
			<div class="employerNumber" valign=top>*사업자 번호</div>
			<div valign=top>
				<div class="employerNo">
					<input id="employerNoFirst" type="text" size="4" maxlength="4" pattern="[0-9]*" name="employerNo1" />
					<span> - </span> 	
					<input id="employerNoSecond" type="text" size="4" maxlength="4" pattern="[0-9]*" name="employerNo2"/>
					<span> - </span> 	
					<input id="employerNothird" type="text" size="4" maxlength="4" pattern="[0-9]*" name="employerNo3"/>
				</div>
			</div>
		</div>
		<div class="employeeAddressClass">
			<div class="employeeAddress" valign=top>* 사업장 주소 </div>
		</div>
		<div>
			<input type="text" id="sample5_address" placeholder="주소" name = "employeeAddress">
			<input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
			<div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>
			<input type="hidden" id="latitude" placeholder="위도" name="latitude">
			<input type="hidden" id="longitude" placeholder="경도" name="longitude">
			<input type="button" onclick="addrInsertClick()" value="주소 등록"><br>
			<input type="button" onclick="test()" value="ㅎㅎ"><br>
		</div>
		<div>
			<div class="employerField" valign=top>* 사업장 분야</div>
			<div>
			 	<select id="fields" name="employerField">
					<option value="매장관리">매장관리</option>
					<option value="IT 디자인">IT 디자인</option>
					<option value="서비스">서비스</option>
					<option value="생산/기능.운전">생산/기능.운전</option>
					<option value="고객상담/리서치">고객상담/리서치</option>
					<option value="서빙.주방">서빙.주방</option>
				</select><br><br>
			</div>
		</div>
		<div>
			<div class="employerHomePage" valign=top>* 홈페이지</div>
			<div><input id="employerHomePageInput" type="text" name="employerHomePage"/></div>
		</div>
		<div>
			<div class="ownerName" valign=top>* 대표자 이름</div>
			<div><input id="ownerNameInput" type="text" name="ownerName"/></div>
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
<script>
	var latitude = '';
	var longitude = '';
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
	function test(){
    	function calcDistance(lat1, lon1, lat2, lon2){
			var EARTH_R, Rad, radLat1, radLat2, radDist; 
            var distance, ret;
	            EARTH_R = 6371000.0;
	            Rad = Math.PI/180;
	            radLat1 = Rad * parseFloat(lat1);
	            radLat2 = Rad * parseFloat(lat2);
	            radDist = Rad * (parseFloat(lon1) - parseFloat(lon2));            
	            distance = Math.sin(radLat1) * Math.sin(radLat2);
	            distance = distance + Math.cos(radLat1) * Math.cos(radLat2) * Math.cos(radDist);
	            ret = EARTH_R * Math.acos(distance);						
            var rtn = Math.round(Math.round(ret) / 1000);
           	if(rtn <= 0){
           		rtn = Math.round(ret) + " m";
           	}else{
           		rtn = rtn + " km";
           	}
            return  rtn;
        } 
        //document.getElementById("latitude").value
        //document.getElementById("longitude").value
		console.log("거리 : "+ calcDistance(127.005476, 37.537187, latitude, longitude));
	}
    
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
	    	         data = JSON.parse(data);
	    	         latitude = data.documents[0].x;
	    	         longitude = data.documents[0].y;
	     			document.getElementById("latitude").value = latitude;
	    			document.getElementById("longitude").value = longitude;
	    	      },
	    	      error : function(xhr, status, error){
	    	         console.log('실패?')
	    	         console.log(xhr);
	    	         console.log(error);
	    	      }      
	    	   });   
    	}
</script>		
		<br><input type="submit" value="회원가입"/>
	</form>
</div>

</body>
</html>