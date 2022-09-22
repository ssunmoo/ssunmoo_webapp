package java1.가계부;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class View {

	Controller control = new Controller();
	// 컨트롤러 사용할 수 있도록 객체 선언
	Scanner scan = new Scanner(System.in);
	// 스캐너 사용할 수 있도록 객체 선언
	
	public static void main(String[] args) {
		View view = new View();
		view.menu();
		
	} // 메인 종료
	
	
	
	// 0. 메인 메뉴 화면 메소드
	
	void menu() {
		while ( true ) {
			read();
			System.out.println(" ========= 메뉴를 선택해주세요 =========");
			System.out.println("[ 1. 추가 2. 수정 3. 삭제 4. 검색 5. 통계 ]");
			
			try {
				
				int select = scan.nextInt();
				
				if ( select == 1) {
					add();
					
				} // if 종료
				
				else if ( select == 2) {
					update();
				} // else if 종료
				
				else if ( select == 3) {
					delete();	
				} // else if 종료
							
				else if ( select == 4) {
					read();
				} // else if 종료
							
				else if ( select == 5) {	
					date_sum();
				} // else if 종료
				
				else{
					System.out.println(" [오류] 번호를 다시 선택하세요 ");
				} // else 종료
				
			} // try 종료
			
			catch (Exception e) {
				System.out.println("[오류] DB 오류 : " + e );
			} // catch 종료
			
		} // while 종료
	} // menu 메소드 종료
	
	
	// 1. 내용 추가 화면 메소드
	void add() {
		
		scan.nextLine();
		System.out.println("날짜 : ");
		String e_date = scan.nextLine();
		System.out.println("금액 : ");
		int e_money = scan.nextInt();
		
		scan.nextLine();
		System.out.println("내용 : ");
		String e_comment = scan.nextLine();
		
		boolean result = control.add(e_date, e_money, e_comment);
		
		if ( result ) {
			System.out.println(" [안내] 등록 완료 ");
		}
		else {
			System.out.println(" [안내] 등록 실패 ");
		}
	} // add 메소드 종료
	
	// 2. 내용 수정 화면 메소드
	void update() {
		
		System.out.println("번호 : ");
		int e_no = scan.nextInt();
		scan.nextLine();
		System.out.println("날짜 : ");
		String e_date = scan.nextLine();
		System.out.println("금액 : ");
		int e_money = scan.nextInt();
		scan.nextLine();
		System.out.println("내용 : ");
		String e_comment = scan.nextLine();
		
		boolean result = control.update( e_no, e_date, e_money, e_comment );
		
		if ( result ) {
			System.out.println(" [안내] 수정 완료 ");
		}
		else {
			System.out.println(" [안내] 수정 실패 ");
		}
	} // update 메소드 종료 
	
	// 3. 내용 출력 화면 메소드
	void read() {
		ArrayList< DTO > list = control.read();
		
		System.out.println("번호\t날짜\t\t금액\t내용");
		
		for ( DTO dto : list ) { // list에서 dto 하나씨 꺼내기
			System.out.print(dto.getE_no()+"\t");
			System.out.print(dto.getE_date()+"\t");
			System.out.print(dto.getE_money()+"\t");
			System.out.print(dto.getE_comment()+"\n");
		}
		// 향상된 for문 for( 타입 파라미터 임시변수 : 리스트/배열 ){}
	}
	
	// 4. 내용 삭제 화면 메소드
	void delete() {
		
		System.out.println("삭제할 번호 : ");
		int e_no = scan.nextInt();
		
		boolean result = control.delete( e_no );
		
		if ( result ) {
			System.out.println(" [안내] 삭제 완료 ");
		}
		else {
			System.out.println(" [안내] 삭제 실패 ");
		}
	}

	
	// 5. 날짜별 금액 합계
	void date_sum() {
		
		HashMap<String, Integer> list = control.date_sum();
		
		for( String key : list.keySet() ) {
			System.out.println("날짜\t\t합계금액");
			System.out.println(key+"\t"+list.get(key));
			
		}
	
	}
	
	
	
} // 클래스 종료