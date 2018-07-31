<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test4/popup.jsp</title>
</head>
<body>
<%
	//팝업창 띄울지 여부
	boolean canPopup=true;
	//모든 쿠키를 배열로 얻어낸다.
	Cookie[] cookies=request.getCookies();
	if(cookies!=null&&cookies.length>0) {
		for(Cookie tmp:cookies) {
			if(tmp.getName().equals("canPopup")) {
				canPopup=false;
			}
		}
	}
%>
<%if(canPopup) {%>
	<script>
		window.open("popup_page.jsp", "팝업", "width=500, height=500, top=100, left=100");
	</script>
<%} %>
<h3>메인 페이지입니다.</h3>
<p>Gura 홈쇼핑</p>
<p>바캉스를 준비하세요.</p>
</body>
</html>