package java1.가계부;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DAO {
	
	
	// 1. 필드
	private Connection con; 
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static DAO dao = new DAO();	// 싱글톤 생성자를 사용할 수 있도록
	
	// 2. 생성자
	private DAO() {
		try {
			con = DriverManager.getConnection(
					
					"jdbc:mysql://localhost:3306/test_220922",
					"root",
					"1234");
			
		} // try 종료
		
		catch (SQLException e) {
			System.out.println( e );
		} // catch 종료
	} // 메소드 종료
	
	
	// ★★★ 외부에서 싱글톤 객체를 반환하는 메소드 ★★★
	public static DAO getInstance() {
		return dao;
	}
	
	
	// ---------------------------------------- 
	// 기능 메소드들
	
	
	// 1. 내용 추가
	public boolean add( DTO dto ) {
		String sql = "insert into expense values( null , ? , ? , ? )";
		
		try {
			
			ps = con.prepareStatement(sql); // 입력받은 내용을 sql 이랑 연결해줄거다
			ps.setString( 1, dto.getE_date() );
			ps.setInt( 2, dto.getE_money() );
			ps.setString( 3 , dto.getE_comment() );
			ps.executeUpdate();
			return true;
			
		} // try 종료
		
		catch (Exception e) {
			System.out.println( e );
		} // catch 종료
		return false;
	} // 메소드 종료
	
	
	// 2. 내용 수정
	public boolean update( DTO dto ) {
		String sql = "update expense set e_date = ?, e_money = ?, e_comment = ? where e_no = ?";
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString( 1, dto.getE_date() );
			ps.setInt( 2, dto.getE_money() );
			ps.setString( 3 , dto.getE_comment() );
			ps.setInt( 4 , dto.getE_no() );
			ps.executeUpdate();
			return true;
			
		} // try 종료
		
		catch (Exception e) {
			System.out.println( e );	
		} // catch 종료
		return false;
	} // 메소드 종료
		
	
	
	
	// 내용 출력
	ArrayList< DTO > read(){
		String sql = "select * from expense";
		ArrayList< DTO > list = new ArrayList<>();
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while ( rs.next() ) { // rs.next() 다음레코드확인
				// 레코드 -> 객체화[포장]하기
				// 레코드[필드4개] 1개 -> 객체화[필드4개] = [1개로포장]
				DTO dto = new DTO(
						rs.getInt(1),	// 현 레코드의 첫번째 필드를 가져온다
						rs.getString(2),	
						rs.getInt(3),
						rs.getString(4));
				list.add(dto);
			} // while 종료	
			return list;
		}
		catch (Exception e) {
			System.out.println(e);
		} return list;
		
		
	}
	

	
	// 3. 내용 삭제

	boolean delete( DTO dto ) {
		String sql = "delete from expense where e_no = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getE_no());
			ps.executeUpdate();
			return true;
		} 
		
		catch (Exception e) {
			System.out.println( e );	
		} // catch 종료
		return false;
	}
	
	
	// 5. 통계
	
	HashMap<String, Integer> date_sum() {
		
		String sql = "select e_date as 날짜, sum(e_money) as 합계 from expense group by e_date";
		HashMap<String, Integer> list = new HashMap<String, Integer>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				list.put(rs.getString(1), rs.getInt(2));
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println( e );	
		} // catch 종료
		return list;
	}
	
	
	
	
	
	
	
	
	
	// ---------------------------------------- 



}
