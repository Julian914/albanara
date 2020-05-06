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
<link rel="stylesheet" type="text/css" href="/Albanara/css/style.css">
<link rel="stylesheet" type="text/css" href="/Albanara/css/employerPage.css">

<script src="/Albanara/js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="/Albanara/js/jquery-ui.js" type="text/javascript"></script>
<script src="/Albanara/js/bootstrap.js" type="text/javascript"></script>



<jsp:include page="header.html" ></jsp:include>
<jsp:include page="nav.html" ></jsp:include>

<script>
	$(function() {
		$(".accordion").accordion({ 
			heightStyle : "content"
		});
	});
</script>



<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<header></header>
<nav></nav>

	<div class="container">
		<h3>현재 진행중인 공고목록</h3>
		<div id="wrap">
			<div class="accordion recruitmentList">
				<!-- 전체공고목록 -->
				<c:forEach var="list" items="${recruitmentList}" varStatus="status">

					<div id="accordion-title">
						<ul class="recruitmentUp">
							<li>접수마감 : ${list.closingDate}</li>
							<li>공고제목 : ${list.recruitmentTitle}</li>
						</ul>
					</div>
					<div id="accordion-contents">
						<ul class="recruitmentDown">
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

						<!-- 지원하기 modal-->
						<button class="btn btn-default"
							data-target="#layerpop${status.index}" data-toggle="modal">지원하기</button>

						<br />
						<div class="modal fade" id="layerpop${status.index}">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">X</button>
										<h4 class="modal-title">이 공고에 지원하겠습니다!</h4>
									</div>
									<form action="insertApplication.do?seq=${list.recruitmentSeq}"
										method="post">
										<div class="modal-body">
											사장님의 질문
											<div id="requirementQuestion">
												<ul>
													<li>질문 1 : ${list.requirementQuestion1}</li>
													<li><input type="radio" name="answer1" value="1">Yes
														<input type="radio" name="answer1" value="0">No</li>
												</ul>
												<ul>
													<li>질문 2 : ${list.requirementQuestion2}</li>
													<li><input type="radio" name="answer2" value="1">Yes
														<input type="radio" name="answer2" value="0">No</li>
												</ul>
												<ul>
													<li>질문 3 : ${list.requirementQuestion3}</li>
													<li><input type="radio" name="answer3" value="1">Yes
														<input type="radio" name="answer3" value="0">No</li>
												</ul>
											</div>
										</div>
										<div class="modal-footer">
											<input type="submit" value="지원하기">

										</div>
									</form>
								</div>
							</div>
						</div>

					</div>
				</c:forEach>
			</div>
		</div>
	</div>


	
<footer></footer>

<jsp:include page="footer.html" ></jsp:include>

<script>
$(document).ready(function() {
    $("header").load("header.html")
    $("nav").load("nav.html")
    $("footer").load("footer.html")
 });
</script>

</body>
</html>