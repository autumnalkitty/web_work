<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/signout.jsp</title>
</head>
<body>
<%
	//id에 저장된 정보 삭제하기
	//session.removeAttribute("id");
	//세션에 저장된 모든 정보를 삭제하기
	session.invalidate();
	String cPath=request.getContextPath();
%>
<script>
	alert("로그아웃 됐습니다.");
	location.href="<%=cPath %>/";
</script>
</body>
</html>