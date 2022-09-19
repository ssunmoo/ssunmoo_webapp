package DATABASE.ch3기본문법;

import java.util.ArrayList;
import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		while ( true ) {
			System.out.println("예제 번호 선택 >> ");
			int ch = scan.nextInt();
			
			// 메소드 호출 방법
				// 1. static(정적) 으로 선언된 함수 : 클래스명.함수명()
				// 2. 일반함수 : 객체명.함수명()
			
			DAO dao = new DAO();	// dao 객체 생성
			
			// 1.
			if( ch == 1 ) {
				ArrayList< MemberDto > list = dao.예제1결과();				
				System.out.println("---------------예제1 결과물 -----------------");
				
				for( MemberDto dto : list ) {
					// list 내 데이터를 dto 데이터와 하나씩 비교
					
					System.out.print( dto.mem_id + "\t");
					System.out.print( dto.mem_name + "\t" );
					System.out.print( dto.mem_nuber + "\t" );
					System.out.print( dto.addr + "\t" );
					System.out.print( dto.phone1 + "\t" );
					System.out.print( dto.phone2 + "\t");
					System.out.print( dto.height + "\t" );
					System.out.print( dto.debut_date + "\n" );
				} // for 종료
			} // if 종료
			
			if( ch == 2 ) {
				ArrayList< String > list = dao.예제2결과();
				for( String s : list ) {
					System.out.print( s + "\t");
				} // for 종료
				System.out.println();
			} // if 종료		
			
			
			if( ch == 3 ) {
				MemberDto dto = dao.예제3결과();
					System.out.print( dto.mem_id + "\t");
					System.out.print( dto.mem_name + "\t" );
					System.out.print( dto.mem_nuber + "\t" );
					System.out.print( dto.addr + "\t" );
					System.out.print( dto.phone1 + "\t" );
					System.out.print( dto.phone2 + "\t");
					System.out.print( dto.height + "\t" );
					System.out.print( dto.debut_date + "\n");
			} // if 종료
			
			
			if ( ch == 4 ) {
				ArrayList< MemberDto > list = dao.예제4결과();
				for( MemberDto dto : list ) {
					System.out.print( dto.mem_id + "\t");
					System.out.print( dto.mem_name + "\n" );
		
				} // for 종료
			} // if 종료
			
			
			if( ch == 5 ) {
				ArrayList< MemberDto > list = dao.예제5결과();
				for( MemberDto dto : list ) {
					System.out.print( dto.mem_name + "\t");
					System.out.print( dto.height + "\t" );
					System.out.print( dto.mem_nuber + "\n" );

				} // for 종료
			} // if 종료
			
			
			if ( ch == 6 ) {
				ArrayList< MemberDto > list = dao.예제6결과();
				for( MemberDto dto : list ) {
					System.out.print( dto.mem_name + "\t");
					System.out.print( dto.height + "\t" );
					System.out.print( dto.mem_nuber + "\n" );
				} // for 종료
			} // if 종료
			
			
			if( ch == 7 ) {
				MemberDto dto = dao.예제7결과();
				System.out.print( dto.mem_id + "\t");
				System.out.print( dto.mem_name + "\t" );
				System.out.print( dto.mem_nuber + "\t" );
				System.out.print( dto.addr + "\t" );
				System.out.print( dto.phone1 + "\t" );
				System.out.print( dto.phone2 + "\t");
				System.out.print( dto.height + "\t" );
				System.out.print( dto.debut_date + "\n");
				
			} // if 종료
			
			
			if( ch == 8 ) {
				ArrayList< MemberDto > list = dao.예제8결과();
				for( MemberDto dto : list ) {
					System.out.print( dto.mem_id + "\t");
					System.out.print( dto.mem_name + "\t" );
					System.out.print( dto.mem_nuber + "\t" );
					System.out.print( dto.addr + "\t" );
					System.out.print( dto.phone1 + "\t" );
					System.out.print( dto.phone2 + "\t");
					System.out.print( dto.height + "\t" );
					System.out.print( dto.debut_date + "\n");
				}
				
			} // if 종료
			
			
			if( ch == 9 ) {
				ArrayList< MemberDto > list = dao.예제9결과();
				for( MemberDto dto : list ) {
					System.out.print( dto.mem_id + "\t");
					System.out.print( dto.mem_name + "\t" );
					System.out.print( dto.debut_date + "\n");
				}
			} // if 종료			
			
			if( ch == 10 ) {
				ArrayList< MemberDto > list = dao.예제10결과();
				for( MemberDto dto : list ) {
					System.out.print( dto.mem_id + "\t");
					System.out.print( dto.mem_name + "\t" );
					System.out.print( dto.debut_date + "\t");
					System.out.print( dto.height + "\n" );
				}
			} // if 종료
			
			
			if( ch == 11 ) {
				ArrayList< MemberDto > list = dao.예제11결과();
				for( MemberDto dto : list ) {
					System.out.print( dto.mem_id + "\t");
					System.out.print( dto.mem_name + "\t" );
					System.out.print( dto.debut_date + "\t");
					System.out.print( dto.height + "\n" );
				}
			} // if 종료			
			
			
			if( ch == 12 ) {
				ArrayList< MemberDto > list = dao.예제12결과();
				for( MemberDto dto : list ) {
					System.out.print( dto.mem_name + "\t" );
					System.out.print( dto.height + "\n" );
				}
			} // if 종료			
			
			
			if( ch == 13 ) {
				ArrayList< MemberDto > list = dao.예제13결과();
				for( MemberDto dto : list ) {
					System.out.print( dto.addr + "\n" );
				} // for 종료
			} // if 종료	
			
			if( ch == 14 ) {
				ArrayList< MemberDto> list = dao.예제14결과();
				for( MemberDto dto : list ) {
					System.out.print( dto.mem_id + "\t");
					System.out.print( dto.value + "\n" );
				} // for 종료
			} // if 종료				
			
			
			if( ch == 15 ) {
				
				
			} // if 종료				

			
			if( ch == 16 ) {
				
				
			} // if 종료				
			
			
			if( ch == 17 ) {
				
				
			} // if 종료				
			
			
			if( ch == 18 ) {
				
				
			} // if 종료				
			
			if( ch == 19 ) {
				
				
			} // if 종료				
			
			
			
			
			
			
		} // while 종료
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // main 종료
} // class 종료
