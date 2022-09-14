package java1.ch5클래스.EX8;

// 1. 클래스 선언
public class Member {

	// 멤버
	// 1. 필드
	String id;
	String password;
	String name;
	
	// 2. 생성자 : 객체 생성 시 초기 값 설정 [ 필드의 처음 값 ] 
		// * 클래스명과 동일해야 함 *
		// * 매개변수 개수에 따라 오버로딩[ 여러개 사용 가능 ] *
	
	// 1. 빈 생성자 [ 매개변수 x ]
	public Member() {
	
	}
	
	// 2. 매개변수가 1개인 생성자
	public Member(String id) {
		this.id = id;
	}
	
	// 3. 매개변수가 2개인 생성자
	public Member(String id, String password) {
		this.id = id;
		this.password = password;
	}


	// 4. 매개변수가 3개인 생성자 [ 풀 생성자 ]
	public Member(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}
	
	
	
	// 3. 메소드
	

}
