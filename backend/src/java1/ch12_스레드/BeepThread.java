package java1.ch12_스레드;

import java.awt.Toolkit;

public class BeepThread extends Thread {

	@Override
	public void run() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();	// Toolkit : console ui 제공
		for( int i = 0; i < 5; i++) {
			toolkit.beep(); // 비프음 소리 함수 [ 소리 속도보다 반복문이 더 빠르다(스레드가 더 빠름) ]
			
			try {
				Thread.sleep(500);	// Thread : 현재 스레드
								  	// 밀리초 : 1000 = 1초
									// .sleep(밀리초) : 스레드 일시정지(초시간만큼 느리게), 무조건 예외처리 발생
			} catch (Exception e) {
				System.out.println(e);
			}
		} // for 종료
	} // run 종료
	
	
	
	
	
	
	
}
