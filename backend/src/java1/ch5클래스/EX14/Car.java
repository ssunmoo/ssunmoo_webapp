package java1.ch5클래스.EX14;

public class Car {
	// 클래스의 멤버구성
	
	// 1. 필드
	String model;	// 인스턴스 멤버
	int speed;		// 인스턴스 멤버
	
	
	
	
	// 2. 생성자 : 클래스명과 동일하다.
		// 객체 선언 시 객체 필드의 초기값 메소드
		// 클래스명 객체명 = new 생성자();
	
	
 	public Car(String model) {
 		// 생성자명 ( 파라미터 ) { 필드 초기화 }
		
 		// 현재 클래스의 model 필드명과 매개변수명이 동일할 경우 식별 불가
		this.model = model;
		// this 키워드 : 자신(나)
			// this.필드명 	: 현재 클래스의 필드 호출
			// this.메소드명 	: 현재 클래스의 메소드 호출
			// this() 		: 현재 클래스의 생성자 호출
		
 	}

	
	// 3. 메소드
	void setSpeed( int speed ) {	// 매개 변수 speed와 현재 클래스의 speed 필드와 이름이 동일
		this.speed = speed;
	}
	
	void run() {
		
		for ( int i = 10; i <= 50; i+=10 ) {
			this.setSpeed(i);
			System.out.println( this.model + "가 달립니다. ( 시속: " + this.speed + "km/h" + " )");
		}
	}
	
	
	
	
	
	
}
