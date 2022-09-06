package study.s1;

public class s0906_EX4_타입변환_1 {

	public static void main(String[] args) {
		
		
		// p.74
		
		byte 바이트변수 = 10;
		int 인트변수 = 바이트변수;			// int = byte [가능=자동타입변환]
		
		// byte 바이트변수2 = 인트변수;  --> byte = int [ 불가능 = 강제 타입 변환 ]
		
		byte 바이트변수3 = (byte)인트변수;	// 강제 형변환 [ (자료형/클래스) 변수/객체 ]
		
		
		
		
	} // 메인 끝
}	// 클래스 끝

/*


	타입 변환 = 자료형 변환 = 변수의 상자[크기] 변환
		1. 자동타입변환 [ 작은 자료형 --> 큰자료형 ]
		 byte > short > int > long > float > double
		 
		2. 강제타입변환 [ 큰자료형 --> 작은자료형 ]
			* 데이터 손실 발생
			* (자료형타입)변수명
			* 
		3. 연산시 타입 변환
			1. [정수] int 보다 작은 수 끼리 연산 시 -> 연산결과 int 형
			2. [실수] 끼리 연산시 -> 연산결과 double
			

		4. 문자열 --> 기본타입
			integer.parseInt(문자열)	-> 숫자
				// 주의점 : "a" -> 불가능























*/