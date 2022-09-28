package java1.ch04_배열;

import java.util.Scanner;

public class EX5_학생점수관리 {
	public static void main(String[] args) {
		
		
		boolean run = true;			// 무한루프 제어 변수
		int studentNum = 0;			// 학생 수 저장 변수
		int[] scores = null; 		// 여러개 점수를 저장할 배열 [ 메모리 할당 전 / 깡통 ] 
		
		Scanner scan = new Scanner(System.in);	// 입력 객체
		
		while (run) {	// 무한루프 실행 [ 종료조건 : 5 입력했을때 ]
			System.out.println("----------------------------");
			System.out.println("1. 학생수 2. 점수입력 3. 점수리스트 4. 분석 5. 종료");
			System.out.println("선택 : ");
			int selectNo = scan.nextInt();
			
			if( selectNo == 1 ) {				// 1 입력했을때
				System.out.println("학생수 : ");
				studentNum = scan.nextInt();
				scores = new int[studentNum];	// *** 입력받은 학생수 만큼 배열에 메모리(길이) 할당
						// new 자료형 [길이]
				System.out.println("배열에 " + studentNum + " 명의 점수 입력 가능");
			}	// if 1 끝
			
			else if( selectNo == 2 ) {			// 2 입력했을때
				for( int i = 0; i < scores.length; i++ ) {	// i는 0부터 배열의 길이까지 1씩 증가 반복
					System.out.print("scores[" + i + "]");
					scores[i] = scan.nextInt();	// i번째 인덱스에 입력 값을 대입
				}	
			}	// else if 1 끝
			
			else if( selectNo == 3 ) {			// 3 입력했을때

				for( int i = 0; i < scores.length; i++ ) {
				 // System.out.printf("scores[%d]> %d" , i , scores[i]);
					System.out.printf("scores[%d]> %d \n" , i , scores[i]);
				}
//				int i = 0;
//				for( int value : scores ) {
//					i++;						
//				}
// 				* [이런 방법도 가능] 반복 회수를 카운트할때 변수하나 생성해서 인덱스 수를 세면 됨		
			}	// else if 2 끝
			
			else if( selectNo == 4 ) {			// 4 입력했을때
				
				int max = 0;	// 최고점수
				int sum = 0;	// 평균 구하기 전 합계 구하기
				for( int value : scores ) {
					if( value > max ) {			// 만약에 해당 값이 max보다 크면 max에 대입
						max = value;
					}
				sum += value;	// 해당 값을 sum 변수에 누적 더하기
				}
				System.out.println( "최고 점수 : " + max );
				double avg = (double)sum/scores.length;
							// * 강제형변환 int -> double
				System.out.println( "평균 점수 : " + avg );	// 평균 : 합계/개수
			
			
			// * 순위별 [ 내림차순 ] 출력
				int temp = 0;	// 값 주고 받을때 저장해줄 변수 생성
				for( int i = 0; i < scores.length; i++) {	// 기준 : 스코어에 저장된 배열들을 왔다리갔다리해서 내림차순(높은값위로) 해줄거다
					for( int j = i+1; j < scores.length; j++ ) {
						if ( scores[i] < scores[j]) {	// > 오름차순, < 내림차순
							// 두 변수 효관
							temp = scores[i];		
							scores[i] = scores[j];
							scores[j] = temp;	
					
						}// if 끝
					} // for2 끝	
				} // for1 끝
				
				int rank = 0;
				for( int value : scores ) {
					System.out.println(value);
					rank++;
				}
				
				
			}	// else if 3 끝
			
			else if( selectNo == 5 ) {			// 5 입력했을때
				run = false;					// 와일이 false로 변경되면서 무한루프 종료
			}	// else if 4 끝
			
			else {			// 그외
				System.out.println("안내) 알 수 없는 번호 입니다.");
			}
			
			
			
		} // 무한루프 종료
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	// 메인 끝
}	// 클래스 끝	
