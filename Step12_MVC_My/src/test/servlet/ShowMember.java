package test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.member.dto.MemberDto;

@WebServlet("/showmember")
public class ShowMember extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDto dto=new MemberDto(1, "김구라", "노량진");
		request.setAttribute("dto", dto);
		RequestDispatcher rd=request.getRequestDispatcher("/views/showmember.jsp");
		rd.forward(request, response);
	}
}
