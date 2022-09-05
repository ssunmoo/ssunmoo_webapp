package java1.ch4배열;

import java.util.Random;
import java.util.Scanner;

public class EX2_로또판별기 {
	public static void main(String[] args) {
	
	
/*
 	로또 판별기
 		1. 구매번호 : 사용자에게 6개 수 입력 -> 배열저장
 			1. 1~45 사이만 입력받기 아니면 재입력
 			2. 중복 제거
 			
 		2. 추첨번호 : 컴퓨터 난수 6개 -> 배열저장
 			1. 1~45 사이의 난수만 입력 받기
 		
 		3. 구매번호와 추첨번호와 동일한 수의 개수가 몇개인	
*/
		
		// 0. 메모리[변수/배열] 선언
		Scanner scan = new Scanner(System.in);
		
		int[] 구매번호 = new int[6];	// int형 변수 6개를 저장할 수 있는 공간
		int[] 추첨번호 = new int[6];	// int형 변수 6개를 저장할 수 있는 공간
		
		// 1. 사용자에게 입력을 [6번] 받는다.
		for( int i = 0; i < 6; i++ ) {
			// i = 인덱스
			
			System.out.println("안내) "+ (i+1) + "번째 번호 선택 : ");
			구매번호[i] = scan.nextInt();
			// 입력 받은 값을 i번째 인덱스에 저장
			
			
			
			// [조건1] 1~45 사이 값 입력 받기
			if( 구매번호[i] < 1 || 구매번호[i] > 45 ) {
				// 만약에 입력한 값이 1보다 작거나 45보다 크면 재입력
				System.err.println("안내) 선택할 수 없는 번호 입니다." );
				i--;
				// 틀린번호를 입력했을 경우 선택한 값을 깍아준다 / 현재 i 무효처리
				continue;
				// 다시 반복문 실행 ---> 증감식
			} 	// if 끝
			
			
			
						
			// [조건2] 배열내 입력된 데이터 확인[ 중복 확인 ]
			boolean 중복체크 = false;
			// 중복여부 젖아하는 변수
			
			for( int j = 0; j < i; j++) {
				if( 구매번호[j] == 구매번호[i] ) {
					System.out.println("안내) 이미 선택된 번호입니다.");
					중복체크 = true;	// 중복 찾았으면 true로 바꾸고 중복체크
				} // if 종료
			}	// for2 종료
			
			if( 중복체크 ) {
				i--;
				continue;
				// 문제가 생기면 반복문으로 이동하기 때문에 1번째 for로 이동
			} System.out.println(구매번호[i] + " 숫자를 선택하셨습니다.");
		}	// for1 끝
		
			// --------------------- 사용자 입력 끝 ------------------------------ //
		
		
		
		
			// --------------------- 컴퓨터 입력 부분 ------------------------------ //
		
		// 컴퓨터 추첨번호
		for( int i = 0; i < 6; i++) {
			Random ran = new Random();
				// 랜덤과 관련된 메소드 제공
				// random.nextInt( 수 ); --> 0부터 입력 수 -1까지 난수 발생
				// random.nextInt( 끝번호 )+시작번호; --> 시작번호 ~ 끝번호까지 난수 발생
			
			추첨번호[i] = ran.nextInt(45)+1;
				// 1 ~ 45 사이의 난수 발생
			
				// [조건1] 중복체크
			for( int j = 0; j < i; j++) {
				if( 추첨번호[j] == 추첨번호[i] ) {
					i--;		// 중복 숫자니까 카운트를 하나 마이너스
					continue;	// 중복을 찾았을 때 조건식을 다 돌지 않고 나감
				}
			} // 컴터 for2 
		} // 컴터 for1 끝
		
		
			// --------------------- 구매번호, 추첨번호 출력부분 ------------------------------ //
		
		for( int value : 구매번호 ) {
			System.out.printf("%2d\t", value);
		}
		System.out.println();
		
		for( int value : 추첨번호 ) {
			System.out.printf("%2d\t", value);
		}
		System.out.println();
		
		
			// --------------------- 구매번호, 추첨번호 두 배열간 동일한 수 출력 ------------------------------ //		
		
		// 각 i마다 j와 비교
		
		int 당첨수 = 0;
		for( int i = 0; i < 구매번호.length; i++ ) {		// 6회
			for( int j = 0; j < 추첨번호.length; j++) {	// 6회 * 6회 -> 36회
				if( 구매번호[i] == 추첨번호[j] ) {
					당첨수++;		// i번째 인덱스와 j번째 인덱스의 값이 같으면 ++
				}
			}	
		}	System.out.println( "총 당첨 개수 : " + 당첨수 );
			
	
		
		
		
		
		
		
		
		
		
		
		

		
		
	}	// 메인 끝
}		// 클래스 끝
