package study.s1;

public class s0914_EX1_연산자_3 {
	
	public static void main(String[] args) {
		
		
		int 정수1 = 10;
		int 정수2 = 20;
		
		System.out.println("더하기 : " + 정수1 + 정수2 );
		System.out.println("더하기 : " + ( 정수1 + 정수2 ));
		System.out.println("빼기 : " + (정수1 - 정수2 ));
		System.out.println("곱하기 : " + (정수1 * 정수2 ));
		System.out.println("나누기 :" + (정수1 / 정수2 ) );
		System.out.println("나머지 : " + (정수1 % 정수2 ));
		
		System.out.println("크거나 같다 : " + (정수1 >= 정수2 ));
		System.out.println("작거나 같다 : " + (정수1 <= 정수2 ));
		System.out.println("크다 : " + (정수1 > 정수2));
		System.out.println("작다 : " + (정수1 < 정수2));
		System.out.println("같다 : " + (정수1 == 정수2 ));
		System.out.println("같지않다 : " + (정수1 != 정수2 ));
		
		
		int 정수3 = 5;
		int 정수4 = 3;
		
		System.out.println("&& and : " + (정수1 >= 정수2 && 정수3 >= 정수4 ));
		System.out.println("|| or : " + (정수1 >= 정수2 || 정수3 >= 정수4 ));
		
		
		// 증감
		int 정수5 = 10;
		System.out.println("후위증가 " + 정수5++ );
		System.out.println("후위증가 " + 정수5);
		System.out.println("후위감소 " + 정수5-- );
		System.out.println("후위감소 " + 정수5 );
		System.out.println("선위증가 " + ++정수5 );
		System.out.println("선위감소 " + --정수5 );
		
		
		
		// 삼항
		int 점수 = 80;
		char 등급 = 점수 > 90 ? 'A' : 'B';
		
		System.out.println("등급 " + 등급);
		
		
		int 정수6 = 10;
		
		정수6 += 3;
		System.out.println(정수6);
		
		정수6 -= 2;
		System.out.println(정수6);
		
		
		
		
		
		
		
		
		
	}
}
