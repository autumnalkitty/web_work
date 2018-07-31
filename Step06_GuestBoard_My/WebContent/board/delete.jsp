<%@page import="test.board.dao.BoardDao"%>
<%@page import="test.board.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/delete.jsp</title>
</head>
<body>
<%
	//삭제할 글 번호를 읽어온다.
	int num=Integer.parseInt(request.getParameter("num"));
	//BoardDao 를 이용해서 해당 글을 삭제한다.
	boolean isSuccess=BoardDao.getInstance().delete(num);
%>
<%if(isSuccess) {%>
	<script>
		alert("<%=num%>번 글을 삭제했습니다.");
		location.href="list.jsp";
	</script>
<%} else {%>
	<script>
		alert("삭제 실패!");
		location.href="list.jsp";
	</script>
<%} %>
</body>
</html>