<%@page import="test.users.dao.UsersDao"%>
<%@page import="test.users.dto.UsersDto"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	UsersDto dto=new UsersDto();
	dto.setId(id);
	dto.setPwd(pwd);
	boolean isSigninSuccess=UsersDao.getInstance().isValid(dto);
	if(isSigninSuccess) {
		//로그인 처리하기
		session.setAttribute("id", id);
	}
%>
{"isSuccess": <%=isSigninSuccess %>}