<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div>구직자 이름</div>
	<div>${Employee.employeeName }</div>
	
	<div>구직자 주소</div>
	<div>${Employee.employeeAddress }</div>
	
	<div>성별</div>
	<div>${Employee.employeeGender }</div>
	
	<div>핸드폰</div>
	<div>${Employee.employeePhone }</div>
	
	<div>이메일</div>
	<div>${Employee.employeeEmail }</div>
	
	
	<button type="button" onclick="location.href='/index.jsp' ">확인하기</button>
	
	
	
</body>
</html>