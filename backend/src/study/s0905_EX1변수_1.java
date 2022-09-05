package study;	// 패키지명

public class s0905_EX1변수_1 {	// 전범위에서 클래스 실행

	public static void main(String[] args) {
		// main 메소드 작성 : 코드를 읽어주는 역할 [ 메인이 없으면 콘솔창에 출력 x ]
		
		
		
		// p. 48
		// 변수 : 변하는 수 [ 데이터 1개 저장 가능한 메모리 ]
		// p. 52
		int value;
		// 변수의 선언 [ 자료형 : 변수명; ]
		
		value = 10;
		// 변수에 값 대입[ 초기화 ]
		System.out.println(value);

		int result = value + 10;
		System.out.println(result);
		
		// p. 53
		int hour = 3;
		int minute = 5;
		// 변수 선언과 동시에 값 대입 [ 초기화 = 처음에 값을 넣어준다 ]
		
		System.out.println(hour + "시간 " + minute + "분");
		// + 연산자
			// 1. 연결 연산자 : 변수 + "문자열" + 변수
				// 3+java => 3java
			// 2. 더하기 연산자 : 변수[숫자] + 변수[숫자] 일때
				// 3+3 => 6
				// ** 하나라도 문자가 있으면 견결 연산자로 출력
		
		
		int totalMinute = ( hour * 60 ) + minute;	// + 더하기 연산자
		System.out.println("총 : " + totalMinute + " 분");	// + 연결연산자
		
		
		// p. 53
		
		int x = 3;
		int y = 5;
		System.out.println("x : " + x + ", y : "+ y);
			// 코드는 순서대로 [ 순서도 / 알고리즘 ] 하나씩 처리한다
			// 문제발생 ** 1:1로 값을 주고 받을 수 없음
			// x = y;	x = 5, y = 5;
			// y = x;	x = 5, y = 5;
		
		// 임시보관 변수 생성 [문제해결 = 임시변수]
		int temp = x;
		x = y;
		y = temp;
		System.out.println("x : " + x + ", y : " + y);
		
	
		
	}	// 메인 e
	
}	// 클래스 e



/*
	1. 변수 선언
		1. 자료형[변수의 크기]
		2. 변수명[변수의 이름] -- 번역[컴파일] --> 메모리 주소 찾아가기
		3. 값 [변수에 들어있는 데이터]
		
		int value = 10;
		[1]		[2]		[3]
		자료형	변수명 = 데이터
	
	2. 변수 호출
		변수명
		
	
	컴퓨터 [ 0, 1 ]		본체
						1. CPU						: 관리 감독 제어 번역 등
						2. 주기억 장치 RAM (메모리)		: 저장[변수] : 프로그램 실행시 [ 휘발성 메모리 ]
						3. 보조기억 장치 ROM (HDD, SSD) : .class 코드파일 [ 비휘발성 메모리 ] : DB
						
						
						메모리[RAM]
	int 변수 = 10				0x1f8b1d2 [ 16진수 메모리 주소 ]				

*/














