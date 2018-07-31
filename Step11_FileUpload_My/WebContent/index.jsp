<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
<%
	String id=(String)session.getAttribute("id");
%>
<%if(id!=null) {%>
	<p><strong><%=id %></strong>님 로그인 중</p>
	<a href="users/signout.jsp">로그아웃</a>
<%} else {%>
	<a href="users/signinform.jsp">로그인</a>
<%} %>
<h3>인덱스 페이지입니다.</h3>
<ul>
	<li><a href="users/signupform.jsp">회원가입</a></li>
	<li><a href="file/list.jsp">자료실</a></li>
	<li><a href="gallery/list.jsp">사진 갤러리</a></li>
	<li><a href="ajax/signinform.jsp">ajax 로그인</a></li>
	<li><a href="ajax2/signinform.jsp">ajax 로그인2</a></li>
	<li><a href="ajax3/upload_form.jsp">ajax 파일 업로드</a></li>
	<li><a href="dragndrop/test1.jsp">dnd 테스트1</a></li>
	<li><a href="dragndrop/test2.jsp">dnd 테스트2</a></li>
	<li><a href="dropzone/upload_form.jsp">dropzone 테스트</a></li>
</ul>
</body>
</html>