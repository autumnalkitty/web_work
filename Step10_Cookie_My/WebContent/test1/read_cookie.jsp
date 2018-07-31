<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test1/read_cookie.jsp</title>
</head>
<body>
<%
	//클라이언트가 요청할 때 request 객체에 쿠키가 담겨있다.
	Cookie[] cookies=request.getCookies();
	//읽어온 문자열을 저장할 변수
	String savedMsg=null;
	if(cookies!=null&&cookies.length>0) {//저장된 쿠키가 있으면
		//반복문 돌면서 쿠키 객체를 하나씩 불러와서
		for(Cookie tmp:cookies) {
			//saveMsg 라는 이름으로 저장된 쿠키가 있다면
			if(tmp.getName().equals("saveMsg")) {
				//저장된 값을 읽어와서 변수에 담는다.
				savedMsg=tmp.getValue();
			}
		}
	}
%>
<p>쿠키에 저장된 문자열: <strong><%=savedMsg %></strong></p>
</body>
</html>