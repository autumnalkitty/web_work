<%@page import="test.users.dao.UsersDao"%>
<%@page import="test.users.dto.UsersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/private/updateform.jsp</title>
</head>
<body>
<%
	//1. 세션에 저장된 id 를 읽어온다.
	String id=(String)session.getAttribute("id");
	//2. id 를 이용해서 회원정보를 얻어온다.
	UsersDto dto=UsersDao.getInstance().getData(id);
	//3. form 에 수정할 회원정보를 출력해서 응답한다.
%>
<h3>회원정보 수정 페이지입니다.</h3>
<form action="update.jsp" method="post" id="updateForm">
	<input type="hidden" name="id" value="<%=id%>"/>
	<label for="id">아이디</label>
	<input type="text" id="id" value="<%=id%>" disabled="disabled"/><br/>
	<label for="pwd">비밀번호</label>
	<input type="password" name="pwd" id="pwd" value="<%=dto.getPwd()%>"/><br/>
	<label for="pwd2">비밀번호 확인</label>
	<input type="password" id="pwd2" value="<%=dto.getPwd()%>"/><br/>
	<label for="email">이메일 주소</label>
	<input type="text" name="email" id="email" value="<%=dto.getEmail()%>"/><br/>
	<button type="submit">수정 확인</button>
</form>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.js"></script>
<script>
	$("#updateForm").submit(function(){
		var pwd1=$("#pwd").val();
		var pwd2=$("#pwd2").val();
		if(pwd1!=pwd2) {
			alert("비밀번호를 확인하세요!");
			return false; //폼 전송막기
		}
	});
	/*
	document.querySelector("#updateForm")
	.addEventListener("submit", function(event){
		var pwd1=document.querySelector("#pwd").value;
		var pwd2=document.querySelector("#pwd2").value;
		if(pwd1 != pwd2){
			alert("비밀번호를 확인 하세요");
			event.preventDefault();//폼전송 막기 
		}
	});
	*/
</script>
</body>
</html>