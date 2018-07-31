<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/file/list.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
<style>
	.page_display a {
		text-decoration: none;
		color: #000;
	}
	.page_display a.active {
		font-weight: bold;
		color: red;
		text-decoration: underline;
	}
	.page_display a.muted {
		color: #cecece;
	}
</style>
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
	<a href="private/upload_form.do">새 파일 업로드</a>
	<h3>파일 목록입니다.</h3>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>파일명</th>
				<th>다운로드 회수</th>
				<th>등록일</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tmp" items="${list}">
			<tr>
				<td>${tmp.num}</td>
				<td>${tmp.writer}</td>
				<td>${tmp.title}</td>
				<td>
					${tmp.orgFileName}
					<a href="download.do?num=${tmp.num}"><i class="glyphicon glyphicon-download pull-right"></i></a>
				</td>
				<td>${tmp.downCount}</td>				
				<td>${tmp.regdate}</td>
				<td>
				<c:if test="${tmp.writer eq id}">
					<a href="javascript:deleteConfirm(${tmp.num})">삭제</a>
				</c:if>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 페이징 처리 -->
	<div class="page_display">
		<c:choose>
			<c:when test="${startPageNum ne 1}">
				<a href="list.do?pageNum=${startPageNum-1}">Prev</a>
			</c:when>
			<c:otherwise>
				<a href="javascript:" class="muted ">Prev</a>
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${startPageNum}" end="${endPageNum}">
			<c:choose>
				<c:when test="${i eq pageNum}">
					<a href="list.do?pageNum=${i}" class="active">${i}</a>
				</c:when>
				<c:otherwise>
					<a href="list.do?pageNum=${i}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${endPageNum lt totalPageCount}">
				<a href="list.do?pageNum=${endPageNum+1}">Next</a>
			</c:when>
			<c:otherwise>
				<a href="javasctipt:" class="muted">Next</a>
			</c:otherwise>
		</c:choose>
	</div>
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