package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;

public class UsersSignupAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//폼 전송되는 회원정보를 추출해서
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		//DB 에 저장하고
		UsersDto dto=new UsersDto();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setEmail(email);
		boolean isSuccess=UsersDao.getInstance().insert(dto);
		request.setAttribute("isSuccess", isSuccess);
		request.setAttribute("id", id);
		return new ActionForward("/views/users/signup.jsp");
	}
}
