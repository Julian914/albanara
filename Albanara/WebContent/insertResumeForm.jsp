<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">

/* css�� */
</style>

</head>
<body>

	<div class="resume">
		<form action="insertResumeAction.do" method="get" enctype="multipart/form-data">
			<h3>�̷¼�</h3>
			<div>����</div>
			<input type="file" name="pictureFilename"><br>
			<div>�̷¼� ����</div>
			<input type="text" name="resumeTitle" value="�̷¼� ���� ���"><br>
			<div>�̷¼� ����</div>
			<textarea cols="100" rows="10" name="resumeContents"
				placeholder="�ڱ�Ұ�" style="overflow-x: hidden; overflow-y: auto"></textarea><br>
			<div>��� �ٹ� ����</div>
			<input type="text" name="desiredWorkingArea" value="��� �ٹ� ����"><br>
			<div>��������</div>
			<input type="text" name="favoriteField" value="���� ����"><br>
			<div>������ ������¥</div>
			<br>
			<br>

			<button type="button"
				onclick="location.href='' ">����ϱ�</button>
			<button type="button"
				onclick="location.href='' ">����ϱ�</button>
		</form>
	</div>


</body>
</html>