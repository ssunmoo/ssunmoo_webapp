package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.dao.MemberDao;
import model.dao.MemberDao2;
import model.dto.MemberDto2;

/**
 * Servlet implementation class info
 */

@WebServlet("/member/info")
public class info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 요청
		String mid = (String)request.getSession().getAttribute("mid");
		
		// 2. db
		MemberDao2 dao2 = new MemberDao2();
		MemberDto2 dto2 = dao2.getinfo(mid);
		
//		// 3. 서비스 로직
//		String result = "성공";
		
		// ** JS DTO 사용 x
			// 1. js 이해할수 있는 형식 변경 [ JSON 방슥 ]
			// 2. DTO -> JSON 박식 [ java 제공 x -> 외부 라이브러리 사용 ]
		// System.out.println("서블릿 : " + dto2 );
		
		JSONObject object = new JSONObject();

		object.put("mno", dto2.getMno());
		object.put("mid", dto2.getMid());
		object.put("mname", dto2.getMname());
		object.put("mphone", dto2.getMphone());
		object.put("memail", dto2.getMemail());
		object.put("maddress", dto2.getMaddress());
		object.put("mdate", dto2.getMdate());
		object.put("mpoint", dto2.getMpoint());

		// 4. 응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print( object );
	
	
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
