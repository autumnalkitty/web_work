<%@page import="test.users.dao.UsersDao"%>
<%@page import="test.users.dto.UsersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/signin.jsp</title>
</head>
<body>
<%
	String url=request.getParameter("url");
%>
<%
	//폼 전송되는 로그인 정보를 추출해서
	request.setCharacterEncoding("utf-8");
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	//DB 의 정보와 일치하는지 확인해서
	UsersDto dto=new UsersDto();
	dto.setId(id);
	dto.setPwd(pwd);
	boolean isSigninSuccess=UsersDao.getInstance().isValid(dto);
	//유효하면 로그인 처리 및 응답, 무효하면 아이디 혹은 비밀번호가 잘못됐다고 응답
%>
<%if(isSigninSuccess) { 
	//세션에 id 담기
	session.setAttribute("id", id); %>
	<p><strong><%=id %></strong>님 로그인 됐습니다.</p>
	<a href="<%=url %>">확인</a>
<%} else { %>
	<p>아이디 혹은 비밀번호가 틀렸습니다.</p>
	<a href="signinform.jsp?url=<%=url %>">확인</a>
<%} %>
</body>
</html>