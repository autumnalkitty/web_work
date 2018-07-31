<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//파라미터로 전달된 값들을 읽어온다.
	String name=request.getParameter("name");
	String value=request.getParameter("value");
	//쿠키 객체를 생성해서 정보를 담는다.
	Cookie cookie=new Cookie(name, value);
	cookie.setMaxAge(60);
	response.addCookie(cookie);
	//바로 리다이렉트로 응답하기
	response.sendRedirect("cookie_form.jsp");
%>