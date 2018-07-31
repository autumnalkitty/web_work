<%@page import="java.io.File"%>
<%@page import="test.gallery.dao.GalleryDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/gallery/private/delete.jsp</title>
</head>
<body>
<%
	int num=Integer.parseInt(request.getParameter("num"));
	String id=(String)session.getAttribute("id");
	String writer=GalleryDao.getInstance().getData(num).getWriter();
	if(!id.equals(writer)) {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "본인의 파일이 아닙니다.");
		return;
	}
	String imagePath=GalleryDao.getInstance().getData(num).getImagePath();
	GalleryDao.getInstance().delete(num);
	String path=application.getRealPath("/upload")+File.separator+imagePath;
	new File(path).delete();
	String cPath=request.getContextPath();
%>
<p>이미지를 삭제했습니다.</p>
<a href="<%=cPath %>/gallery/list.jsp">확인</a>
</body>
</html>