package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;

public class UsersSigninAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		UsersDto dto=new UsersDto();
		dto.setId(id);
		dto.setPwd(pwd);
		boolean isSigninSuccess=UsersDao.getInstance().isValid(dto);
		String url=request.getParameter("url");
		if(isSigninSuccess) {
			request.getSession().setAttribute("id", id);
		}
		request.setAttribute("isSigninSuccess", isSigninSuccess);
		request.setAttribute("url", url);
		return new ActionForward("/views/users/signin.jsp");
	}
}
