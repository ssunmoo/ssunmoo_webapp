package java1.ch5클래스.EX5;

public class Car {

	// p.239
	
	/* 
	   this : 반복적인 코드, 식별용 [ 내부 필드와 매개변수 변수명이 동일할때 사용 ]
	   1. this.필드명 : 현재 클래스의 필드 호출
	   2. this( ) : 현재 클래스의 생성자 호출
	   3. this.메소드명 : 현재 클래스의 메소드 호출
	
	*/
	
	// 필드
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
		
	// 생성자
		// 오버로딩 : 동일한 이름으로 선언 [ 매개변수에 따라 구별 ]
		// 생성자에서 사용되는 매개변수명은 필드명과 동일하게 작성
	
	// 1. 빈생성자 : 매개변수가 없는 생성자 [ 기본 생성자 ] 
	Car(){}
	
	// 2. 매개변수가 1개인 생성자
	Car( String model ){}
	
	// 3. 매개변수가 2개인 생성자
	Car( String model, String color ){
		this( model, color, 5000 );
	}
	
	// 4. 매개변수가 3개인 생성자
	Car( String model, String color, int maxSpeed ){}
	
	
	
	// 메소드
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
