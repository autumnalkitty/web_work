package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;

public class UsersCheckidAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String inputId=request.getParameter("inputId");
		boolean canUse=UsersDao.getInstance().canUseId(inputId);
		request.setAttribute("canUse", canUse);
		return new ActionForward("/views/users/checkid.jsp");
	}
}
