<%@page import="test.users.dao.UsersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/private/delete.jsp</title>
</head>
<body>
<p><strong>${requestScope.id}</strong> 회원님 탈퇴 처리됐습니다.</p>
<a href="${pageContext.request.contextPath}/">인덱스로 이동</a>
</body>
</html>