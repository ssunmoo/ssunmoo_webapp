package model.dao;

import model.dto.MemberDto2;

public class MemberDao2 extends Dao {

	// 기능메소드 구현
	// 1. 회원가입 메소드
	
	public boolean signup( MemberDto2 dto2 ) {
		
		String sql = "insert into"
				+ " member(mid, mpw, mname, mphone, memail, maddress)"
				+ " values(?, ?, ?, ?, ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto2.getMid());
			ps.setString(2, dto2.getMpw());
			ps.setString(3, dto2.getMname());
			ps.setString(4, dto2.getMphone());
			ps.setString(5, dto2.getMemail());
			ps.setString(6, dto2.getMaddress());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println( e );
		}
		return false;
	} // signup 메소드 종료
	
	
	public boolean login( String mid, String mpw ) {
		
		String sql = "select * from member where mid = ? and mpw = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpw);
			rs = ps.executeQuery();
			if( rs.next() ) { // 레코드가 존재하면
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		} 
		return false;
	} // login 메소드 종료
	
	
	
	
}
