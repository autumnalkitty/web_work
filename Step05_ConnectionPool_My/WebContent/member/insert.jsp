<%@page import="test.member.dao.MemberDao"%>
<%@page import="test.member.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>member/insert.jsp</title>
</head>
<body>
<h3>회원정보 추가 결과</h3>
<%
	//post 방식으로 전송된 파라미터 한글 인코딩 설정
	request.setCharacterEncoding("utf-8");
	//전송된 파라미터 추출
	String name=request.getParameter("name");
	String addr=request.getParameter("addr");
	//저장할 회원 정보를 MemberDto 객체에 담기
	MemberDto dto=new MemberDto();
	dto.setName(name);
	dto.setAddr(addr);
	//MemberDao 객체를 이용해서 DB 에 저장
	MemberDao dao=MemberDao.getInstance();
	dao.insert(dto);
%>
<p>회원정보를 추가했습니다.</p>
<a href='list.jsp'>목록보기</a>
</body>
</html>