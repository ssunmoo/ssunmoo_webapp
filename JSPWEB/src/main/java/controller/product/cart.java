package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.dao.MemberDao2;
import model.dao.ProductDao;
import model.dto.CartDto;

/**
 * Servlet implementation class cart
 */
@WebServlet("/product/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1. 요청
		MemberDao2 dao2 = new MemberDao2();
		int mno = dao2.getMno((String)request.getSession().getAttribute("mid"));
		// 2. db 처리
		ArrayList< CartDto > list = new ProductDao().getcart(mno);
		
		// 3. 형변환
		JSONArray array = new JSONArray();
		for ( CartDto dto : list ) {
			JSONObject object = new JSONObject();
			object.put("cartno", dto.getCartno());
			object.put("pstno", dto.getPstno());
			object.put("pname", dto.getPname());
			object.put("pimg", dto.getPimg());
			object.put("pprice", dto.getPprice());
			object.put("pdiscount", dto.getPdiscount());
			object.put("pcolor", dto.getPcolor());
			object.put("psize", dto.getPsize());
			object.put("amount", dto.getAmount());
			array.add(object);
		}
		
		// 4. 응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청
		request.setCharacterEncoding("UTF-8");
		String data = request.getParameter("data");
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		MemberDao2 dao2 = new MemberDao2();
		int mno = dao2.getMno((String)request.getSession().getAttribute("mid")) ;
		
		// 문자열 --> JSON형 변환
		try {
			// 1. JSONParser 객체 생성
			JSONParser parser = new JSONParser();
			
			// 2. parser.parse( 문자열 );
			JSONArray array = (JSONArray) parser.parse(data);
			
			// 3. 반복문으로 데이터 뽑기
			for ( int i = 0; i < array.size(); i++ ) {
				JSONObject object = (JSONObject) array.get(i);	// 순서대로 객체 꺼내기
//				System.out.println( object.toString() );	// 확인
//				System.out.println(object.get("psize"));	
//				System.out.println(object.get("amount"));
//				System.out.println(object.get("pcolor"));
				
				// 4. db처리
				String psize = (String)object.get("psize"); System.out.println(psize);
				int amount = Integer.parseInt( String.valueOf( object.get( "amount" ) ) ); System.out.println(amount);
				String pcolor = (String)object.get("pcolor"); System.out.println(pcolor);
				
				boolean result = new ProductDao().setcart( pno, psize, amount, pcolor, mno );
				
				// 5. 응답 [ 만약에 옵션들 중 하나라도 실패하면 반환 ] 
				if( result == false ) { // 하나라도 실패가 뜰 경우
					response.getWriter().print(result);
					return;
				}
			}
		} catch (ParseException e) {
			System.out.println("JSON으로 변환 실패" + e);
		}
		// 6. 옵션들을 모두 저장했을 경우
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print( "true" );
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
	
}
