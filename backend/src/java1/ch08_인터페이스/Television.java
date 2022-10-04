package java1.ch08_인터페이스;

public class Television implements RemoteControl {
	// [ implements 추상받을 인터페이스 ] : 추상 구현
	// [ extends 상속받을 클래스] : 상속
	
	
	// 1. 필드
	private int volume;
	// 2. 생성자
	// 3. 메소드
	
	// RemoteControl 인터페이스의 추상 메소드를 구현하기
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다");
		
	}
	
	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다");
	}
	
	@Override
	public void setVolume( int volume ) {
		if( volume > RemoteControl.MAX_VOLUME ) {
			// 현재 볼륨이 최대 소음보다 크면
			this.volume = RemoteControl.MAX_VOLUME;
			// 현재 볼륨을 10으로
		}
		else if ( volume < RemoteControl.MIN_VOLUME ) {
			// 현재 볼륨이 최저 소음보다 작으면
			this.volume = RemoteControl.MIN_VOLUME;
			// 현재 볼륨을 0으로
		}
		else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨 : " + this.volume );
	} // setVolume 메소드 종료
	
	
	
	
	
	
}
