package board.Controller.Member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Model.Dao.RegistDao;

/**
 * Servlet implementation class b_select_view
 */
@WebServlet("/Board/board_select_view")
public class board_select_view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public board_select_view() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RegistDao rdao = new RegistDao();
		JSONArray list = rdao.select_view();
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(list);
		
		System.out.println("서블릿리스트"+list);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
