package java1.ch03_조건문반복문;

import java.util.Scanner;

public class EX7_별찍기 {

	public static void main(String[] args) {
		
		
		// 0. 입력 객체 [ 1번 선언 ]
		Scanner scan = new Scanner(System.in);
		
//		// 1. 입력받은 수 만큼 * 출력
//		System.out.println("문제1) 별개수 : ");
//		int s1 = scan.nextInt();
//		
//		for( int i = 1; i <= s1; i++ ) {	// i 는 1부터 입력받은 수 까지 1씩 증가반복
//			System.out.print( "*" );
//		}
//		
//		System.out.println("\n-----------------------------------------------------");
//		
//		// 2. 입력받은 수 많큼  * 출력 [3줄마다 줄바꿈 처리]
//		System.out.println("문제2) 별개수 : ");
//		int s2 = scan.nextInt();
//		
//		for( int i = 1; i <= s2; i++ ) {
//			System.out.println("*");
//			if(i % 3 == 0 ) {
//				System.out.println();
//			}
//		}
//		
//		
///*
//		별문제3 : 입력받은 줄 만큼 출력
//				
//			*		
//			**		
//			***		
//			****	
//			*****
//*/
//		
//		System.out.println("문제3) 줄수 : ");
//		int line3 = scan.nextInt();
//		
//		for( int i = 1; i <= line3; i++) {
//			for(int s = 1; s <= i; s++) {
//				System.out.print("*");
//			}
//			System.out.println();
//			// 줄바꿈
//		}
//		
//
///*
//		별문제4 : 입력받은 줄 만큼 출력
//					
//			*****	
//			****	
//			***			
//			**					
//			*
//*/		
//		System.out.println("문제4) 줄수 : ");
//		int line4 = scan.nextInt();
//		
//		for( int i = 1; i <= line4; i++) {
//			for(int s = 0; s <= line4-i; s++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		
///*		
//		별문제5 : 입력받은 줄 만큼 출력
//
//        *					i =	1			s = 1
//       **					i = 2			s = 2
//      ***					i = 3			s = 3
//     ****					i = 4			s = 4
//    *****					i = 5			s = 5	
//    	
//*/		
//		
//		System.out.println("문제5) 줄수 : ");
//		int line5 = scan.nextInt();
//		
//		for( int i = 1; i <= line5; i++ ) {
//			for( int j = 1; j <= line5-i; j++) {
//				System.out.print(" ");
//			}
//			for( int s = 1; s <= i; s++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		
//
//
///*
//	별문제6 : 입력받은 줄 만큼 출력
//
//	*****	 				i =	1			s = 5			j = 0
//	 ****					i =	2			s = 4			j = 1
//	  ***					i =	3			s = 3			j = 2
//	   **					i =	4			s = 2			j = 3
//	    *					i =	5			s = 1			j = 4
//		
//		
//*/		
//		
//		System.out.println("문제6) 줄수 : ");
//		int line6 = scan.nextInt();
//		
//		for(int i = 1; i <= line6; i++) {
//			for(int j = 1; j <= i-1; j++) {
//				System.out.print(" ");
//			}
//			for(int s = 1; s <= line6-i+1; s++) {
//				System.out.print("*");
//			}
//		System.out.println();
//			
//		}
//		
///*	
//
//별문제7 : 입력받은 줄 만큼 출력
//		
//        *					i =	1			s = 1			j = 4
//       ***					i =	2			s = 3			j = 3
//      *****					i =	3			s = 5			j = 2
//     *******				i =	4			s = 7			j = 1
//	*********				i =	5			s = 9			j = 0
//
//*/		
//		
//		System.out.println("문제7) 줄수 : ");
//		int line7 = scan.nextInt();
//		
//		for(int i = 1; i <= line7; i++) {
//			for(int j = 1; j <= line7-i; j++) {
//				System.out.print(" ");
//			}
//			for(int s = 1; s <= i*2-1; s++ ) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		
//		
//		
//		
///*
//
//별문제8 : 입력받은 줄만큼 출력 
//
//	    1					i =	1			s = 1			j = 4
//       222					i =	2			s = 1			j = 4
//      33333					i =	3			s = 1			j = 4
//     4444444				i =	4			s = 1			j = 4	
//	555555555				i =	5			s = 1			j = 4	
//
//		
//*/
//		System.out.println("문제8) 줄수 : ");
//		int line8 = scan.nextInt();
//		
//		for(int i = 1; i <= line8; i++) {
//		for(int j = 1; j <= line8-i; j++) {
//				System.out.print(" ");
//			}
//			for(int s = 1; s <= i*2-1; s++ ) {
//				System.out.print(i);
//			}
//			System.out.println();
//		}
//		
//		
//		
//		
//		
///*
// * 
//	별문제9 : 입력받은 줄만큼 출력
//
//	*********				i =	1			s = 9			j = 0
//	 *******				i =	2			s = 7			j = 1
//	  *****					i =	3			s = 5			j = 2
//	   ***					i =	4			s = 3			j = 3
//	    *					i =	5			s = 1			j = 4
//
//*/		
//		
//		System.out.println("문제9) 줄수 : ");
//		int line9 = scan.nextInt();
//		
//		for(int i = 1; i <= line9; i++) {
//			for(int j = 1; j <= i-1; j++) {
//				System.out.print(" ");
//			}
//			for(int s = 0; s <= (line9 * 2)-i*2; s++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		
		
/*
 * 
별문제10 : 입력받은 줄만큼 출력

        *					i =	1			s = 1			j = 4
       ***					i =	2			s = 3			j = 3
      *****					i =	3			s = 5			j = 2
	 *******				i =	4			s = 5			j = 1
	*********				i =	5			s = 9			j = 0
	
	 *******				i =	1			s = 7			j = 1
	  *****					i =	2			s = 5			j = 2
	   ***					i =	3			s = 3			j = 3
	    *					i =	4			s = 1			j = 4

*/		
		
		System.out.println("문제10) 줄수");
		int line10 = scan.nextInt();
		
		for(int i = 1; i <= line10; i++) {
			for(int j = 1; j <= line10-i; j++) {
				System.out.print(" ");
			}
			for(int s = 1; s <= i*2-1; s++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		for( int i = 1; i <= line10; i++ ) {
			for( int j = 0; j <= i-1; j++ ) {
				System.out.print(" ");
			}						// 5 * 2 = 10 - 2 
			for( int s = 0; s <= (line10-i)*2-1; s++ ) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
/*



*/		
		
		
		
		
		
		
		
		
		
	}	// 메인종료
	
}	// 클래스종료
