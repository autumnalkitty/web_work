package test.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showtime")
public class ShowTime extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String showTime=new Date().toString();
		request.setAttribute("showTime", showTime);
		RequestDispatcher rd=request.getRequestDispatcher("/views/showtime.jsp");
		rd.forward(request, response);
	}
}
