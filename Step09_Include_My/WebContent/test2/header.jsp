<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//전달된 데이터가 있으면 request 영역에서 찾는다.
	String myName=(String)request.getAttribute("myName");
%>
<div class="header">
	<h3>header 입니다.</h3>
	<p>내 이름은 <strong><%=myName %></strong>입니다.</p>
</div>