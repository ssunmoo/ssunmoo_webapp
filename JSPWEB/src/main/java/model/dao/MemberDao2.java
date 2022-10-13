package model.dao;

import java.io.Console;
import java.util.ArrayList;

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
			// 데이터베이스 오류 3
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
	} // findid 메소드 종료
	
	
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
	} // findpw 메소드 종료
	
	
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
	} // pwchange 메소드 종료


	// 6. 회원 정보 호출
	public MemberDto2 getinfo( String mid ) {
		MemberDto2 dto2 = new MemberDto2();
		
		String sql = "select * from member where mid = ? ";
		// "select * from member where mid = '"+ mid +"' ";
		// mid 변수명으로 넣어주고싶으면 '' 작은따옴표 처리도 해줘야함
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if ( rs.next() ) { 
				
				// 1. 풀생성자 사용
				dto2 = new MemberDto2(
						rs.getInt(1), rs.getString(2), null,
						rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7),
						rs.getString(8), rs.getInt(9));
				//System.out.println("아래" + dto2.toString());
//				// 2. 빈생성자 사용
//				dto2.setMno(rs.getInt(1));
//				dto2.setMid(rs.getString(2));
//				dto2.setMname(rs.getString(4));
//				dto2.setMphone(rs.getString(5));
//				dto2.setMemail(rs.getString(6));
//				dto2.setMaddress(rs.getString(7));
//				dto2.setMdate(rs.getString(8));
//				dto2.setMpoint(rs.getInt(9));
//				System.out.println("아래" + dto2.toString());
				return dto2;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return dto2;
	} // getinfo 메소드 종료
	
	
	// 7. 모든 회원 호출
	public ArrayList< MemberDto2 > getinfolist(){
		
		ArrayList< MemberDto2 > list = new ArrayList<>();
		String sql = " select * from member";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while ( rs.next() ) {
				MemberDto2 dto2 = new MemberDto2(
						rs.getInt(1), rs.getString(2),
						null, rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getString(8), rs.getInt(9));
				list.add(dto2);
			}
			return list;
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	} // getinfolist 메소드 종료
	
	
	// 8. 회원 탈퇴
	public boolean mdelete( String mid, String mpw ) {
		String sql = "delete from member where mid = ? and mpw = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpw);
			int count = ps.executeUpdate();
			// count 삭제가 몇개됐는지 카운트 보기( 삭제 레코드 수 반환 )
			if( count == 1 ) {
				// 1이면 성공, 0이면 삭제된 값 없음 성공시에만 true 반환
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	} // delete 메소드 종료
	
	
	// 9. 아이디 중복체크
	public boolean idcheck( String mid ) {
		String sql = "select * from member where mid = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid );
			rs = ps.executeQuery();
			
			if( rs.next() ) {
				return true;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	} // idcheck 메소드 종료
	
	
	// 10. 이메일 중복 체크
	public boolean emilcheck( String memail ) {
		String sql = "select * from member where memail = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, memail );
			rs = ps.executeQuery();
			if( rs.next() ) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	} // emilcheck 메소드 종료
	
	
	// 11. 회원 정보 수정
	public boolean update( String mid, String mname ) {
		
		String sql = "update member set mname = ? where mid = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mname);
			ps.setString(2, mid);
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
		
	} // update 메소드 종료
	
	
	// 12. 회원아이디 --> 회원 번호 반환
	public int getMno( String mid ) {
		String sql = "select * from member where mid = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			
			// if (1개) while (여러개)
			if( rs.next() ){
				return rs.getInt(1);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} return 0;		
				
				
				
				
	} // getMno 메소드 종료
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
