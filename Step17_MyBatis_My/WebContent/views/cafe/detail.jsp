<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/cafe/detail.jsp</title>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
<style>
	.content {
		width: 766px;
		box-shadow: 10px 10px 5px #888;
	}
	.content img {
		max-width: 100%;
	}
	.comment {
		position: relative;
	}
	.comment form {
		display: none;
	}
	.comment .reply_icon {
		width: 8px;
		height: 8px;
		position: absolute;
		top: 0px;
		left: -12px;
	}
	.muted {
		color: #888;
	}
</style>
</head>
<body>
<c:if test="${not empty keyword}">
	<p>검색어: <strong>${keyword}</strong>에 대한 자세히 보기</p>
</c:if>
<h3>글 자세히 보기 페이지</h3>
<table>
	<tr>
		<th>글 번호</th>
		<td>${dto.num}</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${dto.writer}</td>
	</tr>
	<tr>
		<th>글 제목</th>
		<td>${dto.title}</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td>${dto.regdate}</td>
	</tr>
</table>
<div class="content">${dto.content}</div>
<c:if test="${sessionScope.id eq dto.writer}">
	<a href="private/updateform.do?num=${dto.num}">수정</a>
	<a href="javascript:deleteConfirm()">삭제</a>
</c:if>
<a href="list.do?condition=${condition}&keyword=${keyword}">목록 보기</a>
<div>
	<c:if test="${dto.prevNum ne 0}">
		<a href="detail.do?num=${dto.prevNum}&condition=${condition}&keyword=${keyword}">이전 글</a>
	</c:if>
	<c:if test="${dto.nextNum ne 0}">
		<a href="detail.do?num=${dto.nextNum}&condition=${condition}&keyword=${keyword}">다음 글</a>
	</c:if>
</div>
<!-- 댓글에 관련된 UI -->
<div class="comments">
	<div class="comment_form">
		<form action="private/comment_insert.do" method="post">
			<input type="hidden"  name="writer" id="writer" value="${id}"/>
			<input type="hidden" name="ref_group" id="ref_group" value="${dto.num}"/>
			<input type="hidden" name="target_id" id="target_id" value="${dto.writer}"/>
			<textarea name="content" id="" cols="100%" rows="3"></textarea>
			<button type="submit">등록</button>
		</form>
	</div>
	<c:forEach var="tmp" items="${commentList}">
		<div class="comment" <c:if test="${tmp.num ne tmp.comment_group}">style="margin-left: 30px;"</c:if>>
			<c:if test="${tmp.num ne tmp.comment_group}">
				<img src="${pageContext.request.contextPath}/resources/images/re.gif" alt="" class="reply_icon"/>
				<i class="muted">${tmp.target_id}</i>
			</c:if>
			<img src="${pageContext.request.contextPath}/resources/images/user_image.gif" alt="" />
			<span>${tmp.writer}</span>
			<span>${tmp.regdate}</span>
			<a href="javascript:" class="reply_link">답글</a>
			<c:choose>
				<c:when test="${sessionScope.id eq tmp.writer}">
					<a href="private/comment_update.do?num=${tmp.num}&ref_group=${tmp.ref_group}">수정</a>
					<a href="private/comment_delete.do?num=${tmp.num}&ref_group=${tmp.ref_group}">삭제</a>
				</c:when>
				<c:otherwise>
					<a href="">신고</a>
				</c:otherwise>
			</c:choose>
			<pre>${tmp.content}</pre>
			<form action="private/comment_insert.do" method="post">
				<!-- 덧글 작성자 -->
				<input type="hidden" name="writer" value="${id}"/>
				<!-- 덧글 그룹 -->
				<input type="hidden" name="ref_group" value="${dto.num}" />
				<!-- 덧글 대상 -->
				<input type="hidden" name="target_id" value="${tmp.writer}" />
				<input type="hidden" name="comment_group" value="${tmp.comment_group}" />
				<textarea name="content"></textarea>
				<button type="submit">등록</button>
			</form>
		</div>
	</c:forEach>
</div>
<script>
	function deleteConfirm() {
		var isDelete=confirm("글을 삭제하시겠습니까?");
		if(isDelete) {
			location.href="private/delete.do?num=${dto.num}";
		}
	}
	var isSignin=${isSignin};
	$(".comment_form > form, .comment > form").submit(function() {
		if(!isSignin) {
			var isGoSignin=confirm("로그인이 필요합니다.");
			if(isGoSignin) {
				location.href="${pageContext.request.contextPath}/users/signinform.do?url=${pageContext.request.contextPath}/cafe/detail.do?num=${dto.num}";
			}
			return false;
		}
	});
	//답글 링크를 눌렀을 때
	$(".comment .reply_link").click(function(){
		if($(this).text()=="답글") {
			$(this).text("취소");
		} else {
			$(this).text("답글");
		}
	});
	$(".comment .reply_link").click(function() {
		$(this).parent().find("form").slideToggle(200);
	});
</script>
</body>
</html>