package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;

public class UsersUpdateformAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 세션에 저장된 id 를 읽어온다.
		String id=(String)request.getSession().getAttribute("id");
		//2. id 를 이용해서 회원정보를 얻어온다.
		UsersDto dto=UsersDao.getInstance().getData(id);
		request.setAttribute("dto", dto);
		return new ActionForward("/views/users/private/updateform.jsp");
	}
}
