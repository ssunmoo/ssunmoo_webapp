package java1.ch4배열;

import java.util.Random;
import java.util.Scanner;

public class EX3_틱택토 {
	public static void main(String[] args) {
	
/*
 		택택토 게임
 			[ 조건 ] 
  			1. 게임판 6칸 사용 -> 배열[0~8]
  				1. String 배열		클래스는 비교연산자 불가능
  					== : 문자열1.equals(문자열2)
  					!= : 문자열1.equals(문자열2)
  					
  			2. 사용자(o)가 알을 두고자 하는 위치를 [인덱스]로 입력
  				1. 선택된 위치에 이미 다른 알이 존재하면 재입력[중복제거]
  				
  			3. 컴퓨터(x)가 난수 배열을 생성[0~8]
  				1. 난수의 위치에 이미 다른 알이 존재하면 재생성
  				
  			4. 승리자 판단 [ 1. 가로 2. 세로 3. 대각선 4. 무승부 ]
  			

  			 
  			[ 출력 ]
  			1. 게임판 출력 예시
  			[ ] [ ] [ ]		0 1 2
  			[ ] [ ] [ ] 	3 4 5
  			[ ] [ ] [ ] 	6 7 8
  			
 */
		
		
		
		
		String[] 게임판 = { "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"};
		// String형 배열 9개 생성 및 초기값 설정
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		System.out.println("★ 게임시작 ★\n");
		
		while (true) {	// 와일1 시작
			// 무한루프 [ 종료조건 : 승리판단이 있을 경우 ]
			// 1. 게임판 출력 --> 배열내 모든 데이터 출력
			for( int i = 0; i < 게임판.length; i++ ) {
				System.out.print( 게임판[i] );
				if( i % 3 == 2 ) {
					System.out.println();
				} // if 2 끝
			} // for 1 끝
		

			// 2. 사용자 위치 선택
			while (true) {	// 와일2 시작
				// 무한루프 [ 종료조건 : 알을 두었을때 종료 break ]
				
				System.out.println("위치를 선택하세요 >> ");
				int 위치 = scan.nextInt();
				
				if( 위치 < 0 || 위치 > 8 ) {
					System.err.println("안내) 선택할 수 없는 번호입니다. ");
				}
				if( 게임판[위치].equals("[ ]") ) {
				// 해당 위치에 알이 없으면 해당위치에 알두기
					게임판[위치] = "[O]";
					break;
				}
				else {
					System.err.println("안내) 이미 알이 존재하는 위치입니다.");
				}
			
			} // 와일2 끝

			// 3. 컴퓨터 위치 선택 [ 난수 생성 ]
			while (true) {
				int 위치 = ran.nextInt(9);		// 0 ~ 8 난수 생성
				if( 위치 < 0 || 위치 > 8 ) {		
				}
				if( 게임판[위치].equals("[ ]") ) {	// 게임판 위치가 공백일경우 
					게임판[위치] = "[X]";			// 게임판 위치에 X로 표시
					break;						// 알을 두면 무한루프 종료
				}
			} // 와일3 끝
			
			
			// 4. 승리판단	--> 가로 0 1 2, 3 4 5, 
			if( 게임판[0].equals("[O]")) {	// 게임판 위치에 O 값이 들어있을때
				if( 게임판[0].equals(게임판[1]) && 게임판[1].equals(게임판[2]) ) {
					System.err.println("★★승리★★");
				}
			}
			
			if( 게임판[3].equals("[O]")) {	// 게임판 위치에 O 값이 들어있을때
				if( 게임판[3].equals(게임판[4]) && 게임판[4].equals(게임판[5]) ) {
					System.err.println("★★승리★★");
				}
			}
			
			if( 게임판[6].equals("[O]")) {	// 게임판 위치에 O 값이 들어있을때
				if( 게임판[6].equals(게임판[7]) && 게임판[7].equals(게임판[8]) ) {
					System.err.println("★★승리★★");
				}
			}
			
			
			// 4. 승리판단 --> 세로	0 3 6, 1 4 7, 2 5 8
			if( 게임판[0].equals("[O]")) {
				if( 게임판[0].equals(게임판[3]) && 게임판[3].equals(게임판[6]) ) {
					System.err.println("★★승리★★");
				}
			}
			
			if( 게임판[1].equals("[O]")) {
				if( 게임판[1].equals(게임판[4]) && 게임판[4].equals(게임판[7]) ) {
					System.err.println("★★승리★★");
				}
			}	
				
			if( 게임판[2].equals("[O]")) {
				if( 게임판[2].equals(게임판[5]) && 게임판[5].equals(게임판[8]) ) {
					System.err.println("★★승리★★");
				}
			}
			
			// 4. 승리판단 --> 대각선 0 4 8 , 2 4 6
			if( 게임판[0].equals("[O]")){
				if( 게임판[0].equals(게임판[4]) && 게임판[4].equals(게임판[8]) ) {
					System.err.println("★★승리★★");
				}
			}
			
			if( 게임판[2].equals("[O]")) {
				if( 게임판[2].equals(게임판[4]) && 게임판[4].equals(게임판[6])) {
					System.err.println("★★승리★★");
				}
			}
			
			
			
			
			// 무승부
			// 승리자가 안나올경우 
			// if( 게임판[] )
			
			
			
				
			
			
//				if( 게임판[3].equals("[O]") && 게임판[4].equals("[O]") && 게임판[5].equals("[O]") ) {
//					System.err.println("★★승리★★");
//				}
//				
//				if ( 게임판[6].equals(게임판[7]) && 게임판[7].equals(게임판[8]) ) {
//					System.err.println("★★승리★★");
//				}
//				
//			} // if1 끝
		
			
			
			
		} // 와일1 끝
		
			
		
	
			
		

		
	}	// 메인 끝
}	// 클래스 끝









