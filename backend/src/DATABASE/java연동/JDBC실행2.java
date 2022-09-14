package DATABASE.java연동;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC실행2 {
	public static void main(String[] args) {
		
		
		try {
		// 1. DB 연동
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shop_db3",	// URL
					"root",	// ID
					"1234"	// PW
					);
			System.out.println("DB 연동 성공");		
		
		// 2. SQL 작성
//			String sql = "INSERT INTO PRODUCT VALUES('바나나', 1500, '2021-07-01', '델몬트', 17), ('카스', 2500, '2022-03-01', 'OB', 3), ('삼각김밥', 800, '2023-09-01', 'CJ', 22)";	
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.executeUpdate();
			
			// 1. 카스의 재고수량을 10으로 수정	
//			String sql = "UPDATE PRODUCT SET AMOUNT = 10 WHERE PRODUCH_NAME = '카스'";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.executeUpdate();
			
			// 2. 삼각김밥 제거
//			String sql = "DELETE FROM PRODUCT WHERE PRODUCH_NAME = '삼각김밥'";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.executeUpdate();
			
			// 3. 모든 제품을 콘솔에 출력
			String sql = "SELECT * FROM PRODUCT";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				System.out.println("제품명 : " + rs.getString(1) + "\t" );		// 첫번째 필드의 데이터 가져오기 [ MEMBER_ID ]
				System.out.println("가격 : " + rs.getString(2) + "\t" );		// 두번째 필드의 데이터 가져오기
				System.out.println("유통기한 : " + rs.getString(3) + "\t" );
				System.out.println("회사명 : " + rs.getString(4) + "\t" );
				System.out.println("수량 : " + rs.getString(5) + "\n" );
			}
			
		}catch( Exception e ) {
			System.out.println("DB 연동 실패" + e);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
