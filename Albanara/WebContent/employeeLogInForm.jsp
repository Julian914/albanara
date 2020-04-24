<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<form action="employeeLogIn.do" method="post" id="employeeLogInForm">
		<h2>구직자 로그인</h2>
		<label>ID: </label>
        <input id="employeeLogInId" name="employeeLogInId" type="text" maxlength="16" required="required"><br>
        <label>PW: </label>
        <input id="employeeLogInPw" name="employeeLogInPw" type="password" maxlength="16" required="required"><br>
        <input type="submit" value="로그인">
	</form>
</div>
</body>
</html>