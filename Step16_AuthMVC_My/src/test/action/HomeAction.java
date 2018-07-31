package test.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

public class HomeAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//공지사항을 Dao 이용해서 읽어온다.
		List<String> msgs=new ArrayList<>();
		msgs.add("날씨가 많이 더워요.");
		msgs.add("야외활동을 자제해주세요.");
		msgs.add("웅앵웅");
		msgs.add("초키포");
		//모델을 request 에 담는다.
		request.setAttribute("msgs", msgs);
		return new ActionForward("/views/home.jsp");
	}
}
