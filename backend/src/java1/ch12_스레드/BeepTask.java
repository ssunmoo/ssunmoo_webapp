package java1.ch12_스레드;

import java.awt.Toolkit;

public class BeepTask implements Runnable {	
					// implements : 구현 [ 인터페이스(추상) 구현할때 ]
					// Runnable : 스레드 인터페이스
	
	// 1. 필드
	
	// 2. 생성자
	
	// 3. 메소드[ 스레드 제공하는 함수 = run ]
	@Override
	public void run() {		// Runnable 써야 자동으로 쓸 수 있음
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
	} // run 메소드 종료
	
	
	
}
