package java1.ch5클래스.EX17_final;

public class EX17실행 {

	public static void main(String[] args) {
		
		
		
		// 1. 객체선언
		Person p2 = new Person("111111-222222", "홍길동");
		
		// p2.nation = "USA"			// 오류 : final 필드는 수정 불가
		// p2.ssn = "333333-1111111";
		p2.name = "김민주";			// final 필드가 아니기 때문에 수정 가능 
		
		
		
		
		
		
		
		
		
		
		
	}
}
