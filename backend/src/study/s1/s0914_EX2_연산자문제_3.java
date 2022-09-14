package study.s1;

import java.util.Scanner;

import javax.swing.text.html.CSS;

public class s0914_EX2_연산자문제_3 {

	public static void main(String[] args) {
		
	
	Scanner scanner = new Scanner(System.in);
///*
//	문제1 : 급여 계산 
//		[조건] 입력받기 : 기본급 , 수당 
//		[출력] 실수령액 = 기본급 + 수당 - 세금[기본급10%]
//*/		
//	System.out.println("기본급");
//	double 기본급 = scanner.nextInt();
//	
//	System.out.println("수당");
//	double 수당 = scanner.nextInt();
//	
//	double 실수령액 = (기본급 + 수당) *0.1;
//	System.out.println(실수령액);
	
///*
// 	문제2 : 지폐 개수 세기 
// 		[조건] 십만원 단위의 금액을 입력받기 
// 		[출력] 입력받은 금액의 지폐수 출력 
// 		[예시]  356789
// 			십만원 : 3장 
//			만원 : 5장 
//			천원 : 6장
//*/	
//	System.out.println("십만원단위 금액 입력");
//	int 금액 = scanner.nextInt();
//	
//	System.out.println("십만원 : " + (금액/100000) );
//	금액 -= (금액/100000) * 100000;
//	System.out.println("만원 : " + (금액/10000));
//	금액 -= (금액/10000) * 10000;
//	System.out.println("천원 : " + (금액/1000));
	
	

//// 문제3 : 하나의 정수를 입력받아 7의 배수 이면 '맞다' 아니면 '아니다' [ if x ]
//	
//	System.out.println("정수입력");
//	int 문제3 = scanner.nextInt();
//	String 문제3결과 = (문제3 % 7 == 0 ) ? "맞다" : "아니다";
//	System.out.println(문제3결과);
	
	
//// 문제4 : 하나의 정수를 입력받아 홀수이면 이면 '홀수' 아니면 '짝수' [ if x ]
//	
//	System.out.println("정수입력");
//	int 문제4 = scanner.nextInt();
//	
//	String 문제4결과 = (문제4 % 2 == 0) ? "짝수" : "홀수";
//	System.out.println(문제4결과);
	
//// 문제5 : 하나의 정수를 입력받아 7의 배수 이면서 짝수 이면 '참' 아니면 '거짓'		
//	
//	System.out.println("정수입력");
//	int 문제5 = scanner.nextInt();
//	String 문제5결과 = (문제5 % 7 == 0) && (문제5 % 2 == 0) ? "참" : "거짓";
//	System.out.println(문제5결과);
	
//// 문제6 : 두개의 정수를 입력받아 더 큰수 출력 	
//	
//	System.out.println("정수1");
//	int 문제6정수1 = scanner.nextInt();
//	
//	System.out.println("정수2");
//	int 문제6정수2 = scanner.nextInt();
//	
//	int 문제6결과 = 문제6정수1 > 문제6정수2 ? 문제6정수1 : 문제6정수2;
//	System.out.println(문제6결과);
			
//// 문제7 : 반지름을 입력받아 원 넓이 출력하기		
//	
//	System.out.println("반지름");
//	double 반지름 = scanner.nextDouble();
//	
//	double 원넓이 = 반지름 * 반지름 *3.14;
//	System.out.println(원넓이);

	
//// 문제8 : 두 실수를 입력받아 앞실수의 값이 뒤의 값의 몇 %인지 출력하기		
//// 예) 54.5     84.3  입력했으면    64.285714% 출력
//	
//	System.out.println("실수1");
//	double 문제8실수1 = scanner.nextDouble();
//	
//	System.out.println("실수2");
//	double 문제8실수2 = scanner.nextDouble();
//	
//	double 문제8결과 = (문제8실수1 / 문제8실수2) *100;
//	System.out.println(문제8결과);
		
//// 문제9 : 사다리꼴 넓이 구하기 [ 윗변과 밑변 높이를 입력받아 출력하기 ] 
//// 사다리꼴 계산식 -> ( 윗변 + 밑변 ) * 높이 / 2 		
//	
//	System.out.println("윗변");
//	double 윗변 = scanner.nextDouble();
//	
//	System.out.println("밑변");
//	double 밑변 = scanner.nextDouble();
//	
//	System.out.println("높이");
//	double 높이 = scanner.nextDouble();
//	
//	double 사다리꼴 = ( 윗변 + 밑변 )* 높이 / 2;
//	System.out.println(사다리꼴);
	
	
//// 문제10: 키를 입력 받아 표준체중 출력하기
//// 표준체중 계산식 = > (키 - 100) * 0.9			
//	
//	System.out.println("키");
//	double 키 = scanner.nextDouble();
//	
//	double 표준체중 = ( 키 - 100 ) * 0.9;
//	System.out.println(표준체중);
	

//// 문제11 : 키와 몸무게를 입력받아 BMI 출력하기
//// BMI 계산식 = > 몸무게 / ((키 / 100) * (키 / 100))
//	
//	System.out.println("키");
//	double 키2 = scanner.nextDouble();
//	
//	System.out.println("몸무게");
//	double 몸무게 = scanner.nextDouble();
//	
//	double bmi = 몸무게 / ( (키2/100) * (키2/100) );
//	System.out.println(bmi);
		
//// 문제12 : inch 를 입력받아 cm 로 변환하기 [ 1 inch -> 2.54cm ] 		
//	System.out.println("inch");	
//	double inch = scanner.nextDouble();
//	
//	double cm = inch * 2.54;
//	System.out.println(cm);
	
//// 문제13 :  중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하기
//// 소수 둘째 자리 까지 점수 출력하기
//// 중간고사 반영비율 => 30 %
//// 기말고사 반영비율 => 30 %
//// 수행평가 반영비율 => 40 %	
//	
//	System.out.println("중간고사");
//	double 중간고사 = scanner.nextDouble();
//	
//	System.out.println("기말고사");
//	double 기말고사 = scanner.nextDouble();
//	
//	System.out.println("수행평가");
//	double 수행평가 = scanner.nextDouble();
//	
//	double 결과2 = (중간고사*0.3) + (기말고사*0.3) + (수행평가*0.4); 
//	System.out.printf(" %.2f ", 결과2 );	// .2f 소수점둘째자리까지
		
// 문제14 : 연산 순서 나열 하고 x와 y값 예측하기
int x = 10;
int y = x-- + 5 + --x;
System.out.printf(" x의 값 : %d , y의값 :  %d ", x, y);
	
 /*
	1. x-- : 10
	2. --x : 9 바로감소
	3. x-- + 5  : 10 + 5 : 15 (-1 예정)
 	4. 14(y) + 9(x) : 14 + 9 : 23
 	5. y = 23
 */
		
		
//// 문제15 :  정수3개 입력받아 오름차순 출력 		
//		
//	System.out.println("정수1");	
//	int a = scanner.nextInt();
//	
//	System.out.println("정수2");
//	int b = scanner.nextInt();
//	
//	System.out.println("정수3");
//	int c = scanner.nextInt();
//	
//	int temp = 0;
//	
//	if ( a > b ) {
//		temp = a;
//		a = b;
//		b = temp;
//	}
//		
//	if( a > c ) {
//		temp = a;
//		a = c;
//		c = temp;
//	}
//	
//	if( b > c ) {
//		temp = b;
//		b = c;
//		c = temp;
//	}
//	
//	System.out.println( a + " " + b + " " +c);
	
	
	}
}
