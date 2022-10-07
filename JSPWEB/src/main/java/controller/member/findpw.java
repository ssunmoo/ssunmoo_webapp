package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao2;

/**
 * Servlet implementation class findpw
 */
@WebServlet("/member/findpw")
public class findpw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public findpw() {
    
    
    }
    
    String randstr = "";	// 랜덤 문자를 저장할 문자열 [ 임시 비밀번호 ]
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 0. 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 1. ajax 변수 요청
		String mid = request.getParameter("mid");
		String memail = request.getParameter("memail");
		
		// 2. 메소드 호출
		MemberDao2 dao2 = new MemberDao2();
		boolean result = dao2.findpw(mid, memail);
		
		// 3. 아이디와 이메일이 동일할 경우에만 임시번호 생성
		if ( result ) {
			// 문자 난수 15자리 : 랜덤클래스 사용 [ 임시 비밀번호 ] 
			Random random = new Random();
			for( int i = 0; i < 15; i++ ) {
				randstr += (char)(random.nextInt(26)+97);	// 숫자 ->  [ 문자로 ] 강제형변환
									// 영문 소문자[아스키코드] 	: 97~122
									// random.nextInt(26) 	: 0 ~ 25
									// random.nextInt(26)+97: 97~122
									// 강제형변환 (char)random.nextInt(26)+97 : a ~ z
			}
			// 해당 회원의 비밀번호를 임시 담당하는시
			dao2.pwchange(mid, memail);
		}
		// 4. 반환
		response.getWriter().print( randstr );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
