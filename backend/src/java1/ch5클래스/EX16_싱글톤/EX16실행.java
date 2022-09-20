package java1.ch5클래스.EX16_싱글톤;

public class EX16실행 {
	public static void main(String[] args) {
		
		
		// 객체 선언 [ 클래스명 객체명 = new 생성자(); ]
	 
		/*
		 
		Singleten s1 = new Singleten();	// 생성자 private 접근불가
		Singleten s2 = new Singleten(); // 생성자 private 접근불가
	
		Singleten.s1; // 생성자 private 접근불가
		
		*/
		
		Singleten s3 = Singleten.getISingleten();
		Singleten s4 = Singleten.getISingleten();
		// s3 객체와 s4 객체는 같다
		
		if ( s3.equals(s4) ) {
			// == : 스택 값 비교  .equals() : 힙 값 비교
			
			System.out.println("주소 값이 같다");
		}
		else {
			System.out.println("다르다");
		}
		
		
	}
}
