<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/ajax/signout.jsp</title>
</head>
<body>
<%
	session.invalidate();
%>
<p>로그아웃 됐습니다.</p>
<a href="signinform.jsp">확인</a>
</body>
</html>