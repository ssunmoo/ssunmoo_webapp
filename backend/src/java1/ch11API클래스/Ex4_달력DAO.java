package java1.ch11API클래스;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Ex4_달력DAO {

	
	// ------------ DB 연동 부분 -------------- //
	
	
	// 1. 필드
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private static Ex4_달력DAO dao = new Ex4_달력DAO();	// 싱글톤
		// 싱글톤을 외부로 호출시키는 메소드
		public static Ex4_달력DAO getInstance() {
			return dao;
		}
	
	
	// 2. 생성자 [ 싱글톤용 생성자 ]
	private Ex4_달력DAO() {
		// private : 접근제한자 : 외부 클래스에서 사용 불가능 [ 캡슐화 : 현클래스에서만 사용가능 ]
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test",
					"root",
					"1234");
		} // try 종료
		catch (SQLException e) {
			System.out.println( e );
		} // catch 종료
	} // 싱글톤 메소드 종료
	
	
	// ------------ DB 연동 부분 -------------- //
	
	
	
	boolean 일정추가( String c_date , String c_comment ) {
		
		
		String sql = "insert into calender values( null , ? , ? )";
		try {
			
			ps = con.prepareStatement(sql);	// sql 연결
			ps.setString(1 , c_date);		// sql ?에 값 대입
			ps.setString(2, c_comment);		// sql ?에 값 대입
			ps.executeUpdate();				// sql 실행 
			return true;
		}
		
		catch (Exception e) {
			System.out.println(e);
		} return false;
		
		
		
	}
	
	
	// 일정 출력 함수
	
	HashMap< Integer , ArrayList< String > > 일정출력( String year , String month ) { // 현재 월 일정
		
		String sql = "select * "
				+ "from calender "
				+ "where substring( c_date , 1 , 4 ) = ? "
				+ "and substring( c_date , 6 , 2 ) = ? ";
		
		HashMap< Integer , ArrayList< String > > map = new HashMap<>(); 		
		
		try {
		
			ps = con.prepareStatement(sql);
			ps.setString( 1, year );
			ps.setString( 2, month );
			rs = ps.executeQuery();
			
			while ( rs.next() ) {	// 다음 객체 이동하면서 확인
				// 레코드 -> 필드2와 필드3 -> 하나의 리스트(values)로 담기
				ArrayList< String > values = new ArrayList<>();
						values.add(rs.getString(2));
						values.add(rs.getString(3));
				// pk와 리스트를 map 담기
				map.put( rs.getInt(1), values );
			}
			return map;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return map;
	}
	
	
	
	
	
	
	
	
}
