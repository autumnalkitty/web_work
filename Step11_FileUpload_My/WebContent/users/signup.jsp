<%@page import="test.users.dao.UsersDao"%>
<%@page import="test.users.dto.UsersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/signup.jsp</title>
</head>
<body>
<%
	//폼 전송되는 회원정보를 추출해서
	request.setCharacterEncoding("utf-8");
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	String email=request.getParameter("email");
	//DB 에 저장하고
	UsersDto dto=new UsersDto();
	dto.setId(id);
	dto.setPwd(pwd);
	dto.setEmail(email);
	boolean isSuccess=UsersDao.getInstance().insert(dto);
	//응답하기
%>
<h3>회원가입 요청결과</h3>
<%if(isSuccess) {%>
	<p><strong><%=id %></strong>회원님 가입되었습니다.</p>
	<a href="signinform.jsp">로그인 하기</a>
<%} else { %>
	<p>가입 실패!</p>
	<a href="signupform.jsp">다시 가입하러 가기</a>
<%} %>
</body>
</html>