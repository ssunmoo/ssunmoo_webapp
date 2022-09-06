package java1.ch4배열;

import java.util.Scanner;

public class EX6_회원 {
	public static void main(String[] args) {
		
/*
	회원제 프로그램 구현
		
		[ 조건 ] 
			1. 2차원 배열
			
		[ 기능 ]
			1. 회원가입
				1. 아이디 비밀번호 이름 전화번호
				2. 배열내 빈 공간의 인덱스를 찾아서 해당 인덱스에 회원정보(값) 넣기
				 	String = null / int = 0 / double = 0.0 / boolean = false
				3. 아이디 중복체크														// 아래로 쭉쭉 추가
				4. 최대 회원 100명							     [세로][가로]				// String 기본 값이 null 이라서 값 넣기 전엔 다 null로 가득 참
					* 1명당 4개의 변수 -> 400개 변수 -> 2차원 배열 -> [100][4]				// 00 01 02 03 04	
					* 행 당 1명														// 10 11 12 13 14 	
					* 0열 : 아이디 / 1열 비밀번호 / 2열 : 이름 / 3열 : 전화번호
					
			2. 로그인 기능
				아이디 비밀번호가 동일하면 로그인 성공 
			
			3. 아이디 찾기 기능
				이름 전화번호가 동일하면 아이디 알려주기 
				
			4. 비밀번호 찾기 기능
				아이디 전화번호가 동일하면 비밀번호 알려주기
	
		[ 출력 ]
			1. 메뉴 : 1. 회원가입 2. 로그인 3. 아이디찾기 4. 비밀번호찾기
*/
		
		// 0. 메모리
		String[][] memberlist = new String[100][4];	// 문자열 400개를 저장할 수 있는 배열 선언		
		Scanner scan = new Scanner(System.in);		// 입력 객체								
		
		
		
		
		// 1. 무한루프 [ 프로그램 실행 ]	종료 조건x
		while (true) { // while 시작
			
			System.out.println("\n---------------- [ 회원제 페이지 ] ----------------");
			System.out.println(" 메뉴 : 1. 로그인 2. 회원가입 3. 아이디찾기 4. 비밀번호찾기");
			System.out.println("-----------------------------------------------");
			System.out.println(" 메뉴 선택 : ");
			
			int btn = scan.nextInt();
		
			if( btn == 1 ) {// 1. 로그인을 입력했을 때
				
				// 1. 아이디 / 비밀번호를 입력 받기
				System.out.println(" 아이디를 입력해주세요");
				String id = scan.next();
				System.out.println(" 비밀번호를 입력해주세요");
				String pw = scan.next();
				
				// 2. 배열내 모든 항목[인덱스]와 비교해서 입력한 아이디와 비밀번호 확인
				int login = 0; // 로그인 처리에 대한 상태를 저장하는 변수
				
				for(int i = 0; i < memberlist.length; i++) {
					if( memberlist[i][0] != null ) {
						// 해당 인덱스가 null이 아니면서
						if( memberlist[i][0].equals(id) ) {
							// 해당 인덱스의 아이디가 입력받은 아이디와 같으면서
							login = 2;	// 아이디는 맞으나 비밀번호가 틀렸을때 2
								
							if(memberlist[i][1].equals(pw)) {
								// 해당 인덱스의 비밀번호가 입력받은 비밀번호와 같으면
								System.err.println("[안내] 로그인 성공");
								login = 1;	// 아이디와 비밀번호 모두 맞았을 때
								
								
									// 로그인 성공 시 실행
									// * 추후 코드 로그인 메뉴 * //
									while ( true ) {
										System.out.println(" 메뉴 : 1. 회원탈퇴 2. 로그아웃");
										int btn2 = scan.nextInt();
										if( btn2 == 1 ) {
										// -------------------------------------------- // 
											// i = 로그인 성공한 인덱스 = 로그인한 회원의 인덱스
											memberlist[i][0] = null;
											memberlist[i][1] = null;
											memberlist[i][2] = null;
											memberlist[i][3] = null;
												// 삭제된 회원 뒤로 정보를 한칸씩 당기기
												// 삭제된 데이터 때문에 배열 중간에 빵꾸나있으면 안되니까 삭제된 배열 뒤 배열부터 한칸씩 앞으로 땡겨줘야함
											for( int j = i; j < memberlist.length; j++) {
												memberlist[j][0] = memberlist[j+1][0];
												memberlist[j][1] = memberlist[j+1][1];
												memberlist[j][2] = memberlist[j+1][2];
												memberlist[j][3] = memberlist[j+1][3];
												if( memberlist[j+1][0] == null ) {
													// 다음 인덱스의 값이 null 이면 [ 회원이 없다는 뜻 ]
													break;
												} // if 종료
											} // for 종료
										// -------------------------------------------- // 
											System.out.println("[안내] 회원 탈퇴가 되었습니다.");
											break;
										} // if 종료
										
										else if( btn == 2 ){
											break;
										} // else if 종료 
									} // while 종료
									
								break;
							} // if 끝
						} // if 끝
					} // if끝
				} // for 끝
				if ( login == 0 ) {
					System.err.println("[안내] 동일한 아이디가 없습니다.");
				}
				else if( login == 2 ) {
					System.err.println("[안내] 비밀번호가 일치하지 않습니다.");
				}
				else if( login == 1 ) {
					System.err.println("[안내] 로그아웃 되었습니다.");
				}
				// 3. 있으면 로그인 성공 없으면 로그인 실패
				
				
				
				
				
				
				
			} // btn 1 if 끝	
				
			
			else if( btn == 2 ) {// 2. 회원가입을 입력했을 때
				// 1. 회원 정보를 변수로 입력받기 [ 바로 배열에 대입 x ]
				System.out.println("[회원가입 창입니다 정보를 입력해주세요]");
				System.out.println(" 아이디를 입력해주세요");
				String id = scan.next();

				// 2. 아이디 중복체크 : 입력받은 id가 존재하면 회원가입 실패
				boolean idcheck = true;
				
				for( int row = 0; row < memberlist.length; row++) {
					if( memberlist[row][0] !=null && memberlist[row][0].equals( id ) ) {
						// 입력받은 id와 배열내 id가 같다 [ 중복 찾음 ] 
						// null은 equals 메소드 사용 불가 [ == null, !=null ]
						
						System.err.println("[안내] 이미 사용중인 아이디입니다.");
						idcheck = false;
						break;
					} // if 끝 
				}	// for 끝
				
				
				// 3. 아이디 중복 흐름 제어
				if( idcheck ) {
					System.out.println(" 비밀번호를 입력해주세요");
					String pw = scan.next();
					System.out.println(" 이름을 입력해주세요");
					String name = scan.next();
					System.out.println(" 전화번호를 입력해주세요");
					String phone = scan.next();
				
					// 3. 입력받은 변수들을 배열에 저장한다 [ 배열호출 : 배열명[행인덱스] [열인덱스]
					// 2-1. 배열내 빈 행을 찾는다
					for( int row = 0; row < memberlist.length; row++ ) {
						if( memberlist[row][0] == null ) {
							// row번째 아이디가 null이면 = 회원이 없다
							
							// 2-2 : null 행 위치에 입력받은 데이터를 하나씩 대입
							memberlist[row][0] = id;
							memberlist[row][1] = pw;
							memberlist[row][2] = name;
							memberlist[row][3] = phone;
	
							// 2-3 : 저장완료 시 반복문 종료 [ 끝내기 ]
							break;
						}
						if( row == 99 ) {
							System.err.println("[안내] 최대 회원수가 찼습니다. [회원가입불가능 : 관리자 문의]");
						} // if 2 종료
					} // for 종료
				}	// idcheck if 종료
			} // else if 2종료		
			
			
			else if( btn == 3 ) {									// 3. 아이디찾기를 입력했을 때
				
				// 이름이랑 전화번호를 입력받아서 동일하면 아이디 알려주기
				// 2열 : 이름, 3열 : 전화번호
				// memberlist[i][2] memberlist[i][3]  이게 맞는지 다시 생각해보자
				// -- > 이거는 맞고 비교 대상 설정이 잘못되어있었음 입력한 값과 배열내에 있는 값을 비교해야 함
				
				
				
				// 1. 이름, 전화번호 입력받기
				// 2. 배열내 모든 항목을 비교해서 동일한 이름, 전화번호 확인
				// 3. 존재하면 해당 아이디 출력, 아니면 미출력
				
				System.out.println("---------------- [ 아이디 찾기 ] ----------------");
				System.out.println(" 이름을 입력해주세요");
				String name = scan.next();
				System.out.println(" 전화번호를 입력해주세요");
				String phone = scan.next();
				
				for( int i = 0; i < memberlist.length; i++ ) {	// 모든 항목  출력
					if(	memberlist[i][0] != null && memberlist[i][2].equals(name) && memberlist[i][3].equals(phone)) {
							//	아이디가 null 값이 아니면서,			입력한 이름과 같고				입력한 전화번호가 같으면
						System.err.println( "[안내] 회원님의 아이디는 : [ " + memberlist[i][0] + " ] 입니다");
						break;
					} // if 종료
					if( i == memberlist.length-1 ) {	// i가 마지막 인덱스와 같으면 [ 모두 검사했는데 조건 못찾음 ]
						System.err.println("[안내] 동일한 회원정보가 없습니다.");
					} // if 종료
				} // for 종료
				
			}
				
			else if( btn == 4 ) {// 4. 비밀번호찾기를 입력했을 때
				
				// 1. 아이디 배열 : [0], 전화번호 배열 : [3] 입력받기
				// 2. 배열내 모든 항목을 비교해서 동일한 아이디, 비밀번호 확인
				// 3. 존재하면 해당 비밀번호를 출력, 아니면 미출력
				
				System.out.println("---------------- [ 비밀번호 찾기 ] ----------------");
				System.out.println(" 아이디을 입력해주세요");
				String id = scan.next();
				System.out.println(" 전화번호를 입력해주세요");
				String phone = scan.next();
				
				for( int i = 0; i < memberlist.length; i++ ) {
					if( memberlist[i][1] != null && memberlist[i][0].equals(id) && memberlist[i][3].equals(phone) ) {
						// 비밀번호가 null 값이 아니면서			id가 입력한 것과 동일하고				phone가 입력한 것과 동일할때
						System.err.println("[안내] 회원님의 비밀번호는 : [ " + memberlist[i][1] + " ] 입니다.");
						break;
					} // if 종료
					if( i == memberlist.length-1 ) {
						System.err.println("[안내] 동일한 회원정보가 없습니다.");
					}
				} // for 종료
				
				
				
				
			} // btn 4 else if 종료
			
			else{
				System.err.println("[안내] 번호를 다시 선택해주세요.");
			}
			
			
		} // while 끝
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	// 메인 끝
} // 클래스 끝
