<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
</head>
<body>
<h3>홈 페이지입니다.</h3>
<c:if test="${not empty sessionScope.id }">
	<p><strong><a href="users/private/info.do">${id}</a></strong>님 로그인 중</p>
	<a href="users/signout.do">로그아웃</a>
</c:if>
<ul>
	<li><a href="users/signupform.do">회원가입</a></li>
	<li><a href="users/signinform.do?url=${pageContext.request.contextPath}/">로그인</a></li>
</ul>
<h3>공지 사항 입니다.</h3>
<ul>
	<c:forEach var="tmp" items="${msgs }">
		<li>${tmp }</li>
	</c:forEach>
</ul>
</body>
</html>