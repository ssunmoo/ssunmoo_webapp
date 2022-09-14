package java1.ch5클래스.EX10;

public class CarMain {
	public static void main(String[] args) {
		
	// 1. 객체 선언	
	Car myCar = new Car();
	
	// 2. 객체에 메소드 호출
	myCar.setGas(5);
	// 매개변수o -> 5넣어줌 반환x
	
	// 3. 객체에 메소드 호출 -> 반환된 값을 변수명에 저장해줌
	boolean gasState = myCar.isLeftGas();
	// 매개변수x 반환 boolean
	
	
	if( gasState ) {
		System.out.println("출발합니다.");
		myCar.run();
		// 매개변수x 반환x
	}
	
	if( myCar.isLeftGas() ) {
		System.out.println("가스를 주입할 필요가 있습니다.");
		
	}
	else {
		System.out.println("가스를 주입하세요.");
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
