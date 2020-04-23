<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
</head>
<body>
<form>
	주소<input type ="text" name ="location" value="" id ="addr">
	<input type ="submit" value ="전송" onclick ="Click()">
</form>

<script type="text/javascript">

function Click() {
	var location = $("#addr").val();
	$.ajax({
		url : 'map/kakaoMap.go',
		type : 'post',
		dataType:'text',
		data: {
			"location" : location, 
		},
		success: function(data){
			console.log(data);
		},
		error : function(xhr, status, error){
			console.log('실패?')
			console.log(xhr);
			console.log(error);
		}		
	});	
}


</script>
</body>
</html>