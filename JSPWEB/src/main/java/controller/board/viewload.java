package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.BoardDao;

@WebServlet("/board/viewload")
public class viewload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public viewload() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 요청 [ 클릭한 게시물의 번호 저장 = backend ]
		// ** 세션 : 웹서버에 저장할 수 있는 메모리 공간 -> 브라우저 마다 할당
			// 서버가 종료, 시간 타이머, 브라우저 종료
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// 2. 세션 객체 만들기
		HttpSession session = request.getSession();
		
		// 3. 클릭한 게시물 번호를 세션에 저장
		request.getSession().setAttribute("bno", bno);
		
		// 4. 로그인한 회원 아이디
		String mid = (String)session.getAttribute("mid");
		
		
		// 해당 유저가 24시간내 한번도 클릭한 적이 없으면 [ 세션이 없으면 ]
		if( session.getAttribute(bno+mid) == null ) {
			// 4. Dao 조회수 증가
			BoardDao.getInstance().bviewupdate( bno );
			
			// 3. 현재 유저가 조회한 기록 남기기 [ 해당 유저가 조회수를 올린적 있다 없다 ]
			request.getSession().setAttribute(bno+mid, true);
			request.getSession().setMaxInactiveInterval(60*60*24);  // 하루 동안		
			
		}
		
		
		
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
