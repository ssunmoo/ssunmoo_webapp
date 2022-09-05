package java1.ch3조건문반복문;

public class EX3_FOR {

	
	public static void main(String[] args) {
		
		
		
		
		
//		// p.150	1~10까지 출력
//		
//			// 1. 반복문이 없을 경우
//		System.out.println("1");	System.out.println("2");
//		System.out.println("3");	System.out.println("4");
//		System.out.println("5");	System.out.println("6");
//		System.out.println("7");	System.out.println("8");
//		System.out.println("9");	System.out.println("10");
//
//		
//			// 2. for문
//		for( int i = 1; i < 10; i++) {
//			System.out.println(i);
//		}
//		
//
//			// 3. while문
//		int i = 1;					// 1. 초기값
//		while( i <= 10 ) {			// 2. 조건문
//			System.out.println(i);	// 3. 실행문
//			i++;					// 4. 증감식
//		}
//		
//		
//		
//		
//		// p.151
//		
//		
//			// for문
//		int sum = 0;
//		
//		for(i = 1; i <= 100; i++) {
//			sum += i;
//		}	System.out.println("1부터 100까지의 합 : " + sum);
//		
//			// while문
//		int 합계 = 0;
//		int a = 1;
//		while( a <= 10 ) {
//			합계 += a;
//			a++;
//		}	System.out.println("1부터 100까지의 합 : " + a);
//		
//		
//		
//		int 예제3합계 = 0;
//		
//		for(int x = 1; x <= 100; x++) {
//			if(x % 7 == 0 )
//				예제3합계 += x;
//		}System.out.println("예제3결과1 : " + 예제3합계);
//		
//		int 예제3합계2 = 0;
//		for( int y = 0; y <= 100; y+=7) {
//			예제3합계2 += y;
//		}System.out.println("예제3결과2 : " + 예제3합계2);
//		
//
//		
//		// 구구단 for문
//		int i = 0;
//		int j = 0;
//		int 실행횟수 = 0;
//
//		for(i = 2; i < 10; i++) {
//				System.out.println("\n" + "[ " + i + " 단 ]");
//			for(j = 1; j < 10; j++) {
//				System.out.println( i + " * " + j + " = " + i*j);
//				실행횟수++;	
//			}	System.out.println(실행횟수);
//		}
		
		// 구구단 while문
		int a = 1;
		int b = 0;
		
		while( a < 9 ) {
			a++;
			while( b < 9) {
				
				b++;
				continue;
	
			} 
			System.out.println(a + " * " + b + " = " + a*b);
			
			
		}
			
			
		//		// 3. while문
		//	int i = 1;					// 1. 초기값
		//	while( i <= 10 ) {			// 2. 조건문
		//		System.out.println(i);	// 3. 실행문
		//		i++;					// 4. 증감식
		//	}
		
		
		
		
		
	}
}




/*
 

  	반복문 : 조건이 true이면 실행문 반복  
  
  	[ for ] : (초기값; 조건문; 증감식) { 실행문 }
  		
  	[ while ] : 무한 루프일때만 사용
  	* break : 반복문 종료 키워드 [ 가장 가까운 반복문 탈출 ]
  	* continue : 반복문으로 이동 키워드 [ 증감식 이동 ]
  		while (true) { 실행문 }
  	
		초기값
		while (조건문) {
			실행문
			증감식
		}

  
 */









