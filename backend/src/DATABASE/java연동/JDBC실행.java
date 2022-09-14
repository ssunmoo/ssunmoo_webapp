package DATABASE.java연동;

import java.sql.DriverManager;		// DB 드라이버 클래스 [ 드라이버 데이터 ]
import java.sql.Connection;			// DB 연동 인터페이스
import java.sql.PreparedStatement;	// SQL 조작 인터페이스
import java.sql.ResultSet;			// SQL 결과 조작 인터페이스

import com.mysql.cj.xdevapi.PreparableStatement;

public class JDBC실행 {
	public static void main(String[] args) {
		
		// JDBC : 자바와 DB 연동
			// 1. 라이브러리 필요 [ mysql-connector-java-8.0.30.jar ]
				// * jar : 미리 만들어진 클래스들의 집합
		
			// 2. 해당 프로젝트 라이브러리 추가
				// 1. 해당 프로젝트 오른쪽 클릭
				// 2. build path -> configure build path
				// 3. Libraries 탭 선택
				// 4. add Extrenal Jar -> 해당 jar 파일 선택
				// ** 해당 jar 파일의 경로가 변경되면 라이브러리 실행 불가능
				// 5. apply
		
			// 3. 미리 만들어진 JDBC 관련된 클래스를 사용할 수 있다.
				// 1. Connection : 인터페이스
				// 2. DriverManager	: 클래스
					// 3. getConnection( db주소, db계정명, db비밀번호 )  : 메소드
		
			// MYSQL 연동할 때 해당 클래스에서 예외( 오류 발생 )
				// * 연동 실패 했을 경우 그에 대한 대처 코드가 없어서
				// 해결방안 : 예외처리 [ try ~ catch ]
		
		try { // 만일 try 괄호 안에서 예외가 발생하면 catch 로 코드 흐름이 이동
				// 예외가 없으면 try 괄호만 정상실행
			Class.forName("com.mysql.cj.jdbc.Driver");	// mysql 드라이버 이름 확인
			
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shop_db3",
					"root", "1234"
					);
			System.out.println("DB 연동 성공");
			
			
			
			// * JDBC에서 SQL 조작
			// 1. 테이블에 데이터 추가
				// 1. SQL 문법을 " " 로 감싸고 문자열 변수에 저장
//				String sql = "INSERT INTO MEMBER VALUES('tess', '나훈아', '경기 부천시 중동')";
//				// 2. SQL 조작 인터페이스
//				PreparedStatement ps = con.prepareStatement(sql);	
//				// 3. SQL 실행 SQL의 ctrl + enter (실행)이랑 같음
//				ps.executeUpdate();
//				
//				
//				// row 추가하기
//				sql = "INSERT INTO MEMBER VALUES('iyou', '아이유', '인천 남구 주안동'), ('jyp', '박진영', '경기 고양시 장항동')";
//				ps = con.prepareStatement(sql);
//				ps.executeUpdate();
//				
//				// 박진영 주소 변경
//				String sql = "UPDATE MEMBER SET MEMBER_ADDR = '경기도 안산시 상록구' WHERE MEMBER_ID ='jyp'";
//				PreparedStatement ps = con.prepareStatement(sql);
//				ps.executeUpdate();
//				
//				// 아이유 레코드 삭제
//				sql = "DELETE FROM MEMBER WHERE MEMBER_ID = 'iyou'";
//				ps = con.prepareStatement(sql);
//				ps.executeUpdate();
				
				String sql = "SELECT * FROM MEMBER";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery(); // 쿼리 [ SQL 결과 ]
					// 결과가 레코드[행] 여러개 존재하기 때문에
					
				// 반복문을 이용하여 레코드 하나씩 출력
					// null -> 검색레코드1 -> 검색레코드2
					// .next() : 다음 레코드 호출 [ 다음 레코드가 있으면 true 없으면 false 반환 ]
					// .getString(필드순서번호) : 해당 필드의 데이터를 문자열로 가져오기
					// .getInt(필드순서번호) : 해당 필드의 데이터를 정수형으로 가져오기
				
				while( rs.next() ) { // while (조건) 조건이 true이면 반복문 실행
					// rs.nect() : 다음 레코드 이동
					System.out.println("회원아이디 : " + rs.getString(1) + "\t" );		// 첫번째 필드의 데이터 가져오기 [ MEMBER_ID ]
					System.out.println("회원명 : " + rs.getString(2) + "\t" );		// 두번째 필드의 데이터 가져오기
					System.out.println("회원주소 : " + rs.getString(3) + "\n" );		// 세번째 필드의 데이터 가져오기
				}
				
				
				
		}catch( Exception e ) {
			System.out.println("연동 실패" + e );
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
