package controller.member;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dto.MemberDto;

@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public signup() {
		super();
	}

    
    // 일단 뷰라고 생각하고 작성하기..
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
//		// 입력
//		Scanner scan = new Scanner(System.in);
//		System.out.println(" ▷ 아이디 : ");
//		String id = scan.next();
//		System.out.println(" ▷ 비밀번호 : ");
//		String pw = scan.next();
//		System.out.println(" ▷ 이름 : ");
//		String name = scan.next();
//		System.out.println(" ▷ 연락처 : ");
//		String phone = scan.next();

		
		// 폼으로 전송받은 변수를 요청하기 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");

		// 1. 입력받은 변수 4개를 dto 하나로 객체화
		MemberDto dto = new MemberDto(id, pw, name, phone);
		
		// 2. 입력 값이 dto에 제대로 들어갔는지 확인 
		System.out.println(dto.toString());
		
		// 3. MemberDao 호출
		boolean result = MemberDao.getInstence().signup(dto);
		if ( result ) {
			System.out.println(" [회원가입 성공] ");
		}
		else {
			System.out.println(" [회원가입 실패] ");
		}
		
		
		
		
		
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}


    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	doGet(request, response);
	}

}
