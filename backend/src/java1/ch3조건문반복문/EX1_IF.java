package java1.ch3조건문반복문;

public class EX1_IF {

		public static void main(String[] args) {
			// 코드를 실행해주는 메소드
			
			
			// 예제1) : 참 실행문이 1개일때는 중괄호 생략 가능
			if( 3 > 1 )
			System.out.println("예1) 3이 1보다 크다");
			
			// 예제2)	: 조건이 false 이기 때문에 실행 불가
			if( 3 > 5 )
			System.out.println("예2) 3이 5보다 크다");
			
			
			// 예제3) p.136 [ 예상 : 점수가 93점이기 때문에 첫번째 if문만 실행 ]
			int score = 93;
			
			if(score >= 90) {
				System.out.println("점수가 90보다 큽니다");
				System.out.println("등급은 A 입니다");
			}
			
			if(score < 90) {	// 조건이 false라서 실행x
				System.out.println("점수가 90보다 작습니다.");
				System.out.println("등급은 B 입니다");
			}
			
			
			// 예제4) p. 137
			
			int score2 = 85;
			
			if(score2 >= 90) {	// 85 >= 90 false 실행 x
				System.out.println("점수가 90보다 큽니다");
				System.out.println("등급은 A 입니다");
			} else {
				System.out.println("점수가 90보다 작습니다");
				System.out.println("등급은 B 입니다");
			}
			
			
			// 예제5) p. 138
			// 1. 조건이 다수이면서 하나의 결과 : if ~ else if 쓰기
			// 2. 조건이 다수이면서 여러개의 결과 : if 여러개 쓰기
			int score3 = 75;
		
			if(score3 >= 90) {
				System.out.println("점수가 100~90입니다");
				System.out.println("등급은 A 입니다");
			}else if(score >= 80 ) {
				System.out.println("점수가 80~89입니다");
				System.out.println("등급은 B 입니다");
			}else if(score >= 70 ) {
				System.out.println("점수가 70~79입니다");
				System.out.println("등급은 C 입니다");
			}else {
				System.out.println("점수가 70 미만입니다");
				System.out.println("등급은 D 입니다");
			}
			
			
			
			
			// 예제6) if 중첩
			
			int score4 = 95;
			char 성별 = 'M';
			
			if( score4 == 100 ) {
				if( 성별 == 'M' ) {
					System.out.println("100점 이면서남자이다");
				}else { System.out.println("100점 이면서 여자이다");
				}
			}else {
				if( 성별 == 'F') {
					System.out.println("100점이 아니면서 여자이다");
				} else {
					System.out.println("100점이 아니면서 남자이다");
				}
			}
			
			
			
			
			
			
		}
	
}

/*
	if문 : 조건식 : true / false		[ 비교연산자, 논리연산자, 함수, 변수] : 값에 true,false가 있으면 들어갈 수 있음
 	
 	
 	if 형태
 		1. if(조건) 참			: 참[true] 
 		
 		2. if(조건 {				: 참[true]
 				참
 			}
 		
 		3. if(조건){
 				참
 			}else{
 				거짓
 			}
 		
 		4. if(조건){
 				참1
 			}else if(조건2){
 				참2
 			}else if(조건3){
 				참3
 			}else{
 				거짓
 			}
 			
 		5. if(조건){
 				if(조건){
 					참
 				}else{
 					거짓
 				}
 			}
 	
 	
 	whitch문 : 데이터(값)제어
 	
 	
 	
 	
 	
 	
 	
 
 
*/