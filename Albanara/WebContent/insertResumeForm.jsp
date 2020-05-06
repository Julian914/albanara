<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/Albanara/css/jquery-ui.css">
<link rel="stylesheet" href="/Albanara/css/bootstrap.css">
<link rel="stylesheet" href="/Albanara/css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css" href="/Albanara/css/style.css">
<script src="/Albanara/js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="/Albanara/js/jquery-ui.js" type="text/javascript"></script>
<script src="/Albanara/js/bootstrap.js" type="text/javascript"></script>

<title>Insert title here</title>
<style type="text/css">

/* css�� */
</style>

</head>
<body>

	<header></header>
	<nav></nav>


	<div class="container">
		<div class="page-header text-center">
			<h1>�̷¼�</h1>
			<h3>�Ʒ� ��Ŀ� �°� �ۼ����ֽø� �˴ϴ�.</h3>
		</div>


		<div class="row">
			<form action="insertResume.do" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<div>���� ÷��</div>
					<input type="file" name="pictureFilename">
				</div>
	
				<div class="form-group">
					<div>�̷¼� ����</div>
					<input type="text" name="resumeTitle" placeholder="�̷¼� ���� ���">	
				</div>
				
				<div class="form-group">
					<div>�̷¼� ����</div>
					<textarea cols="100" rows="10" name="resumeContents"
						placeholder="�ڱ�Ұ�" style="overflow-x: hidden; overflow-y: auto"></textarea>
				</div>
				
				<div class="form-group">
					<div>��� �ٹ� ����</div>
					<input type="text" name="desiredWorkingArea" placeholder="��� �ٹ� ����">		
				</div>
				
				<div class="form-group">
					<div>��������<br> 
						<input type="radio" name="favoriteField" value="��">��<br>
						<input type="radio" name="favoriteField" value="����">����<br>
						<input type="radio" name="favoriteField" value="����">����<br>
						<input type="radio" name="favoriteField" value="ģ��">ģ��<br>
					</div>
				</div>
				
				<div class="form-group">
					<input type="submit" value="���">
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

	<!-- 
		<form action="insertResume.do" method="post"
			enctype="multipart/form-data">
			<h3>�̷¼�</h3>
			<div>���� ÷��</div>
			<input type="file" name="pictureFilename"><br>
			<div>�̷¼� ����</div>
			<input type="text" name="resumeTitle" placeholder="�̷¼� ���� ���"><br>
			<div>�̷¼� ����</div>
			<textarea cols="100" rows="10" name="resumeContents"
				placeholder="�ڱ�Ұ�" style="overflow-x: hidden; overflow-y: auto"></textarea>
			<br>
			<div>��� �ٹ� ����</div>
			<input type="text" name="desiredWorkingArea" placeholder="��� �ٹ� ����"><br>
			<div>
				��������<br> <input type="radio" name="favoriteField" value="��">��<br>
				<input type="radio" name="favoriteField" value="����">����<br>
				<input type="radio" name="favoriteField" value="����">����<br>
				<input type="radio" name="favoriteField" value="ģ��">ģ��<br>
			</div>
			<br> <br> <input type="submit" value="���">
		</form>
		
	 -->
		
</body>
</html>