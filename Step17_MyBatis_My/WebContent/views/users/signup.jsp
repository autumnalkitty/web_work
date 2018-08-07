<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/users/signup.jsp</title>
</head>
<body>
<h3>회원가입 요청결과</h3>
<c:choose>
	<c:when test="${requestScope.isSuccess}">
		<p><strong>${requestScope.id}</strong> 회원님 가입됐습니다. </p>
		<a href="signinform.do">로그인 하기</a>
	</c:when>
	<c:otherwise>
		<p>가입 실패!</p>
		<a href="signupform.do">다시 가입하러 가기</a>
	</c:otherwise>
</c:choose>
</body>
</html>