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

@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//수정할 회원의 정보를 읽어온다.
		int num=Integer.parseInt(request.getParameter("num"));
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		//MemberDto 객체에 회원의 정보를 담고
		MemberDto dto=new MemberDto(num, name, addr);
		//DB 에 수정 내용 반영하고
		MemberDao dao=MemberDao.getInstance();
		dao.update(dto);
		//클라이언트에게 응답한다.
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
		pw.println("<title>회원 정보 수정 결과</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<script>");
		pw.println("alert('회원 정보를 수정했습니다.')");
		pw.println("location.href='list';");
		pw.println("</script>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}
