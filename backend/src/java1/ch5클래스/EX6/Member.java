package java1.ch5클래스.EX6;

public class Member {

	// 필드
	String id;
	String pw;
	String name;
	int point;
			
	// 생성자
	
	// 1. 빈 생성자 실행
	public Member() {}
	
	// 2. 회원가입 시 사용되는 객체 생성자
	Member( String id, String pw, String name, int point ){
		this.id = id; // this 사용하는 이유 : 내부필드와 매개변수의 이름이 동일할 경우 식별용
		this.pw = pw;
		this.name = name;
		this.point = point;
	}
	
	// 3. 비밀번호 변경 시 사용되는 객체 생성자
	Member( String pw ){
		this.pw = pw;
		this.name = name;
	}
	
	// 4. 로그인[ 아이디, 비밀번호 ]시 사용되는 객체 생성자
	Member( String id, String pw ){
		this.id = id;
		this.pw = pw;
	}
	
	
	
	// 메소드
	
	
	
	
}
