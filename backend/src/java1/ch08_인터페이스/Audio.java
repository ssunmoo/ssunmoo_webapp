package java1.ch08_인터페이스;

public class Audio implements RemoteControl {

	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("오디오를 켭니다");
	}
	
	@Override
	public void turnOff() {
		System.out.println("오디오를 끕니다");
	}
	
	@Override
	public void setVolume(int volume) {
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
		System.out.println("현재 오디오 볼륨 : " + this.volume );
	} // setVolume 메소드 종료
	
	
	
	
	
	
	
	
	
}
