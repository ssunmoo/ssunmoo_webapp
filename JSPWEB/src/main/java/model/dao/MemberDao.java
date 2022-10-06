package model.dao;

import model.dto.MemberDto;

public class MemberDao extends Dao {
					// Dao 한테 상속받기
	
	private static MemberDao mdao = new MemberDao();
	public static MemberDao getInstence() {
		return mdao;
	}
	
	// 1. 회원가입
	
	public boolean signup( MemberDto dto ) {
		String sql = "insert into member values(?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getPhone());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	} // signup 메소드 종료
	
	
	
	
	
	
	
	
	
	
}
