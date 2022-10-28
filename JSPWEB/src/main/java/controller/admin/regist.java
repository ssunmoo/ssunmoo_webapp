package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.ProductDao;
import model.dto.ProductDto;

/**
 * Servlet implementation class regist
 */
@WebServlet("/admin/regist")
public class regist extends HttpServlet { // HttpServlet : Http 에 대한 속성을 상속 받음
	private static final long serialVersionUID = 1L;
       
    public regist() {
        super();
        // TODO Auto-generated constructor stub
    }

	// 1. 제품 등록 : POST 사용
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 첨부파일이 있을 경우에만 사용 [ 업로드용 ]
		MultipartRequest multi = new MultipartRequest(
				request,
				request.getSession().getServletContext().getRealPath("/admin/pimg"), // getRealPath : 배포한 서버의 경로
				1024*1240*10,
				"UTF-8",
				new DefaultFileRenamePolicy());
		
		String pname = multi.getParameter("pname");
		String pcomment = multi.getParameter("pcomment");
		int pprice = Integer.parseInt(multi.getParameter("pprice"));
		float pdiscount = Float.parseFloat(multi.getParameter("pdiscount"));
		String pimg = multi.getFilesystemName("pimg");	// 첨부파일이어서 getparameter 안됨
		
		int pcno = Integer.parseInt(multi.getParameter("pcno"));
		
		ProductDto dto = new ProductDto(0, pname, pcomment, pprice, pdiscount, (byte)0, pimg, null, pcno );
		// System.out.println( dto.toString());

		boolean result = new ProductDao().setProduct(dto);
		response.getWriter().print(result);
		
	} // doPost e
	
	
	// 2. 제품 출력 : GET 사용
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// * type : 1 [ 모든 제품 출력 ] type : 2 [ 개별 제품 출력 ]
		String type = request.getParameter("type");
		
		response.setCharacterEncoding("UTF-8");
		
		if( type.equals("1")) {	// type : 1 [ 모든 제품 출력 ]
			
			// 1. 전체출력 2. 판매중만 출력
			String option = request.getParameter("option");
			
			ArrayList< ProductDto > list = new ProductDao().getProductlist( option );
			// ArrayList -> JSON로 변환
			JSONArray array = new JSONArray();
			for( int i = 0; i < list.size(); i++ ) {
				JSONObject object = new JSONObject();
				
				object.put("pno", list.get(i).getPno());
				object.put("pname", list.get(i).getPname());
				object.put("pcomment", list.get(i).getPcomment());
				object.put("pprice", list.get(i).getPprice());
				object.put("pdiscount", list.get(i).getPdiscount());
				object.put("pactive", list.get(i).getPactive());
				object.put("pimg", list.get(i).getPimg());
				object.put("pdate", list.get(i).getPdate());
				object.put("pcno", list.get(i).getPcno());
				array.add(object);
			}
			response.getWriter().print(array);
			
		}else if ( type.equals("2")) { // type : 2 [ 개별 제품 출력 ]
			
			// 1. 호출할 제품번호 요청
			int pno = Integer.parseInt(request.getParameter("pno"));
			
			// 2. db 처리
			ProductDto dto = new ProductDao().getProduct( pno );
			
			// 3. dto -> json 처리
			JSONObject object = new JSONObject();
			
			object.put("pno", dto.getPno());
			object.put("pname", dto.getPname());
			object.put("pcomment", dto.getPcomment());
			object.put("pprice", dto.getPprice());
			object.put("pdiscount", dto.getPdiscount());
			object.put("pactive", dto.getPactive());
			object.put("pimg", dto.getPimg());
			object.put("pdate", dto.getPdate());
			object.put("pcno", dto.getPcno());
			
			// 4. 응답
			response.getWriter().print(object);
		}
		
	} // doGet e
	
	
	// 3. 제품 수정 [ put ] 업데이트 시 사용
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 첨부파일이 있을 경우에만 사용 [ 업로드용 ]
		MultipartRequest multi = new MultipartRequest(
				request,
				request.getSession().getServletContext().getRealPath("/admin/pimg"), // getRealPath : 배포한 서버의 경로
				1024*1240*10,
				"UTF-8",
				new DefaultFileRenamePolicy());
		
		// 수정할 대상 리스트
		int pno = Integer.parseInt(multi.getParameter("pno")); 
		String pname = multi.getParameter("pname");
		String pcomment = multi.getParameter("pcomment");
		int pprice = Integer.parseInt(multi.getParameter("pprice"));
		float pdiscount = Float.parseFloat(multi.getParameter("pdiscount"));
		byte pactive = Byte.parseByte(multi.getParameter("pactive"));
		String pimg = multi.getFilesystemName("pimg");	// 첨부파일이어서 getparameter 안됨
		int pcno = Integer.parseInt(multi.getParameter("pcno")); 
		
		
		ProductDto dto = new ProductDto(pno, pname, pcomment, pprice, pdiscount, pactive, pimg, null, pcno );
		// System.out.println( dto.toString());
		
		boolean result = new ProductDao().updateproduct(dto);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
		
		
	} // doPut e
	
	
	// 4. 제품 삭제 [ delete ]
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 삭제할 제품 번호 요청
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		// 2. dao
		boolean result = new ProductDao().deleteproduct(pno);		
		
		//3. 응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
		
		
		
	} // doDelete e
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
