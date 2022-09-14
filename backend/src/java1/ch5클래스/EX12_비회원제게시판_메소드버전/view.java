package java1.ch5클래스.EX12_비회원제게시판_메소드버전;

import java.sql.Connection;
import java.util.Scanner;

// print, scanner : 입/출력 작성 예정

public class view {
	
	// * 함수 밖에 스캐너를 선언한 이유 : 모든 함수에서 같이 사용하려고 [ 필드화 ]
    static Scanner scan = new Scanner(System.in);
	
    public static void main(String[] args) {
			
		start(); // 함수 호출
		
	
		
	}
	
	// 1. 프로그램 시작하는 함수 [ 매개변수x 반환x 정적메소드 : 호출 시 객체 생략 가능 ]
    public static void start() {
		while( true ) {
			
			view_boardlist(); // 무조건 게시물 보기 view_boardlist(); 함수 호출
			
			System.out.println(" ====== [ 비회원 게시판 ] ====== ");
			System.out.println(" 1. 글쓰기   2. 글보기");
			int ch = scan.nextInt();
			
			if( ch == 1 ) {		// 1번을 입력했으면 view_regist(); 함수 호출
				view_regist();
				
			} // if 종료
			
			else if( ch == 2) { // 2번을 입력했으면 view_board(); 함수 호출
				view_board();
				
			} // else if 종료
			
			else {
				
			} // else 종료
		} // 와일 종료
	} // 메소드 종료
    
    
    // 2. 게시물을 등록하는 화면 구현 함수
    static void view_regist() {
    	
    	scan.nextLine();
    	System.out.println(" ------ [ 게시물 등록 페이지 ] ------ ");
    	
    	System.out.println("[안내] 제목을 입력해주세요 : ");
    	String title = scan.nextLine();
    	System.out.println("[안내] 내용을 입력해주세요 : ");
    	String content = scan.nextLine();
    	System.out.println("[안내] 작성자를 입력해주세요 : ");
    	String writer = scan.next();
    	System.out.println("[안내] 비밀번호를 입력해주세요 : ");
    	String password = scan.next();
    	
    	// 1. 메소드 호출
    	boolean result = contorller.con_regist( title, content, writer, password );
    	
    	// 2. 메소드 호출된 결과를 가지고 제어
    	if( result ) {
    		System.out.println("[안내] 게시물 등록 완료");
    		
    	} // if 종료
    	else {
			System.out.println("[안내] 게시물 등록 실패 [ 관리자에게 문의 ]");
		}
    	
    } // 메소드 종료
	
    
    
    // 3. 게시물 상세페이지 화면 구현 함수
    static void view_board() {
    	System.out.println("[안내] 게시물 번호를 선택 하세요");
    	int bnum = scan.nextInt();
    	System.out.println(" ------ [ 게시물 상세 페이지 ] ------ ");
    	
    	Board temp = contorller.boardlist[bnum];
    	// 새로운객체[임시객체] = 입력 받은 인덱스의 객체
    	if( temp == null ) {
    		System.out.println("[안내] 없는 게시물 번호 입니다.");
    		return;
    	}
    	
    	System.out.println("제목 : " + temp.title );
    	System.out.println("작성자 : " + temp.writer);
    	System.out.println("내용 : " + temp.content);
    	
    	System.out.println(" 1. 뒤로가기  2. 수정  3. 삭제 ");
    	int ch = scan.nextInt();
    	
    	if ( ch == 1 ) {
    		
    	} // if 종료
    	
    	else if ( ch == 2) { // 수정 화면 함수 호출
    		view_update( bnum );
    		
    	} // else if 종료
    	
    	else if ( ch == 3 ) { // 삭제 화면 함수 호출
    		
    		view_delete( bnum );	// 매개변수 1개 int = 현재 보고있는 게시물 번호
    		
    	} // else if 종료
    	
    	else {
    		System.out.println("[안내] 잘못선택하셨습니다.");
    	} // else 종료
    	
    	
    	return;
    	
    } // 메소드 종료
    
    
    // 4. 게시물 목록 화면 구현 함수
    static void view_boardlist() {
    	System.out.println(" ------ [ 게시물 목록 ] ------ ");
    	System.out.println(" [번호]  [작성자]  [제목]");
    	for( int i = 0; i < contorller.boardlist.length; i++ ) {
    		
    		Board temp = contorller.boardlist[i];
    			// temp 객체의 목적 : 코드 줄이기
    		if( temp != null ) {
    			
    		System.out.print( " " + i + "\t" );
    		System.out.print( temp.writer  + "\t" );
    		System.out.print( temp.title  + "\n" );
    		
    		} // if 종료
    	} // for 종료
    } // 메소드 종료
    
    
    // 5. 게시물 삭제 함수
    static void view_delete( int bnum ) {
    	System.out.println("[안내] 비밀번호를 입력하세요");
    	String password = scan.next();
		
    	boolean result = contorller.con_delete(bnum, password);
    	if( result ) {
			System.out.println("[안내] 삭제되었습니다.");
		} // if 종료
		else {
			System.out.println("[안내] 비밀번호가 다릅니다");
		} // else 종료
    } // 메소드 종료
    
    
    // 6. 게시물 수정 함수
    static void view_update( int bnum ) {
    	System.out.println("[안내] 비밀번호를 입력하세요");
    	String password = scan.next();
    	
    	System.out.println("수정할 제목을 입력하세요 >> ");
    	String title = scan.next();
    	
    	System.out.println("수정할 내용을 입력하세요 >> ");
    	String content = scan.next();
    	
    	boolean result = contorller.con_update(bnum, password, title, content);
    	
    	if( result ) {
    		System.out.println("[안내] 게시물 수정 성공");
    	} // if 종료
    	else {
			System.out.println("[안내] 게시물 수정 실패");
		} // else 종료

    } // 메소드 종료
    
    
 
} // 클래스 종료

























