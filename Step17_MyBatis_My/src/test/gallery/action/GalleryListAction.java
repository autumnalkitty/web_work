package test.gallery.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.gallery.dao.GalleryDao;
import test.gallery.dto.GalleryDto;

public class GalleryListAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		GalleryDto dto=new GalleryDto();
		List<GalleryDto> list=GalleryDao.getInstance().getList(dto);
		request.setAttribute("list", list);
		return new ActionForward("/views/gallery/list.jsp");
	}
}
