<%@page import="kosta.albanara.model.Employers"%>
<%@page import="kosta.albanara.dao.EmployerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Albanara/css/jquery-ui.css">
<link rel="stylesheet" href="Albanara/css/bootstrap.css">
<link rel="stylesheet" href="Albanara/css/bootstrap-theme.css">
<link rel="stylesheet" href="/Albanara/css/Chart.css">
<script src="/Albanara/js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="/Albanara/js/jquery-ui.js" type="text/javascript"></script>
<script src="/Albanara/js/bootstrap.js" type="text/javascript"></script>
<script src="/Albanara/js/Chart.js" type="text/javascript"></script>
<script src="/Albanara/js/Chart.bundle.js" type="text/javascript"></script>
</head>
<body>
	<h1>기업 마이페이지</h1>
	기업명 : ${employer.employerName} <br>
	기업주소 : ${employer.employerAddress } <br>
	기업홈페이지 주소 : ${employer.employerHomePage} <br>
	
	<c:if test="${employer.employerId==login.employerId }">
	<input type="button" value="정보수정" onclick="location.href='session/UpdateEmployersForm.do?id=${login.employerId}'"/>
	</c:if>
	<canvas id="employerGender" width="800"></canvas>
<script>
var employerGender = $('#employerGender');
var myDoughnutChart = new Chart(employerGender, {
    type: 'pie',
    data: {
        labels: ['Red', 'Blue'],
        datasets: [{
            label: '지원자 성별 현황',
            data: [${woman}, ${man}],
            backgroundColor: [
            	'rgba(255, 99, 132, 0.2)',
            	'rgba(54, 162, 235, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {}
});
</script>
</body>
</html>