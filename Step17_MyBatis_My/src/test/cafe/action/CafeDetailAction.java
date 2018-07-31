package test.cafe.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeCommentDao;
import test.cafe.dao.CafeDao;
import test.cafe.dto.CafeCommentDto;
import test.cafe.dto.CafeDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeDetailAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num=Integer.parseInt(request.getParameter("num"));
		String keyword=request.getParameter("keyword");
		String condition=request.getParameter("condition");
		CafeDto dto=new CafeDto();
		if(keyword!=null) {//검색어가 전달된 경우
			if(condition.equals("titlecontent")) {
				dto.setTitle(keyword);
				dto.setContent(keyword);
			} else if(condition.equals("title")) {
				dto.setTitle(keyword);
			} else if(condition.equals("content")) {
				dto.setContent(keyword);
			} else if(condition.equals("writer")) {
				dto.setWriter(keyword);
			}
			request.setAttribute("keyword", keyword);
			request.setAttribute("condition", condition);
		}
		dto.setNum(num);
		CafeDto resultDto=CafeDao.getInstance().getData(dto);
		CafeDao.getInstance().addViewCount(num);
		request.setAttribute("dto", resultDto);
		//로그인 여부를 확인해서 request 에 담기
		String id=(String)request.getSession().getAttribute("id");
		boolean isSignin=false;
		if(id!=null) {
			isSignin=true;
		}
		request.setAttribute("isSignin", isSignin);
		//댓글 리스트
		int ref_group=Integer.parseInt(request.getParameter("num"));
		List<CafeCommentDto> commentList=CafeCommentDao.getInstance().getList(ref_group);
		request.setAttribute("commentList", commentList);
		return new ActionForward("/views/cafe/detail.jsp");
	}
}
