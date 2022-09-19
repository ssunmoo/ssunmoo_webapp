package DATABASE.ch3기본문법;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {

	// 1. 필드
	
	Connection con;			// db 연결 인터페이스
	PreparedStatement ps;	// sql 연결/조작 인터페이스
	ResultSet rs;			// sql 결과 [쿼리] 조작 인터페이스
	
	
	
	// 2. 생성자
	public DAO() {
		
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/market_db",
					"root",
					"1234");
		} // try 종료
		catch (Exception e) {
			System.out.println("오류 : " + e);
		
		} // catch 종료
	} // 함수 종료
	
	
	

	// 3. 메소드

	// 예제1 : 레코드 10줄 -> memberDto 8개 -> 배열/리스트
	public ArrayList< MemberDto > 예제1결과() {
		
		// 배열(Array) 대신에 배열을 편하게 사용할 수 있는 미리 만들어진 클래스 [ 컬렉션(수집) 프레임 워크 ]
			// ** 리스트 선언 : ArrayList< 리스트에 들어갈 객체의 클래스명 > 리스트명 = new ArrayList<>();
			// < > : 제네릭
			// 리스트에 객체 담기 : 리스트명.add( 객체명 ) 
			
		ArrayList< MemberDto > list = new ArrayList<>();
		// MemberDto로 생성된 객체 여러개를 담을 수있는 list 객체 선언 
		
		
		// 1. sql 작성
		String sql = "select * from member";
		
		// 2. sql 연결조작
		try {
			ps = con.prepareStatement(sql); // sql 연결/조작 인터페이스
			rs = ps.executeQuery();
			
			while ( rs.next() ) {
				MemberDto dto = new MemberDto(
						rs.getString(1),	rs.getString(2),
						rs.getInt(3),		rs.getString(4),
						rs.getString(5),	rs.getString(6),
						rs.getShort(7),		rs.getString(8));
				// 객체 -> 배열/리스트 담기
				list.add( dto );
			
			} // while 종료 
			return list;
			
		}catch (Exception e) {
			System.out.println("예제1 오류 " + e );
			return list;
		} // catch 종료
	}// 예제1 메소드 종료
		
		
		// ------------------------------------------------ //
		
		
	
	
	// 예제2 레코드 10줄
		
	ArrayList< String > 예제2결과() {
		
		ArrayList< String > list = new ArrayList<>();
		// 1. String 객체 여러개를 저장할 수 있는 list 객체 선언
		
		String sql = "select mem_name from member";
	
		try {
	
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while ( rs.next() ) {
				// rs.next() : 다음레코드로 이동			
					list.add(rs.getString(1));
					// rs.get자료형(필드번호)
			} // while 종료
			
			return list;
			// 완료 후 반환
		
		} // try 종료
		
		catch (Exception e) {
			System.out.println("예제2 오류 " + e );
			return list;
			// 완료 후 반환
		} // catch 종료

	} // 메소드 종료
		
		
		
	// 예제3 : 레코드 1줄 : DTO 1개
	
	MemberDto 예제3결과() {
		
		String sql = "select * from member where mem_name ='블랙핑크'";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			// 결과 1개라서 반복문 필요 없음
			
			if( rs.next() ) {
				// 결과가 1개이면 반복문 x 
				MemberDto dto = new MemberDto(
						rs.getString(1), 	rs.getString(2),
						rs.getInt(3), 		rs.getString(4),
						rs.getString(5),	rs.getString(6),
						rs.getShort(7), 	rs.getString(8));
				return dto;
			} // if 종료
		} // try 종료
		catch (Exception e) {
			System.out.println("예제3 오류 " + e);
		} // catch 종료
		return null;

	} // 메소드 종료
		
		
		
	// 예제 4 레코드 3줄 dto 3개
	
	ArrayList< MemberDto > 예제4결과() {

		ArrayList< MemberDto > list = new ArrayList<>();
		String sql = "select mem_id , mem_name from member where height <= 162";
				
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while ( rs.next() ) {
				
				
				MemberDto dto = new MemberDto();
				// 빈객체 선언
				
				dto.mem_id = rs.getString(1);	
				// 검색된 레코드의 첫번째 필드 -> 객체 필드에 대입
				
				dto.mem_name = rs.getString(2);	
				// 검색된 레코드의 두번째 필드 -> 객체 필드에 대입
			
				list.add(dto);
				// 생성된 객체를 list에 저장(담기)
		
			} // while 종료
			return list;
				
		} // try 종료
		catch (Exception e) {
			System.out.println("예제4 오류 " + e);
			return list;
			
		} // catch 종료
	} // 메소드 종료
	
	
	
	
	// 예제 5 레코드 2줄 3개
	
	ArrayList< MemberDto > 예제5결과() {
		
		ArrayList< MemberDto > list = new ArrayList<>();
		String sql = "SELECT MEM_NAME , HEIGHT , MEM_NUBER FROM MEMBER WHERE HEIGHT >= 165 AND MEM_NUBER > 6";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while ( rs.next() ) {
				MemberDto dto = new MemberDto();
				
					dto.mem_name = rs.getString(1);
					dto.height = rs.getShort(2);
					dto.mem_nuber = rs.getInt(3);
					
					list.add(dto);
					
			} // while 종료
			return list;
			
		} // try 종료
		catch (Exception e) {
			System.out.println("예제5 오류 " + e);
			return list;
		}
	} // 메소드 종료
	
	
	
	// 예제 6 
	
	ArrayList< MemberDto > 예제6결과() {
		
		ArrayList< MemberDto > list = new ArrayList<>();
		String sql = "SELECT MEM_NAME, HEIGHT , MEM_NUBER FROM MEMBER WHERE HEIGHT >= 165 OR MEM_NUBER > 6";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while ( rs.next() ) {
				MemberDto dto = new MemberDto();
				
				dto.mem_name = rs.getString(1);
				dto.height = rs.getShort(2);
				dto.mem_nuber = rs.getInt(3);
			
				list.add(dto);
			} // while 종료
			
			return list;
		}
		catch (Exception e) {
			System.out.println("예제6 오류 " + e);
			return list;
		}
		
	}
	
	
	
	// 예제 7
	
	MemberDto 예제7결과() {
		
		String sql = "select * from member where mem_name like '우%'";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if( rs.next() ) {
				MemberDto dto = new MemberDto(
						rs.getString(1), 	rs.getString(2),
						rs.getInt(3), 		rs.getString(4),
						rs.getString(5),	rs.getString(6),
						rs.getShort(7), 	rs.getString(8));
				return dto;		
			} // if 종료
		} // try 종료
		
		catch (Exception e) {
			System.out.println("예제7 오류 " + e);
		}
		return null;
		
	} // 메소드 종료
	
	
	
	
	// 예제 8
	
	ArrayList< MemberDto > 예제8결과() {
		
		ArrayList< MemberDto > list = new ArrayList<>();
		String sql = "SELECT * FROM MEMBER WHERE MEM_NAME LIKE '__핑크'";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while ( rs.next() ) {
				MemberDto dto = new MemberDto(
						rs.getString(1), 	rs.getString(2),
						rs.getInt(3), 		rs.getString(4),
						rs.getString(5),	rs.getString(6),
						rs.getShort(7), 	rs.getString(8));	
				
				list.add(dto);
			} // while 종료
			return list;
	
		} // try 종료
		
		catch (Exception e) {
			System.out.println("예제8 오류 " + e);
			return list;
		}
		
	} // 메소드 종료
	
	
	// 예제 9 
	
	
	ArrayList< MemberDto > 예제9결과() {
	
		ArrayList< MemberDto > list = new ArrayList<>();
		String sql = "select mem_id , mem_name , debut_date from member order by debut_date desc";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while ( rs.next() ) {
				MemberDto dto = new MemberDto();
				
					dto.mem_id = rs.getString(1);
					dto.mem_name = 	rs.getString(2);
					dto.debut_date = rs.getString(3);
					
					list.add(dto);
			}  // while 종료
			return list;
		}
		
		catch (Exception e) {
			System.out.println("예제9 오류 " + e);
			return list;
		}

	} // 메소드 종료
	
	
	
	
	// 예제 10
	
	
	ArrayList< MemberDto > 예제10결과() {
		
		ArrayList< MemberDto > list = new ArrayList<>();
		String sql = "SELECT MEM_ID, MEM_NAME, DEBUT_DATE, HEIGHT FROM MEMBER WHERE HEIGHT >= 164 ORDER BY HEIGHT DESC";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while ( rs.next() ) {
				MemberDto dto = new MemberDto();
				
				dto.mem_id = rs.getString(1);
				dto.mem_name = 	rs.getString(2);
				dto.debut_date = rs.getString(3);
				dto.height = rs.getShort(4);
				
				list.add(dto);
				
			} // while 종료
			return list;	
		}
		
		catch (Exception e) {
			System.out.println("예제10 오류 " + e);
			return list;
		}

	} // 메소드 종료
	
	
	
	// 예제 11
	
	ArrayList< MemberDto > 예제11결과() {
		
		ArrayList< MemberDto > list = new ArrayList<>();
		String sql = "SELECT MEM_ID , MEM_NAME , DEBUT_DATE , HEIGHT FROM MEMBER WHERE HEIGHT >= 164 ORDER BY HEIGHT DESC, DEBUT_DATE ASC";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while ( rs.next() ) {
				MemberDto dto = new MemberDto();
				
				dto.mem_id = rs.getString(1);
				dto.mem_name = 	rs.getString(2);
				dto.debut_date = rs.getString(3);
				dto.height = rs.getShort(4);
				
				list.add(dto);
			} // while 종료
			return list;	
		}
		
		catch (Exception e) {
			System.out.println("예제11 오류 " + e);
			return list;
		}
	} // 메소드 종료	

	
	
	// 예제 12
	
	ArrayList< MemberDto > 예제12결과() {
		ArrayList< MemberDto > list = new ArrayList<>();
		String sql = "SELECT MEM_NAME , HEIGHT FROM MEMBER ORDER BY HEIGHT DESC LIMIT 3, 2";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		
			while ( rs.next() ) {
				MemberDto dto = new MemberDto();
				
				dto.mem_name = rs.getString(1);
				dto.height = rs.getShort(2);
				
				list.add(dto);
			}
			return list;
		}
		
		catch (Exception e) {
			System.out.println("예제12 오류 " + e);
			return list;
		}
	}
	

	
	
	
	// 예제 13
	
	ArrayList< MemberDto > 예제13결과() {
		
		ArrayList< MemberDto > list = new ArrayList<>();
		String sql ="SELECT DISTINCT ADDR FROM MEMBER";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		
			while ( rs.next() ) {
				MemberDto dto = new MemberDto();
				
				dto.addr = rs.getString(1);
				
				list.add(dto);
			}
			return list;

		}
		
		catch (Exception e) {
			System.out.println("예제13 오류 " + e);
			return list;
		}
	}
	
	
	
	// 예제 14
	
	ArrayList< MemberDto> 예제14결과(){
		
		ArrayList< MemberDto> list = new ArrayList<>();
		String sql = "SELECT MEM_ID, SUM( AMOUNT ) AS 수량합계 FROM BUY GROUP BY MEM_ID";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while ( rs.next() ) {
				MemberDto dto = new MemberDto();
				ResultDto dto2 = new ResultDto();
				
				dto.mem_id = rs.getString(1);
				dto2.value = rs.getDouble(2);
				
				list.add(dto);
			}
			return list;
		}
		
		catch (Exception e) {
			System.out.println("예제14 오류 " + e);
			return list;
		}	
			
	}
	
	
	
	
	// 예제 15
	
	// 예제 16
	
	// 예제 17
	
	// 예제 18
	
	// 예제 19
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 3. sql 결과조작
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // 클래스 종료

