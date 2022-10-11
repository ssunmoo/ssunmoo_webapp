package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao2;

/**
 * Servlet implementation class delete
 */
@WebServlet("/member/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public delete() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. ajax에 변수 요청
		String mpw = request.getParameter("mpw");
		
		// 2. 세션 호출
		String mid = (String)request.getSession().getAttribute("mid");
		
		// 3. dao 호출
		MemberDao2 dao2 = new MemberDao2();
		boolean result = dao2.mdelete(mid, mpw);
		
		//4.
		response.getWriter().print( result );
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	
	}

}
