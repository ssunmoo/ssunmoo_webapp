package java1.ch5클래스.EX13_비회원제게시판_DB버전;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardDao {

	
	// 1. 필드
	
	// JDBC 자주 사용하는 클래스/인터페이스
	Connection con;	// DB에 접속할 수 있는 인터페이스
		// con = DriverManager.getConnection( "DB주소", "DB계정명", "DB비밀번호" );
		// 오류 발생 [ 예외 발생 ] : 만약 DB 접속실패 했을 경우에 대한 대처 코드를 넣어서 해결해야함 [ 예외 처리 ]
	
	
	PreparedStatement ps;	// 접속된 DB에 SQL 연결/조작하는 인터페이스
	ResultSet rs;			// SQL 결과를 조작하는 인터페이스
	
	// 2. 생성자

	public BoardDao() {
		// 빈 생성자에 DB 접속 코드 ( 객체 생성 시 자동으로 DB 접속 )

		try {
			con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/BOARDTEST",
			"root",
			"1234");
			System.out.println(" [안내] DB 접속 성공");
			
		} // try 종료
		catch ( Exception e ) {
			System.out.println(" [경고] DB 접속 실패" + e );
		} // catch 종료
	} // 메소드 종료

	
	
	
	// 3. 메소드
		// 1. 등록 메소드
		boolean regist ( BoardDto boardDto ) {
			// 1. sql 작성
			String sql = "insert into board ( b_title, b_content , b_writer , b_password , b_view )"
						+ "values( ?, ?, ?, ?, ? );";
						// ? : 변수가 들어갈 자리에 [ 와일드카드 ]
			// 2. sql 연결 조작
			try {
				ps = con.prepareStatement(sql);	// 위에서 작성된 sql ps인터페이스 연결
					// ? 에 변수 넣기
				ps.setString(1, boardDto.b_title );		// 1 : 첫번째 ? , 제목
				ps.setString(2, boardDto.b_content );	// 2 : 두번째 ? , 내용
				ps.setString(3, boardDto.b_writer );		// 3 : 세번째 ? , 작성자
				ps.setString(4, boardDto.b_password );	// 4 : 네번째 ? , 패스워드
				ps.setInt(5, 0);						// 5 : 다섯번째 ? , 0 : 게시물 등록시 조회수 0부터 시작이라서
					
				ps.executeLargeUpdate();		// ps 인터페이스 sql 실행
				return true;	// 등록 성공 시 true
				
			} // try 종료
			// 3. sql 결과
			catch ( Exception e ) {
				System.out.println(" [경고] DB오류 " + e );
			} // catch 종료
			return false;	// 등록 실패 시 false
		} // 메소드 종료
	
		
		// * 전체 게시물 수 메소드
		int getrows() {
			
			// 1. sql 작성
			String sql = "select count(*) from board";
			// 2. sql 연결/조작
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery(); // 쿼리는 결과가 여러개기떄문에 변수에 담아야함
				
				if( rs.next() ) {
					return rs.getInt( 1 ); // 첫번째 레코드[행/게시물수] 반환
				} // if 종료
				
			} // try 종료
			catch ( Exception e ) {
				System.out.println(" [경고] 실패" + e);
			} // catch 종료
			// 3. sql 결과
			
			return 0;
		}
		
		
		
		// 2. 모든 게시물 출력 메소드
		BoardDto[] getBoardlist( ) {
			int count = getrows(); // 전체 게시물 수 함수 호출 -> 반환 count에 저장
			BoardDto[] boardlist = new BoardDto[ count ]; // 배열 선언 [ 배열의 길이 = 게시물 수 ]
		
			// 1. sql 작성
			String sql = "select * from board";
			// 2. sql 연결/조작
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();	// select : executeQuery 
				// ResultSet rs : 쿼리 [ sql 결과 ]에 조작
				// rs -> null  --.next()--> 검색된 로우 -> 다음 로우
							
				int index = 0; // 배열에 인덱스를 대체할 변수 선언
				while ( rs.next()) {
					// 레코드 한개당 6개의 필드 > 6개 변수 > 객체 > 배열
					int b_no = rs.getInt(1); // 해당 레코드의 첫번째 필드의 데이터 호출
					String b_title = rs.getString(2);
					String b_content = rs.getString(3);
					String b_writer = rs.getString(4);
					String b_password = rs.getString(5);
					int b_view = rs.getInt(6);
					
					// 1. 해당 레코드의 필드를 호출해서 객체화
					BoardDto board = new BoardDto(b_no, b_title, b_content, b_writer, b_password, b_view);
					
					// 2. 객체를 배열에 저장
					boardlist[index] = board;
					
					// 3. 인덱스 증가
					index++;
					
				} // while 종료
			} // try 종료
			
			catch ( Exception e ) {
				System.out.println(" [경고] DB 오류 : " + e);
			} // c 종료
			
			
			return boardlist;
		} // 메소드 종료
		
		// 3. 개별 게시물 출력 메소드
		BoardDto getBoard( int b_no ) {
			BoardDto board = null;
			
			// 1. sql 작성
			String sql = "select * from board where b_no = ?"; // ? = 변수가 들어갈 자리
			try {
				ps = con.prepareStatement(sql);
				ps.setInt( 1, b_no );
				rs = ps.executeQuery(); // ResultSet : rs
				
				// 검색된 레코드의 필드를 객체화
				if( rs.next() ) {
					board = new BoardDto( rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getInt(6));
					// System.out.println("board에 들어있는거 : " + board);
				} // if 종료
				
			} // try 종료
			catch( Exception e) {
				System.out.println( " [경고] DB 오류 " + e );
			} // catch 종료
			
			// 2. sql 연결/조작
			
			// 3. sql 결과
			
			
			
			
			return board;
		} // 메소드 종료
		
		// 4. 수정처리 메소드
		boolean update( int b_no , String b_password ,
				String new_title , String new_content ) {
			// sql 코드 들어갈 예정
			return false;
		} // 메소드 종료
		
		
		// 5. 삭제처리 메소드
		boolean delete( int b_no, String b_password ) {
			// sql 코드 들어갈 예정
			return false;
		} // 메소드 종료
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
