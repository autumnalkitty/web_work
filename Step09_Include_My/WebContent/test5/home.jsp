<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test5/home.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
<%
	request.setAttribute("thisPage", "home");
%>
<jsp:include page="navbar.jsp"/>
<div class="container">
	<h1>Home</h1>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad error quo tempora et ullam optio obcaecati quisquam magnam possimus culpa nesciunt accusantium aliquid blanditiis eaque nostrum quam facilis repudiandae. At.</p>
</div>
</body>
</html>