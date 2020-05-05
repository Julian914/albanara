<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String id = null;

    if (session.getAttribute("id") != null) {
      id = URLDecoder.decode((String)session.getAttribute("id"), "UTF-8");
   } 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- seq 는 수시로 바뀌기에 테스트해볼때만 바꾸시고 항상 체크해주세요-준상- -->
<a href="member/showEmployee.do?seq=21">구직자 마이페이지 이동</a><br> 
<a href="recruitment/insertRecruitmentForm.do">공고 등록 페이지 이동</a><br>
<a href="recruitment/updateRecruitmentForm.do?seq=24">공고(1) 수정 페이지 이동</a><br>
<a href="recruitment/deleteRecruitmentAction.do?seq=24">공고(10) 삭제 페이지 이동</a><br>
<a href="recruitment/showRecruitmentAction.do?seq=23">공고(1) 상세 페이지 이동</a><br>
<a href="recruitment/recruitmentList.do">공고목록으로 이동</a><br>
<a href="member/employeeSignUpForm.do">구직자 회원가입 페이지 이동</a><br>
<a href="member/employerSignUpForm.do">기업 회원가입 페이지 이동</a><br>
<a href="member/employerLogInForm.do">기업 로그인 페이지 이동</a><br>
<a href="member/employeeLogInForm.do">구직자 로그인 페이지 이동</a><br>
<a href="session/UpdateEmployeesForm.do">구직자 수정페이지 이동</a><br>
<a href="session/UpdateEmployersForm.do">기업 수정페이지 이동</a><br>
<a href="member/detailEmployers.do?seq=1">기업 상세페이지 이동(기업)</a><br>
<a href="member/showEmployersPage.do?seq=24">기업 상세페이지 이동(구직자)</a><br>
<a href="session/logOut.do">로그아웃</a><br>
<b><%=id%></b>님 반갑습니다.





</body>
</html>