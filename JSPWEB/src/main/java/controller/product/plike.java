package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dao.MemberDao2;
import model.dao.ProductDao;

@WebServlet("/product/plike")
public class plike extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public plike() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청
		MemberDao2 dao = new MemberDao2();
		int pno = Integer.parseInt(request.getParameter("pno")); 
		int mno = dao.getMno((String)request.getSession().getAttribute("mid")); // 세션을 이용하여 mid 가져오기 세션은 object라서 String로 형변환
		
		// 2. db 처리
		int result = new ProductDao().setplike( pno, mno );
		
		// 3. 응답
		response.getWriter().print(result); // 1 : 취소, 2 : 등록, 3 : 오류
	
	}

	
	
	
	
	
}
