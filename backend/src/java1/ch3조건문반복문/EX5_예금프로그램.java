package java1.ch3조건문반복문;

import java.util.Scanner;

public class EX5_예금프로그램 {

	public static void main(String[] args) {
		
		
		// p.161 확인문제7
		
		boolean run = true;	// boolean형 변수 선언, 종료하는 스위치 변수(on/off, true/false 등)
		int balance = 0; // int형 변수 선언, 금액을 저장하는 변수
		
		Scanner scan = new Scanner(System.in);	// 입력 객체
		// 객체 선언 : 클래스명 객체명 = new 생성자명(클래스명)( 매개변수 );
		
		
		while ( run ) {	// true 이면 반복문 실행 -> 변수에 true를 넣어줬기 때문에 true
			System.out.println("--------------------------");
			System.out.println("1.예금 2.출금 3.잔고 4.종료");	// 입력 경우의 수 4개
			System.out.println("--------------------------");
			System.out.println("선택 >> ");
			
			int ch = scan.nextInt();
			
		
			
			
			if( ch == 1 ) { // 1을 입력했을 경우
				
				System.out.println("안내] 예금액을 입력해주세요 >> " );
				balance += scan.nextInt();	// 금액을 저장하는 변수에 누적 더하기
				
			}
			else if( ch == 2 ) {  // 2을 입력했을 경우
				System.out.println("안내] 출금액을 입력해주세요 >> ");
				// 잔액 부족 [ 경우의 수 2개 : 1. 예금액보다 출금액이 더 크거나 같으면, 2. 더 작으면 ]
				
				int money = scan.nextInt(); 
				if( balance < money) {
					System.out.println("안내] 잔액이 부족합니다.");
				}
				else {
					balance -= money;
				}
				
				
				
			}
			else if( ch == 3 ) {  // 3을 입력했을 경우
				System.out.println("안내] 현재 금액은 >> " + balance + " 입니다.");
				
			}
			else if( ch == 4 ) {  // 4를 입력했을 경우
				break;
			}
			else {  // 그외를 입력했을 경우
				System.out.println("안내] 번호를 잘못 선택하셨습니다. 다시 선택해주세요."); }
			
		}	// while 종료
		System.out.println("안내] 종료하겠습니다.");
		
		
		
		
		
		
		
		
		
		
	}	// main 함수(메인 스레드를 포함하고있어서 코드를 출력함)
}	// 퍼블릭 클래스 종료

/*
 
			---- 저장 [ 메모리 = JVM ] ----
 	1. 변수 : 데이터 1개를 저장할 수 있는 메모리 공간	[ 값 저장 ]
 	2. 배열 : 데이더 여러개를 저장할 수 있는 메모리 공간	[ 값 저장 ]
 	3. 메소드 = 함수 : 코드를 저장할 수 있는 메모리 공간	[ 행동 저장 ]
 	4. 객체 : 변수, 메소드를 묶어 놓은 집합소 
 		// 객체마다 변수와 메소드(함수) 포함 = 클래스 멤버
 		// 객체 멤버 호출 시 ( . ) : 접근 연산자
 	
 
 
 
 */





















