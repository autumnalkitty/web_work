<%@page import="test.board.dto.BoardDto"%>
<%@page import="test.board.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/updateform.jsp</title>
</head>
<body>
<%
	//수정할 글 번호를 읽어온다.
	int num=Integer.parseInt(request.getParameter("num"));
	//BoardDao 를 이용해서 수정할 글정보를 얻어온다.
	BoardDto dto=BoardDao.getInstance().getData(num);
%>
<h3>글 수정 폼입니다.</h3>
<form action="update.jsp">
	<input type="hidden" name="num" value="<%=dto.getNum() %>"/>
	<label for="num">번호</label>
	<input type="text" id="num" value="<%=dto.getNum() %>" disabled /><br />
	<label for="writer">작성자</label>
	<input type="text" name="writer" id="writer" /><br />
	<label for="title">제목</label>
	<input type="text" name="title" id="title" /><br />
	<label for="content">내용</label>
	<textarea name="content" id="content" cols="30" rows="10"></textarea>
	<br />
	<button type="submit">수정 완료</button>
	<button type="reset">취소</button>
</form>
</body>
</html>