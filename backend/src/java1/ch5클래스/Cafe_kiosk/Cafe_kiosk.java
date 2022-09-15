package java1.ch5클래스.Cafe_kiosk;

import java.util.Scanner;

public class Cafe_kiosk {
	

	public static void main(String[] args) {
		

		// 입력받을 수 있는 스캐너 클래스 생성
		Scanner scanner = new Scanner(System.in);
		
		// 객체 생성
		Cafe_contorller con = new Cafe_contorller();
		
		
		
		while ( true ) { 
			System.out.println(" =========== 어서오세요 하루 카페입니다 =========== ");
			System.out.println(" 1. 메뉴선택  2. 장바구니확인  3. 결제  4. 관리자메뉴 ");
			int main_menu = scanner.nextInt();  
			
			// 선택을 계속할 수 있도록 반복 출력해줄거라 while문 사용
			while ( true ) {
				
				if ( main_menu == 1 ) { // 1. 메뉴선택
					System.out.println(" [ 주문하실 메뉴를 선택해주세요 ]");
					System.out.println(" ----------------------- ");
					// System.out.println(" 1. 아메리카노[1000원]  2. 바닐라라떼[1500원]  3. 카페라떼[2000원]  4. 카푸치노[2500원] 5. 그린티라떼[3000원] 6. 처음으로");
					System.out.println("  1. 아메리카노 -- 1000원 ");
					System.out.println("  2. 바닐라라떼 -- 1500원 ");
					System.out.println("  3. 카페라떼 -- 2000원 ");
					System.out.println("  4. 카푸치노 -- 2500원 ");
					System.out.println("  5. 그린티라떼 -- 3000원 ");
					System.out.println("  6. 처음으로");
					System.out.println(" ----------------------- ");
					int menu_select = scanner.nextInt();
					
					if( menu_select == 1 ) { // 1. 아메리카노
						System.out.println(" [안내] 아메리카노 [1000원] 1개를 장바구니에 담았습니다.");
						con.아메리카노();

						continue; // 메뉴를 재선택할 수 있도록 컨티뉴를 사용해서 반복문 재실행
					} // if 종료
					
					else if( menu_select == 2 ) { // 2. 바닐라라떼
						System.out.println(" [안내] 바닐라라떼[1500원] 1개를 장바구니에 담았습니다.");
						con.바닐라라떼();
			
					} // else if 종료
					
					else if( menu_select == 3 ) { // 3. 카페라떼
						System.out.println("[안내] 카페라떼[2000원] 1개를 장바구니에 담았습니다.");
						con.카페라떼();
						
					} // else if 종료
					
					else if( menu_select == 4 ) { // 4. 카푸치노
						System.out.println(" [안내] 카푸치노[2500원] 1개를 장바구니에 담았습니다.");
						con.카푸치노();
	
					} // else if 종료
					
					else if( menu_select == 5 ) { // 5. 그린티라떼
						System.out.println(" [안내] 그린티라떼[3000원] 1개를 장바구니에 담았습니다.");
						con.그린티라떼();

					} // else if 종료
					
					else if( menu_select == 6 ) { // 6. 첫화면으로 돌아가기
						break;
					} // else if 종료
					
					else {
						System.err.println(" [안내] 메뉴를 다시 선택해주세요 ");
						continue; // 안내 메세지 출력 후 반복문 재실행
					} // else 종료
				} // if 종료
				
				
				else if ( main_menu == 2 ) { // 2. 장바구니확인
					System.out.println(" ------- [ 장바구니 ] ------- ");
					con.장바구니();
					
					System.out.println();
					break; // 브레이크 안거니까 장바구니 반복..!!! 브레이크 넣으니까 해결 
				} // else if 종료
				
				
				else if ( main_menu == 3 ) { // 3. 결제
					System.out.println(" [안내] 결제 예정인 메뉴입니다. ");
					con.장바구니();

					System.out.println(" [안내] 금액을 입력하세요");
					int 결제금액 = scanner.nextInt();
					
					con.결제( 결제금액 );
					
					break;
				} // else if 종료
				
				
				else if ( main_menu == 4 ) { // 4. 관리자메뉴
					System.out.println(" [안내] 비밀번호를 입력하세요 ");
					int password = scanner.nextInt();
					
					if ( password == 1234 ) {
						System.out.println(" [안내] 메뉴를 선택하세요");
						System.out.println(" 1. 재고확인  2. 재고추가  3. 매출확인 ");
						int admin_select = scanner.nextInt();
						if ( admin_select == 1 ) { // 1번 재고확인
							System.out.println(" [안내] 현재 재고 현황입니다.");
							System.out.println(" 아메리카노 재고 : " + con.아메리카노_재고 );
							System.out.println(" 바닐라라떼 재고 : " + con.바닐라라떼_재고);
							System.out.println(" 카페라떼 재고 : " + con.카페라떼_재고);
							System.out.println(" 카푸치노 재고 : " + con.카푸치노_재고);
							System.out.println(" 그린티라떼 재고 : " + con.그린티라떼_재고);
							break; // 첫 화면으로 돌아가도록 
							
						} // if 종료
							
						else if ( admin_select == 2 ) { // 2번 재고추가
							System.out.println(" [안내] 원하는 제품을 선택 후 재고를 추가해주세요 ");
							System.out.println(" 1. 아메리카노 재고 : " + con.아메리카노_재고 );
							System.out.println(" 2. 바닐라라떼 재고 : " + con.바닐라라떼_재고);
							System.out.println(" 3. 카페라떼 재고 : " + con.카페라떼_재고);
							System.out.println(" 4. 카푸치노 재고 : " + con.카푸치노_재고);
							System.out.println(" 5. 그린티라떼 재고 : " + con.그린티라떼_재고);	
							int menu_select2 = scanner.nextInt();
							
							System.out.println(" [안내] 추가할 수량을 선택하세요 ");
							int add = scanner.nextInt();
							
							con.재고추가( menu_select2, add );
							System.out.println(" [안내] 재고 추가가 완료되었습니다 ");
							
							break; // 첫 화면으로 돌아가도록 
							
						} // else if 종료
							
						else if ( admin_select == 3 ) { // 3번 매출확인
							
							System.out.println(" [안내] 금일 매출을 확인하세요 ");							
							System.out.println(" 아메리카노 : " + con.아메리카노_매출량 + "개, " + con.아메리카노_매출량*1000 + "원");
							System.out.println(" 바닐라라떼 : " + con.바닐라라떼_매출량 + "개, " + con.바닐라라떼_매출량*1500 + "원");
							System.out.println(" 카페라떼 : " + con.카페라떼_매출량 + "개, " + con.카페라떼_매출량*2000 + "원");
							System.out.println(" 카푸치노 : " + con.카푸치노_매출량 + "개, " + con.카푸치노_매출량*2500 + "원");
							System.out.println(" 그린티라떼 : " + con.그린티라떼_매출량 + "개, " + con.그린티라떼_매출량*3000 + "원");
							System.out.println(" 총 매출은 : " + con.총매출금액 + "원 입니다");

							
							
							
							
							
							
							break;
						} // else if 종료
					} // if 종료
					
					else {
						System.out.println(" [안내] 비밀번호가 틀렸습니다 : 접근불가 ");
					} // else 종료
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				} // else if 종료
				
				else { // 그외 번호 선택
					System.err.println(" [안내] 번호를 다시 선택해주세요");
				} // else 종료
			} // 와일2 종료
		}// 와일1 종료
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // 메인 종료
} // 클래스 종료
