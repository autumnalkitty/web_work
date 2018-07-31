package test.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MemberInsertAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		boolean isSuccess=MemberDao.getInstance().insert(dto);
		if(isSuccess) {
			request.setAttribute("msg", "저장했습니다.");
			request.setAttribute("url", "/member/list.do");
		} else {
			request.setAttribute("msg", "실패했습니다.");
			request.setAttribute("url", "/member/insertform.jsp");
		}
		ActionForward af=new ActionForward("/views/member/alert.jsp");
		return af;
	}
}
