package java1.ch5클래스.EX12_비회원제게시판_메소드버전;

public class contorller {

	
	static Board[] boardlist = new Board[100];
		
	// 1. 게시물 등록 함수
	static boolean con_regist( String title, String content, String writer, String password) {
		
		// 1. 객체 생성(객체화)
		Board board = new Board(title, content, writer, password, 0 );
		
		// 2. 배열 빈공간에 배치
		for( int index = 0; index < boardlist.length; index++ ) {
			if( boardlist[index] == null ) {
				boardlist[index] = board;
				return true;	// 게시물 등록 성공 의미 -> 함수 탈출
			} // if 종료
		} // for 종료
		
		// 3. 공간이 없을 경우
		return false;	// 게시물 등록 실패 의미 -> 배열에 자리가 없다
	} // 메소드 종료
	
	
	
	
	// 2. 게시물 삭제 함수
	static boolean con_delete( int bnum, String password ) {
		if( boardlist[bnum].password.equals(password)) {
		
			for( int i = bnum; i < boardlist.length; i++ ) {
				boardlist[i] = boardlist[i+1];	// 한칸씩 당기기
				if( boardlist[i+1] == null ) {
					break;
				} // if 종료
			}// for 종료
		return true;
		} // if 종료
		else {
			return false;
		} // else 종료
	} // 메소드 종료
	
	
	// 3. 게시물 수정 함수
	static boolean con_update( int bnum, String psaaword, String title, String content ) {
		if( boardlist[bnum].password.equals(psaaword) ) {
			boardlist[bnum].title = title;
			boardlist[bnum].content = content;
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	
	
	
	
	
	
}
