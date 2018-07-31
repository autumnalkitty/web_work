<%@page import="java.util.List"%>
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
<h3>Home 페이지입니다.</h3>
<ul>
	<li><a href="member/list.do">회원목록 보기</a></li>
</ul>
<h3>오늘의 공지사항</h3>
<ul>
	<c:forEach var="tmp" items="${msgs}">
		<li>${tmp}</li>
	</c:forEach>
</ul>
</body>
</html>