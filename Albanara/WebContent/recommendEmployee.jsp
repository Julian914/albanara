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
	<div id="wrap">
		<div class="recommendEmployee">
			<c:forEach var="recommendEmployeeList" items="${recommendEmployee}" varStatus="status">
				<div id="accordion-title">
					<ul class="recruitmentUp">
						<li>이름 : ${recommendEmployeeList.employeeName}</li>
						<li>거주지 : ${recommendEmployeeList.employeeAddress}</li>
					</ul>
				</div>			
			</c:forEach>
		</div>
	</div>	
</body>
</html>