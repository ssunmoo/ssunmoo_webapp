package java1.ch5클래스.EX9;

public class Calculator { // 클래스 선언
	
	
	
	// 1. 필드
	
	// 2. 생성자
	
	// 3. 메소드 [ js 함수와 비슷 ] 
		// 형태 : 반환타입 메소드명 ( 매개변수1, 매개변수2 ~ ) { 실행문 return 반환값 }
	
	void powerOn() {
	// void : 반환x [ 함수가 종료되면서 반환 값은 없다 ]
		System.out.println("전원을 켭니다");
		return; // void 일 경우 생략 가능
	
	}
	
	// 2. 반환o [ 매개변수가 2개인 함수 선언 ] // 인트 변수 2개를 받고 int 변수 1개 준다.
	int plus( int x , int y ) {
		int result = x + y;
		return result;
		
	}
	
	// 3. 반환o [ 매개변수 2개인 함수 선언 ]
	double divide( int x, int y ) {
		double result = (double)x / (double) y;		// (새로운자료형) 변수 : 강제형변환
		return result;
	}
	
	// 4. 반환x [ 매개변수x 함수 선언]
	void powerOff() {
		System.out.println("전원을 끕니다");
		return;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // 클래스 끝
