<%@page import="test.member.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/showmember.jsp</title>
</head>
<body>
<%
	MemberDto dto=(MemberDto)request.getAttribute("dto");
%>
<h3>회원 한 명의 정보</h3>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>주소</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><%=dto.getNum() %></td>
			<td><%=dto.getName() %></td>
			<td><%=dto.getAddr() %></td>
		</tr>
	</tbody>
</table>
</body>
</html>