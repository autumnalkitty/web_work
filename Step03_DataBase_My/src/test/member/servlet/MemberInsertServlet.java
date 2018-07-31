package test.member.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

@WebServlet("/member/insert")
public class MemberInsertServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 방식으로 전송됐을 때 한글 인식
		request.setCharacterEncoding("utf-8");
		//전송된 파라미터 추출
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		//저장할 회원 정보를 MemberDto 객체에 담기
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		//MemberDao 객체를 이용해서 DB 에 저장
		MemberDao dao=MemberDao.getInstance();
		dao.insert(dto);
		//클라이언트에게 응답하기
		//응답 인코딩 설정
		response.setCharacterEncoding("utf-8");
		//응답 컨텐츠 설정
		response.setContentType("text/html;charset-utf-8");
		//클라이언트에게 응답할 수 있는 객체의 참조값 얻어오기
		PrintWriter pw = response.getWriter();
		//html 형식으로 응답하기
		pw.println("<!doctype html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'/>");
		pw.println("<title>회원 정보 추가결과 페이지</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<p>회원 정보를 추가했습니다.</p>");
		pw.println("<a href='list'>목록보기</a>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}
