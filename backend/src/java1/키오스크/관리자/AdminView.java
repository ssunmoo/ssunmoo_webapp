package java1.키오스크.관리자;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminView {
	
	AdminController acontrol = new AdminController();
	
	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		AdminView admin = new AdminView();
		admin.menu();
		
		
		
	} // 메인 종료
	
	
	// 1. 관리자 메뉴
	void menu() {
		
		while ( true ) {
			System.out.println(" 1. 메뉴추가 2. 제품추가 3. 주문확인 ");
			
			try { 
				int ch = scan.nextInt();
				
				if ( ch == 1 ) {
					inMenu();		// 메소드 호출
				}
				else if ( ch == 2 ) {
					inProduct();	// 메소드 호출
				}
				else if ( ch == 3 ) {
					
				}
				
				else {
					System.out.println(" [경고] 선택할 수 없는 번호입니다. ");
				}
			} // try 종료
			catch (Exception e) {
				System.out.println(" [경고] 선택할 수 없는 작동입니다. ");
				scan = new Scanner(System.in);	// 오류 있을 경우 스캐너(입력받은 값)를 초기화
			} // catch 종료
	
		} // 와일 종료		
	} // 메소드 종료
	
	
	
	// 2. 메뉴 추가 화면
	void inMenu() {
		System.out.println(" 추가할 메뉴 이름 : ");
		String menuname = scan.next();
		
		
		
		boolean result = acontrol.inMenu( menuname );
		
		if( result ) {
			System.out.println(" [ 안내 ] 메뉴 등록이 완료되었습니다 ");
		}
		else {
			System.out.println(" [ 안내 ] 메뉴 등록이 실패하였습니다 ");	
		}
	} // 메소드 종료
	
	
	// 3. 제품 추가 화면
	void inProduct() {
		// 현재 메뉴 목록 //
		
		ArrayList< MenuDTO > list = acontrol.getMenu();
		
		System.out.println(" 메뉴번호\t메뉴이름");
		for( MenuDTO menu : list ) {
			System.out.print( menu.getMno() +"\t");
			System.out.print( menu.getMname() +"\n");
		}
		System.out.println(" 추가할 제품의 메뉴 번호를 선택하세요 ");
		byte mno = scan.nextByte();
		
		System.out.println();
		// 제품 추가 //
		scan.nextLine();
		System.out.println(" 제품명 : ");
		String pname = scan.nextLine();
		
		System.out.println(" 가격 : ");
		int pprice = scan.nextInt();
		
		scan.nextLine();
		System.out.println(" 소개 : ");
		String pcomment = scan.nextLine();
		
		System.out.println(" 초기재고 : ");
		short pamount = scan.nextShort();
		
		
		boolean result = 
				acontrol.inProduct(pname, pprice, pcomment, pamount, mno);
		
		if( result ) {
			System.out.println(" [ 안내 ] 제품 등록이 완료되었습니다 ");
		}
		else {
			System.out.println(" [ 안내 ] 제품 등록이 실패하였습니다 ");	
		}
	} // 메소드 종료
	
	// 4. 주문 확인 하면
	void getOrder() {
		
	} // 메소드 종료

	
	
	
	
	
} // 클래스 종료
