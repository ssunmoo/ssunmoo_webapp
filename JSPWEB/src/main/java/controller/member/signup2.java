package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao2;
import model.dto.MemberDto2;

// @WebServlet("/member/signup2") 해당 클래스를 호출하는 URL 정의
@WebServlet("/member/signup2")	// 해당 클래스로 연결(매핑) URL 설정
public class signup2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public signup2() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// *** 한글 인코딩 *** 이거 안넣으면 한글 안들어감
		request.setCharacterEncoding("UTF-8");
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mpwconfirm = request.getParameter("mpwconfirm");
		String mname = request.getParameter("mname");
		String mphone = request.getParameter("mphone");
		String memail = request.getParameter("memail");
		
		//주소 4개 요청
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String address3 = request.getParameter("address3");
		String address4 = request.getParameter("address4");
		
		String maddress = address1+","+address2+","+address3+","+address4;
		
		// 변수 6개 Dto2 객체화
		MemberDto2 dto2 = new MemberDto2(0, mid, mpw, mname, mphone, memail, maddress, null, 0);
		System.out.println(dto2.toString());
		
		// Dao 메소드 호출용 객체 선
		MemberDao2 dao2 = new MemberDao2();

		// 결과 제어
		boolean result = dao2.signup(dto2);
		if( result ) {
			response.sendRedirect("/JSPWEB/member/login.jsp");
		}
		
		
		
//		if( result ) {
//			System.out.println(" [ 회원가입 성공 ] ");
//		}
//		else {
//			System.out.println(" [ 회원가입 실패 ] ");
//		}
		


	}

}
