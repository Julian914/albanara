<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

/* css�� */
</style>

</head>
<body>

		<form action="member/insertResume.do" method="post" enctype="multipart/form-data">
			<h3>�̷¼�</h3>
			<div>���� ÷��</div>
			<input type="file" name="pictureFilename"><br>
			<div>�̷¼� ����</div>
			<input type="text" name="resumeTitle" placeholder="�̷¼� ���� ���"><br>
			<div>�̷¼� ����</div>
			<textarea cols="100" rows="10" name="resumeContents"
				placeholder="�ڱ�Ұ�" style="overflow-x: hidden; overflow-y: auto"></textarea><br>
			<div>��� �ٹ� ����</div>
			<input type="text" name="desiredWorkingArea" placeholder="��� �ٹ� ����"><br>
			<div>��������</div>
			<input type="text" name="favoriteField" placeholder="���� ����"><br>
			<br>
			<br>

			<input type="submit" value="���">
		</form>

</body>
</html>