package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonValue;

import model.dao.MemberDao2;
import model.dto.MemberDto2;

/**
 * Servlet implementation class infolist
 */
@WebServlet("/member/infolist")
public class infolist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public infolist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDao2 dao2 = new MemberDao2();
		ArrayList< MemberDto2 > list = dao2.getinfolist();

		// Dto ------> json
		// 1. JSONObject 여러개 담을수 있는 JSON리스트 선언 
		JSONArray array = new JSONArray();
		for( MemberDto2 dto2 : list ) {
			// 2. JSONObject 생성 
			JSONObject object = new JSONObject();	
			// 3. JSONObject 에 엔트리[정보] 담기
			object.put( "mno", dto2.getMno() );
			object.put( "mid", dto2.getMid() );
			object.put( "mname", dto2.getMname() );
			object.put( "mphone", dto2.getMphone() );
			object.put( "memail", dto2.getMemail() );
			object.put( "maddress", dto2.getMaddress() );
			object.put( "mdate", dto2.getMdate() );
			object.put( "mpoint", dto2.getMpoint() );
			array.add( object ); // 4. JSONObject 객체를 리스트에 담기
			
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print( array );
				
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
