package test.file.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import test.controller.Action;
import test.controller.ActionForward;
import test.file.dao.FileDao;
import test.file.dto.FileDto;

public class FileUploadAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//파일을 저장할 폴더의 절대경로 얻어오기
		//application 은 ServletContext type 객체인데 jsp 의 기본 객체이다.
		//WebContent/upload 폴더를 만들어야 한다.
		ServletContext application=request.getServletContext();
		String realPath=application.getRealPath("/upload");
		//최대 업로드 사이즈 값 지정
		int sizeLimit=1024*1024*50; //50MB
		//WEB-INF/lib/cos.jar 파일이 있어야 아래의 클래스들을 import 해서 사용할 수 있다.
		//MultipartRequest 객체를 생성해서 클라이언트가 업로드한 파일을 WebContent/upload 폴더에 저장한다.
		try {
			MultipartRequest mr=new MultipartRequest(request, realPath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
			//업로드된 파일의 정보는 mr 객체를 이용해서 얻어온다.
			String title=mr.getParameter("title");
			//원본 파일명
			String orgFileName=mr.getOriginalFileName("myFile");
			//파일시스템에 저장된 파일명
			String saveFileName=mr.getFilesystemName("myFile");
			//파일의 크기
			long fileSize=mr.getFile("myFile").length();
			//업로드한 클라이언트의 아이디
			HttpSession session=request.getSession();
			String writer=(String)session.getAttribute("id");
			//업로드된 파일 정보를 FileDto 에 담고
			FileDto dto=new FileDto();
			dto.setWriter(writer);
			dto.setTitle(title);
			dto.setOrgFileName(orgFileName);
			dto.setSaveFileName(saveFileName);
			dto.setFileSize(fileSize);
			//DB 에 저장한다.
			boolean isSuccess=FileDao.getInstance().insert(dto);
			request.setAttribute("isSuccess", isSuccess);
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return new ActionForward("/views/file/private/upload.jsp");
	}
}
