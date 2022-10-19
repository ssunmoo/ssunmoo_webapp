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
 * Servlet implementation class rwrite
 */
@WebServlet("/reply/rwrite")
public class rwrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public rwrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 [ 공통 ]
		request.setCharacterEncoding("UTF-8");
		
		// 댓글 내용 , 작성자 번호, 게시물 번호
		String rcontent = request.getParameter("rcontent");
		
		// 세션에 저장되어있는 mid를 불러와서 mno에 접근 함
		MemberDao2 mdao2 = new MemberDao2();
		int mno = mdao2.getMno((String)request.getSession().getAttribute("mid"));
		
		// *** 로그인을 안했을 경우 [ 비회원 ]
		if( mno == 0 ) {
			response.getWriter().print("0");
			return;
		}
		
		// 게시물 번호 가져오기
		int bno = (Integer)request.getSession().getAttribute("bno");
			
		// 타입 요청 [ 0 : 댓글 , 1 : 대댓글 ]
		String type = request.getParameter("type");
		
		
		boolean result = false;
		// DB처리 2가지 경우
		if ( type.equals("reply") ) { // 댓글일 경우
			result = BoardDao.getInstance().rwrite( rcontent, mno, bno ); // db처리
			
		}
		else if ( type.equals("rereply") ) { // 대댓글일 경우
			
			int rindex = Integer.parseInt( request.getParameter("rno") );
			result = BoardDao.getInstance().rrwrite( rcontent, mno, bno, rindex ); // db처리
		
		}
		
		
		// 3. 결과 반환
		if ( result ) {
			// 댓글 등록이 성공했을 경우
			response.getWriter().print("1");
		}
		else {
			// 댓글 등록이 실패했을 경우
			response.getWriter().print("2");
		}
		
	
		
	
	
	
	
	
	
	
	}

}
