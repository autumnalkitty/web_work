<%@page import="test.friends.dto.FriendsDto"%>
<%@page import="test.friends.dao.FriendsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>friends/updateform.jsp</title>
</head>
<body>
<%
	int num=Integer.parseInt(request.getParameter("num"));
	FriendsDao dao=FriendsDao.getInstance();
	FriendsDto dto=dao.getData(num);
%>
<h3>친구정보 수정 폼입니다.</h3>
<form action="update.jsp" method="post">
	<input type="hidden" name="num" value="<%=dto.getNum() %>"/>
	<label for="num">번호</label>
	<input type="text" name="num" value="<%=dto.getNum() %>" disabled/><br/>
	<label for="name">이름</label>
	<input type="text" name="name" value="<%=dto.getName() %>"/><br/>
	<label for="phone">전화</label>
	<input type="text" name="phone" value="<%=dto.getPhone() %>"/><br/>
	<button type="submit">수정 확인</button>
</form>
</body>
</html>