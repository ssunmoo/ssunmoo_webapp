package board.Controller.Member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Model.Dao.RegistDao;
import Model.Dto.RegistDto;

/**
 * Servlet implementation class board_list
 */
@WebServlet("/Board/board_list")
public class board_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public board_list() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RegistDao rdao = new RegistDao();
		
		// 1. 페이지당 게시물 수 값 가져오기
		int list_size = Integer.parseInt(request.getParameter("list_size"));
		
		// 2. 전체 게시물 수
		int total_size = rdao.get_total_size();
		
		// 3-1. 전체 페이지 수 계산하기
		int total_page = 0;
		if ( total_size % list_size == 0 ) {
			// 페이지당 게시물 수로 전체 게시물 수를 나눴을때
			
			total_page = total_size / list_size;
			// 나머지가 없으면 
		}
		else {
			total_page = total_size / list_size +1;
			// 나머지가 있으면
		}
		
		// 3-2. 현재 페이지 수 값 가져오기
		int page = Integer.parseInt(request.getParameter("page"));
		
		// 3-3. 페이지별 시작 게시물 행 번호
		int start_row = (page-1) * list_size;
		// 시작 행 번호는 현재 페이지수-1 * 페이지당 게시물 수
		
		// 3-4. 화면에 표시할 최대 버튼 수
		int btn_size = 3;
		
		// 버튼 시작 번호
		int start_btn = ( (page-1) / btn_size ) * btn_size +1;
		
		// 버튼 끝 번호
		int end_btn = start_btn + ( btn_size-1 );
		
		// 만약에 end_btn이 마지막 페이지보다 클 경우 마지막 버튼 번호는 마지막 페이지 번호로
		if ( end_btn > total_page ) {
			end_btn = total_page;
		}
		
		// * 페이징 처리에 필요한 정보를 담을 제이슨 오브젝트 선언하기 * 
		JSONObject boards = new JSONObject();
		JSONArray list = rdao.board_list();
		
		boards.put("total_page", total_page);
		boards.put("data", list);
		boards.put("start_btn", start_btn);
		boards.put("end_btn", end_btn);
		boards.put("total_size", total_size);
				
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print( boards );
		System.out.println("서블릿 boards : "+boards);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
