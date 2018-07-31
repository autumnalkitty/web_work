<%@page import="java.util.List"%>
<%@page import="test.gallery.dao.GalleryDao"%>
<%@page import="test.gallery.dto.GalleryDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/gallery/list.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
<%
	List<GalleryDto> list=GalleryDao.getInstance().getList();
	String id=(String)session.getAttribute("id");
	if(id==null) {
		id="";
	}
	String cPath=request.getContextPath();
%>
<div class="container">
	<%if(id!=null&&!id.equals("")) {%>
			<p><strong><%=id %></strong>님 로그인 중</p>
	<%} else {%>
		<a href="<%=cPath %>/users/signinform.jsp">로그인</a>
	<%} %>
	<a href="private/uploadform.jsp">사진 올리기</a>
	<h3>사진 갤러리입니다.</h3>
	<hr/>
	<%for(GalleryDto tmp:list){%>
	<div class="col-xs-3">
		<h4><%=tmp.getCaption() %></h4>
		<img src="<%=cPath%><%=tmp.getImagePath()%>" 
			class="img-responsive img-thumbnail"/>
		<p>
			작성자:<strong><%=tmp.getWriter() %></strong><br/>
			등록일:<strong><%=tmp.getRegdate() %></strong><br />
			<%if(id.equals(tmp.getWriter())) { %><a href="javascript:deleteConfirm(<%=tmp.getNum() %>)">삭제</a><%} %>
		</p>
	</div>
	<%} %>
</div>
<script>
	function deleteConfirm(num) {
		var isDelete=confirm(num+"번 파일을 삭제 하시겠습니까?")
		if(isDelete) {
			location.href="private/delete.jsp?num="+num;
		}
	}
</script>
</body>
</html>