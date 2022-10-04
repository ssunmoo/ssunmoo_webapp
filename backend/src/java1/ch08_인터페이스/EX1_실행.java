package java1.ch08_인터페이스;

public class EX1_실행 {

	public static void main(String[] args) {
		
		// 객체 선언 [ 인터페이스 x ]
		Television tv = new Television();
		
		// 1. 인터페이스 구현 객체 선언 : 인터페이스 변수명 = new 구현클래스();
		// RemoteControl rc = new Television();
		
		// 1. 인터페이스 구현 변수 선언
		RemoteControl rc;
		
		// 2. 인터페이스 변수에 구현 객체 대입
		rc = new Television();
		
		// 3. 메소드 실행
		rc.turnOn(); // tv 전원
		rc.setVolume(7);
		rc.turnOff();
		// ** 구현 객체 변경해보기 **
		
		System.err.println("[ tv -> audio 변경 ] ");
		
		// 4. 인터페이스 변수에 변경할 구현 객체 대입
		rc = new Audio();

		// 5. 메소드 실행
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
		
		
		System.err.println("[ audio -> 스마트tv 변경 ] ");
		SmartTelevision stv = new SmartTelevision();
		
		rc = stv;
		rc.turnOn();
		rc.setVolume(3);
		rc.turnOff();
		
		Searchable sc = stv;
		sc.search("20번");
		
		
		
		
		
		
	} // 메인 종료
}
