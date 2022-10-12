package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao2;

/**
 * Servlet implementation class emailcheck
 */
@WebServlet("/member/emailcheck")
public class emailcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public emailcheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String memail = request.getParameter("memail");
	MemberDao2 mdao = new MemberDao2();
	
	boolean result = mdao.emilcheck( memail );
	response.getWriter().print(result);
	
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
