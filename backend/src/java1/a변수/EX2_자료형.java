package java1.a변수;

public class EX2_자료형 {

	public static void main(String[] args) {
		
		
		
		
		
		// p.61
		// 정수 타입 [ 10진수 ] : 소수점이 없음
		// 1. byte -128 ~ +127까지 저장 가능한 상자
		System.out.println("byte변수");
		
		byte 바이트변수1 = -128;
		System.out.println("바이트변수1 : " + 바이트변수1);
		
		byte 바이트변수2 = 127;
		System.out.println("바이트변수2 : " + 바이트변수2);
		
			// byte 바이트변수3 = 128;		범위 초과로 인한 오류 발생
		
		
		
		System.out.println("---------------------------------------");
		System.out.println("char변수");
		
		
		
		
		// 2. char[ 한글자 ] : 유니코드
			// 문자[1개] 입력시 : ' ' 작은따옴표
			// 문자열[여러개] 입력시 : " " 큰따옴표
		char 문자변수1 = 65;
		System.out.println("문자변수1 : " + 문자변수1);
		
		char 문자변수2 = 'A';
		System.out.println("문자변수2 : " + 문자변수2);
		
		int 문자변수3 = 'A';										// int로 예시 보여주기
		System.out.println("문자변수3 : " + 문자변수3);
		
		char 문자변수4 = '가';
		System.out.println("문자변수4 : " + 문자변수4);
		
		int 문자변수5 = '가';										// int로 예시 보여주기
		System.out.println("문자변수5 : " + 문자변수5);
		
		
		
		
		System.out.println("---------------------------------------");
		System.out.println("short변수");
		
		
		// 3. short [ 10진수 ] : +-3만정도
		
		short 쇼트변수1 = 30000;
		System.out.println("쇼트변수1 : " + 쇼트변수1);
			// short 쇼트변수1 = 40000;
		
		
		System.out.println("---------------------------------------");
		System.out.println("int변수");
		
		// 4. int [ * 정수 기본 자료형 ] : +-20억정도
		int 인트변수1 = 1000000000;
		System.out.println("인트변수1 : " + 인트변수1);
			// int 인트변수2 = 3000000000; --> 오류발생 : 저장범위 초과
		
		System.out.println("---------------------------------------");
		System.out.println("long변수");
		
		// 5. long [ 입력 숫자뒤에 L 추가해서 가능 ] : int 이상
		long 롱변수1 = 1000000000;
		System.out.println("롱변수1 : " + 롱변수1);
		
		// 5-1. long [ 입력숫자뒤에 + L]  
		long 롱변수2 = 3000000000L;
		System.out.println("롱변수2 : " + 롱변수2);
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("---------------------------------------");
		System.out.println("int : 10진수 정수를 저장하는 자료형[상자]");
	
		
		// 1. int : 10진수 정수를 저장하는 자료형[상자]
		
		int var1 = 0b1011;	// 2진수	[ 0b : 2진수 작성 가능 ]
		System.out.println("2진수[1011 -- int(10진수) --> 11] : "+ var1);
		
		int var2 = 0206;	// 8진수 [ 0 : 8진수 작성 가능 ]
		System.out.println("8진수[206 -- int(10진수) --> 134] " + var2);
		
		int var3 = 365;	
		System.out.println("10진수[365 -- int(10진수) --> 365] " + var3);
		
		int var4 = 0xb3;	
		System.out.println("16진수[b3 -- int(10진수) --> 179] " + var4);
		
	
		
		
		
	}
	
}
/*
 
 		[진수]
 			* 2진수를 다른 진수로 변환해서 다양한 표현 단위로 사용할 수 있다 --> 많은 단위를 표현가능
 			2진수	: 0, 1 	[ 기계어, 이진 코드 ] : 표현 단위가 적음 
 			8진수	: 0, 1, 2, 3, 4, 5, 6, 7
 			10진수	: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9	[사람이 사용하는 일상 숫자단위 ] 
 			16진수	: 0, 1, 2, 3, 4, 5, 6, 7, 9, 9, a(10), b(11), c(13) 등등
 					  
 			
 			
 			
 			
 			
  
*/