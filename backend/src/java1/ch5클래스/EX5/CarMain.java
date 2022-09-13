package java1.ch5클래스.EX5;

public class CarMain {
	public static void main(String[] args) {
		
		
		// 1. 객체 선언 : 빈 생성자
		Car car1 = new Car();
		
		// 2. 객체 선언 : 매개변수가 1개인 생성자
		Car car2 = new Car( "자가용" );
		
		// 3. 객체 선언 : 매개변수가 2개인 생성자
		Car car3 = new Car( "자가용", "빨강");
		
		// 4. 객체 선언 : 매개변수가 3개인 생성자
		Car car4 = new Car( "택시", "검정", 200 );
		
		System.out.println( car1 );
		System.out.println( car2.model );
		
		System.out.println( car3.model );
		System.out.println( car3.color );
		
		System.out.println( car4.model );
		System.out.println( car4.color );
		System.out.println( car4.maxSpeed );

	}
}
