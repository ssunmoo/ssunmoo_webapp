package board.Controller.Member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Dao.RegistDao;

/**
 * Servlet implementation class view_plus
 */
@WebServlet("/Board/view_plus")
public class view_plus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view_plus() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int b_no = Integer.parseInt(request.getParameter("b_no"));
		RegistDao rdao = new RegistDao();
		boolean result = rdao.view_plus(b_no);
		response.getWriter().print(result);
	
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
