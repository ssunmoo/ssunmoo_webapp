package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao2;

/**
 * Servlet implementation class update
 */
@WebServlet("/member/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 식별자 필요 -> 로그인 정보 -> 세션에 저장되어있음 -> "mid"
		// 회원 가입 시 중복 확인했기 때문에 아이디로 사용 가능
		String mid = (String)request.getSession().getAttribute("mid");
		
		// 수정할 내용
		String mname = request.getParameter("mname");
		
		MemberDao2 mdao = new MemberDao2();
		
		boolean result = mdao.update( mid, mname );
		response.getWriter().print(result);
	
	
	
	
	
	
	
	
	
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
