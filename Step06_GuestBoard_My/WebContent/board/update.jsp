<%@page import="test.board.dao.BoardDao"%>
<%@page import="test.board.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/update.jsp</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	//수정할 글정보를 읽어온다.
	int num=Integer.parseInt(request.getParameter("num"));
	String writer=request.getParameter("writer");
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	//BoardDao 객체를 이용해서 수정, 반영한다.
	BoardDto dto=new BoardDto();
	dto.setNum(num);
	dto.setWriter(writer);
	dto.setTitle(title);
	dto.setContent(content);
	boolean isSuccess=BoardDao.getInstance().update(dto);
%>
<%if(isSuccess) {%>
	<p><strong><%=num %></strong>번 글 정보를 수정했습니다.</p>
<%} else { %>
	<p>글 수정 실패!</p>
<%} %>
<a href="list.jsp">글목록 보기</a>
</body>
</html>