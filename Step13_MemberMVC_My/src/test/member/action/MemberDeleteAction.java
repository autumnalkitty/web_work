package test.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.member.dao.MemberDao;

public class MemberDeleteAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num=Integer.parseInt(request.getParameter("num"));
		System.out.println("num");
		MemberDao.getInstance().delete(num);
		ActionForward af=new ActionForward("/member/list.do");
		af.setRedirect(true);
		return af;
	}
}
