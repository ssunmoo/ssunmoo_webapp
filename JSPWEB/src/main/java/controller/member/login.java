package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dao.MemberDao2;
import model.dto.MemberDto2;

/**
 * Servlet implementation class login
 */
@WebServlet("/member/login")	// 해당 클래스로 들어올 수 있는 경로
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		MemberDao2 dao2 = new MemberDao2();
		
//		boolean result = dao2.login(mid, mpw);
//		response.getWriter().print(result);

		// db메소드 반환 결과를 js ajax에게 응답
		int result = dao2.login(mid, mpw);
		response.getWriter().print(result);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		// 1. form 내 input 태그로 부터 변수 요청
//		String mid = request.getParameter("mid");
//		String mpw = request.getParameter("mpw");
//		
//		MemberDao2 dao2 = new MemberDao2();
//		
//		boolean result = dao2.login(mid, mpw);
//		if( result ) {
//			response.sendRedirect("/JSPWEB/member/index.jsp");
//		}
//		else {
//			response.sendRedirect("/JSPWEB/member/login.jsp");
//		}
		
	}

}
