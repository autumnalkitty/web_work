<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/showtime.jsp</title>
</head>
<body>
<%
	String showTime=(String)request.getAttribute("showTime");
%>
<h3>현재 시간입니다.</h3>
<p>현재 시간: <strong><%=showTime %></strong></p>
</body>
</html>