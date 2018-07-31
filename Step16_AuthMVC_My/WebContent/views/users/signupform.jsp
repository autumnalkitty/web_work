<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/users/signup_form.jsp</title>
</head>
<body>
<h3>회원가입 페이지입니다.</h3>
<form action="signup.do" method="post" id="signupform">
	<label for="id">아이디</label>
	<input type="text" name="id" id="id"/>
	<span id="checkResult"></span>
	<br />
	<label for="pwd">비밀번호</label>
	<input type="password" name="pwd" id="pwd"/><br />
	<label for="email">이메일</label>
	<input type="text" name="email" id="email"/><br />
	<button type="submit">가입</button>
</form>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.js"></script>
<script>
	//폼의 유효성 여부
	var formValid=false;
	$("#signupform").submit(function() {
		if(formValid==false) {
			return false;
		}
	});
	//아이디 입력란에 실행했을 때 입력할 함수 등록
	$("#id").on("input", function() {
		//입력한 아이디 읽어와서
		var inputId=$(this).val();
		//ajax 요청을 이용해서 서버에 보낸다.
		$.ajax({
			url: "checkid.do", 
			method: "post", 
			data: {"inputId": inputId}, 
			success: function(responseData) {
				//responseData 는 object
				if(responseData.canUse) {
					formValid=true;
					$("#checkResult").text("사용가능").css("color", "#00ff00");
				} else {
					formValid=false;
					$("#checkResult").text("사용불가").css("color", "#ff0000");
				}
			}
		});
	});
</script>
</body>
</html>