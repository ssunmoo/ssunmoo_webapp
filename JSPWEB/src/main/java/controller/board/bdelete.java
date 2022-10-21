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

		// 2. 삭제할 게시물 호출
		BoardDto bdto = BoardDao.getInstance().getboard(bno);

		// 3. Dao 처리 [ DB내 데이터 삭제 ]
		boolean result = BoardDao.getInstance().bdelete( bno );
		if( result ) {
			String deletepath = request.getSession().getServletContext().getRealPath("/upload/"+ bdto.getBfile() );
			File file = new File( deletepath );
			if( file.exists() ) file.delete(); // 해당 경로에 존재하는 파일 삭제 기능
			// File 클래스
			// 자바 외부에 존재하는 파일 조작/제어 메소드를 제공하는 클래스
			// 1. 객체명.length() : 해당 파일의 바이트 길이
			// 2. 객체명.delete() : 해당 파일 삭제
			// 3. 객체명.exists() : 해당 파일이 존재하면 true 아니면 false
		
		}
		
		// 3. 결과 전송
		response.getWriter().print(result);
		
		
	
	
	
	
	
	
	
	
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
