package study;

public class s0905_EX2_자료형_3 { 

	public static void main(String[] args) {
	
		
		/*
		 	var
		 	byte -128 ~ 127
		 	
		 	char 문자 1개
		 	
		 	short +3만
		 	int	 +- 20억정도
		 	long 20억이상
		 	
		 	float 소수점 7
		 	double 소수점 18
		 	
		 	boolean true false
		 	
		 */
		
		
		int var1 = 0b1011;
		System.out.println("2진수" + var1);
		
		int var2 = 0206;
		System.out.println("8진수" + var2);
		
		int var3 = 365;
		System.out.println("10진수" + var3);
		
		// -128~127
		byte 바이트1 = -128;
		System.out.println("바이트1 : " + 바이트1);
		
		byte 바이트2 = 127;
		System.out.println("바이트2 : " + 바이트2);
		
		
//		byte 바이트3 = 128;
//		System.out.println("바이트3 : "+ 바이트3);
		
		char 문자1 = 'A';
		System.out.println("문자1 : " + 문자1);

		char 문자2 = '가';
		System.out.println("문자2: " + 문자2);
		
		int 인트1 = 1000000000;
		System.out.println("인트1 : " + 인트1);
		
//		int 인트2 = 3000000000;
//		System.out.println("인트2 " + 인트2);
		
//		short 쇼트1 = 1000000000;
//		System.out.println("쇼트1 : " + 쇼트1);
		
		short 쇼트2 = 30000;
		System.out.println("쇼트2 : " + 쇼트2);
		
		long 롱1 = 1000000000;
		System.out.println("롱1 : " + 롱1);
		
//		long 롱2 = 3000000000;
//		System.out.println("롱2 : " + 롱2);
		
		
		float 플로트1 = 3.14F;
		System.out.println("플로트 : " + 플로트1);
		
		float 플로트2 = 0.123456789123456789F;
		System.out.println("플로트 : " + 플로트2);
		
		double 더블1 = 3.14;
		System.out.println("더블1 : " + 더블1);
		
		double 더블2 = 0.123456789123456789;
		System.out.println("더블2 : " + 더블2);
		
		
		boolean 논리 = true;
		System.out.println("논리 : " + 논리);
		
	}
	
}
