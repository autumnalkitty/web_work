<%@page import="test.board.dao.BoardDao"%>
<%@page import="test.board.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	 //1. 전송되는 폼 내용을 추출해서
	request.setCharacterEncoding("utf-8");
	String writer=request.getParameter("writer");
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	//2. DB 에 저장하고
	BoardDto dto=new BoardDto();
	dto.setWriter(writer);
	dto.setTitle(title);
	dto.setContent(content);
	BoardDao dao=BoardDao.getInstance();
	boolean isSuccess=dao.insert(dto);
	//3. 응답하기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/insert.jsp</title>
</head>
<body>
<%if(isSuccess) {%>
	<p><strong><%=writer %></strong>님의 글이 저장됐습니다.</p>
	<a href="list.jsp">글목록 보기</a>
<%} else { %>
	<p>글 저장 실패</p>
	<a href="insertform.jsp">새글 작성하기</a>
<%} %>
</body>
</html>