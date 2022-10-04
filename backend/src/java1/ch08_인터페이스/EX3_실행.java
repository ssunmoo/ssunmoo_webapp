package java1.ch08_인터페이스;

public class EX3_실행 {

	public static void main(String[] args) {

		Car myCar = new Car();
		
		myCar.run();
		
		System.out.println("\n[ 금호 타이어로 교체 ]");
		// 구현객체 교체
		myCar.frontLeftTire = new KumhoTire();
		myCar.frontRightTire = new KumhoTire();
		
		myCar.run();
		
		
		
		
		
		
		
	}

}
