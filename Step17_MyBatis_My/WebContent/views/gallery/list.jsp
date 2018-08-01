<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/gallery/list.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<c:choose>
		<c:when test="${not empty id}">
			<p><strong>${id}</strong>님 로그인 중</p>
		</c:when>
		<c:otherwise>
			<a href="${pageContext.request.contextPath}/users/signinform.do">로그인</a>
		</c:otherwise>
	</c:choose>
	<a href="private/uploadform.do">사진 올리기</a>
	<h3>사진 갤러리입니다.</h3>
	<c:forEach var="tmp" items="${list}">
		<div class="col-xs-3">
			<h4>${tmp.caption}</h4>
			<img src="${pageContext.request.contextPath}${tmp.imagePath}" 
				class="img-responsive img-thumbnail"/>
			<p>
				작성자:<strong>${tmp.writer}</strong><br/>
				등록일:<strong>${tmp.regdate}</strong><br />
				<c:if test="${tmp.writer eq id}">
					<a href="javascript:deleteConfirm(${tmp.num})">삭제</a>
				</c:if>
			</p>
		</div>
	</c:forEach>
</div>
<script>
	function deleteConfirm(num) {
		var isDelete=confirm(num+"번 파일을 삭제 하시겠습니까?")
		if(isDelete) {
			location.href="private/delete.do?num="+num;
		}
	}
</script>
</body>
</html>