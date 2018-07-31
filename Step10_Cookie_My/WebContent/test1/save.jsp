<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test1/save.jsp</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	//폼 전성되는 문자열 읽어오기
	String msg=request.getParameter("msg");
	//쿠키 객체 생성 new Cookie("key", value);
	Cookie cookie=new Cookie("saveMsg", msg);
	//최대 유지시간(초단위)
	cookie.setMaxAge(60);
	//response 객체에 담기
	response.addCookie(cookie);
	//응답 시 응답되는 웹브라우저에 자동 저장
%>
<p>당신의 웹브라우저에 쿠키를 저장했습니다.</p>
<a href="read_cookie.jsp">저장된 쿠키 보기</a>
</body>
</html>