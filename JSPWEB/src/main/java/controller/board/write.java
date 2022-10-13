package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDao;
import model.dao.MemberDao2;

/**
 * Servlet implementation class write
 */
@WebServlet("/board/write")
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public write() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String mid = (String)request.getSession().getAttribute("mid");
		MemberDao2 mdao2 = new MemberDao2();
		int mno = mdao2.getMno(mid);
		
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		boolean reuslt = BoardDao.getInstance().write(btitle, bcontent, mno);
		System.out.println("쓴값 받아오기 타이틀: " + btitle);
		System.out.println("쓴값 받아오기 내용: " + bcontent);
		System.out.println("쓴값 받아오기 회원번호: " + mno);
		System.out.println( reuslt );
		
		// ajax 전용
		response.getWriter().print(reuslt);
		
		
//		//  페이지 전환 form 전용
//		if( reuslt ) {
//			response.sendRedirect("list.jsp");
//		}
//		else {
//			response.sendRedirect("write.jsp");
//		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
