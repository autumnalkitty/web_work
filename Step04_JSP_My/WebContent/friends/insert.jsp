<%@page import="test.friends.dto.FriendsDto"%>
<%@page import="test.friends.dao.FriendsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>friends/insert.jsp</title>
</head>
<body>
<h3>친구정보 추가 결과</h3>
<%
	//post 방식으로 전송된 파라미터 한글 인코딩 설정
	request.setCharacterEncoding("utf-8");
	//전송된 파라미터 추출
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	FriendsDto dto=new FriendsDto();
	dto.setName(name);
	dto.setPhone(phone);
	FriendsDao dao=FriendsDao.getInstance();
	dao.insert(dto);
%>
<p>친구정보를 추가했습니다.</p>
<a href="list.jsp">목록보기</a>
</body>
</html>