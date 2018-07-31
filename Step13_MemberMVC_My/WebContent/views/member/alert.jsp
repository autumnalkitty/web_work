<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/member/alert.jsp</title>
</head>
<body>
<%
	String msg=(String)request.getAttribute("msg");
	String url=(String)request.getAttribute("url");
	String cPath=request.getContextPath();
%>
<h3>알림 페이지</h3>
<p><%=msg %></p>
<a href="<%=cPath %><%=url %>">확인</a>
</body>
</html>