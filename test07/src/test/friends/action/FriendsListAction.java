package test.friends.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.friends.dao.FriendsDao;
import test.friends.dto.FriendsDto;

public class FriendsListAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		List<FriendsDto> list=FriendsDao.getInstance().getList();
		request.setAttribute("list", list);
		return new ActionForward("/views/friends/list.jsp");
	}
}
