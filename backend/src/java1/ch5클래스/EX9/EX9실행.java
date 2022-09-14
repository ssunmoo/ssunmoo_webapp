package java1.ch5클래스.EX9;

public class EX9실행 {
	public static void main(String[] args) {
		
		
		// 1. 객체 생성
		Calculator myCalc = new Calculator();
		
		
		// 2. 메소드 호출 ( 매개변수x 반환x )[ 객체명.메소드명() ]
		myCalc.powerOn();
		
		// 3. 메소드 호출 ( 매개변수 2개 반환 1개 )
		int result1 = myCalc.plus(5, 6);
			// 메소드가 돌려준 값 [ 반환값 ] 을 result1 변수에 저장
			// * 반환타입과 변수의 자료형이 동일해야 함
		System.out.println( "result1 : " + result1 );
		
		
		// 3.
		
		byte x = 10;
		byte y = 4;
		double result2 = myCalc.divide(x, y);
		System.out.println( "resylt2" + result2 );
		
		// 4.
		myCalc.powerOff();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
