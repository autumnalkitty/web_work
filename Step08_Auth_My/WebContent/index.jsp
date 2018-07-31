<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
<%
	String cPath=request.getContextPath();
	//session 에 "id" 라는 키값으로 담겨있는 문자열을 읽어온다.
	String id=(String)session.getAttribute("id");
	/*
		로그인된 상태면 id 에는 로그인한 회원의 id 가 들어있고
		로그인이 안 된 상태면 id 에는 null 이 들어있다.
	*/

%>
<h3>인덱스 페이지입니다.</h3>
<%if(id!=null) { %>
	<p><strong><a href="users/private/info.jsp"><%=id %></a></strong>님 로그인 중…</p>
	<a href="users/signout.jsp">로그아웃</a>
<%} %>
<ul>
	<li><a href="users/signupform.jsp">회원가입</a></li>
	<li><a href="users/signinform.jsp?url=<%=cPath %>/">로그인</a></li>
	<li><a href="market/buy.jsp">상품 구입</a></li>
	<li><a href="market/buy2.jsp">상품 구입2</a></li>
	<li><a href="market/buy3.jsp">상품 구입3</a></li>
</ul>
</body>
</html>