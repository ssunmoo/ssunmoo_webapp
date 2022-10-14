package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dao.MemberDao2;

/**
 * Servlet implementation class write
 */
@WebServlet("/board/write")
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public write() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		String mid = (String)request.getSession().getAttribute("mid");	// 1. 로그인 세션 [ 로그인한 사람의 아이디 ]
//		MemberDao2 mdao2 = new MemberDao2();							// 2. 회원 아이디 --> 회원번호
//		int mno = mdao2.getMno(mid);										
//		System.out.println(mid);										// 값 잘 들어왔는지 확인하기
//		
//		String btitle = request.getParameter("btitle");					// 3. 입력 받은 데이터1 요청
//		String bcontent = request.getParameter("bcontent");				// 3. 입력 받은 데이터2 요청
//		
//		boolean reuslt = BoardDao.getInstance().write(btitle, bcontent, mno);	// 4. Dao 호출하여 [ 저장 ]
//		System.out.println("쓴값 받아오기 타이틀: " + btitle);
//		System.out.println("쓴값 받아오기 내용: " + bcontent);
//		System.out.println("쓴값 받아오기 회원번호: " + mno);
//		System.out.println( reuslt );
//		
//		// ajax 전용
//		response.getWriter().print(reuslt);										// 5. 아작스에게 결과 넘겨주기
		
		
//		//  페이지 전환 form 전용
//		if( reuslt ) {
//			response.sendRedirect("list.jsp");
//		}
//		else {
//			response.sendRedirect("write.jsp");
//		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1. 첨부파일[ cos.jar 라이브러리 필요 ]
		// 2. HttpServletRequest : 첨부파일 지원 x [ 소량의 문자 가능 ]
		// 3. MultipartRequest : 첨부파일 지원o [ 대용량의 문자 가능 ]
			// 첨부파일 : http post 메소드 지원
		// new MultipartRequest( 1.요청방식, 2.파일저장경로, 3.최대용량범위(바이트), 4.인코딩타입, 5.기타(보안기능))
				// 1비트( 0, 1 ) -> 1바이트( 01011111 : 8비트 ) -> 1kb(1024b) --> 1mb ( 1024kb)
		
		// 1. 저장 경로 [ 프로젝트 저장 ]
		String uploadpath = "C:\\Users\\504\\git\\ssunmoo_webapp\\JSPWEB\\src\\main\\webapp\\upload";
		
		
		// 2. Multipart 객체 생성
		MultipartRequest multi = new MultipartRequest(
					request, 			// 1. 요청방식
					uploadpath, 		// 2. 저장 경로
					1024 * 1024 *10,	// 3. 용량 10MB		[ 1024 : 1kb / 1024*1024 : 1mb / 1024*1024*1024 : 1G ]
					"UTF-8",			// 4. 인코딩
					new DefaultFileRenamePolicy() // 5. 업로드된 파일의 이름이 중복일 경우 자동으로 이름 변경
				
			); // 생성자 종료
		
		// 3. 해당 저장 경로에 첨부파일이 업로드 됨
		
		// 4. 나머지 데이터를 직접 요청
		String btitle = multi.getParameter("btitle");	// request -> multi 파트 사용
		System.out.println(btitle); // 확인용
	
		String bcontent = multi.getParameter("bcontent");	// request -> multi 파트 사용
		System.out.println(bcontent); // 확인용
		
		// DB에 저장할 파일을 식별하기 위해 첨부파일 경로/이름 호출
		String bfile = multi.getFilesystemName("bfile"); // 첨부된 파일 이름 호출시 getFilesystemName 
		System.out.println(bfile);
		
		// 5. 회원아이디 --> 회원번호로 호출
		MemberDao2 mdao = new MemberDao2();
		int mno = mdao.getMno((String)request.getSession().getAttribute("mid"));
		
		// 6. DB 처리
		boolean result = BoardDao.getInstance().write(btitle, bcontent, mno, bfile );
		
		// 7. 응답
		response.getWriter().print(result);
		
	
	
	
	
	
	}

}
