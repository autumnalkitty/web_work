<%@page import="test.member.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>member/delete.jsp</title>
</head>
<body>
<%
	//파라미터로 전달되는 회원의 번호를 정수로 읽어온다.
	int num=Integer.parseInt(request.getParameter("num"));
	//DB 에서 해당 회원의 정보를 삭제하고
	MemberDao dao=MemberDao.getInstance();
	dao.delete(num);
%>
<script>
	alert("<%=num %>번 회원정보를 삭제했습니다.");
	location.href="list.jsp";
</script>
</body>
</html>