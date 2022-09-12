package study.s2;

import java.util.Scanner;

public class 도서대여 {
	public static void main(String[] args) {
		
		
/*		
 
   * 도서 대여 console 프로그램
   1. 배열 변수
      1. 회원 [ 아이디(중복x) , 비밀번호 ]
      2. 도서 [ 도서명(중복x) , 도서대여여부(대여가능,대여중) , 대여인(로그인시 아이디) ]
   2. 초기메뉴
      1.회원가입 2.로그인 
         1.회원가입시 아이디 중복체크 
         2.로그인 성공시 로그인메뉴 , 로그인 실패시 로그인실패 출력 
   3. 로그인시 메뉴 
      1. 도서검색 2.도서목록 3.도서대여 4.도서반납 5.로그아웃
          1. 도서검색시 도서명이 일치하면 도서명과 도서대여여부 출력
         2. 도서목록시 모든 도서명 출력 
         3. 도서대여시 도서대여 여부가 가능할때 도서대여 처리
         4. 도서반납시 본인이 대여한 도서만 반납 처리 
         5. 로그아웃 초기메뉴로 
   4. 로그인시 아이디가 admin 이면 관리자메뉴 
      1. 도서등록 2.도서목록 3.도서삭제(도전) 4.로그아웃
         1. 도서등록시 도서명을 입력받아 도서 등록처리
         2. 도서목록시 모든 도서명 출력 
         3. 도서삭제시 삭제할 도서명을 입력받아 동일한 도서명 삭제[ null ]
         4. 로그아웃시 초기메뉴로 		
         		
*/		

		
		Scanner scan = new Scanner(System.in);
		String id_list = []
		
		
		System.out.println("-- [메뉴를 선택해주세요] --");
		System.out.println(" 1. 회원가입 2. 로그인");
		int select = scan.nextInt(); 
		
		// 1. 회원가입 선택
		if(select == 1) {
			System.out.println("1번");
			
			
		}
		
		// 2. 로그인 선택
		else if (select == 2) {
			
			// 아이디, 비밀번호 입력받기
			System.out.println("아이디를 입력해주세요");
			String id = scan.next();
			System.out.println("비밀번호를 입력해주세요");
			String pw = scan.next();
			
			// 아이디
			if () {
				
			}
			
			// 아이디가 틀렸을때
			else {
				
			}
			
		}
		
		
		
		
		
		
		
	} // 메인 종료
} // 클래스 종료
