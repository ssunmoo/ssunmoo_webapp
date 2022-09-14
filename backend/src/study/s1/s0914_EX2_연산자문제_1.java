package study.s1;

import java.util.Scanner;

public class s0914_EX2_연산자문제_1 {

	public static void main(String[] args) {
		
		
		// 문제 1 급여계산	
			// [ 조건 ] 입력받기 : 기본급 , 수당
			// [ 출력 ] 실수령액 = 기본급 + 수당 - 세금 [ 기본급 10% ]
		
		
		Scanner scan = new Scanner(System.in);
		
//		System.out.println("기본급 입력 : ");
//		int 기본급 = scan.nextInt();
//		
//		System.out.println("수당 입력 : ");
//		int 수당 = scan.nextInt();
//		
//		int 실수령액 = 기본급 + 수당 - (int)(기본급 * 0.1); // 강제 형변환 : double -> int 
//		System.out.println("실수령액 ㅣ " + 실수령액 );
		
		
		
//		// 문제 2 : 지폐 개수 세기
//			// 조건 : 십만원 단위의 금액을 입력받기
//			// 출력 : 입력받은 금액의 지폐수 출력
//			// 예시 : 3556789
//			// 십만원권 3장, 만원권 5장, 천원권 6장
//		
//		System.out.println("문제2] 10만원 단위의 금액 입력 ");
//		int 금액 = scan.nextInt();
//		
//		System.out.println("십만원 ㅣ " + (금액 / 100000 ) + "장");
//			금액 -= (금액/100000) * 100000;
//		System.out.println("만원 ㅣ " + (금액 / 10000 ) + "장");
//			금액 -= (금액/10000)* 10000;
//		System.out.println("천원 ㅣ " + (금액 / 1000 ) + "장");
		
		
//		// 문제 3 하나의 정수를 입력받아 7의 배수이면 맞다 아니면 아니다
//		
//		System.out.println("7의배수를 입력하세요");
//		int 문제3 = scan.nextInt();
//		
//		String 문제3결과 = (문제3 % 7 == 0 ) ? "맞다" : "아니다";
//		System.out.println(문제3결과);
		
		
//		// 문제 4 하나의 정수를 입력 받아 홀수이면 홀수 아니면 짝수
//		
//		System.out.println("정수를 입력하세요");
//		int 문제4 = scan.nextInt();
//		
//		String 문제4결과 = (문제4 % 2 == 0 ) ? "짝수" : "홀수";
//		System.out.println(문제4결과);
		
		
		
//		// 문제 5 하나의 정수를 입력 받아 7의 배수이면서 짝수이면 참 아니면 거짓
//		
//		System.out.println("정수를 입력하세요");
//		int 문제5 = scan.nextInt();
//		
//		String 문제5결과 = (문제5 % 7 == 0 ) && (문제5 % 2 == 0) ? "참" : "거짓";
//		System.out.println(문제5결과);
		
		
//		// 문제 6 두개의 정수를 입력 받아 더 큰 수 출력
//		
//		System.out.println("정수 1 입력");
//		int 문제6정수1 = scan.nextInt();
//		
//		System.out.println("정수 2 입력");
//		int 문제6정수2 = scan.nextInt();
//		
//		int 문제6결과 = 문제6정수1 > 문제6정수2 ? 문제6정수1 : 문제6정수2;
//		System.out.println(문제6결과);
		
		
//		// 문제 7 반지름을 입력받아 원 넓이 출력하기
//		
//		System.out.println("반지름 입력");
//		double 문제7 = scan.nextDouble();
//		
//		double 문제7결과 = (문제7 * 문제7) * 3.14; 
//		System.out.println(문제7결과);
		
//		// 문제 8 두 실수를 입력 받아 앞 실수의 값이 뒤의 값의 몇 % 인지 출력
//		
//		System.out.println("실수 1 입력");
//		double 문제8실수1 = scan.nextDouble();
//		
//		System.out.println("실수 2 입력");
//		double 문제8실수2 = scan.nextDouble();
//		
//		double 문제8결과 = ( 문제8실수1 / 문제8실수2 )*100;
//		System.out.println(문제8결과);
		
		
//		// 문제 9 사다리꼴 넓이 구하기 
//		// 사다리꼴 계산식  (윗변 + 밑변) * 높이 / 2 
//		
//		System.out.println("윗변");
//		double 윗변 = scan.nextDouble();
//		
//		System.out.println("밑변");
//		double 밑변 = scan.nextDouble();
//		
//		System.out.println("높이");
//		double 높이 = scan.nextDouble();
//		
//		double 넓이구하기 = ( 윗변 + 밑변 )*높이 / 2;
//		System.out.println(넓이구하기);
		
		
		
//		// 문제 10 키를 정수로 입력 받아 표준체중 출력
//		// 표준 체중 계산식 -> ( 키 - 100 ) * 0.9
//		
//		
//		System.out.println("키 입력");
//		double 키 = scan.nextInt();
//		
//		double 표준체중 = (( 키 - 100 ) *0.9);
//		System.out.println(표준체중);
		
		
//		// 문제 11 키와 몸무게를 입력받아 BMI 출력
//		// 계산식 = 몸무게 / ((키 / 100 ) * (키 / 100))
//		
//		System.out.println("키를 입력하세요");
//		int 문제11키 = scan.nextInt();
//		
//		System.out.println("몸무게를 입력하세요");
//		int 문제11몸무게 = scan.nextInt();
//		
//		int 문제11BMI = (문제11몸무게 / ((문제11키 / 100) * (문제11키 / 100)));
//		System.out.println(문제11BMI);
		
		
//		// 문제 12 inch 를 입력 받아 cm 로 변환 [ 1inch -> 2.54cm ]
//		
//		System.out.println("inch 입력");
//		double inch = scan.nextDouble();
//		
//		double cm = ( inch * 2.54 );
//		System.out.println(cm);
		
		
		
//		// 문제 13 중간고사 기말고사 수행평가를 입력받아 반영비율별 계산
//		// 소수 둘째자리까지 점수 출력
//		// 중간고사 반영비율 -> 30% 기말고사 반영비율 -> 30% 수행평가 반영비율 -> 40%
//		
//		System.out.println("중간고사 점수");
//		double 중간고사 = scan.nextDouble();
//		
//		System.out.println("기말고사 점수");
//		double 기말고사 = scan.nextDouble();
//		
//		System.out.println("수행평가 점수");
//		double 수행평가 = scan.nextDouble();
//		
//		double 점수출력 = ( 중간고사 * 0.3 + 기말고사 * 0.3 + 수행평가 * 0.4 );
//		System.out.printf("점수는 : %.2f\n", 점수출력);
		
	
		
//		// 문제 14 연산 순서를 나열하고 x와 y값 예측하기
//		
//		int x = 10;
//		int y = x-- + 5 + --x;
//		System.out.printf("x의 값 : %d, y의 값 : %d ", x, y );
//
//		/*
//			증감 연산자가 1순위로 계산
//			[ 순서 ]
//			1. x--	: 10 [후위 : 나중에 감소 ]
//			2. --x  : 9 [선위 : 바로 감소 ]
//			3. x-- + 5 : 10 + 5 > 15 (-1) [x-- 후위 감소]
//			4. 14 + 9 : 14 + 9 > 23
//			5. y = 23
//
//		*/
		
		
		// 문제 15 정수 3개를 입력 받아 오름차순 출력
		
		System.out.println("정수 1");
		int a = scan.nextInt();
		
		System.out.println("정수 2");
		int b = scan.nextInt();
		
		System.out.println("정수 3");
		int c = scan.nextInt();
		
		int temp = 0;
		
		if( a > b ) {
			temp = a;
			a = b;
			b = temp;
		}
		if( a > c ) {
			temp = a;
			a = c;
			c = temp;
		}
		if( b > c ) {
			temp = b;
			b = c;
			c = temp;
		}
		System.out.println(a + "" + b + "" + c);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
