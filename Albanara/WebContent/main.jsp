<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="images/favicon6.ico" type="images/x-icon"> 
<link rel="icon" href="images/favicon6.ico" type="image/x-icon">

<link rel="stylesheet" href="/Albanara/css/jquery-ui.css">
<link rel="stylesheet" href="/Albanara/css/bootstrap.css">
<link rel="stylesheet" href="/Albanara/css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css" href="/Albanara/css/style.css">
<link rel="stylesheet" type="text/css" href="/Albanara/css/main.css">


<script src="/Albanara/js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="/Albanara/js/jquery-ui.js" type="text/javascript"></script>
<script src="/Albanara/js/bootstrap.js" type="text/javascript"></script>


<title>Insert title here</title>
</head>
<body>
	<header></header>
	<nav></nav>
	
	<div class="container">
		<div class="mapRecommendation">
			<div id="map" style="width:300px;height:300px;margin-top:10px;"></div>
			
			<input type = "checkbox" name = "ablityCategory" value = "strength" >힘
			<input type = "checkbox" name = "ablityCategory" value = "patience">끈기
			<input type = "checkbox" name = "ablityCategory" value = "kindness">친절
			<input type = "checkbox" name = "ablityCategory" value = "intelligency">지능
			
				
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
			
			var positions = [];
			
			var strength = [];
			var strengthPositions = [];
			var strengthIndex;
			
			var kindness = [];
			var kindnessPositions = [];
			var kindnessIndex;
			
			var intelligency = [];
			var intelligencyPositions = [];
			var intelligencyIndex;
			
			var patience = [];
			var patiencePositions = [];
			var patienceIndex;
			
			$("input:checkbox").on("click", function(){
				if($(this).prop("checked")) {
					if($(this).val() === 'strength') {
						<c:forEach items="${list}" var="item">
							console.log('${item}')
							<c:if test="${item.recruitmentType eq 'strength'}">
								strengthPositions.push({
									content : "<div>${item.recruitmentTitle}</div><div>${item.recruitmentType}</div><div>${item.startingWorkingDate}~${item.endingWorkingDate}</div><div>${item.startingWorkingTime}:00~${item.endingWorkingTime}:00</div>" + 
									"<div>${item.wageType} ${item.wage}원</div>",
									latlng : new kakao.maps.LatLng(parseFloat("${item.longitude}"), parseFloat("${item.latitude}"))
								});	
							</c:if>
						</c:forEach>
						for (strengthIndex = 0; strengthIndex < strengthPositions.length; strengthIndex++) {
							// 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다  
							strength.push(
								// 마커를 생성합니다	
								new kakao.maps.Marker({
							        map: map, // 마커를 표시할 지도
							        position: strengthPositions[strengthIndex].latlng //마커의 위치
							    })
							);
							 
						    // 마커에 표시할 인포윈도우를 생성합니다 
						    var infowindow = new kakao.maps.InfoWindow({
						        content: strengthPositions[strengthIndex].content // 인포윈도우에 표시할 내용
						    });
						    
						    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
						    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
						    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
						    kakao.maps.event.addListener(strength[strengthIndex], 'mouseover', makeOverListener(map, strength[strengthIndex], infowindow));
						    kakao.maps.event.addListener(strength[strengthIndex], 'mouseout', makeOutListener(infowindow));
						}
						
					} else if($(this).val() === 'kindness') {
						<c:forEach items="${list}" var="item">
							console.log('${item}')
							<c:if test="${item.recruitmentType eq 'kindness'}">
								kindnessPositions.push({
									content : "<div>${item.recruitmentTitle}</div><div>${item.recruitmentType}</div><div>${item.startingWorkingDate}~${item.endingWorkingDate}</div><div>${item.startingWorkingTime}:00~${item.endingWorkingTime}:00</div>" + 
									"<div>${item.wageType} ${item.wage}원</div>",
									latlng : new kakao.maps.LatLng(parseFloat("${item.longitude}"), parseFloat("${item.latitude}"))
								});	
							</c:if>
						</c:forEach>
						for (kindnessIndex = 0; kindnessIndex < kindnessPositions.length; kindnessIndex++) {
							kindness.push(
								new kakao.maps.Marker({
							        map: map, 
							        position: kindnessPositions[kindnessIndex].latlng 
							    })
							);
				
						    var infowindow = new kakao.maps.InfoWindow({
						        content: kindnessPositions[kindnessIndex].content 
						    });
						    
				
						    kakao.maps.event.addListener(kindness[kindnessIndex], 'mouseover', makeOverListener(map, kindness[kindnessIndex], infowindow));
						    kakao.maps.event.addListener(kindness[kindnessIndex], 'mouseout', makeOutListener(infowindow));
						}
					} else if($(this).val() === 'intelligency') {
						<c:forEach items="${list}" var="item">
							console.log('${item}')
							<c:if test="${item.recruitmentType eq 'intelligency'}">
								intelligencyPositions.push({
									content : "<div>${item.recruitmentTitle}</div><div>${item.recruitmentType}</div><div>${item.startingWorkingDate}~${item.endingWorkingDate}</div><div>${item.startingWorkingTime}:00~${item.endingWorkingTime}:00</div>" + 
									"<div>${item.wageType} ${item.wage}원</div>",
									latlng : new kakao.maps.LatLng(parseFloat("${item.longitude}"), parseFloat("${item.latitude}"))
								});	
							</c:if>
						</c:forEach>
						for (intelligencyIndex = 0; intelligencyIndex < intelligencyPositions.length; intelligencyIndex++) {
							intelligency.push(
								new kakao.maps.Marker({
							        map: map, 
							        position: intelligencyPositions[intelligencyIndex].latlng 
							    })
							);
				
						    var infowindow = new kakao.maps.InfoWindow({
						        content: intelligencyPositions[intelligencyIndex].content 
						    });
						    
				
						    kakao.maps.event.addListener(intelligency[intelligencyIndex], 'mouseover', makeOverListener(map, intelligency[intelligencyIndex], infowindow));
						    kakao.maps.event.addListener(intelligency[intelligencyIndex], 'mouseout', makeOutListener(infowindow));
						}
						} else if($(this).val() === 'patience') {
							<c:forEach items="${list}" var="item">
							console.log('${item}')
							<c:if test="${item.recruitmentType eq 'patience'}">
								patiencePositions.push({
									content : "<div>${item.recruitmentTitle}</div><div>${item.recruitmentType}</div><div>${item.startingWorkingDate}~${item.endingWorkingDate}</div><div>${item.startingWorkingTime}:00~${item.endingWorkingTime}:00</div>" + 
									"<div>${item.wageType} ${item.wage}원</div>",
									latlng : new kakao.maps.LatLng(parseFloat("${item.longitude}"), parseFloat("${item.latitude}"))
								});	
							</c:if>
						</c:forEach>
						for (patienceIndex = 0; patienceIndex < patiencePositions.length; patienceIndex++) {
							patience.push(
								new kakao.maps.Marker({
							        map: map, 
							        position: patiencePositions[patienceIndex].latlng 
							    })
							);
				
						    var infowindow = new kakao.maps.InfoWindow({
						        content: patiencePositions[patienceIndex].content 
						    });
						    
				
						    kakao.maps.event.addListener(patience[patienceIndex], 'mouseover', makeOverListener(map, patience[patienceIndex], infowindow));
						    kakao.maps.event.addListener(patience[patienceIndex], 'mouseout', makeOutListener(infowindow));
						}
					}
						    
				}else {
					if($(this).val() === 'strength') {
						for(var i = 0; i < strength.length; i++)
							strength[i].setMap(null);
						
						strength = [];
						strengthIndex = 0;
					} else if($(this).val() === 'kindness') {
						for(var i = 0; i < kindness.length; i++)
							kindness[i].setMap(null);
						
						kindness= [];
						kindnessIndex = 0;
					} else if($(this).val() === 'intelligency') {
						for(var i = 0; i < intelligency.length; i++)
							intelligency[i].setMap(null);
						
						intelligency= [];
						intelligencyIndex = 0;
					} else if($(this).val() === 'patience') {
						for(var i = 0; i < patience.length; i++)
							patience[i].setMap(null);
						
						patience= [];
						patienceIndex = 0;
					}
					
				}
				}); 
			
			
			
			// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
			function makeOverListener(map, marker, infowindow) {
			    return function() {
			        infowindow.open(map, marker);
			    };
			}
			
			// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
			function makeOutListener(infowindow) {
			    return function() {
			        infowindow.close();
			    };
			}
			
			</script>
		</div>
        <div class="login_container">
        	<form id="login_form">
        		<div class="btn-group btn-group-toggle" data-toggle="buttons">
					<label class="btn radio_btn">
						<input type="radio" name="login" id="employee" required="required"> 개인회원
					</label>
					<label class="btn radio_btn">
						<input type="radio" name="login" id="employer" required="required"> 기업회원
					</label>
					
				</div>
				<br>
				<div class="loginIdPassSumbmit">
					<div class="idPass">
	                    <input id="logInId" name="logInId" type="text" maxlength="16" placeholder="아이디" required="required"><br>
	                    <input id="logInPw" name="logInPw" type="password" maxlength="16" placeholder="비밀번호" required="required"><br>
	                </div>
	                <div class="submitBtn">
	                    <input type="submit" value="로그인">
	                </div>
                </div>
                
                <div class="">
                	<input type="button" value="기업회원가입">
                	<input type="button" value="">
                </div>
        	</form>
        </div>
    </div>
	<footer></footer>
<script>
$(document).ready(function() {
    $("header").load("header.html")
    $("nav").load("nav.html")
    $("footer").load("footer.html")
 });
</script>
</body>
</html>