package java1.ch3조건문반복문;

import java.util.Random;
import java.util.Scanner;

public class EX6_가위바위보 {

	public static void main(String[] args) {
		
/*
  
 	가위바위보 게임
 		[ 조건 ]
 		1. 플레이어에게 가위[0], 바위[1], 보[2] 중에 입력받기
 		2. 컴퓨터에게 난수 [ 0 ~ 2 ] 생성
 			* Random 클래스 사용
 			* Random ran = new Random();	// 3 넣으면 0부터 2까지 ( 랜덤 변수의 범위가 지정숫자 -1까지이기 때문)
 			* 변수명.nextInt(수) : 0~수-1 까지의 난수 발생
 		3. 승리자 판단 [ 경우의 수 ]
 		4. 게임종료 시 최종 승리자 출력 [ 10판했으면 더 많이 이긴 사람이 승리 ]
 	  		1. 게임 판수 출력 
 	  		2. 최종 승리자가 출력
 		
 		[ 메뉴 ] 
 			가위(0) 바위(1) 보(2) 종료(3)
 			
 			
 */		
		
		// 0. 모든 코드에서 사용될 변수[메모리] 선언
		Scanner scan = new Scanner(System.in);
		
		int 플레이어 = 0;
		int 컴퓨터 = 0;
		int 판수 = 0;
		int 승리수 = 0;	// 0 : 무승부, 양수 : 플레이어, 음수 : 컴퓨터
		
		
		// 4. 반복될 수 있도록 와일문 추가
		while ( true ) {	// 와일 시작 [ 종료조건 : 3 입력 시 종료 ]
			
			// 1. 플레이어에게 입력 받기
			System.out.println(" ★ 가위 바위 보 게임 시작 ★ ");
			System.out.println("가위(0) 바위(1) 보(2) 종료(3): ");
			플레이어 = scan.nextInt();
			
				
				// 6. 입력 경우의수 [ 1. 0~2 : 게임진행 번호 / 2. 3 : 게임종료 번호 / 3. 그외 : 비정상 번호 ] 

				if((플레이어 >= 0) && (플레이어 <=2)) {	// 플레이어가 정상적인 진행번호를 눌렀을때 게임 시작			// if문 시작
					// ----------------------------------- 게임진행 코드 ----------------------------------------- //
					
					// 2. 컴퓨터에게 난수 입력 받기
					Random ran = new Random(); // 1. 랜덤 객체를 생성한다.
					컴퓨터 = ran.nextInt(3); // 2. 랜덤 객체를 이용한 int형 난 수  생성 : 객체명.nextInt(수)  0~(수-1)
					
					//3. 승리자 판단 [ 경우의 수 3개 = 1.승리 2.무승부 3.패배 ]
					if( (플레이어 == 0 && 컴퓨터 == 2) || (플레이어 == 1 && 컴퓨터 == 0) || (플레이어 == 2 && 컴퓨터 == 1) ) {	// 1. 승리	내가 이기는 수 : [ 나 : 컴 = 0 2 , 1 0 , 2 1 ] 
						System.out.println("[ 플레이어 승리 ]");
						System.out.println("----------------------");
						System.out.println("플레이어 >> " + 플레이어);
						System.out.println("컴퓨터 >> " + 컴퓨터);
					
						승리수++;
					}	
					else if( (플레이어 == 0 && 컴퓨터 == 0) || (플레이어 == 1 && 컴퓨터 == 1) || (플레이어 == 2 && 컴퓨터 == 2) ) {	// 2. 무승부
						System.out.println("[ 무승부 ]");
						System.out.println("----------------------");
						System.out.println("플레이어 >> " + 플레이어);
						System.out.println("컴퓨터 >> " + 컴퓨터);
					} 
					else {	// 3. 패배	컴퓨터가 이김
						System.out.println("[ 컴퓨터 승리 ]");
						System.out.println("----------------------");
						System.out.println("플레이어 >> " + 플레이어);
						System.out.println("컴퓨터 >> " + 컴퓨터);
						
						승리수--;
					} 
					
					// ----------------------------------- 게임진행 코드 ----------------------------------------- //
					
				}	// if문 종료
				else if( 플레이어 == 3 ) {
					System.out.println("게임종료] 게임횟수 : " + 판수 );
					
					if( 승리수 == 0 ) {
						System.out.println( "최종결과] 무승부" );						
					}
					else if( 승리수 >= 1 ) {
						System.out.println( "최종결과] 플레이어 승리" );

					}
					else {
						System.out.println( "최종결과] 컴퓨터 승리" );

						break;	// 게임 종료 무한루프 탈출
					}
				}
				else {
					System.out.println("안내] 알 수 없는 번호입니다.");
				}
			
			
			
			
			// 5. 게임횟수 증가
			판수++;
			System.out.println("현재 게임 판수 >> " + 판수);
			System.out.println("----------------------\n");
		}	// 와일 종료
		
		

		
		
		
		
		
		
	}	// main 끝
		
}	//	클래스 끝
