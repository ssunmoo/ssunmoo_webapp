package board.Controller.Member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Dao.RegistDao;

/**
 * Servlet implementation class view_reply
 */
@WebServlet("/Board/view_reply")
public class view_reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public view_reply() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int b_no = Integer.parseInt(request.getParameter("b_no"));
		RegistDao rdao = new RegistDao();
		
		
	
	
	
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
