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
import model.dto.OrderDto;
import model.dto.ProductDto;

@WebServlet("/product/order")
public class order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public order() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String data = request.getParameter("data");			// 결제할 제품 리스트 [문자열]
		String oinfo = request.getParameter("oinfo");		// 수령인 정보 [문자열]
		
		MemberDao2 dao2 = new MemberDao2();
		int mno = dao2.getMno((String)request.getSession().getAttribute("mid")); // 주문자 회원번호
		// Integer.parseInt((String)request.getSession().getAttribute("mid"));	// 주문자 회원번호
		
		// System.out.println("data" + data);
		// System.out.println("oinfo" + oinfo);
		
		// 문자열 타입 JSON 방식 --> JSON 타입 형변환
		JSONParser parser = new JSONParser();
		
		try {
			
			// 1. 객체 [ 회원정보 문자열 --> JSON 1개라서 : object]
			JSONObject jsonObject = (JSONObject) parser.parse( oinfo );
			
			// 수령자 정보
			String oname = String.valueOf(jsonObject.get("oname"));
			String ophone =	String.valueOf(jsonObject.get("ophone"));
			String oaddress = String.valueOf(jsonObject.get("oaddress"));
			String orequest = String.valueOf(jsonObject.get("orequest"));
			
			
			// 2. 리스트 [ 결제할 제품 리스트 문자열 -> JSONArray : 여러개라서 array]
			JSONArray jsonArray = (JSONArray) parser.parse( data );
			
			
			// 주문 Dto를 담을 리스트
			ArrayList< OrderDto > list = new ArrayList<>();
			
			// 3-1. 반복문 [ orderDto 객체 -> Dao 처리 ]
			for( int i = 0; i < jsonArray.size(); i++ ) {
				JSONObject object = (JSONObject)jsonArray.get(i);
						
				// 주문 상세 정보
				int odamount = Integer.parseInt(String.valueOf(object.get("amount")));
				int pprice = Integer.parseInt(String.valueOf(object.get("pprice")));
				float pdiscount = Float.parseFloat(String.valueOf(object.get("pdiscount")));
				int odprice = Math.round(pprice -(pprice * pdiscount));
				int pstno = Integer.parseInt(String.valueOf(object.get("pstno")));
				
				// 주문 Dto 생성
				OrderDto dto = new OrderDto(
						0, oname, ophone, oaddress, orequest, null, mno, 0, odamount, odprice, 0, pstno );
			
				// 정보 잘 담겼는지 확인
				System.out.println(dto.toString()); 
				
				// 리스트에 담기
				list.add(dto);
				// System.out.println(list); 
			} // for e
			
			// 3-2. 주문 상세 DB 처리
			boolean result = new ProductDao().setOrder( list );
			response.getWriter().print( result ); // 성공 시
			
		} catch (ParseException e) {
			System.out.println("제이슨 형변환 오류 : " + e);
		} response.getWriter().print( "false" ); // 오류 시 false
		
		
		
		
		
		
		
	}

}
