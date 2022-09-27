package java1.ch12스레드;

import java.awt.Toolkit;

public class EX1_스레드 {

	public static void main(String[] args) {
		// 스레드 : 한가닥의 실 의미 [ 코드를 읽는 하나의 흐름 ]
		// 멀티스레드 : 코드를 읽는 여러개의 흐름
		// main스레드 : main함수 시작 시 실행 --> return 시 스레드 종료
		
		
		// 1. p525 싱글 스레드 : 소리가 5번 출력되고 문자열이 5번 출력된다.
		System.out.println("-- 싱글 스레드 시작 --");
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();	// Toolkit : console ui 제공
		for( int i = 0; i < 10; i++) {
			toolkit.beep(); // 비프음 소리 함수 [ 소리 속도보다 반복문이 더 빠르다(스레드가 더 빠름) ]
			
			try {
				Thread.sleep(500);	// Thread : 현재 스레드
								  	// 밀리초 : 1000 = 1초
									// .sleep(밀리초) : 스레드 일시정지(초시간만큼 느리게, 무조건 예외처리 발생)
			} catch (Exception e) {
				System.out.println(e);
			}
		} // for 종료
		
		for( int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
		} // for 종료
		
		
		// 2. p526 멀티 스레드
		System.out.println("-- 멀티 스레드 시작 --");
		
		Runnable beepTask = new BeepTask();	// 구현 객체
		Thread therad = new Thread(beepTask);
		therad.start();	// run 메소드 호출
		
		// main스레드 : 생성된 스레드 실행 후 다음 코드 실행
		
		for( int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
		} // for 종료
		
		
		// 3. p.527 익명 구현 객체 -> 1회용 [ 이름 없으니까 다른곳에 호출 불가능 ]
		System.out.println("-- 익명 구현객체 시작 --");
		
		Thread thread2 = new Thread( new Runnable() {
			
			@Override
			public void run() {
				
				Toolkit toolkit = Toolkit.getDefaultToolkit();	// Toolkit : console ui 제공
				for( int i = 0; i < 10; i++) {
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
		});
	
		thread2.start();
		
		for( int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
		} // for 종료
		
		
		
		
		// 4. p529 : Thread 클래스 객체
		System.out.println("-- Therad 클래스를 이용한 멀티 스레드 --");

		Thread thread3 = new Thread();
		
		therad.start();	// run 메소드 호출
		
		for( int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
		} // for 종료
		
		
		// 5. p530 : 클래스명 객체명 = new 생성자() { 멤버 재정의  };
		System.out.println("-- Therad 클래스를 이용한 익명 자식 객체 멀티 스레드 --");
		Thread thread4 = new Thread() {		// 멤버 재정의 가능
			
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
			}
		};
		
		thread4.start();
		
		for( int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
		} // for 종료
		
		
		
		
		
		

	
	return; // main 함수 종료
	
	} // main 종료
}
