package java1.ch07_상속;

// 부모 클래스
public class CellPhone {

	// 1. 필드
	String model;
	String color;
	
	// 2. 생성자
		// [ 기본 생성자 : 생성자가 1개도 없을 때 보이진 않지만 자동으로 생성되는 것(깡통)]
		// 만일 빈 생성자가 아닌 다른 생성자를 선언 했으면 기본 생성자는 자동 선언이 안됨
	
	// 3. 메소드
	void powerOn() {
		System.out.println("전원을 켭니다");
	}
	
	void powerOff() {
		System.out.println("전원을 끕니다");
	}
	
	void bell() {
		System.out.println("벨이 울립니다");
	}
	
	void sendVoice( String message ) {
		System.out.println("나 : " + message );
	}
	
	void receibeVoice( String message ) {
		System.out.println("상대방 : " + message );
	}
	
	void hangUp() {
		System.out.println("전화를 끕니다");
	}
	
	
	
}
