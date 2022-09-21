package java1.키오스크.관리자;

import java.awt.Menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminDAO {

	
	
	// 1. 필드
	private Connection con;				// DB연동 인터페이스
	private PreparedStatement ps;		// SQL 연동/조작 인터페이스
	private ResultSet rs;				// SQL 결과(쿼리) 조작 인터페이스
		
	private static AdminDAO adao = new AdminDAO();	// 싱글톤 DAO 객체 [ 1. 생성자가 private 2. 정적객체]
	
	
	// 2. 생성자
	private AdminDAO() {
		
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mmth",
					"root",
					"1234");
			System.out.println(" DB 연동 성공 ");
		} catch ( Exception e ) {
			System.out.println(" DB 연동 실패 : " + e);
		}
	
	} // 메소드 종료
	
	// 3. 메소드
	
	// 외부에서 싱글톤 객체를 반환하는 메소드
	public static AdminDAO getInstance() {
		return adao;
	} // 메소드 종료
	
	
	
	// 4. 기능메소드
		// 1. 메뉴 추가 [ 인수 : 메뉴이름 , 반환 : 성공/실패 ]
	boolean inMenu( String menuname ) {
		// 1. sql 작성
		String sql = "insert into menu values( null , ? )";
		
		try {
			
		// 2. sql 연결/조작	
			ps = con.prepareStatement(sql);
			ps.setString ( 1, menuname );		// 1번째 ?에 변수 대입
			ps.executeUpdate();					// 3. sql 실행/결과조작량
			return true;						// 반환
		
		}
		catch( Exception e) {
			System.out.println(" 메뉴 추가 실패 : " + e );
			return false;
		}	
	} // 메소드 종료
	
	
		// 2. 메뉴 호출
	ArrayList< MenuDTO > getMenu() {
		
		ArrayList< MenuDTO > list = new ArrayList<>();
		String sql = "select * from menu";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {	// rs.next() : 다음 레코드
				MenuDTO menu = new MenuDTO(
						rs.getInt(1), rs.getString(2)); 
				// 현재 검색된 레코드의 필드 호출 시 : rs.get자료형(검색필드순번)
				
				list.add(menu);
				
			} // 와일 종료
			return list;
			
		} catch (Exception e) {
			System.out.println(" 호출 불가 " + e);
		}
		return list;
	} // 메소드 종료
	
	
		// 3. 제품 추가
	boolean inProduct( ProductDTO productDto ) {
	
		String sql = "insert into product values( null, ?, ?, ?, ?, ?)";
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString( 1, productDto.getPname() );
			ps.setInt( 2, productDto.getPprice() );
			ps.setString( 3, productDto.getPcomment() );
			ps.setShort( 4, productDto.getPamount() );
			ps.setByte( 5, productDto.getMno() );
			ps.executeUpdate();
			return true;	// 성공 시 true 반환
			
		} // try 종료
		
		catch (Exception e) {
			System.out.println(" 추가 실패 " + e);
		} // catch 종료
		return false;
		
	}
	
	
	
	
	
		// 4. 주문 확인
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // 클래스 종료
