<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천구직자 폼</title>
</head>
<body>
	<h3>추천 구직자</h3>
	<div id="container">
		<div class="recommendEmployee">
			<c:forEach var="recommendEmployeeList" items="${recommendEmployee}" varStatus="status">
					<div id = "recommendEmployee">
						이름 : ${recommendEmployeeList.employeeName}<br>
						거주지 : ${recommendEmployeeList.employeeAddress}<br>
					</div>
					<input type="button" 
					onclick="location.href='../member/searchResume.do?employerSeq=${recommendEmployeeList.employerSeq}'" 
					value="이력서보기">
				</div>			
			</c:forEach>
		</div>
	</div>	
</body>
</html>