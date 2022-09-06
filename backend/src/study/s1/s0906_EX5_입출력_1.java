package study.s1;

import java.util.Scanner;

public class s0906_EX5_입출력_1 {

	public static void main(String[] args) {
		
		// p. 90 print format : 출력형식 [ 서식 = 모양 = 폼 ]
		
		int 변수 = 123;
		System.out.println(변수 + "원");
		System.out.printf("%d원\n", 변수);
		
		int value = 123;
		System.out.printf("상품의 가격 : %d원\n", value);
		System.out.printf("상품의 가격 : %6d원\n", value);
		System.out.printf("상품의 가격 : %-6d원\n", value);
		System.out.printf("상품의 가격 : %06d원\n", value);
		
		double area = 3.14159 *10 * 10;  // 실수
		System.out.printf("반지름이 %d인 원의 넓이 : %10.2f\n", 10, area);
		
		String name = "홍길동";
		String job = "도적";
		System.out.printf("%6d | %-10s | %10s\n", 1, name, job);
		
		
		// 입력객체(클래스) 선언
		Scanner 입력객체 = new Scanner(System.in);
		// [객체 생성] 클래스명 객체명 = new 생성자();
			// new 객체 선언 시 메모리 할당 키워드
		
		int 입력정수 = 입력객체.nextInt();
		System.out.println("입력 받은 정수 : " + 입력정수 );
		
		String 입력문자열 = 입력객체.next();
		System.out.println("입력 받은 문자열 : " + 입력문자열);
		
		System.out.println("------------------------\n");
		
		
		// 입력예제
		// 1. 입력받기 [ 준비물 : scanner 클래스로 객체 1개 필요 ]
		// 2. 키보드 ( system.in) --입력 > 객체저장 -- next() --> 변수저장
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("이름 : ");
		String 이름 = scanner.next();
		
		System.out.println("나이 : ");
		int 나이 = scanner.nextInt();
		
		System.out.println("키 : ");
		double 키 = scanner.nextDouble();
		
		// 3. 변수 출력
		System.out.println("---------------개인정보------------\n");
		System.out.printf("%5s \t %5s \t %5s\n", "이름", "나이", "키");
		System.out.printf("%5s \t %td \t %5.1f", 이름, 나이, 키);
		
	
	}	// 메인끝
}	// 클래스끝







/*


	system.out.print : 출력
	system.in.print : 입력
	
	 형식문자
	 	1. %d : 정수
	 		%숫자d	: 오른쪽부터 숫자만큼 자리차지 [ 만약에 숫자가 없을 경우 공백 채움 ]
	 		%0숫자d	: 오른쪽부터 숫자만큼 자리차지 [ 만약에 숫자가 없을 경우 0 채움 ]
	 		%-숫자d	: 왼쪽부터 숫자만큼 자리 차지 [ ]
	 		
	 		
	 	2. %f : 실수
	 		%자리수.소수자리f
	 			%10.2f : 10자리의 자리 차지, 소수점 2자리 표시












*/


