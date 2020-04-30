<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기업로그인폼</title>
</head>
<body>
<div class="container">
	<form action="employerLogIn.do" method="post" id="employerLogInForm">
		<h2>기업 로그인</h2>
		<label>ID: </label>
        <input id="employerLogInId" name="employerLogInId" type="text" maxlength="16" required="required"><br>
        <label>PW: </label>
        <input id="employerLogInPw" name="employerLogInPw" type="password" maxlength="16" required="required"><br>

        <input type="submit" value="로그인">
	</form>
</div>
</body>
</html>