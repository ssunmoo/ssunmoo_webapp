package board.Controller.Member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Dao.RegistDao;
import Model.Dto.RegistDto;

/**
 * Servlet implementation class board_delete
 */
@WebServlet("/Board/board_delete")
public class board_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public board_delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		String b_pw2 = request.getParameter("b_pw2");
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		System.out.println("번호를찾습니다.. : "+b_no);
		
		RegistDao dao = new RegistDao();
		boolean result = dao.board_delete(b_pw2, b_no);
		
		System.out.println("서블릿 b_pw : "+b_pw2);
		System.out.println("서블릿 b_no : "+b_no);
		response.getWriter().print(result);
	
	
	
	
	
	
	
	
	
	
	}

	private int Integer(String parameter) {
		// TODO Auto-generated method stub
		return 0;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
