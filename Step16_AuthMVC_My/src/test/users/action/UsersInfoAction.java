package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;

public class UsersInfoAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. session 에 저장된 id 를 읽어와서
		String id=(String)request.getSession().getAttribute("id");
		//2. DB 에서 해당 id 의 회원정보를 읽어와서
		UsersDto dto=UsersDao.getInstance().getData(id);
		request.setAttribute("dto", dto);
		return new ActionForward("/views/users/private/info.jsp");
	}
}
