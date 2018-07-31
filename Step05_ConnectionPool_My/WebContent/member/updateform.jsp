<%@page import="test.member.dto.MemberDto"%>
<%@page import="test.member.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>member/updateform.jsp</title>
</head>
<body>
<%
	//수정할 회원의 번호를 읽어온다.
	int num=Integer.parseInt(request.getParameter("num"));
	//DB 에서 수정할 회원의 정보를 얻어온다.
	MemberDao dao=MemberDao.getInstance();
	MemberDto dto=dao.getData(num);
%>
<h3>회원정보 수정 폼입니다.</h3>
<form action="update.jsp" method="post">
	<input type="hidden" name="num" value="<%=dto.getNum() %>"/>
	<label for="num">번호</label>
	<input type="text" name="num" value="<%=dto.getNum() %>" disabled/><br/>
	<label for="name">이름</label>
	<input type="text" name="name" value="<%=dto.getName() %>"/><br/>
	<label for="addr">주소</label>
	<input type="text" name="addr" value="<%=dto.getAddr() %>"/><br/>
	<button type="submit">수정 확인</button>
</form>
</body>
</html>