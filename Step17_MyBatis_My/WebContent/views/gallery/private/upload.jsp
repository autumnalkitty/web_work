<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/gallery/private/upload.jsp</title>
</head>
<body>
<c:choose>
	<c:when test="${isSuccess}">
		<p>이미지를 업로드했습니다.</p>
		<a href="../list.do">목록 보기</a>
	</c:when>
	<c:otherwise>
		<p>이미지 업로드 실패</p>
		<a href="../list.do">목록보기</a>
	</c:otherwise>
</c:choose>
</body>
</html>