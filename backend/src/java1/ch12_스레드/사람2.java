package java1.ch12_스레드;

public class 사람2 extends Thread {

	// 필드 [ 객체 ]
	private 계산기 계산기;
	
	public void set계산기( 계산기 계산기 ) {
		this.setName("사람2");
		this.계산기 = 계산기;
	}
	
	public void run() {
		계산기.set저장소( 50 );
	}
}
