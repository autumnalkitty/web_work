package test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showfortune")
public class ShowFortune extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 오늘의 운세를 얻어오는 비즈니스 로직 수행
		String fortuneToday="밖에 나가면 엄청 더워요!";
		//2. 로직 수행결과로 얻어진 데이터(Model)를 request 에 담기
		request.setAttribute("fortuneToday", fortuneToday);
		//3. view(jsp) 페이지로 forward 이동
		RequestDispatcher rd=request.getRequestDispatcher("/views/showfortune.jsp");
		rd.forward(request, response);
	}
}
