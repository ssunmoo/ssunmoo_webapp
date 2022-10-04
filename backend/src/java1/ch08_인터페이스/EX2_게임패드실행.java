package java1.ch08_인터페이스;

import java.util.Scanner;

public class EX2_게임패드실행 {
	
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		게임패드 gpad;
		// 인터페이스 변수 선언
		
		while ( true ) {
			System.out.println("1. 축구게임 2. 비행기게임");
			int ch = scan.nextInt();
			if ( ch == 1 ) {
				gpad = new 축구게임();
				// 인터페이스 변수에 구현객체 주소 값 대입(연결)
				System.out.println("★축구 게임 시작★");
				게임스타트(gpad);
			}
			else if ( ch == 2 ) {
				gpad = new 비행기게임();
				System.out.println("★비행기 게임 시작★");
				게임스타트(gpad);
			}
		} // while 종료
	} // 메인 종료

	public static void 게임스타트( 게임패드 gpad ) {
								// gpad에 연결되어있는 주소 값 전달
								// 파라미터의 다형성
		while ( true ) {
			char 버튼 = scan.next().charAt(0);
			if ( 버튼 == 'A' ) {
				gpad.A버튼();
			}
			if ( 버튼 == 'B' ) {
				gpad.B버튼();
			} 
			if ( 버튼 == 'C' ) {
				gpad.C버튼();
			}
			if ( 버튼 == 'E' ) {
				return;
			}
			
		} // while 종료
	} // 게임스타트 메소드 종료
		
}
