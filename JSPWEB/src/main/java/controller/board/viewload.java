package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		request.getSession().setAttribute("bno", bno);
	
		System.out.println("비넘버: "+bno);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
