package java1.c조건문반복문;

import java.util.Scanner;

public class EX2_IF연습문제 {
	public static void main(String[] args) {
		
		
		
		Scanner scan = new Scanner(System.in);
		
//		// 문제1 : 2개의 정수를 입력 받아서 더 큰수 출력
//		
//		System.out.println("첫번째 정수를 입력하세요 : ");
//		int a = scan.nextInt();
//		
//		System.out.println("두번째 정수를 입력하세요 : ");
//		int b = scan.nextInt();
//		
////		if ( a > b ) {
////			System.out.println(a);	
////		}else {
////			System.out.println(b);
////		}
//		
//		if( a > b ) {
//			System.out.println(a);
//		}else if( a < b ) {
//			System.out.println(b);
//		}else {
//			System.out.println("두수는 같다");
//		}
//
//		
//		
//		// 문제2 : 3개의 정수를 입력 받아서 가장 큰 수 출력
//		
//		System.out.println("첫번째 정수를 입력하세요 : ");
//		int a2 = scan.nextInt();
//		
//		System.out.println("두번째 정수를 입력하세요 : ");
//		int b2 = scan.nextInt();
//		
//		System.out.println("세번째 정수를 입력하세요 : ");
//		int c2 = scan.nextInt();
//		
//		int max = a2;	// 첫번째 데이더를 가장 큰수로 지정
//		
//		if( max < b2 ) {
//			max = b2;
//		}	
//		if(max < c2) {
//			max = c2;
//		}
//		System.out.println(max);
//			
//
//
//		// 문제3 : 3개의 정수를 입력받아서 오름차순 / 내림차순 
//		
//		System.out.println("문제3) 첫번째 정수를 입력하세요");
//		int 문제3_1 = scan.nextInt();
//		
//		System.out.println("문제3) 두번째 정수를 입력하세요");
//		int 문제3_2 = scan.nextInt();
//		
//		System.out.println("문제3) 세번째 정수를 입력하세요");
//		int 문제3_3 = scan.nextInt();
//		
//		
//		int temp = 0;
//
//		if( 문제3_1 > 문제3_2 ) {
//			temp = 문제3_1;
//			문제3_1 = 문제3_2;
//			문제3_2 = temp;
//		}
//		if( 문제3_1 > 문제3_3 ) {
//			temp = 문제3_1;
//			문제3_1 = 문제3_3;
//			문제3_3 = temp;
//		}
//		if( 문제3_2 > 문제3_3) {
//			temp = 문제3_2;
//			문제3_2 = 문제3_3;
//			문제3_3 = temp;
//		}
//		System.out.println(문제3_1 + " " + 문제3_2 + " " + 문제3_3);
//		
//		
//		
////		if(temp < 문제3_1) {
////			temp = 문제3_1;
////		}
////		if(문제3_1 < 문제3_2) {
////			문제3_1 = 문제3_2;
////		}
////		if(문제3_2 < 문제3_3) {
////			문제3_2 = 문제3_3;
////		}
////		if(temp < 문제3_3) {
////			문제3_3 = temp;
////		}
////		
////		System.out.println(문제3_1);
////		System.out.println(문제3_2);
////		System.out.println(문제3_3);
////		// 2 6 4 0 
////		
////		// 2 6 4 2	  1을 4에
////		// 6 6 4 2    2를 1에
////		// 6 4 4 2    3을 2에
////		// 6 4 2 2    4를 3에
//		
//		
//		
//		
//		
//		// 문제4 : 점수를 입력받아 점수가 90점 이상이면 합격 아니면 불합격 출력 
//		
//		System.out.println("문제3) 점수를 입력하세요");
//				
//		int 문제4 = scan.nextInt();
//		
//		if ( 문제4 >= 90 ) {
//			System.out.println("합격");
//		}else {
//			System.out.println("불합격");
//		}
//		
//		
//		//문제5
//		// 점수를 입력받아 점수가 90점 이상이면 A등급
//		//				점수가 80점 이상이면 B등급
//		//				점수가 70점 이상이면 C등급
//		//				그외 재시험
//		
//		
//		
//		System.out.println("문제5) 점수를 입력하세요");
//		int 문제5 = scan.nextInt();
//	
//		
//		if( 문제5 >= 90 ) {
//			System.out.println("A등급");
//		}else if( 문제5 >= 80 ){
//			System.out.println("B등급");
//			
//		}else if( 문제5 >= 70 ){
//			System.out.println("C등급");
//		}else {
//			System.out.println("재시험");
//		}
//		
//		
//		
///* 문제6
//			[ 입력 ] : 국어,영어,수학 입력받기
//			[ 조건 ]
//				평균이 90점 이상이면서 
//					국어점수 100점 이면 '국어우수' 출력
//					영어점수 100점 이면 '영어우수' 출력
//					수학점수 100점 이면 '수학우수' 출력
//				평균이 80점 이상이면서 
//					국어점수 90점이상 이면 '국어장려' 출력
//					영어점수 90점이상 이면 '영어정려' 출력
//					수학점수 90점이상 이면 '수학장려' 출력
//				그외 재시험 
//*/
//		// 경우의 수 3개 중 첫번째 경우의 수 : 3개, 두번째 경우의 수 : 3개  --> 총 9개의 경우의 수
//		// 
//		
//		
//		System.out.println("문제6) 국어 점수 입력");
//		int 국어 = scan.nextInt();
//		
//		System.out.println("문제6) 국어 점수 입력");
//		int 영어 = scan.nextInt();
//		
//		System.out.println("문제6) 국어 점수 입력");
//		int 수학 = scan.nextInt();
//		
//		double 평균 = (국어+영어+수학)/3;
//		
//		if(평균 >= 90) {
//			if(국어 == 100) {
//				System.out.println("국어우수");
//			}
//			if(영어 == 100) {
//				System.out.println("영어우수");
//			}
//			if(수학 == 100) {
//				System.out.println("수학우수");
//			}
//		}
//		
//		
//		else if(평균 >= 80) {
//			if(국어 == 90) {
//				System.out.println("국어장려");
//			}
//			if(영어 == 90) {
//				System.out.println("영어장려");
//			}
//			if(수학 == 90) {
//				System.out.println("수학장려");
//			}
//		}
//		
//		else {
//			System.out.println("재시험");
//		}
////		// 1. 큰 경우의 수 3개 작성
////		if(평균 >= 90) {}
////		else if(평균 >= 80) {}
////		else {}
////		
////		
//
//			** &&로 다시 하기
////		if(평균 >=90 && 국어 == 100) {
////			System.out.println("국어우수");
////		}
		
		
		
		//문제7 로그인페이지
		// [ 입력 ] : 아이디와 비밀번호를 입력받기
		// [ 조건 ] : 회원아이디가 admin 이고 
		//           비밀번호가 1234 일 경우에는 
		//          로그인 성공 아니면 로그인 실패 출력		
		
		
		System.out.println("문제7) 아이디를 입력하세요");
		String 아이디 = scan.next();
		
		System.out.println("문제7) 비밀번호를 입력하세요");
		String 비밀번호 = scan.next();

		// 기본자료형[ int, char, double 등 ]기본 자료형 비교연산자 가능
		// 클래스[ 객체 : 기본 자료형 외 전부 String, Scanner, System 등]는 비교연산자 불가능  --> 비교 메소드(함수)
		// 기본자료형 == vs 객체명.equals()
		// . : 접근연산자 ( 내부 )
		
		if( 아이디.equals("admin")) {	// 아이디가 맞을때 안쪽 if 실행
			if(비밀번호.equals("1234")) {
				System.out.println("로그인성공");
			}else {
				System.out.println("로그인실패");
			}
		}else { // 아이디가 맞지 않을 때
			System.out.println("아이디가 맞지 않습니다");
		}
		
		
		
// 	String는 클래스라서 .equals 를 사용해줘야함 == 비교연산자 불가능 아래꺼 못써
//		if( 아이디 == "admin" ) {
//				// 문자열이라서 " " 안에 넣어줘야함
//			if( 비밀번호 == "1234" ) {
//				System.out.println("로그인성공");
//			}
//		}else {
//			System.out.println("로그인실패");
//		}
		

		
		
		
		
		
		
		
	}
}
