package java1.ch1변수;

public class EX3_문자열 {
	public static void main(String[] args) {
		
		
		// p.64 String 타입 [ String 클래스 ]
			// char 문자 = '자바';	// char은 문자 1개만 저장 가능
		// String 문자열 = "자바";
				
		String name = "홍길동";
		System.out.println(name);

		String job = "프로그래머";
		System.out.println(job);
	
	
		// p.66
		System.out.println("안녕하세요");	// 출력 후 줄바꿈o
		System.out.print("자바입니다");	// 출력 후 줄바꿈x
		System.out.println(" 오잉");
	
		System.out.println("번호\t이름\t직업");
		System.out.print("행 단위 출력\n");
		System.out.print("행 단위 출력\n");
		System.out.println("우리는 \"개발자\" 입니다");
		System.out.println("봄\\여름\\가을\\겨울");
	
	
		System.out.println(" \\   /\\ \n  ) (  ') \n (  /  )\n  \\(__)|\n");
		System.out.println("|\\_/| \n|q p|\t/}\n( 0 )\"\"\"\\\n|\"^\"`\t |\n||_/=\\\\__|\n");
		
		
		System.out.println("\t[[ 출석부 ]]\t\n--------------------------------\n이름\t1교시\t2교시\t3교시\n강호동\t출석\t결석\t결석\n유재석\t출석\t결석\t결석\n--------------------------------");
		
	
	}
}
/*
 	문자[ 한글자 ]			: char		: ' ' 작은 따옴표
 	문자열[ 두글자이상 ]		: String	: " " 큰 따옴표
 
 	- console 화면에 출력 함수	
	 	print()		: 출력
	 	printIn()	: 출력 후 줄바꿈
	 	printf()	: 형식문자 출력
	 
 	- 제어[이스케이프] 문자
 		1. \n : 줄바꿈	2. \t : 들여쓰기[tab 5칸]
 		3. \특수문자 : 특수문자 출력
 		
 		
 		
 		
 		
 		
 		
 	
 
 */