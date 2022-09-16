package java1.ch5클래스.EX13_비회원제게시판_DB버전;

public class BoardControl {

	
	BoardDao boardDao = new BoardDao();
	// 현재 클래스에 존재하는 메소드들이 전역으로 사용할 수 있도록 객체화
	
	
	// 1. 
	boolean regist( String b_title, String b_content,
			String b_writer, String b_password ) { 
		
		// 1. 4개의 파라미터를 받는다
		// 2. 변수 여러개를 하나씩 이동할 경우 코드가 길어지니까 객체화 함 [ 게시물 번호와 조회수 번호는 기본값 0 ]
		BoardDto boardDto = new BoardDto(0, b_title, b_content, b_writer, b_password, 0);
		// 3. 유효성 검사 [ 추후예정 ]
		// 4. DB 저장 처리
		boolean result = boardDao.regist(boardDto);
		// dao.regist 메소드 호출 후 결과 값을 result 에 저장
		
		// 5. DB 결과 반환 
		return false;
	}
	
	
	// 2. 
	BoardDto[] getBoardlist( ) {
		BoardDto[] boardlist = null;
		boardlist = boardDao.getBoardlist();
		return boardlist;
	}
	
	// 3.
	BoardDto getBoard( int b_no ) {
		BoardDto board = null;
		board = boardDao.getBoard( b_no );
		return board;
	}
	
	// 4. 
	boolean update( int b_no, String b_password,
		String new_title, String new_content ) {
		// 로직 or Dao 호출 작성 예정
		return false;
	}
	
	// 5. 
	boolean delete ( int b_no, String b_password ) {
		// 로직 or Dao 호출 작성 예정
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
