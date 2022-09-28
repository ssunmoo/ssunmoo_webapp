package java1.ch12_스레드.타이머스레드;

import java.util.Scanner;

public class EX_실행 {

	public static void main(String[] args) {

	/*
		[ 멀티 스레드 ]

		1. Thread 클래스 상속
		2. Runnable 인터페이스 구현

		* run 메소드 구현
		* start 메소드로 run 호출
		
	 */
		
		// 스캐너 객체 선언
		Scanner scan = new Scanner(System.in);
		
		// 타이머라는 멀티 스레드 선언
		Timer timer = new Timer();
		// 타이머의 현재 실행 상태 변수
		boolean timerstate = false;
		// 타이머의 현재 일시정지 상태 변수
		boolean waitstate = true;
		
		
		while ( true ) {
			System.out.println("1. 타이머시작 2. 리셋 3. 저장[DB]");
			int ch = scan.nextInt();
			
			// 확인용
			System.out.println( ch + " " + timerstate + " " + waitstate );
			
			// 1. 타이머를 처음 켰을 때
			if( ch == 1 && timerstate == false && waitstate == true ) {
				timer.start();
				timerstate = true;
			} // if 종료
			
			
			// 2. 타이머가 켜져 있을때 일시 정지
			if( ch == 1 && timerstate == true && waitstate == true ) {
				timer.setWait( false );
				waitstate = false;
			} // if 종료
			
			
			// 3. 타이머가 켜져 있을때 일시정지 해제
			if( ch == 1 && timerstate == true && waitstate == false ) {
				timer.setWait( true );
				waitstate = true;
			} // if 종료
			
			
			// 4. 타이머가 켜져 있을때 리셋
			if ( ch == 2 ) {
				// timer.stop(); --> 비권장
				timer.setStop( false ); // 변수를 이용한 안전 종료
				timerstate = false;
				waitstate = true;
				timer = new Timer();
			} // if 종료
			
			
		} // while 종료
		
		
		
		
	}
}
