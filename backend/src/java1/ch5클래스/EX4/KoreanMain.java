package java1.ch5클래스.EX4;

public class KoreanMain {
	public static void main(String[] args) {
		

		// 1. 매개변수가 있는 생성자 객체선언
		Korean k1 = new Korean("박자바", "010-0000-1234");
		System.out.println( k1.name );
		System.out.println( k1.ssn );
		System.out.println( k1.nation );
		
		
		
		// 2. 매개변수가 없는 생성자 객체선언
		Korean k2 = new Korean();
		k2.name = "김자바";
		k2.ssn = "010-1234-0000";
		System.out.println( k2.name );
		System.out.println( k2.ssn );
		System.out.println( k2.nation );
		
	}

}


/*
	매개변수[인수] : 외붑로부터 들어오는 변수
	


*/