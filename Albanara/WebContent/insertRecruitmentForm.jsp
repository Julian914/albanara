<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
</style>
<link rel="stylesheet" href="Albanara/css/jquery-ui.css">
<link rel="stylesheet" href="Albanara/css/bootstrap.css">
<link rel="stylesheet" href="Albanara/css/bootstrap-theme.css">
<script src="Albanara/js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="Albanara/js/jquery-ui.js" type="text/javascript"></script>
<script src="Albanara/js/bootstrap.js" type="text/javascript"></script>
<script>
	$(function() {
		$(".datepicker").datepicker();
	});
</script>
<title>공고 등록</title>
</head>
<body>
	<div class="container">
		<h1>모집 공고</h1>
		<form action="insertRecruitmentAction.do" method="post">
			<div>모집 공고</div>
			<div>
				<input type="text" name="recruitmentTitle">
			</div>
			<div>분류</div>
			<input type="radio" id="strength" name="recruitmentType"
				value="strength"> <label for="strength">힘</label> <input
				type="radio" id="intelligence" name="recruitmentType"
				value="inteligence"> <label for="inteligence">지능</label> <input
				type="radio" id="kindness" name="recruitmentType" value="kindness">
			<label for="kindness">친절</label> <input type="radio" id="patience"
				name="recruitmentType" value="patience"> <label
				for="patience">끈기</label>
			<div>모집 인원</div>
			<div>
				<input type="number" name="recruitmentSize">
			</div>
			<div>근무 시작일</div>
			<input type="date" name="startingWorkingDate">
			<div>근무 종료일</div>
			<input type="date" name="endingWorkingDate">
			<div>총 근무일수</div>
			<input type="number" name="totalWorkingDay">
			<div>근무 시간</div>
			<div>시작 시간</div>
			<input type="number" name="startingWorkingTime">
			<div>종료 시간</div>
			<input type="number" name="endingWorkingTime">
			<div>총 시간</div>
			<input type="number" name="totalWorkingTime">
			<div>급여</div>
			<select id="wageType" name="wageType">
				<option value="hourlyWage" selected>시급</option>
				<option value="dailyWage">일급</option>
			</select> <input type="number" name="wage">
			<div>성별</div>
			<input type="radio" id="other" name="gender" value="other"> <label
				for="other">성별무관</label> <input type="radio" id="male" name="gender"
				value="male"> <label for="male">남자</label> <input
				type="radio" id="female" name="gender" value="female"> <label
				for="female">여자</label>
			<div>연령</div>
			<input type="radio" id="other" name="age" value="other"> <label
				for="other">연령무관</label> <input type="radio" id="age" name="age"
				value="age"> <label for="age">연령제한 있음</label> <input
				type="number" name="minAge">세 이상 <input type="number"
				name="maxAge">세 이하
			<div>우대 조건</div>
			<input type="text" name="requirementQuestion1"> <input
				type="text" name="requirementQuestion2"> <input type="text"
				name="requirementQuestion3">
			<div>모집 종료일</div>
			<input type="date" name="closingDate">
			<div>상세 정보</div>
			<textarea id="recruitmentContents" rows="4" cols="50">
		</textarea>
			<div>근무지 주소</div>
			<br> <input type="reset" value="초기화"><input
				type="submit" value="등록">
		</form>
	</div>
</body>
</html>