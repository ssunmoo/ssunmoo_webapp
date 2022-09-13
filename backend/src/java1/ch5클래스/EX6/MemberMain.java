package java1.ch5클래스.EX6;

import java.util.Scanner;

public class MemberMain {
	public static void main(String[] args) {
	
		
		Scanner scan = new Scanner(System.in);
		
		// Member 객체 100개를 저장하는 1차원 배열
		Member[] MemberObject = new Member[100];
		
		
		while (true) {
			
			System.out.println("1. 회원가입 2. 로그인");
			int ch = scan.nextInt();
			
			
			if( ch == 1 ) {
			
				// 입력
				System.out.println("아이디 : ");
				String id = scan.next();
				System.out.println("비밀번호 : ");
				String pw = scan.next();	
				System.out.println("이름 : ");
				String name = scan.next();
				
				// 객체 선언	
				Member signupInfo = new Member( id, pw, name, 1000 );
				
				int index = 0;	// 반복문 실행 횟수
				for( Member temp : MemberObject ) { // for (반복 임시 변수 : 배열 ) { }
					index++; // 1씩 증가
					
					if ( temp == null ) { // 만약에 해당 객체가 비어있으면
						MemberObject[ index ] = signupInfo;
						// 원본에 수정 [ 주소 값 대입 ]
						// 해당 인덱스의 새로운 객체 대입 [ 객체의 주소 값 대입 ]
						
						break;
						// 1번 저장 후 멈추기
						
						// temp = signupInfo;	// temp는 임시변수 [ 반복문 종료시 끝남 ]
					} // if 종료
				} // for 종료	
			} // if 종료
			
			else if( ch == 2 ){
				
				// 입력
				System.out.println("아이디 : ");
				String id = scan.next();
				System.out.println("비밀번호 : ");
				String pw = scan.next();
				
				// 객체 선언
				Member loginInfo = new Member( id, pw );
				
				for( Member temp : MemberObject ) {
					if ( temp != null &&
						// 해당 객체가 공백이 아니면서
						temp.id.equals( loginInfo.id ) && 
						// 해당 객체의 아이디가 입력 받은 아이디와 같고
						temp.pw.equals( loginInfo.pw ) ) {
						// 해당 객체의 비밀번호가 입력 받은 비밀번호와 같으면
						
						System.out.println("로그인 성공");
						break;
					} // if 종료
				} // for 종료
			} // else if 종료
		} // while 종료
		
		
		
		
		
		
		
		

	}

}
