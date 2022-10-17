package Model.Dao;

import java.io.Console;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Model.Dto.RegistDto;
import Model.Dto.ReplyDto;

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
			}
			return list;
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	} // board_list 메소드 종료
	
	
	// 선택한 게시글 상세보기 
	public JSONArray select_view() {
		JSONArray list = new JSONArray();
		String sql = "select * from board";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) { 
				
				JSONObject object = new JSONObject();
				object.put("b_no", rs.getString(1));
				object.put("b_title", rs.getString(2));
				object.put("b_content", rs.getString(3));
				object.put("b_name", rs.getString(4));
				object.put("b_date", rs.getString(6));
				object.put("b_view", rs.getInt(7));
				
				list.add(object);
				// System.out.println("다오리스트"+list);
			}
			// System.out.println("다오리스트"+list);
			return list;
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	} // board_list 메소드 종료
	
	
	// 게시글 삭제
	public boolean board_delete( String b_pw2 , int b_no){
		
		//String sql = "delete from board where b_pw = ?";
		String sql = "delete from board where b_pw = ? and b_no = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, b_pw2 );
			ps.setInt(2, b_no);
			int count = ps.executeUpdate();
			if ( count == 1) {
				return true;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	} // board_delete 메소드 종료
	
	
	// 조회수 증가
	public boolean view_plus( int b_no ) {
		String sql = "update board set b_view = b_view+1 where b_no = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, b_no);
			ps.executeUpdate();
			
			String sql2 ="select * from board";
			ps = con.prepareStatement(sql2);
			ps.executeQuery();
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
		
	} // view_plus 메소드 종료
	
	
	// 댓글 등록
	public boolean reply_up( String r_reply, int b_no ) {

		String sql = "insert into reply values(null, ?, 0, ? )";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, r_reply);
				ps.setInt(2, b_no);
				ps.executeUpdate();
				return true;
				
			} catch (Exception e) {
				System.out.println(e);
			}
			return false;
	}
	
	// 댓글 출력
	public JSONArray reply_view() {
		
		JSONArray array = new JSONArray();
		String sql = "select * from reply";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while ( rs.next() ) {
				JSONObject object = new JSONObject();
				object.put("r_reply", rs.getString(2));
				array.add(object);
			}
			return array;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return array;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
