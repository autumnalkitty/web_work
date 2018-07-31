<%@page import="java.util.List"%>
<%@page import="test.friends.dao.FriendsDao"%>
<%@page import="test.friends.dto.FriendsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>friends/list.jsp</title>
</head>
<body>
<%
	FriendsDao dao=FriendsDao.getInstance();
	List<FriendsDto>list=dao.getList();
%>
<h3>친구 목록입니다.</h3>
<a href="insertform.jsp">친구정보 추가</a>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>전화</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
	<%for(FriendsDto tmp:list) { %>
		<tr>
			<td><%=tmp.getNum() %></td>
			<td><%=tmp.getName() %></td>
			<td><%=tmp.getPhone() %></td>
			<td><a href="updateform.jsp?num=<%=tmp.getNum() %>">수정</a></td>
			<td><a href="delete.jsp?num=<%=tmp.getNum() %>">삭제</a></td>
		</tr>
	<%} %>
	</tbody>
</table>
</body>
</html>