package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDao;

/**
 * Servlet implementation class bdelete
 */
@WebServlet("/board/bdelete")
public class bdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public bdelete() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1. 삭제할 번호 요청
		int bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("서블릿bno :"+bno);
		
		// Dao 처리
		
		boolean result = BoardDao.getInstance().bdelete( bno );
		response.getWriter().print(result);
		
	
	
	
	
	
	
	
	
	
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
