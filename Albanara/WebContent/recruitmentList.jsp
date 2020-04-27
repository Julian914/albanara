<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/Albanara/css/jquery-ui.css">
<link rel="stylesheet" href="/Albanara/css/bootstrap.css">
<link rel="stylesheet" href="/Albanara/css/bootstrap-theme.css">
<script src="/Albanara/js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="/Albanara/js/jquery-ui.js" type="text/javascript"></script>
<script src="/Albanara/js/bootstrap.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		$('.accordion').accordion();
		$('#accordion').accordion();
	});
</script>

<style type="text/css">
.application {
	color: black;
}
.accordion .child
{
	height: 200px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>진행중인 공고</h3>
	<div id="wrap">
		<div class="accordion recruitmentList">
			<c:forEach var="list" items="${recruitmentList}" varStatus="status">
				<div id="accordion-title">
					<ul class="recruitmentUp">
						<li>접수마감 : ${list.closingDate}</li>
						<li>공고제목 : ${list.recruitmentTitle}</li>
					</ul>
				</div>
				<div id="accordion-contents">
					<ul class="recruitmentDown">
						<li>기업이름 : ${list.employerSeq} 이름 들어올 예정</li>
						<li>총 근무시간 : ${list.totalWorkingTime} 시간</li>
						<li>연령제한 : ${list.minAge} 세 ~${list.maxAge} 세</li>
						<li>시급 : ${list.wage} 원</li>
						<li>근무지 주소 : ${list.workingPlaceAddress}</li>
						<li>근무일자 :<fmt:parseDate var="startdate"
								value="${list.startingWorkingDate}" pattern="yyyy-MM-dd" /> <fmt:formatDate
								value="${startdate}" pattern="yyyy.MM.dd" /> ~<fmt:parseDate
								var="enddate" value="${list.endingWorkingDate}"
								pattern="yyyy-MM-dd" /> <fmt:formatDate value="${enddate}"
								pattern="yyyy.MM.dd" /></li>
					</ul>
					<!-- 지원하기 modal -->
					<button class="btn btn-default" data-target="#layerpop"
						data-toggle="modal">지원하기</button>

					<br />
					<div class="modal fade" id="layerpop">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">

									<button type="button" class="close" data-dismiss="modal">X</button>
									<h4 class="modal-title">이 공고에 지원하겠습니다!</h4>
								</div>
								<div class="modal-body">
									<input type="hidden" name="seq" value="${list.recruitmentSeq}">
									사장님의 질문
									<div id="requirementQuestion">
										<ul>
											<li>질문 1: ${list.requirementQuestion1}</li>
											<li><input type="radio" name="boolaen1" value="Yes">Yes</li>
											<li><input type="radio" name="boolaen1" value="No">No</li>
										</ul>
										<ul>
											<li>질문 2: ${list.requirementQuestion2}</li>
											<li><input type="radio" name="boolaen2" value="Yes">Yes</li>
											<li><input type="radio" name="boolaen2" value="No">No</li>
										</ul>
										<ul>
											<li>질문 3: ${list.requirementQuestion3}</li>
											<li><input type="radio" name="boolaen3" value="Yes">Yes</li>
											<li><input type="radio" name="boolaen3" value="No">No</li>
										</ul>
									</div>
								</div>
								
								<div class="modal-footer">
									<button a href="insertApplication.do?seq=${list.recruitmentSeq}" type="submit">지원완료</a></button>
								</div>
							</div>
						</div>
					</div>

					<div class="accordion employeesList">
						<!-- index: ${status.index} -->

						<c:forEach var="employeeListMap" items="${employeeListMapList}">
						<!--//for:${employeeListMap.key }, ${status.index }-->
					
						<c:if test="${status.index eq employeeListMap.key}">
						<!--if : ${employeeListMap.employeeList}-->
						
							<c:forEach var="employeeList" items="${employeeListMap.employeeList}">
									<div class="accordion-title2">
										<ul class="recruitmentUp2">
											<li>지원자 ${employeeList.employeeSeq}</li>
										</ul>
									</div>
									<div class="accordion-contents2 child">
										<ul class="recruitmentDown2">
											<li>이름 : ${employeeList.employeeName}</li>
											<li>생년월일 :${employeeList.employeeBirthday}</li>
											<li>성별 : ${employeeList.employeeGender}</li>
											<li>주소 : ${employeeList.employeeAddress}</li>
											<li>번호 : ${employeeList.employeePhone}</li>
										</ul>
									</div>
								</c:forEach>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>