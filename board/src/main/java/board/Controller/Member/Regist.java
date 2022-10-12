package board.Controller.Member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Dao.RegistDao;
import Model.Dto.RegistDto;

@WebServlet("/Board/regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Regist() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// *** 한글 인코딩 *** 이거 안넣으면 한글 안들어감
		request.setCharacterEncoding("UTF-8");
		
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");
		String b_name = request.getParameter("b_name");
		String b_pw = request.getParameter("b_pw");
	
		RegistDao dao = new RegistDao();
		
		boolean result = dao.regist(b_title, b_content, b_name, b_pw);
		response.getWriter().print(result);
		
//		if( result ) {
//			System.out.println("글 등록 성공");
//			response.sendRedirect("/board/Board/boardlist.jsp");
//		}
//		else {
//			System.out.println("글 등록 실패");
//			response.sendRedirect("/board/Board/regist.jsp");
//		}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
