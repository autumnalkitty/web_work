<%@page import="test.friends.dto.FriendsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/friends/list.jsp</title>
</head>
<body>
<h3>친구 목록입니다.</h3>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>등록일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="tmp" items="${list}">
			<tr>
				<td>${tmp.num}</td>
				<td>${tmp.name}</td>
				<td>${tmp.phone}</td>
				<td>${tmp.regdate}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>