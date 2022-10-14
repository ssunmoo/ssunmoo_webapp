package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.dao.BoardDao;
import model.dto.BoardDto;

/**
 * Servlet implementation class view
 */
@WebServlet("/board/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1. 세션 요청 [ 세션 (object) -> String -> int 형변환 ]
			// 다형성 : 부모가 자식에게 강제 형변환 가능
		
		int bno = (Integer)request.getSession().getAttribute("bno");
		System.out.println(bno);
	
		// 2. dao 처리
		BoardDto dto = BoardDao.getInstance().getboard(bno);
		
		// 3. dto -> json 현변환
		JSONObject object = new JSONObject();
		object.put("bno", dto.getBno());
		object.put("btitle", dto.getBtitle());
		object.put("bcontent", dto.getBcontent());
		object.put("mid", dto.getMid());
		object.put("bfile", dto.getBfile());
		
		// 삭제 수정 버튼을 활성화하기 위한 식별 변수 선언 [ 현재 게시글 작성자 판단 ]
		// 1. 로그인한 세션 정보 호출
		String mid = (String)request.getSession().getAttribute("mid");
		
		// 2. 로그인한 세션과 현재 게시물의 작성자가 일치하면
		if(mid != null && mid.equals( dto.getMid() )) {
			// 로그인 했으면서 로그인된 아이디가 현재 게시물의 작성자 아이디와 동일하면
			object.put("btnaction", true);
		}
		
		
		
		System.out.println("뷰 : " + object);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(object);
		
		// response.sendRedirect("../board/view.jsp");
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
