package test.file.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.file.dao.FileDao;
import test.file.dto.FileDto;

public class FileListAction extends Action {
	//한 페이지에 나타낼 row 의 개수
	private static final int PAGE_ROW_COUNT=5;
	//하단 디스플레이의 페이지 개수
	private static final int PAGE_DISPLAY_COUNT=3;
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
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
		int totalRow=FileDao.getInstance().getCount();
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
		//startRowNum 과 endRowNum 을 FileDto 에 담은 다음
		FileDto dto=new FileDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		//FileDto 객체를 전달해서 파일목록을 불러온다.
		List<FileDto> list=FileDao.getInstance().getList(dto);
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("totalPageCount", totalPageCount);
		return new ActionForward("/views/file/list.jsp");
	}
}
