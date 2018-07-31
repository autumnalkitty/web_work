package test.member.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.member.dao.MemberDao;

@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터로 전달되는 회원의 번호를 정수로 읽어온다.
		int num=Integer.parseInt(request.getParameter("num"));
		//DB 에서 해당 회원의 정보를 삭제하고
		MemberDao dao=MemberDao.getInstance();
		dao.delete(num);
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
		pw.println("<title>삭제 결과 페이지</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<p>회원 정보를 삭제했습니다.</p>");
		pw.println("<a href='list'>회원 목록 보기</a>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}
