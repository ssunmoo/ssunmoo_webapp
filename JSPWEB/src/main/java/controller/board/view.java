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
		object.put("mno", dto.getMno());
		
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
