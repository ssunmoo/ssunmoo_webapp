package controller.board;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class filedown
 */
@WebServlet("/board/filedown")
public class filedown extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public filedown() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// [ 업로드 된 파일을 다운로드하기 ]
		// 1. 다운로드할 파일명 요청
		request.setCharacterEncoding("UTF-8");			// 한글인코딩
		String bfile = request.getParameter("bfile");	// 다운로드할 파일 요청
		
		// 2. [ 업로드 된 경로 + 파일명 ]으로 해당 파일위치 찾기
		String uploadpath = "C:\\Users\\504\\git\\ssunmoo_webapp\\JSPWEB\\src\\main\\webapp\\upload\\"+bfile;
		
		// System.out.println(bfile);
		// 3. 해당 경로의 파일을 객체화 [ java에서 File 클래스 지원 ]
		File file = new File(uploadpath);	// 해당 경로에 존재하는 파일을 객체화해서 불러오기 [ 해당 파일을 조작, 메소드 사용 가능 ]
		
		// 4. HTTP에서 지원하는 다운로드 메소드 [ response ]
		response.setHeader(
				"Content-Disposition",	// 다운로드 형식 HTML에서 지원 [ 브라우저 차이 있음 ]
				"attachment;filename="	// 파일 다운로드 시 명시된 파일명
				+ URLEncoder.encode(bfile, "UTF-8"));
				// 한글 파일명이 있을 수 있으므로 URLEncoder.encode(데이터, "UTF-8")으로 인코딩
			
		
		// 5. 파일 전송 [ 외부와 데이터를 통신(스트림) : 바이트 단위 ]
			// 1. [ 입력 스트림 객체 생성 ] 파일의 내용물을 바이트로 모두 읽기
			BufferedInputStream fin = new BufferedInputStream( new FileInputStream(file) );
			
			// 2. 파일의 바이트 길이 만큼 배열 선언
			byte[] bytes = new byte[ (int)file.length() ]; // file.length() 해당 파일의 바이트 길이 메소드
			
			// 3. 파일의 내용[ 바이트 ] 읽어오기 
			fin.read( bytes );	// 읽어온 바이트를 바이트 배열에 저장
			
			// 4. [ 출력 스트림 객체 생성 ]
			// http로 출력하기 위한 response.getOutputStream()
			BufferedOutputStream fout = new BufferedOutputStream( response.getOutputStream()); 
			// 5. 배열에 존재하는 바이트 출력
			fout.write(bytes);	// 바이트 배열에 저장된 바이트를 모두 내보내기
			
			
			// ** 스트림은 버퍼( 전송 시 사용되는 메모리 공간 = 대용량에서는 전송 후 꼭 초기화 )를 사용하므로 사용 후 버퍼를 닫아줘야함
			fout.flush();	// 출력 스트림 버퍼 초기화
			fin.close();	// 입력 스트림 닫기
			fout.close();	// 출력 스트림 닫기
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
