package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeCommentDao;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeCommentDeleteAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num=Integer.parseInt(request.getParameter("num"));
		boolean isSuccess=CafeCommentDao.getInstance().delete(num);
		request.setAttribute("isSuccess", isSuccess);
		int ref_group=Integer.parseInt(request.getParameter("ref_group"));
		ActionForward af=new ActionForward("/cafe/detail.do?num="+ref_group);
		af.setRedirect(true);
		return af;
	}
}
