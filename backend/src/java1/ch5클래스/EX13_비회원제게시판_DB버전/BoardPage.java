package java1.ch5클래스.EX13_비회원제게시판_DB버전;
import java.awt.print.Pageable;
import java.util.Scanner;
public class BoardPage {
	
	// 1. 필드 
	// 입력객체 
	Scanner scan = new Scanner(System.in);
	BoardControl control = new BoardControl();
	// 모든 메소드에서 사용하려고 밖에 선언
	
	// 2. 생성자
	
	
	// 3. 메소드	
	public static void main(String[] args) {
		// 메소드 호출 방식 : 1. static 2. new
		BoardPage page = new BoardPage();
		page.view();
		
	} // 메인 종료
	
	
	
	// 0. 메인화면
	void view( ) {
		BoardPage page = new BoardPage();	// 메소드 호출용 객체
		
		while ( true ) {
			page.getBoardlist();	// 모든 게시물 출력 함수 호출
			
			System.out.println(" 1. 글쓰기  2. 글보기 ");
			int btn = scan.nextInt();
				
			if( btn == 1 ) {
				page.regist();		// 1번 게시물 등록 함수 호출
			} // if 종료
			
			else if ( btn == 2 ) {
				page.getBoard();	// 2번 개별 게시물 함수호출
				
			} // else if 종료
				
			else {
				System.out.println(" [안내] 알 수 없는 번호입니다");
			} // else 종료
		} // 와일 종료
	} // 메소드 종료
	
	
	// 1. 등록화면
	void regist() {
		System.out.println(" 등록페이지 >> ");
		System.out.println(" 제목 : ");
		String b_title = scan.nextLine();
		System.out.println(" 내용 : ");
		String b_content = scan.nextLine();
		System.out.println(" 작성자 : ");
		String b_writer = scan.next();
		System.out.println(" 비밀번호 : ");	
		String b_password = scan.next();
		scan.nextLine(); // nextLine를 해결하기위해 하나 넣는 것
		
		// view 에서 입력받은 데이터를 BoardControl 로 이동하기 위해 객체 선언과 불러오기
		// * BoardControl 의 객체 선언은 전역으로 사용해야되서 맨위로 올림
		boolean result = control.regist(b_title, b_content, b_writer, b_password);
		
		// BoardControl 에서 처리된 결과를 reulst 에 저장한 다음 제어 [ control 실행 후 결과의 경우의 수 ]
		if ( result ) {
			System.out.println(" [안내] 게시물 등록 완료");
		} // if 종료
		else {
			System.out.println(" [안내] 게시물 등록 실패");
		} // else 종료
		
	} // 메소드 종료

	// 2. 모든 게시물 출력화면
	void getBoardlist() {
		System.out.println(" ========= [ 게시판 ] ========= ");
		System.out.println(" 번호\t작성자\t제목\t조회수");
		
		BoardDto[] boardlist = control.getBoardlist();
		
		// 향상된 for 문
		for( BoardDto dto : boardlist ) {
		// for( 배열의 자료형 반복변수명 : 배열 ) 
			System.out.print( "  " + dto.b_no + "\t");
			System.out.print( dto.b_writer + "\t");
			System.out.print( dto.b_title + "\t");
			System.out.print( " " + dto.b_view + "\n");
		}
		
	} // 메소드 종료
	
	
	// 3. 개별 게시물 출력화면
	void getBoard() {
		System.out.println(" 게시물 번호 : ");	// 1. 보고싶은 게시물 번호를 입력 받는다.
		int b_no = scan.nextInt();
		BoardDto board = control.getBoard( b_no ); // 2. 입력받은 번호를 getBoard 에게 전달하면 해당 게시물 정보를 가져옴 [ 없으면 null ]
			if( board == null ) {
				System.out.println(" [경고] 해당 게시물이 없습니다.");
				return;
			} // if 종료
		
		System.out.println(" 개별 페이지 >> ");
		System.out.print(" 제목 : " + board.b_title + "\t" );
		System.out.print(" 작성자 : " + board.b_writer + "\t" );
		System.out.print(" 조회수 : " + board.b_view );
		System.out.print(" 내용 : " + board.b_content );
		
		System.out.println(" 1. 뒤로가기 2. 수정 3. 삭제 ");
		int btn = scan.nextInt();
		BoardPage page = new BoardPage();
		
		if( btn == 1 ) {
			return;
		} // if 종료
		
		else if( btn == 2 ) {
			page.update();
		} // else if 종료
		
		else if( btn == 3 ) {
			page.delete();		
			} // else if 종료
			
		else {
			System.out.println(" [안내] 알 수 없는 번호입니다");
		} // else 종료

	} // 메소드 종료
	
	// 4. 수정처리 출력화면
	void update() {
		System.out.println(" 수정 페이지 >> ");
	} // 메소드 종료
	
	// 5. 삭제처리 출력화면
	void delete() {
		System.out.println(" 삭제 페이지 >> ");
	} // 메소드 종료

} // 클래스 종료