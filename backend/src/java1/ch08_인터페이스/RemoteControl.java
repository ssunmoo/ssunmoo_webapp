package java1.ch08_인터페이스;

	// 클래스 선언 : 접근제한자 class 클래스명 { }
	// 인터페이스 선언 : 접근제한자 interface 인터페이스명 { }
public interface RemoteControl {

	// [ static final ] : 상수 키워드 생략 시 자동으로 상수 선언
	// public static final int --> 인데 생략된 것
	// 초기 값 필수
 	public int MAX_VOLUME = 10;
 	public int MIN_VOLUME = 0;
	
 	// 1. [ abstract ] : 추상 키워드 생략 시 자동으로 추상 선언
 	// 2. 선언만 -> 각 클래스에서 정의함 [ 구현 객체 ]
 	public abstract void turnOn();
 	public void turnOff();
 	public void setVolume( int volume );
 	
}
