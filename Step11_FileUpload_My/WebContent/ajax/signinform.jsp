<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/ajax/signinform.jsp</title>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.js"></script>
<style>
	.result {
		background-color: #000;
		color: #fff;
		border-radius: 10px;
		margin-top: 10px;
		font-weight: bold;
		font-size: 16px;
	}
</style>
</head>
<body>
<%
	String id=(String)session.getAttribute("id");
%>
<%if(id!=null) { %>
	<p>
		<strong><%=id %></strong>님 로그인 중
		<a href="signout.jsp">로그아웃</a>
	</p>
<%} %>
<h3>jquery 를 활용한 ajax form 전송</h3>
<form action="signin.jsp" method="post" id="myForm">
	<label for="id">아이디</label>
	<input type="text" name="id" id="id"/><br />
	<label for="pwd">비밀번호</label>
	<input type="password" name="pwd" id="pwd"/><br />
	<button type="submit">로그인</button>
</form>
<div class="result"></div>
<script>
	$("#myForm").submit(function() {
		//폼에 입력한 값을 serialize 문자열로 읽어오기(id=??&pwd=??&...)
		var param=$(this).serialize();
		//ajax request 를 이용해서 폼 내용 서버에 전송하기
		$.ajax({
			url: "signin.jsp", 
			method: "post", 
			data: param, 
			success: function(responseData) {
				console.log(responseData);
				$(".result").text(responseData);
				//responseData 는 object 이다.
				if(responseData.isSuccess) {
					alert("로그인 됐습니다.");
				} else {
					alert("아이디 혹은 비밀번호를 확인하세요.");
				}
			}, 
			error: function(xhr) {
				$(".result").text(xhr.responseText);
			}
		});
		return false; //폼 전송 막기(페이지 전환 방지)
	});
</script>
</body>
</html>