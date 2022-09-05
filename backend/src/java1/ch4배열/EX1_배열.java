package java1.ch4배열;

public class EX1_배열 {

	public static void main(String[] args) {
		
		
		// p.180 예제1
		
		// 1. 배열 선언
		int[] scores = { 83, 90, 87 };	// int형 배열 선언, 3개 값 초기화, 인덱스 0 ~ 2
		
		// 2. 배열 호출
		System.out.println("배열[0] : " + scores[0]);	// 배열내 0번 인덱스 호출 -> 83
		System.out.println("배열[1] : " + scores[1]);	// 배열내 1번 인덱스 호출 -> 90
		System.out.println("배열[2] : " + scores[2]);	// 배열내 2번 인덱스 호출 -> 87
		System.out.println("배열 : " + scores);		// 배열명 입력시 주소[번지]값 호출
		
		// 3. 배열 반복문 활용
		int sum = 0;
		for( int i = 0; i < scores.length; i++) {	// i는 0부터 배열의 길이 미만까지 1씩 증가
			sum += scores[i];	// i번째 인덱스 값을 호출해서 sum 변수에 누적 더하기	
		}
		System.out.println("총합 : " + sum);
		System.out.println("평균 : " + (sum/3) );		
							// 1. sum/3 	-> int/int 		-> int
							// 2. sum/3.0 	-> int/double 	-> double
		
		
		
		
		// 예제2
		
		// 1. 배열 선언 [ new 연산자 사용 ]
		int[] 배열 = new int[3];	// new 연산자를 이용한 int형 3개를 저장할 수 있는 배열 선언 [ 고정 길이 ]
		
		// 2. for 배열 내 모든 인덱스 호출
		for( int i = 0; i < 배열.length; i++ ) {
			System.out.println(배열[i]);
		}
		
		// 3. 배열내 각 인덱스 데이터 넣기
		배열[0] = 100;
		배열[1] = 93;
		배열[2] = 20;
		
		// 4. for 배열 내 모든 인덱스 호출
		for( int i = 0; i < 배열.length; i++ ) {
			System.out.println(배열[i]);
		}
		
		// 5. 향상된 for문
		for( int value : 배열) {
			// for( 반복변수 : 배열명 )
			// 배열내 첫번째 인덱스[0]부터 마지막 인덱스까지 반복 변수에 하나씩 담기
			System.out.println( value );
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // 메인 끝
}	// 클래스 끝
