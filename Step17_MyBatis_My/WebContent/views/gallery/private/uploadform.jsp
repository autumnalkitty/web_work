<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/gallery/private/uploadform.jsp</title>
</head>
<body>
<p><strong>${id}</strong>님 로그인 중</p>
<h3>사진 업로드 폼입니다.</h3>
<form action="upload.do" method="post" enctype="multipart/form-data">
	<label for="caption">설명</label>
	<input type="text" name="caption" id="caption"/><br/>
	<label for="image">이미지</label>
	<input type="file" name="image" id="image"/><br/>
	<button type="submit">업로드</button>
</form>
</body>
</html>