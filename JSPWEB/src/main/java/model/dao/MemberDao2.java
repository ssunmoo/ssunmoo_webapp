package model.dao;

import java.io.Console;

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
	
	
//	public boolean login( String mid, String mpw ) {
//		
//		String sql = "select * from member where mid = ? and mpw = ?";
//		
//		try {
//			ps = con.prepareStatement(sql);
//			ps.setString(1, mid);
//			ps.setString(2, mpw);
//			rs = ps.executeQuery();
//			if( rs.next() ) { // 레코드가 존재하면
//				return true;
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		} 
//		return false;
//	} // login 메소드 종료
	
	
	public int login( String mid, String mpw ) {
		
		String sql = "select * from member where mid = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			
			if( rs.next() ) { 
				sql = "select * from member where mid = ? and mpw = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, rs.getString(2));
				// 첫번째 selsct 에서 찾은 첫번째 ? 대입
				ps.setString(2, mpw);
				rs = ps.executeQuery();
				
				if( rs.next() ) {
					return 1;
					// 로그인 성공 시 1
				} return 2;
				// 패스워드 틀렸을 시 2
			}
		} catch (Exception e) {
			System.out.println(e);
			return 3;
			// 데이터페이스 오류 3
		} 
		return 0;
		// 아이디 없음 0
		
	} // login 메소드 종료
	
	
	
	// 3. 아이디 찾기
	public String findid ( String mname, String memail) {
		String sql = "select * from member where mname = ? and memail = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mname);
			ps.setString(2, memail);
			rs = ps.executeQuery();
			
			// 만일 동일한 정보가 있으면 찾은 레코드의 아이디 반환
			if( rs.next() )	return rs.getString(2);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	
	// 4. 비밀번호 찾기 [ 임시 비밀번호 발급하기 ]
	public boolean findpw( String mid , String memail) {
		String sql = "select * from member "
				+ "where mid = ? and memail = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , mid );
			ps.setString( 2 , memail );
			rs = ps.executeQuery();
			if( rs.next() ) return true;
		}catch (Exception e) { System.out.println(e); }
		return false;
	}
	
	
	// 5. 임시 비밀번호 업데이트
	public boolean pwchange ( String mid, String randstr) {
		String sql = "select * from member where mid = ? and memail = ?";
		//MemberDto2 dto = new MemberDto2();
		//System.out.println(dto.toString());
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, randstr);
			ps.setString(2, mid);
			ps.executeUpdate(); 
			return true;
			// 만일 동일한 정보가 있으면 찾은 레코드의 비밀번호 반환
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
