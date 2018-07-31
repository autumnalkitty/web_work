<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("go4.jsp 페이지에서 요청 처리중…");
	/* 
	아래의 코드는 pageContext.forward("/gura.jsp"); 와 동일하게 동작한다.
	pageContext 객체가 기본적으로 제공되지 않는 서블릿에서는
	forward 이동을 위해 아래와 같은 코드가 필요하다.	
	 */
	//RequestDispatcher 객체의 참조값을 얻어와서
	RequestDispatcher rd=request.getRequestDispatcher("/gura.jsp");
	//forward 이동하기
	rd.forward(request, response);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>go4.jsp</title>
</head>
<body>

</body>
</html>