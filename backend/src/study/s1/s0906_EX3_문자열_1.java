package study.s1;

public class s0906_EX3_문자열_1 {	
	
	public static void main(String[] args) {
		
		
		// p.64 String 타입 [ String 클래스 ]
			// char 문자 = "자바";  --> 오류발생 : char 문자 한개만 저장할 수 있다.
		
		String 문자열 = "자바";
		
		// p.65
		String name = "홍길동";
		System.out.println(name);
		String job = "프로그래머";
		System.out.println(job);
		
		// p.66
		System.out.println("안녕하세요");	// println : 출력 후 줄바꿈처리 o
		System.out.print("자바입니다");	// print : 출력 후 줄바꿈처리 x
		System.out.println("하하하");

		System.out.println("번호\t이름\t직업");
		System.out.print("행 단위 출력\n");
		System.out.print("행 단위 출력\n");
		System.out.println("우리는 \"개발자\" 입니다");
		System.out.println("봄\\여름\\가을\\겨울");
		
		
		System.out.println("\n---------------------------");
		// 예1.
		System.out.println("\\  /\\");
		System.out.println(" )( ')");
		System.out.println("( /  )");
		System.out.println("\\(__)|");
		
		
		System.out.println("|\\_/|");
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`   |");
		System.out.println("||_/=\\\\_|");
		
		
		
	}	// 메인 끝
}	// 클래스 끝


/*

	문자 [ 한글자] : char : '자'
	문자열 [ 두글자 이상 ] : String : "자바입니다"
	
	- console 화면에 출력하는 함수
		print() : 출력
		println() : 출력 후 줄바꿈[\n] 포함
		printf() : 형식문자출력
		
	- 제어[이스케이프] 문자
		1. \n : 줄바꿈 2. \t : 들여쓰기 [tab 5칸\
		3. \특수문자 : 특수문자 출력
			"홍길동" -> 홍길동
			"\"홍길동\"" -> "홍길동"



*/











