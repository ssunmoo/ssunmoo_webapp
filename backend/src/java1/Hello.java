package java1;	// 현재 클래스가 속한 패키기[폴더] 표시
	
	// 1. 클래스 선언부
public class Hello {	
	// public : 접근제한자(전범위)
	// class : 클래스 선언시 사용되는 키워드
	// Hello : 클래스명[내가 지어준 이름]
	// { } : 클래스 시작 ~ 끝
	
	// * 모든 코드는 클래스 { } 안에서 작성해야 됨 
	
	// 2. 함수 선언부
	public static void main(String[] args) {
					// main 메소드에 main 스레드[코드를 읽어주는 역할]  * 스레드 : 코드를 읽어주는 흐름 단위
 					// * 실행할 코드는 main 메소드 안에서 작성
		System.out.println("Hello, Java");
		
		
	}
	// 3. 주석 처리
		// 1. // : 한줄 주석
		// 2. /* */ : 여러줄 주석
	
	// 4. 세미콜론 ;
		// 실행문이 끝났음을 꼭 표시 ---> 실행
		
}
