package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.BoardDao;
import model.dto.BoardDto;

/**
 * Servlet implementation class list
 */
@WebServlet("/board/list")
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public list() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 페이지당 게시물 수
		int listsize = Integer.parseInt(request.getParameter("listsize")); 
		
		// 2. 전체 게시물 수
		int totalsize = BoardDao.getInstance().gettotalsize();
		
		// 3-1. 전체 페이지 수 계산
		int totalpage = 0;
		if( totalsize % listsize == 0 ) {		
			totalpage = totalsize / listsize;	
			// 나머지가 없으면
		}
		else {
			totalpage = totalsize / listsize +1;
			// 나머지가 존재하면 나머지를 표시할 페이지 +1
		}
		// 3-2. 현재 페이지 수
		int page = Integer.parseInt( request.getParameter("page") );
		
		// 3-3. 페이지별 시작 게시물 행번호
		int startrow = (page-1)*listsize;
		
		// 3-4. 화면에 표시할 최대 버튼 수
		int btnsize = 5;		// 버튼을 5개씩 표시 [ 몫 : 현재 페이지가 최대 버튼수보다 커지면 ]
		
		// 버튼 시작 번호
		int startbtn = ( (page-1) / btnsize ) * btnsize +1;	
		
		// 버튼 끝 번호
		int endbtn = startbtn + (btnsize-1);			
		
		//	만약에 endbtn이 마지막 페이지보다 클 경우 마지막 버튼 번호는 마지막 페이지 번호
		if ( endbtn > totalpage ) {
			endbtn = totalpage;
		}
		
		
		// * 페이징 처리에 필요한 정보는 담은 jsonobject
		JSONObject boards = new JSONObject();
		
		// 2. DB
		ArrayList<BoardDto> list = BoardDao.getInstance().getlist( startrow, listsize );
		
		JSONArray array = new JSONArray();
		// arraylist --> jsonarray로 변환하기 [ js에서 사용해야되므로 ]
		for( int i = 0; i < list.size(); i++ ) {
			
			JSONObject object = new JSONObject();
			object.put("bno", list.get(i).getBno());
			object.put("btitle", list.get(i).getBtitle());
			object.put("bdate", list.get(i).getBdate());
			object.put("bview", list.get(i).getBview());
			object.put("mid", list.get(i).getMid());
			array.add(object);
		}
		
		// 3. 응답
		boards.put("totalpage", totalpage);
		boards.put("data", array);
		boards.put("startbtn", startbtn);
		boards.put("endbtn", endbtn);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(boards);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
