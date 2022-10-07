package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao2;

/**
 * Servlet implementation class findid
 */
@WebServlet("/member/findid")
public class findid extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public findid() {

    
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 0. 한글 인코딩
		request.setCharacterEncoding("UTF-8"); // 요청 시 한글인코딩
		
		// 1. 변수 요청
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		// 2. DB 처리
		MemberDao2 dao2 = new MemberDao2();
		String result = dao2.findid(mname, memail);
		
		// 3. 응답
		response.getWriter().print( result );
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
