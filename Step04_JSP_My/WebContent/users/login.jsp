<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>users/login.jsp</title>
</head>
<body>
<%
	//폼에서 전송되는 아이디, 비밀번호 읽어오기
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	boolean isSuccess=false;
	if(id.equals("gura")&&pwd.equals("1234")) {
		isSuccess=true;
	}
%>
<h3>로그인 요청 결과</h3>
<% if(isSuccess) {%>
	<p><strong><%=id %></strong>님이 로그인되었습니다.</p>
<% } else { %>
	<p>아이디 혹은 비밀번호가 틀렸습니다.</p>
<% } %>
</body>
</html>