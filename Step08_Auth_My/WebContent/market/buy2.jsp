<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/market/buy2.jsp</title>
</head>
<body>
<%
	String id=(String)session.getAttribute("id");
	if(id==null) {
		String cPath=request.getContextPath();
		response.sendRedirect(cPath+"/users/signinform.jsp");
	}
%>
<h3>상품 구입 페이지입니다.</h3>
<a href="">구입하기</a>
</body>
</html>