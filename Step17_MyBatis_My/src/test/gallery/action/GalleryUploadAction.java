package test.gallery.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import test.controller.Action;
import test.controller.ActionForward;
import test.gallery.dao.GalleryDao;
import test.gallery.dto.GalleryDto;

public class GalleryUploadAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ServletContext application=request.getServletContext();
		String realPath=application.getRealPath("/upload");
		int sizeLimit=1024*1024*50;
		try {
			MultipartRequest mr=new MultipartRequest(request, realPath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
			String caption=mr.getParameter("caption");
			String imagePath=mr.getFilesystemName("image");
			HttpSession session=request.getSession();
			String writer=(String)session.getAttribute("id");
			GalleryDto dto=new GalleryDto();
			dto.setWriter(writer);
			dto.setCaption(caption);
			dto.setImagePath("/upload/"+imagePath);
			boolean isSuccess=GalleryDao.getInstance().insert(dto);
			request.setAttribute("isSuccess", isSuccess);
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return new ActionForward("/views/gallery/private/upload.jsp");
	}
}
