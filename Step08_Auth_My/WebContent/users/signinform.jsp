<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/signinform.jsp</title>
</head>
<body>
<%
	String url=request.getParameter("url");
	if(url==null) {
		url=request.getContextPath()+"/index.jsp";
	}
%>
<h3>로그인 폼입니다.</h3>
<form action="signin.jsp?url=<%=url %>" method="post">
	<label for="id">아이디</label>
	<input type="text" name="id" id="id" /><br />
	<label for="pwd">비밀번호</label>
	<input type="password" name="pwd" id="pwd"/><br />
	<button type="submit">로그인</button>
</form>
</body>
</html>