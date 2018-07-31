package test.file.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.controller.Action;
import test.controller.ActionForward;
import test.file.dao.FileDao;
import test.file.dto.FileDto;

public class FileDeleteAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//삭제할 파일 번호를 읽어온다
		int num=Integer.parseInt(request.getParameter("num"));
		//파일 시스템에서 삭제하기 위해서는 저장된 파일명을 알아야한다.
		FileDto dto=FileDao.getInstance().getData(num);
		String saveFileName=dto.getSaveFileName();
		//세션의 아이디와 삭제할 글의 작성자가 같은지 확인
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		String writer=FileDao.getInstance().getData(num).getWriter();
		if(!id.equals(writer)) {
			//금지된 요청이라고 에러를 응답한다.
			try {
				response.sendError(HttpServletResponse.SC_FORBIDDEN, "본인의 파일이 아닙니다.");
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			//서비스 메소드 종료
			return null;
		}
		//DB 에서 파일 정보 삭제
		FileDao.getInstance().delete(num);
		//WebContent/upload 폴더에서 실제 파일 삭제
		//삭제할 파일의 전체 경로 구성
		ServletContext application=request.getServletContext();
		String path=application.getRealPath("/upload")+File.separator+saveFileName;
		//File 객체를 생성해서 삭제
		new File(path).delete();
		ActionForward af=new ActionForward("/file/list.do");
		af.setRedirect(true);
		return af;
	}
}
