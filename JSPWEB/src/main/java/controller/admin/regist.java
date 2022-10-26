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
public class regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public regist() {
        super();
        // TODO Auto-generated constructor stub
    }

    // 제품 출력 : GET 사용
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList< ProductDto > list = new ProductDao().getProductlist();
		
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
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		
		
		
		
	}

	// 제품 등록 : POST 사용
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 첨부파일이 있을 경우에만 사용 [ 업로드용 ]
		MultipartRequest multi = new MultipartRequest(
				request,
				request.getSession().getServletContext().getRealPath("/admin/pimg"),
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
		
		
	}

}
