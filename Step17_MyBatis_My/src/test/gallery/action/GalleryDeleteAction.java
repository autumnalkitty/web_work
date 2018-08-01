package test.gallery.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.controller.Action;
import test.controller.ActionForward;
import test.gallery.dao.GalleryDao;
import test.gallery.dto.GalleryDto;

public class GalleryDeleteAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num=Integer.parseInt(request.getParameter("num"));
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		GalleryDto dto=GalleryDao.getInstance().getData(num);
		String writer=dto.getWriter();
		if(!id.equals(writer)) {
			try {
				response.sendError(HttpServletResponse.SC_FORBIDDEN, "본인의 파일이 아닙니다.");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		String imagePath=dto.getImagePath();
		GalleryDao.getInstance().delete(num);
		ServletContext application=request.getServletContext();
		String path=application.getRealPath("/upload")+File.separator+imagePath;
		new File(path).delete();
		ActionForward af=new ActionForward("/views/gallery/private/delete.jsp");
		return af;
	}
}
