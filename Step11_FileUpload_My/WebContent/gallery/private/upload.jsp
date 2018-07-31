<%@page import="test.gallery.dto.GalleryDto"%>
<%@page import="test.gallery.dao.GalleryDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/gallery/private/upload.jsp</title>
</head>
<body>
<%
	String realPath=application.getRealPath("/upload");
	int sizeLimit=1024*1024*50;
	MultipartRequest mr=new MultipartRequest(request, realPath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
	String caption=mr.getParameter("caption");
	String imagePath=mr.getFilesystemName("image");
	String writer=(String)session.getAttribute("id");
	GalleryDto dto=new GalleryDto();
	dto.setWriter(writer);
	dto.setCaption(caption);
	dto.setImagePath("/upload/"+imagePath);
	System.out.println("image path : " + dto.getImagePath());
	boolean isSuccess=GalleryDao.getInstance().insert(dto);
%>
<%if(isSuccess) {%>
	<p>이미지를 업로드했습니다. </p>
	<a href="../list.jsp">목록보기</a>
<%} else {%>
	<p>이미지 업로드 실패</p>
	<a href="../list.jsp">목록보기</a>
<%} %>
</body>
</html>