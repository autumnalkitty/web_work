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
<%-- 
	navbar.jsp 페이지를 include 하고 	thisPage 라는 파라미터명으로
	home 이라는 파라미터값을 전달할 수 있다.
 --%>
<jsp:include page="navbar.jsp">
	<jsp:param value="home" name="thisPage"/>
</jsp:include>
<div class="container">
	<h1>Home</h1>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad error quo tempora et ullam optio obcaecati quisquam magnam possimus culpa nesciunt accusantium aliquid blanditiis eaque nostrum quam facilis repudiandae. At.</p>
</div>
</body>
</html>