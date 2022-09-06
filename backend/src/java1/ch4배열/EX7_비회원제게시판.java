package java1.ch4배열;

import java.util.Scanner;

public class EX7_비회원제게시판 {
	public static void main(String[] args) {
		

/*
 
	1. 입력받을 수 있는 Scanner 생성
	2. 선택 >> 1. 글쓰기 2. 글보기 출력
	3. 1을 선택했을때, 2를 선택했을때, 그외 --> 3개중에 1개는 무조건 선택해야하니까 if, else if, else 사용
	4. 1. 글쓰기 선택 시
		1. 글쓰기 페이지 출력
		2. 제목, 내용, 작성자, 비밀번호의 객체를 sysout으로 입력받아 생성
		3. 입력 받은 내용을 저장해줄 배열 생성 100개까지 저장, 4개 항목 입력 [100][4]
		4. [글저장] 배열 생성, 배열에 저장해주기   
		5. 첫 페이지에 출력되도록 번호, 작성자, 제목 순으로 출력
		6. 앞장에 출력되도록 for문 돌려서 더해줌 
			- 글저장의 랭스길이까지 반복하고 저장할 내용 기재
			- 글을 출력해보니 [글저장]에 break를 안걸어주니 100개가 한번에 입력되서 break 추가
 	
 	5. [2. 글보기 선택 시]
 		1. 목록보기(뒤로가기) -> break 써서 종료
 		2. 3번 글수정 -> 패스워드 입력받고 저장된 배열 길이까지 for문 돌림
 			- 저장된 패스워드와 입력한 패스워드와 맞는지 확인
 			- 맞다면 수정할 제목과 내용을 입력받아서 저장된 배열에서 해당 위치에 대입해주기
 			- 입력이 완료되었다면 더이상 실행되지 않도록 break -> 안걸어주니까 알람 계속 뜸
 			- 비밀번호가 다를때 알람뜨기 break 얘도 브레이크 안걸어주니까 알람 계속 뜸 			
 		3. 2번 글삭제 -> 패스워드 입력받아서 비밀번호가 동일하면 실행
 			- 해당 인덱스에 null 을 대입해서 값 없애주기
 			- for문을 돌려서 저장된 인덱스에 null 값이 있는지 확인 후 있다면 앞으로 한칸씩 땡겨주기
 			- for 문이 다 돌고 null 값이 발견되면 알림 후 종료
 	 
*/		
		
	Scanner scan = new Scanner(System.in);
	String[][] 글저장 = new String[100][4];
	
	while ( true ) {
		
		
		System.out.println("----------[ 커뮤니티 ]----------");
		System.out.println("번호\t작성자\t제목 ");
		
		for( int i = 0; i < 글저장.length; i++) {
			if( 글저장[i][0] != null ) {
				// 저장된 글이 있을때
				System.out.println( i + "\t" + 글저장[i][2] + "\t" + 글저장[i][0] );
			}
		}
		System.out.println("-----------------------------");	
		
		
		System.out.println(" 선택 >> 1. 글쓰기 2. 글보기");
		int 선택 = scan.nextInt();
		
	//	String 글쓰기 = scan.next();
	//	String 글보기 = scan.next();
		
		if(	선택 == 1 ) {
			System.out.println("--------[ 글쓰기 페이지 ]--------");
			System.out.println("제목 : ");
			String title = scan.next();
			System.out.println("내용 : ");
			String content = scan.next();
			System.out.println("작성자 : ");
			String writer = scan.next();
			System.out.println("비밀번호 : ");
			String password = scan.next();
			
		// 입력받은 변수들을 글저장 배열에 저장하기 [ 배열호출 : 배열명[행인덱스] [열인덱스]
		
			for(int i = 0; i < 글저장.length; i++) {
				if( 글저장[i][0] == null ) {
					// 글저장 배열이 null일때(값이 없을때)
					글저장[i][0] = title;
					글저장[i][1] = content;
					글저장[i][2] = writer;
					글저장[i][3] = password;
					break;
					
				} // if 종료
			} // for 종료
		} // if 종료
		
		
		else if( 선택 == 2) {
			System.out.println("게시글 번호[인덱스] 선택 : ");
			int 게시글번호 = scan.nextInt();
			
			for( int i = 0; i < 글저장.length; i++) {
				if( 게시글번호 == i ) {
					System.out.println("--------[ 게시물 상세페이지 ]--------");
					System.out.println("작성자 : " + 글저장[i][2] + " 제목 : " + 글저장[i][0]);
					System.out.println("내용 : " + 글저장[i][1]);
					System.out.println("--------------------------------");
					
					System.out.println(" 선택 >> 1. 목록보기(뒤로가기) 2. 글삭제 3. 글수정");
					int 글수정메뉴 = scan.nextInt();
					
					if( 글수정메뉴 == 1) {
						break;	// 뒤로가기니까 멈추고 이전으로 나가기
					}
					else if ( 글수정메뉴 == 2) {	// 삭제
						
						System.out.println("게시물 비밀번호 입력 : " );
						String pw = scan.next();
						
						if( 글저장[i][3].equals(pw) ) {	// 비밀번호가 동일하면
							
							글저장[i][0] = null;
							글저장[i][1] = null;
							글저장[i][2] = null;
							글저장[i][3] = null;
							// 저장된 내용을 삭제하기
							
							for( int a = i; a < 글저장.length; a++) {
								글저장[a][0] = 글저장[a+1][0];
								글저장[a][1] = 글저장[a+1][1];
								글저장[a][2] = 글저장[a+1][2];
								글저장[a][3] = 글저장[a+1][3];
								if( 글저장[a+1][0] == null ) {
									// 저장된 배열에 null 값이 발견되면 끝내
									System.err.println("[알림] 게시글 삭제 완료");
									break;
								} // if 종료
							} // for 종료
						} // if 종료
						
						else {
							System.err.println("[알림] 비밀번호가 다릅니다.");
						}
						
					} // else if
					else if ( 글수정메뉴 == 3) {	// 수정
						System.out.println("게시물 비밀번호 입력 : " );
						String pw = scan.next();
						
						for( int j = 0; j < 글저장.length; j++ ) {
							if( 글저장[j][3] != null && 글저장[j][3].equals(pw) ) {	// 저장된 비밀번호가 입력한 번호랑 같을때
								System.out.println("수정할 제목 : ");
								String 수정할제목 = scan.next();
								System.out.println("수정할 내용 : ");
								String 수정할내용 = scan.next();
								
								글저장[j][0] = 수정할제목;
								글저장[j][1] = 수정할내용;
									
								System.err.println("[알림] 내용이 수정되었습니다.");		
								break;
							} // if 끝
							
							else{
								System.err.println("[알림] 비밀번호가 다릅니다 [삭제실패]");
								break;
							} // else 종료
						} // for 종료
					} // else if 종료
					else {
						System.err.println("번호 오류");
					} // else 종료
					
				} // if 종료
			} // for 종료
		} // else if 종료
		
		else {
			System.err.println("[안내] 번호입력 오류 다시 선택해주세요.");
		}
	
	
	}
	
	
	
	
	
	
	
	
	
		
		
		
	} // main 종료
}	// class 종료



/*
	
	비회원제 게시판 만들기
	
	[ 조건 ]
	변수 , 제어문 , 반복문 , 1차원 배열 , 2차원 배열 , main 메소드만 사용
	게시물 개수 최대 100개
	
	[ 출력 예시 ]
	-------------------
	번호		작성자	제목
	-------------------
	1.글쓰기	2.글보기
	
	

*/





	

















