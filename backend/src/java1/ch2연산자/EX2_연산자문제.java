package java1.ch2연산자;

import java.util.Scanner;

public class EX2_연산자문제 {
	public static void main(String[] args) {
	
		
/*
		문제1 : 급여 계산 
			[조건] 입력받기 : 기본급 , 수당 
			[출력] 실수령액 = 기본급 + 수당 - 세금[기본급10%]
*/
		Scanner scan = new Scanner(System.in);
//		
//		System.out.println("기본급 입력 : ");
//		int 기본급 = scan.nextInt();
//		
//		System.out.println("수당 입력 : ");
//		int 수당 = scan.nextInt();
//		
//		int 실수령액 = 기본급 + 수당 - (int)(기본급 * 0.1);
//							// 강제 형 변환 : double -> int
//		System.out.println("실수령액은 : " + 실수령액 + " 입니다");
//
//		
//		
///*
//	 	문제2 : 지폐 개수 세기 
//	 		[조건] 십만원 단위의 금액을 입력받기 
//	 		[출력] 입력받은 금액의 지폐수 출력 
//	 		[예시]  356789
//	 			십만원 : 3장 
//				만원 : 5장 
//				천원 : 6장
//*/	
//		
//		System.out.println("문제2 10만원 단위의 금액을 입력하세요 : ");
//		int 금액 = scan.nextInt();
//		
//		System.out.println("십만원 : " + ( 금액/100000 ) + "장");
//			금액-= (금액/100000) * 100000;
//		System.out.println("만원 : " + ( 금액/10000 ) + "장");
//			금액-= (금액/10000) * 10000;
//		System.out.println("천원 : " + ( 금액/1000 ) + "장");
//		
//		
//		
//// 문제3 : 하나의 정수를 입력받아 7의 배수 이면 '맞다' 아니면 '아니다' [ if x ]
//		
//		
//		System.out.println("문제3 정수를 입력하세요 : ");
//		int 문제3 = scan.nextInt();
//		
//		String 문제3결과 = (문제3 % 7 == 0) ? "맞다" : "아니다";
//								// 삼항연산자
//		System.out.println(문제3결과);
//		
//		
//		
//		
//// 문제4 : 하나의 정수를 입력받아 홀수이면 이면 '홀수' 아니면 '짝수' [ if x ]
//		
//		System.out.println("문제4 정수를 입력하세요 : ");
//		int 문제4 = scan.nextInt();
//		
//		String 문제4결과 = (문제4 % 2 == 0) ? "짝수" : "홀수";
//		// 입력받은 값을 2로 나눴을때 	   나머지가 0이면 : 아니면
//		
//		System.out.println(문제4결과);
//		
//		
//// 문제5 : 하나의 정수를 입력받아 7의 배수 이면서 짝수 이면 '참' 아니면 '거짓' 
//		
//		System.out.println("문제5 정수를 입력하세요 : ");
//		int 문제5 = scan.nextInt();
//		
//		String 문제5결과 = (문제5 % 7 == 0) && (문제5 % 2 == 0) ? "참" : "거짓";
//		// 입력받은 값을 7로 나눴을때 나머지가 없음(7의배수) 그리고 2로나눴을떄 나머지가 없음(짝수)	맞으면 : 틀리면
//		System.out.println(문제5결과);
//		
//
//// 문제6 : 두개의 정수를 입력받아 더 큰수 출력 
//
//		System.out.println("문제6 정수1을 입력하세요 : ");
//		int 문제6정수1 = scan.nextInt();
//		
//		System.out.println("문제6 정수2을 입력하세요 : ");
//		int 문제6정수2 = scan.nextInt();
//		
//		int 문제6결과 = 문제6정수1 > 문제6정수2 ? 문제6정수1 : 문제6정수2;
//										// 조건이 맞으면	틀리면 
//		System.out.println(문제6결과);
//		
//
//// 문제7 : 반지름을 입력받아 원 넓이 출력하기 
//		
//		System.out.println("문제7 반지름을 입력하세요 : ");
//		double 문제7 = scan.nextDouble();
//		
//		double 원넓이 = (문제7 * 문제7) * 3.14; 
//		System.out.println(원넓이);
//
//		
//// 문제8 : 두 실수를 입력받아 앞실수의 값이 뒤의 값의 몇 %인지 출력하기 
//// 예) 54.5     84.3  입력했으면    64.285714% 출력 		
//		
//		System.out.println("문제8 실수1 입력하세요 : ");
//		double 실수1 = scan.nextDouble();
//		
//		System.out.println("문제8 실수2 입력하세요 : ");
//		double 실수2 = scan.nextDouble();
//		
//		double 문제8결과 = (실수1 / 실수2)*100;
//		System.out.println(문제8결과);
//		
//		
//// 문제9 : 사다리꼴 넓이 구하기 [ 윗변과 밑변 높이를 입력받아 출력하기 ] 
//// 사다리꼴 계산식 -> ( 윗변 + 밑변 ) * 높이 / 2 
//		
//		System.out.println("문제9 윗변 입력하세요 : ");
//		double 윗변 = scan.nextDouble();
//		
//		System.out.println("문제9 밑변 입력하세요 : ");
//		double 밑변 = scan.nextDouble();
//		
//		System.out.println("문제9 높이 입력하세요 : ");
//		double 높이 = scan.nextDouble();
//		
//		double 넓이구하기 = (윗변 + 밑변) * 높이 /2;
//		System.out.println(넓이구하기);
//		
//		
//// 문제10: 키를 정수를 입력받아 표준체중 출력하기
//// 표준체중 계산식 = > (키 - 100) * 0.9		
//		
//		System.out.println("문제10 키를 입력하세요 : ");
//		int 키 = scan.nextInt();
//		
//		int 표준체중 = (키 - 100)*(int)0.9;
//		System.out.println(표준체중);
//		
//		
//// 문제11 : 키와 몸무게를 입력받아 BMI 출력하기
//// BMI 계산식 = > 몸무게 / ((키 / 100) * (키 / 100))		
//		
//		System.out.println("문제11 키를 입력하세요 : ");
//		int 문제11키 = scan.nextInt();
//		
//		System.out.println("문제11 몸무게를 입력하세요 : ");
//		int 문제11몸무게 = scan.nextInt();
//		
//		int BMI = 문제11몸무게 / ((문제11키/100)) * ((문제11키/100));
//		System.out.println(BMI);
//		
//		
//
//// 문제12 : inch 를 입력받아 cm 로 변환하기 [ 1 inch -> 2.54cm ] 		
//		System.out.println("문제12 inch를 입력하세요 : ");
//		double inch = scan.nextDouble();
//
//		double cm = (inch * 2.54);
//		
//		System.out.println(cm);
//		
//		
//		
//// 문제13 :  중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하기
//// 소수 둘째 자리 까지 점수 출력하기
//// 중간고사 반영비율 => 30 %
//// 기말고사 반영비율 => 30 %
//// 수행평가 반영비율 => 40 %
//		
//		
//	System.out.println("문제13 중간고사 입력하세요 : ");
//	Double 중간고사 = scan.nextDouble();
//	
//	System.out.println("문제13 기말고사 입력하세요 : ");
//	Double 기말고사 = scan.nextDouble();
//	
//	System.out.println("문제13 수행평가 입력하세요 : ");
//	Double 수행평가 = scan.nextDouble();
//	
//	double 점수출력 = (중간고사 * 0.3 + 기말고사 * 0.3 + 수행평가 * 0.4);
//	System.out.printf("점수는 : %.2f\n", 점수출력);
//				
//						
//				
//// 문제14 : 연산 순서 나열 하고 x와 y값 예측하기
//// int x = 10;
//// int y = x-- + 5 + --x;
//// printf(" x의 값 : %d , y의값 :  %d ", x, y)
//				
//	int x = 10;
//	int y = x-- + 5 + --x;
//	
//	// 증감연산자가 1순위로 계싼
//	// * 순서 *
//	// 1. x--			: 10[ 후위 : 나중에 감소 ]
//	// 2. --x			: 9	[ 선위 : 바로 감소]
//	// 3. x-- + 5		: 10 + 5 => 15 (-1)[x-- 후위 감소]  
//	// 4. 14 + 9		: 14 + 9 => 23
//	// 5. y = 23
//		
//	
//	System.out.printf(" x의 값 : %d, y의 값 : %d", x, y);
//	System.out.println("\n-----------------------");
//	System.out.println(x--);
//	System.out.println(--x);
//
//		

//// 문제15 :  정수3개 입력받아 오름차순 출력 
// 	
//		System.out.println("정수1을 입력하세요 : ");
//		int a = scan.nextInt();
//		
//		System.out.println("정수2을 입력하세요 : ");
//		int b = scan.nextInt();
//		
//		System.out.println("정수3을 입력하세요 : ");
//		int c = scan.nextInt();
//		
//		int temp = 0;
//		
//		if( a > b ) {
//			temp = a;
//			a = b;
//			b = temp;
//		}
//		
//		if(a > c) {
//			temp = a;
//			a = c;
//			c = temp;
//		}
//		
//		if(b > c) {
//			temp = b;
//			b = c;
//			c = temp;
//		}
//		
//		System.out.println(a + " " + b + " " + c);

		
		
		
		
// 문제16 :  정수4개 입력받아 오름차순 출력 
		
		System.out.println("정수1을 입력하세요 : ");
		int 문제16정수1 = scan.nextInt();
		
		System.out.println("정수2을 입력하세요 : ");
		int 문제16정수2 = scan.nextInt();
		
		System.out.println("정수3을 입력하세요 : ");
		int 문제16정수3 = scan.nextInt();
		
		System.out.println("정수4을 입력하세요 : ");
		int 문제16정수4 = scan.nextInt();
		
		int 문제16비교1 = 문제16정수1 > 문제16정수2 ? 문제16정수1 : 문제16정수2;
		int 문제16비교2 = 문제16비교1 > 문제16정수3 ? 문제16비교1 : 문제16정수3;
		int 문제16결과 = 문제16비교2 > 문제16정수4 ? 문제16비교2 : 문제16정수4;
		System.out.println("결과 : " + 문제16결과);

	}
}




/*

	


*/