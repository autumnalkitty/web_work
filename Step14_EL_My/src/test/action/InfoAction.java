package test.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.member.dto.MemberDto;

public class InfoAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDto dto=new MemberDto(1, "김구라", "노량진");
		request.setAttribute("dto", dto);
		return new ActionForward("/views/info.jsp");
	}
}
