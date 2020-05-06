<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<script src="/Albanara/js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="/Albanara/js/jquery-ui.js" type="text/javascript"></script>
<script src="/Albanara/js/bootstrap.js" type="text/javascript"></script>
<meta charset="UTF-8">
<title>추천구직자 폼</title>
</head>
<body>
	<h3>추천 구직자</h3>
	<div id="container">
		<div class="recommendEmployee">
			<c:forEach var ="recommendEmployeeList" items= "${recommendEmployee}">
				<div id = "recommendEmployee">
					이름 : ${recommendEmployeeList.employeeName}<br>
					거주지 : ${recommendEmployeeList.employeeAddress}<br>
				</div>
				<div>
					<input type="button" 
					onclick="location.href='../member/searchResume.do?employerSeq=${recommendEmployeeList.employeeSeq}'" 
					value="이력서보기">			
				</div>	
			</c:forEach>
		</div>
	</div>	
</body>
</html>