package java1.ch5클래스.EX7_비회원제게시판;

import java.util.Scanner;

import javax.swing.border.Border;

public class EX7실행 {
	public static void main(String[] args) {
		
	/*	
		
		설계 [ 메모리 ]
			1. 제목 2. 내용 3. 작성자 4. 비밀번호
			선택지 : 1. 2차원배열 2. 클래스 -> 객체 -> 1차원배열
		
		클래스 설계
			클래스 멤버 : 필드, 생성자, 메소드
			1. 필드 : 메모리 저장소
				1. 문자열 제목 
				2. 문자열 내용
				3. 문자열 작성자
				4. 정수열 비밀번호
				5. 정수열 조회수
				
			2. 생성자
				1. 빈생성자 [ 매개변수가 없는 생성자 ]
				2. 풀생성자 [ 모든 매개변수가 있는 생성자 ]
			
	*/
		
		Scanner scan = new Scanner(System.in);
		Board[] boardlist = new Board[100];	// Board 객체 100개를 저장할 수 있는 배열 선언
		
		
		while (true) {
			
//			// 1. 방법
//			for( int index = 0; index < boardlist.length; index++ ) {
//				System.out.println(" --------- 글보기 --------- ");
//				System.out.println(" [번호]\t[작성자]\t[제목]\n");
//				System.out.printf(" %d\t%s\t%s" + index, boardlist[index].writer, boardlist[index].title);
//			}
			
			// 2. 방법 향상된 for문
			int num = 0;
			System.out.println(" --------- 글보기 --------- ");
			System.out.println(" [번호]\t[작성자]\t[제목]");
			for( Board temp : boardlist ) {	// 배열내 모든 객체를 하나씩 temp 객체에 반복 대입	
				if( temp != null ) {
					// 만일 객체가 존재하면 출력
					
					System.out.printf("  %d \t %s \t  %s \n", num, temp.writer, temp.title );
				}	num++;
			}
			
			
			System.out.println(" --------- 선택 ---------- ");
			System.out.println(" 1. 글쓰기\t2. 글보기");
			int ch = scan.nextInt();
			
									
			// 1번 글쓰기 선택
			// 1. 출력, 입력, 저장
			if( ch == 1 ) {
				scan.nextLine();
				// nextLine을 쓰면 nextLine이 합쳐지기 때문에 해결하기 위해 의미없는 한줄 추가하는 것
				
				System.out.println("[안내] 제목을 입력하세요 : ");
				String title = scan.nextLine(); // nextLine 쓰면 띄어쓰기도 사용 가능
				System.out.println("[안내] 내용을 입력하세요 : ");
				String content = scan.nextLine();
				System.out.println("[안내] 작성자를 입력하세요 : ");
				String writer = scan.next();
				System.out.println("[안내] 비밀번호를 입력하세요 : ");
				String password = scan.next();
				// 2. 사용이 편리하도록 저장된 변수 4개를 하나의 객체로 만들기 [ 4개 묶음처리 ]
			
				Board regist = new Board( title, content, writer, password, 0 ); 
				// 객체선언 : 클래스명 명수명 = new 생성자 ( 매개변수 순서대로 )
				
				// 3. 배열에 객체 저장 [ 빈 공간을 찾아서 빈 공간에 저장 ]
				for( int index = 0; index < boardlist.length; index++ ) {
					if( boardlist[index] == null ) {
						boardlist[index] = regist;
						System.out.println("[안내] 글 등록이 완료되었습니다.");
						break;
					} // if 종료
				} // for 종료
			} // if 종료
			
			
			
			// 2번 글보기 선택
			else if ( ch == 2 ) {
				System.out.println("[안내] 게시글 번호를 선택하세요" );
				int select = scan.nextInt();
				
				Board board = boardlist[select];
				// 입력된 번호[인덱스]의 객체를 호출해서 board에 저장한 것
				
				System.out.println( " --------- 상세페이지 --------- " );
				System.out.println( "작성자 : " + board.writer );
				System.out.println( "제목 : " + board.title );
				System.out.println( "내용 : " + board.content );
				
				System.out.println("\n 1. 목록보기 2. 삭제 3. 수정");
				int ch2 = scan.nextInt();
				
				if( ch2 == 1 ) {
					
				}
				// 게시글 삭제
				else if( ch2 == 2 ) {
					System.out.println("[안내] 비밀번호를 입력하세요 ");
					String pw = scan.next();
					if( board.password.equals( pw ) ) {
						// 만일 현재 게시물의 비밀번호와 입력 받은 비밀번호가 같으면 삭제
						
						// 삭제된거 매꿔야하니까 한칸씩 당기기 [삭제된 인덱스 뒤로]
						for( int index = select; index < boardlist.length; index++ ) {
							// 현재 보고있는 게시물의 인덱스부터 마지막 인덱스까지 1씩 증가
							
							boardlist[index] = boardlist[index+1];
							
							if( boardlist[index+1] == null ) {
								break;
							} // if 종료
						} // for 종료
					} // if 종료
				} // else if 종료
				
				// 게시글 수정
				else if( ch2 == 3 ) {
					System.out.println("[안내] 비밀번호를 입력하세요");
					String pw = scan.next();
					if( board.password.equals( pw ) ) {
						
						scan.nextLine();
						System.out.println("[안내] 수정할 제목을 입력하세요 : ");
						boardlist[select].title = scan.nextLine();
						System.out.println("[안내] 수정할 내용을 입력하세요 : ");
						boardlist[select].content = scan.nextLine();
						
//						// 이것도 가능!
//						System.out.println("[안내] 수정할 제목을 입력하세요 : ");
//						String title = scan.next();
//						System.out.println("[안내] 수정할 내용을 입력하세요 : ");
//						String content = scan.next();
//						
//						board.title = title;
//						board.content = content;
						
						System.out.println("[안내] 수정이 완료되었습니다.");
					} // if 종료
				} // else if 종료
				
				else {
					System.err.println("[안내] 번호를 다시 선택해주세요 ");
				} // else 종료

			} // else if 종료

			else {
				System.err.println("[안내] 번호를 다시 선택해주세요 ");
			} // else 종료

		} // while 종료
		
		
		
		
		
		
		
		
		
		
		
	}
}
