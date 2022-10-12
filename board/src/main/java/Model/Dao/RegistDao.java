package Model.Dao;

import java.io.Console;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Model.Dto.RegistDto;

public class RegistDao extends Dao {
	
	public boolean regist( String b_title, String b_content, String b_name, String b_pw ) {
		String sql = "insert into board( b_title, b_content, b_name, b_pw) values(?, ?, ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, b_title);
			ps.setString(2, b_content);
			ps.setString(3, b_name);
			ps.setString(4, b_pw);
			ps.executeUpdate();
			// System.out.println( dto.toString());
			return true;
			
		} catch (SQLException e) {
			System.out.println("DB연동에러 : " + e);
		}
		return false;
	} // regist 메소드 종료
	
	
	
	// 모든 게시글 출력
	public JSONArray board_list() {
		JSONArray list = new JSONArray();
		String sql = "select * from board";
		//String sql = "select b_no, b_title, b_content, b_name, b_date, b_view from board";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) { 
				
				JSONObject object = new JSONObject();
				object.put("b_no", rs.getInt(1));
				object.put("b_title", rs.getString(2));
				object.put("b_content", rs.getString(3));
				object.put("b_name", rs.getString(4));
				object.put("b_date", rs.getString(6));
				object.put("b_view", rs.getInt(7));
				
				list.add(object);
				// System.out.println(list);
			}
			return list;
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
		
	} // board_list 메소드 종료
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
