package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeCommentDao;
import test.cafe.dto.CafeCommentDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeCommentDeleteAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num=Integer.parseInt(request.getParameter("num"));
		int ref_group=Integer.parseInt(request.getParameter("ref_group"));
		int comment_group=Integer.parseInt(request.getParameter("comment_group"));
		CafeCommentDto dto=new CafeCommentDto();
		dto.setNum(num);
		dto.setComment_group(comment_group);
		boolean isSuccess=CafeCommentDao.getInstance().delete(dto);
		request.setAttribute("isSuccess", isSuccess);
		ActionForward af=new ActionForward("/cafe/detail.do?num="+ref_group);
		af.setRedirect(true);
		return af;
	}
}
