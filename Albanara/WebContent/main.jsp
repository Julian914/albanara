<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="images/favicon6.ico" type="images/x-icon"> 
<link rel="icon" href="images/favicon6.ico" type="image/x-icon">

<link rel="stylesheet" type="text/css" href="/Albanara/css/header.css">
<link rel="stylesheet" type="text/css" href="/Albanara/css/nav.css">
<link rel="stylesheet" type="text/css" href="/Albanara/css/footer.css">
<link rel="stylesheet" type="text/css" href="/Albanara/css/main.css">
<link rel="stylesheet" href="/Albanara/css/jquery-ui.css">
<link rel="stylesheet" href="/Albanara/css/bootstrap.css">
<link rel="stylesheet" href="/Albanara/css/bootstrap-theme.css">

<script src="/Albanara/js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="/Albanara/js/jquery-ui.js" type="text/javascript"></script>
<script src="/Albanara/js/bootstrap.js" type="text/javascript"></script>


<title>Insert title here</title>
</head>
<body>
	<header></header>
	<nav></nav>
	
	<div class="container">
        <div class="login_container">
        	<form id="login_form">
        		<div class="btn-group btn-group-toggle" data-toggle="buttons">
					<label class="btn radio_btn">
						<input type="radio" name="login" id="employee" required="required"> 개인회원
					</label>
					<label class="btn radio_btn">
						<input type="radio" name="login" id="employer" required="required"> 기업회원
					</label>
					
				</div>
				<br>
				<div class="loginIdPassSumbmit">
					<div class="idPass">
	                    <input id="logInId" name="logInId" type="text" maxlength="16" placeholder="아이디" required="required"><br>
	                    <input id="logInPw" name="logInPw" type="password" maxlength="16" placeholder="비밀번호" required="required"><br>
	                </div>
	                <div class="submitBtn">
	                    <input type="submit" value="로그인">
	                </div>
                </div>
        	</form>
        </div>
    </div>
	<footer></footer>
<script>
$(document).ready(function() {
    $("header").load("header.html")
    $("nav").load("nav.html")
    $("footer").load("footer.html")
 });
</script>
</body>
</html>