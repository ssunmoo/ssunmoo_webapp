package 개인과제_RPG게임;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
	
		
	Scanner scanner = new Scanner(System.in);
		 
		 
		// ------------ 던전 입장 시 시작 ----------- //
  	   
  	 System.out.println(" [ 어느 던전에 입장하시겠습니까? ] ");
  	 System.out.println(" 1. A던전  2. B던전  3. C던전 ");
  	 
  	 int hunt = scanner.nextInt();
  	 
  	 
  	 if ( hunt == 1 ) {					// 1번 A던전 선택
  		System.out.println(" --- A 던전에 입장하였습니다 --- ");
  		
  		while ( true ) {
  			
  		System.out.println(" [ 원하는 행동을 선택해주세요 ] ");
  		System.out.println(" 1. 전투  2. 숨어있기  3. 마을로돌아가기 ");
  		
		int hunt_select = scanner.nextInt();
  	
		if ( hunt_select == 1 ) {
			System.out.println(" --- 전투를 시작합니다 몬스터를 사냥하세요! --- ");

	  		while ( true ) { 	
	  			System.out.println(" 1. 공격하기  2. 도망가기 ");
	  			
	  			int battle = scanner.nextInt();
	  			
	  			if( battle == 1 ) {			// 1번 공격하기 선택
	  				System.out.println(" -- 몬스터를 공격했습니다! --  ");
	  				
	  				continue; // 전투를 계속할지 말지 선택할 수 있도록	
	  				
	  				// 만약에 몬스터의 체력이 0이되면 죽은거니까 끝내기
	  				
	  				// 나 int hp = 0; 
	  				// hp++
	  				// 
	  				
	  				// 죽으면 exp++, 골드++
	  				
	  				
	  				
	  			} // battle 1번 공격하기 if 종료
	  			
	  			else if ( battle == 2 )	{	// 2번 도망가기 선택
	  				System.out.println(" [ 도망챠 ᕕ( ˃̣̣̥᷄⌓˂̣̣̥᷅ )ᕗ ]  ");
	  				break;
	  			} // battle 2번 도망가기 else if 종료
	  			
	  			else {
	  				System.out.println(" [ 다시 선택하세요 ] ");
	  				continue;
	  			} // battle else 종료
	  	  			
	  	  	} // while 
  	  		
  		} // hunt_select 1번 전투 if 종료	

  	  		else if ( hunt_select == 2 ) {	// 2번 숨어있기 선택
  	  			System.out.println(" [ 무서워.. 숨어있자! |x･`)  ] ");
  	  			continue;
  	  			
  	  		} // hunt_select 2번 숨어있기 else if 종료
  	  		
  	  		else if ( hunt_select == 3 ) {	// 3번 마을로 돌아가기 선택
  	  			
  	  			break;
  	  			
  	  		} // hunt_select 3번 마을로가기 else if 종료
 
  	 } // hunt 1번 A던전 if 종료
  
	} // 전투 while 종료	
  	 
  	 
  	 
  	 else if ( hunt == 2 ) {		// 2번 B던전 선택
  		System.out.println(" --- B 던전에 입장하였습니다 --- ");
  		System.out.println(" [ 원하는 행동을 선택해주세요 ] ");
  		System.out.println(" 1. 전투  2. 숨어있기  3. 마을로돌아가기 ");
  		
  		
  	 } // hunt 2번 else if 종료
  	   
  	 else if ( hunt == 3 ) {		// 3번 C던전 선택
  		System.out.println(" --- C 던전에 입장하였습니다 --- ");
  		System.out.println(" [ 원하는 행동을 선택해주세요 ] ");
  		System.out.println(" 1. 전투  2. 숨어있기  3. 마을로돌아가기 ");
  		
  		
 	 } // hunt 3번 else if 종료
  	 
  	 else if ( hunt == 4 ) {		// 4번 마을 선택
  		System.out.println(" [ 마을로 돌아갑니다 ] ");
  		return;
  		
 	 } // hunt 4번 else if 종료 
  	   
  	   
  	   // ------------ 던전 입장 시 종료 ----------- //		 
		
		


		
		
		
		
		
		
		

	} // 메인종료
} // 클래스 종료
