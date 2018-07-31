package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeCommentDao;
import test.cafe.dto.CafeCommentDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeCommentInsertAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String writer=request.getParameter("writer");
		String target_id=request.getParameter("target_id");
		String content=request.getParameter("content");
		int ref_group=Integer.parseInt(request.getParameter("ref_group"));
		//comment_group 이 null 이면 원글에 단 댓글
		String comment_group=request.getParameter("comment_group");
		int seq=CafeCommentDao.getInstance().getSequence();
		CafeCommentDto dto=new CafeCommentDto();
		dto.setNum(seq);
		dto.setWriter(writer);
		dto.setTarget_id(target_id);
		dto.setContent(content);
		dto.setRef_group(ref_group);
		if(comment_group==null) {
			dto.setComment_group(seq);
		} else {
			dto.setComment_group(Integer.parseInt(comment_group));
		}
		CafeCommentDao.getInstance().insert(dto);
		ActionForward af=new ActionForward("/cafe/detail.do?num="+ref_group);
		af.setRedirect(true);
		return af;
	}
}