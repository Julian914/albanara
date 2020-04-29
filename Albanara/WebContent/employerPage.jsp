<%@page import="kosta.albanara.model.Employers"%>
<%@page import="kosta.albanara.dao.EmployerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>기업 마이페이지</h1>
	기업명 : ${employer.employerName} <br>
	기업주소 : ${employer.employerAddress } <br>
	기업홈페이지 주소 : ${employer.employerHomePage} <br>
</body>
</html>