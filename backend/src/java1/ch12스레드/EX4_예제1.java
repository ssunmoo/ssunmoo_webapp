package java1.ch12스레드;

import java.util.Scanner;

public class EX4_예제1 {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		// 음악 스레드 선언
		
		boolean musicstate = false;	// 음악 재생 여부 판단 변수
		Music music = new Music();
		
		boolean moviestate = false; // 영화 재생 여부 판단 변수
		Movie movie = new Movie();
		Thread thread = new Thread(movie); // 영화 스레드 선언
		
		while ( true ) {
			
			
			// 음악 재생
			if ( musicstate == false ) {
				System.out.println("1. 음악[재생] ");
			}
			else {
				System.out.println("1. 음악[중지] ");
			}

			
			// 영화 재생
			if ( moviestate == false ) {
				System.out.println("2. 영화[재생] ");
			}
			else {
				System.out.println("2. 영화[중지] ");	
			}
			
			int ch = scan.nextInt();


			// 1. 음악재생
			if ( ch == 1 && musicstate == false ) {	// 입력한 값이 1번이면서 음악스레드가 꺼져있으면
				music.start();			// 음악 스레드 실행 메소드
				musicstate = true;		// 현재 스레드가 작업 스레드의 재생여부 변경
			}
			else if ( ch == 1 && musicstate == true ) {	// 입력한 값이 1번이면서 음악스레드가 켜져있으면
				musicstate = false;		// 현재 스레드가 작업 스레드의 재생여부 변경
				music.setStop( false );	// 음악 스레드 종료 -> while 종료 -> run 메소드 종료 [ 멀티스레드 종료 ]
				music = new Music(); 	// 재실행을 위해 메모리를 다시 가지고와야함
			}
			
			// 2. 영화재생
			if( ch == 2 && moviestate == false ) {
				thread.start();
				moviestate = true;
			}
			else if ( ch == 2 && moviestate == true ) {
				// thread.stop();	// 강제종료 [ 비권장 ] 
				movie.setStop( false );
				moviestate = false;
				thread = new Thread(movie); // 재실행을 위해 메모리를 다시 가지고와야함
			}
		
		
		
		} // 와일 종료
		
		
		
		
		
		
	} // 메인 종료
		
}

/*
	
	Thread 클래스
	Runnable 인터페이스



*/