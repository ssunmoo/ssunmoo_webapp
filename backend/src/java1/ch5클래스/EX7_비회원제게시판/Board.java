package java1.ch5클래스.EX7_비회원제게시판;

public class Board {

	// 클래스 멤버
	// 1. 필드
	
	// 상자크기[자료형] 상자이름[변수명]
	String title;	
	String content;	
	String writer;
	String password;
	int view;
	
	
	// 2. 생성자
	
	// 1. 빈생성자 [ 기본생성자 ]
	public Board() {
		
	}
	
	// 2. 풀 생성자
	public Board( String title, String content, String writer, String password, int view ) {
	
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.password = password;
		this.view = view;
		
	}	
	
	
	// 3. 메소드
	
	
}
