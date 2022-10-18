package controller.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dto.BoardDto;

/**
 * Servlet implementation class bupdate
 */
@WebServlet("/board/bupdate")
public class bupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 서버 업로드 파일 경로 찾기
		String uploadpath = request.getSession().getServletContext().getRealPath("/upload");
		
		// 2. MultipartRequest 객체 생성 
		MultipartRequest mulit = new MultipartRequest(
				request,
				uploadpath,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy());
	
		// 3. 요청
		String btitle = mulit.getParameter("btitle");		// 수정할 제목
		String bcontent = mulit.getParameter("bcontent");	// 수정할 내용
		String bfile = mulit.getFilesystemName("bfile");	// 새로운 첨부파일
		
			
		// 수정할 게시물의 번호 가져오기
		int bno = (Integer)request.getSession().getAttribute("bno");
		
		// 수정 전 게시물 번호 
		BoardDto bdto = BoardDao.getInstance().getboard(bno);
		
		// * 기존 첨부파일 변경 여부 판단
		boolean bfilechange = true;
		
		// 2. 수정 시 새로운 첨부파일 등록이 없을 경우 [ 기존 첨부 파일 호출 ]
		if( bfile == null ) {
			bfile = bdto.getBfile();
			bfilechange = false;
		}
		
		// 4. Dao 처리 [ 업데이트 = 새로운 첨부파일 ]
		boolean result = BoardDao.getInstance().bupdate( bno, btitle, bcontent, bfile);
		
		if ( result ) { // 업데이트 성공 시 [ 첨부 파일이 변경되었을 경우 ] 기존 파일 삭제
			if ( bfilechange ) {
				String deletepath = request.getSession().getServletContext().getRealPath("/upload/"+bdto.getBfile());
				File file = new File(deletepath);
				if ( file.exists() ) file.delete();
			}
		}
		
		// 5. 결과반환
		response.getWriter().print(result);
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

