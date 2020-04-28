<%@page import="kosta.albanara.model.HyunMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here </title>
</head>
<body>
	
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

var latitude = '';
var longitude = '';

var positions = [];
var category = [];
var list = new Array();
<c:forEach items="${list}" var="item">
	console.log('${list}')
	latitude = ${item.latitude}
	longitude = ${item.longitude}
	positions.push({
		content : "<div>${item.recruitmentTitle}</div><div>${item.recruitmentType}</div><div>${item.startingWorkingDate}~${item.endingWorkingDate}</div><div>${item.startingWorkingTime}:00~${item.endingWorkingTime}:00</div>" + 
		"<div>${item.wageType} ${item.wage}원</div>",
		latlng : new kakao.maps.LatLng(parseFloat("${item.longitude}"), parseFloat("${item.latitude}"))
	});
	category.push({
		type : '${item.recruitmentType}'
	});	
</c:forEach>


$("input:checkbox").on("click", function(){
	if ($(this).prop("checked")) {
		for (var i = 0; i < positions.length; i++) {
			if($(this).val() === category[i].type) {					
			    var marker = new kakao.maps.Marker({
			        map: map, 
			        position: positions[i].latlng 
			    });

			    var infowindow = new kakao.maps.InfoWindow({
			        content: positions[i].content 
			    });

			    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
			    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
			}  
		}
	}else {
		marker.setMap(null);
	}
	}); 
console.log(positions);

// 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다  




/* for (var i = 0; i < positions.length; i ++) {
    // 마커를 생성합니다	
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng  //마커의 위치
    });
    // 마커에 표시할 인포윈도우를 생성합니다 
    var infowindow = new kakao.maps.InfoWindow({
        content: positions[i].content // 인포윈도우에 표시할 내용
    });
    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
} */

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

//마커가 지도 위에 표시되도록 설정합니다
//marker.setMap(map);

/* 아래와 같이도 할 수 있습니다 */
/*
for (var i = 0; i < positions.length; i ++) {
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng // 마커의 위치
    });

    // 마커에 표시할 인포윈도우를 생성합니다 
    var infowindow = new kakao.maps.InfoWindow({
        content: positions[i].content // 인포윈도우에 표시할 내용
    });

    // 마커에 이벤트를 등록하는 함수 만들고 즉시 호출하여 클로저를 만듭니다
    // 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
    (function(marker, infowindow) {
        // 마커에 mouseover 이벤트를 등록하고 마우스 오버 시 인포윈도우를 표시합니다 
        kakao.maps.event.addListener(marker, 'mouseover', function() {
            infowindow.open(map, marker);
        });

        // 마커에 mouseout 이벤트를 등록하고 마우스 아웃 시 인포윈도우를 닫습니다
        kakao.maps.event.addListener(marker, 'mouseout', function() {
            infowindow.close();
        });
    })(marker, infowindow);
}
*/
</script>
</body>
</html>