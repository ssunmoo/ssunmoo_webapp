package board.Controller.Member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import Model.Dao.RegistDao;

/**
 * Servlet implementation class reply_view
 */
@WebServlet("/Board/reply_view")
public class reply_view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public reply_view() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		RegistDao rdao = new RegistDao();
		JSONArray array = rdao.reply_view();
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print( array );

	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
