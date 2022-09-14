package java1.ch5클래스.EX11;

public class EX11실행 {
	public static void main(String[] args) { // 코드를 읽어주는 [ 스레드 ] 가 포함된 함수
		
		
		
		// run 메소드 호출 = 동일한 클래스에 존재
		// 1. 메소드 선언 시 main 함수가 해당 메소드를 먼저 읽게하려면 static 사용 		
		run();
		
		// 2. 객체 만들고 static 메소드 아닌 메소드를 호출한다.
		EX11실행 ex11실행 = new EX11실행();
		ex11실행.run2();
		
		
	} // main 종료
	
	// 1. 함수 선언 [ 반환x 매개변수x ]
	static void run() {
		while ( true ) {
			System.out.println("1. 회원가입 2. 로그인");
			
		} // while 종료
	} // 메소드 종료
	

	void run2() {
		while ( true ) {
			System.out.println("1. 회원가입 2. 로그인");
			
		} // while 종료
	} // 메소드 종료
	
}
