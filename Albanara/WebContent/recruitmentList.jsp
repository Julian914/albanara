<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>�������� ����</h3>
		
	<c:forEach var ="list" items="${recruitmentList}">
	
	<ul class = "recruitmentTitle">
		<li>�������� : ${list.closingDate}</li>
	<%-- 	<li>${list.recruitmentTitle}</li> --%>
	</ul>
	
	<ul class = "recruitmentContents">	
		<li>����̸� : ${list.employerSeq.employerName}</li>
		<%-- <li>�� �ٹ��ð� : ${list.totalWorkingTime}</li> --%>
		<li>�������� : ${list.minAge}~${list.maxAge}</li>
		<li> �ñ� : ${list.wage}</li>
		<li>�ٹ��� �ּ� : ${list.workingPlaceAddress}</li>
	<%-- 	<li>$�ٹ����� : {list.startingWorkingDate}~${list.endingWorkingDate}</li> --%>
	</ul>
	</c:forEach>



</body>
</html>