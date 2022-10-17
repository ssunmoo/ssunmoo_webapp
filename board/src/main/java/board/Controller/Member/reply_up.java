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
 * Servlet implementation class view_reply
 */
@WebServlet("/Board/reply_up")
public class reply_up extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public reply_up() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String r_reply = request.getParameter("r_reply");
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		
		RegistDao rdao = new RegistDao();
		boolean result = rdao.reply_up(r_reply, b_no );

		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
