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
		JSONArray list = rdao.board_list();
		
		response.setCharacterEncoding("UTF-8");
		//System.out.println(list);
		response.getWriter().print( list );
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
