package java1.ch5클래스.EX4;

public class Korean {

	
	
	// 필드
	String nation = "대한민국";
		// 클래스 내부에 미리 초기화 - > 객체 생성시 대한민국 대입
	String name;
	String ssn;
	
	
	// 1. 매개변수가 있는 생성자
	public Korean( String n, String s ) {
		// 클래스명 ( 매개변수 1, 매개변수 2)
		name = n;
		ssn = s;
	}
	
	// 2. 매개변수가 없는 생성자
	public Korean() {
		
	}
	
	
	// 메소드
}
