package controller.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDao;
import model.dto.BoardDto;

/**
 * Servlet implementation class bfiledelete
 */
@WebServlet("/board/bfiledelete")
public class bfiledelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public bfiledelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 삭제할 게시물 번호 = 현재 보고있는 게시물 번호 = 세션 ( object -> 형변환 )
		int bno = (Integer)request.getSession().getAttribute("bno");

		// 2. 삭제할 게시물 정보 호출
		BoardDto bdto = BoardDao.getInstance().getboard(bno);
		
		// 3. Dao 처리 [ 업데이트 ]
		boolean result = BoardDao.getInstance().bfiledelete( bno );
		
		// 4. 실제 파일 삭제 처리
		if( result ) {
			String deletepath = request.getSession().getServletContext().getRealPath("/upload/"+bdto.getBfile());
			File file = new File(deletepath);
			if( file.exists() ) file.delete();
		
		}
		// 5. 반환
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
