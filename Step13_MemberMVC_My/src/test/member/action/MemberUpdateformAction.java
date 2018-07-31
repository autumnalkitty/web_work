package test.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MemberUpdateformAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num=Integer.parseInt(request.getParameter("num"));
		MemberDto dto=MemberDao.getInstance().getData(num);
		request.setAttribute("dto", dto);
		ActionForward af=new ActionForward("/views/member/updateform.jsp");
		return af;
	}
}
