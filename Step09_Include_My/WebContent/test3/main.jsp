<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test3/main.jsp</title>
<%@include file="../include_files/css_loading.jsp" %>
</head>
<body>
<%--
	include 시킬 때는 현재 물리적 위치를 기준으로 상대경로로 설정해야한다.
 --%>
<%@include file="../include_files/header.jsp" %>
<div class="main">
	<h3>main 컨텐츠입니다.</h3>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci non excepturi quasi fugiat ipsam totam necessitatibus velit obcaecati dolores amet nisi optio officia tempore sunt soluta mollitia similique natus possimus.</p>
</div>
<%@include file="../include_files/footer.jsp" %>
</body>
</html>