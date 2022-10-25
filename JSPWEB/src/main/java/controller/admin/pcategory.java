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

import model.dao.ProductDao;
import model.dto.PcategoryDto;

/**
 * Servlet implementation class pcategory
 */
@WebServlet("/board/pcategory")
public class pcategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public pcategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 2. db 처리
		ArrayList< PcategoryDto > list = new ProductDao().getPcategory();
		
		// 3. 리스트 -> json으로 변환
		JSONArray array = new JSONArray();
		for ( PcategoryDto dto : list ) {
			JSONObject object = new JSONObject();
			object.put("pcno", dto.getPcno());
			object.put("pcname", dto.getPcname());
			array.add(object);
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
	
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청
		request.setCharacterEncoding("UTF-8");
		String pcname = request.getParameter("pcname");
		
		// 2. Dao 처리
		boolean result = new ProductDao().setPcategory(pcname);
		// ProductDao dao = new ProductDao(); 로 안쓰고 이렇게 한줄만 써도됨
		
		// 3. 값 전달
		response.getWriter().print(result);
		
		
	}

	
	
	
	
	
	
	
	
	
}
