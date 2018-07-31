package test.cafe.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeDao;
import test.cafe.dto.CafeDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeListAction extends Action {
	//한 페이지에 나타낼 row 의 개수
	private static final int PAGE_ROW_COUNT=5;
	//하단 디스플레이의 페이지 개수
	private static final int PAGE_DISPLAY_COUNT=3;
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		/*
		request 에 검색 keyword 가 전달될 수도 있고 안될 수도 있다.
		1. 전달 안되는 경우: home 에서 목록보기를 누른 경우
		2. 전달되는 경우: list.do 에서 검색어를 입력 후 form 전송한 경우
		3. 전달되는 경우: 이미 검색을 한 상태에서 페이지 링크를 누른 경우
		*/
		//검색과 관련된 파라미터를 읽어온다.
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
		//보여줄 페이지의 번호
		int pageNum=1;
		//보여줄 페이지의 번호가 파라미터로 전달되는지 읽어온다.
		String strPageNum=request.getParameter("pageNum");
		if(strPageNum!=null) {//페이지 번호가 넘어오면
			//페이지 번호를 설정한다.
			pageNum=Integer.parseInt(strPageNum);
		}
		//보여줄 페이지 데이터의 시작 ResultSet row 번호
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		//보여줄 페이지 데이터의 끝 ResultSet row 번호
		int endRowNum=pageNum*PAGE_ROW_COUNT;
		//전체 row 의 개수를 읽어온다.
		int totalRow=CafeDao.getInstance().getCount(dto);
		//전체 페이지의 개수 구하기
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		//시작 페이지 번호
		int startPageNum=1+((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		//끝 페이지 번호
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		//끝 페이지 번호가 잘못된 값이라면
		if(totalPageCount < endPageNum) {
			endPageNum=totalPageCount; //보정해준다.
		}
		//startRowNum 과 endRowNum 을 CafeDto 에 담은 다음
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		//CafeDto 객체를 전달해서 파일목록을 불러온다.
		List<CafeDto> list=CafeDao.getInstance().getList(dto);
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("totalPageCount", totalPageCount);
		request.setAttribute("totalRow", totalRow);
		return new ActionForward("/views/cafe/list.jsp");
	}
}
