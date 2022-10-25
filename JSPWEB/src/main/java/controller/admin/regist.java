package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

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
		
		ProductDto dto = new ProductDto(0, pname, pcomment, pprice, pdiscount, (byte)0, pimg, null, 0);
		System.out.println( dto.toString());
		System.out.println(pname);
		System.out.println(pcomment);
		System.out.println(pdiscount);
		System.out.println(pimg);
		
		
		
	}

}
