package 개인과제_RPG게임;

import java.util.Random;
import java.util.Scanner;

public class RPG게임 {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      while(true) {
         
	  int hp = 10; int mp=20; int exp=0; int gold=0; int attack=0; int lv = 1;
	  int dm = 2; int ran = 0;
        
	  if(exp == 20) {
    	 System.out.println(" lv.1 up! ");
    	 hp += 2;
    	 mp += 4;
    	 
    	 if( lv == 5 ) {
    		 dm += 2;
    	 }
    	 if( lv == 10 ) {
    		 dm += 2;
    	 }
	  }
          
      System.out.println("⚔⚔⚔⚔⚔자바죽이기⚔⚔⚔⚔⚔⚔⚔");   
      System.out.println("⚔〇\t\t\t\t ⚔\r\n"
            + "⚔\t　　ｏ\t\t\t ⚔\r\n"
            + "⚔\t　　°\t\t\t ⚔\r\n"
            + "⚔\t　┳┳ ∩∩\t\t\t ⚔\r\n"
            + "⚔\t　┃┃(･∀･)　☆　　★\t\t ⚔\r\n"
            + "⚔\t┏┻┻┷━Ｏ ┏┷┓┏┷┓\t\t ⚔\r\n"
            + "⚔\t┃Welcome┠┨★┠┨☆┃\t ⚔\r\n"
            + "⚔\t┗©━━©┛ ┗©┛┗©┛\t\t ⚔");
      System.out.println(" ⚔⚔RPG게임에 오신것을 환영합니다⚔⚔");
      System.out.println("     1. 캐릭터 생성 2. 로그인 3. 회원가입 "); int input = scanner.nextInt();
      
////////////////////////////////////////////////////////////////////////////////////////////////////
   if(input==1) {
      String 캐릭터정보 ="null,null,10,20,0,0,전직미완료";
      
      System.out.println("▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀");
      System.out.println("\t        캐릭터생성");
      System.out.println("\t성별을 직접 입력하세요[남자/여자]");String x=scanner.next();
      System.out.println("\t캐릭터 아이디 입력해주세요!!");String name=scanner.next();
      System.out.println("\t선택하신 캐릭터의 성별은 '"+x+"'\n\t이름은 '"+name+"' 로 생성하시겠습니까?\n"+"\t      1.Y 2.N");int answer=scanner.nextInt();
      System.out.println("▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀");
         if(answer==1&&x.equals("남자")) {
            
            System.out.print("\t　∧ ,, ∧\r\n"
                  + "\t （´･ω･）　ヽヽ\r\n"
                  + "\t　/つ　〇━⊂二二フ\r\n"
                  + " \t                  ⊂(  ‘ д’)つ\n");
            System.out.println("\t환영합니다!!");
            System.out.println("\t당신의 캐릭터의 성별은 '"+x+"'\n\t이름은 '"+name+"' 입니다");
         
            if(캐릭터정보.split(",")[0].equals("null") ) { 캐릭터정보 = "👉성별:"+x 
                  +"\n👉아이디:"+name  + 
                  "\n👉HP :"+캐릭터정보.split(",")[2] +
                  "\n👉MP :"+캐릭터정보.split(",")[3] +
                  "\n👉경험치 :"+캐릭터정보.split(",")[4] + 
                  "\n👉골드 :"+캐릭터정보.split(",")[5]+ 
                  "\n👉직업 :"+캐릭터정보.split(",")[6]; }
            System.out.println("\t╭◜◝ ͡ ◜◝╮\r\n"
                  + "\t( ＊•◡•＊ )\r\n"
                  + "\t╰◟◞ ͜ ◟◞╯\n"
                  +"\t👉👉확인정보👈👈");
            System.out.println("\t人◕ ‿‿ ◕人");
            System.out.println(캐릭터정보);
            
         }//남자 캐릭터 if E
         
         if(answer==2) {System.out.println(" ____                         \r\n"
                 + "/\\  _`\\                       \r\n"
                 + "\\ \\ \\L\\ \\   __  __       __   \r\n"
                 + " \\ \\  _ <' /\\ \\/\\ \\    /'__`\\ \r\n"
                 + "  \\ \\ \\L\\ \\\\ \\ \\_\\ \\  /\\  __/ \r\n"
                 + "   \\ \\____/ \\/`____ \\ \\ \\____\\\r\n"
                 + "    \\/___/   `/___/> \\ \\/____/\r\n"
                 + "                /\\___/        \r\n"
                 + "                \\/__/         "); continue;}
         
         
         else if(answer==1&&x.equals("여자")){
            System.out.print("　∧ ,, ∧\r\n"
                  + " （´･ω･）　ヽヽ\r\n"
                  + "　/つ　〇━⊂二二フ\r\n"
                  + "                   ⊂(  ‘ д’)つ\n");
            System.out.println("====환영합니다!!");
            System.out.println("당신의 캐릭터의 성별은 '"+x+"'\n 이름은 '"+name+"' 입니다");
            
            if(캐릭터정보.split(",")[0].equals("null") ) { 캐릭터정보 = "👉성별: "+x 
                  +"\n👉아이디:"+name  + 
                  "\n👉HP : "+캐릭터정보.split(",")[2] + 
                  "\n👉MP : "+캐릭터정보.split(",")[3] +  
                  "\n👉경험치 : "+캐릭터정보.split(",")[4] + 
                  "\n👉골드 : "+캐릭터정보.split(",")[5]+  
                  "\n👉직업 : "+캐릭터정보.split(",")[6]; }
            System.out.println("\t╭◜◝ ͡ ◜◝╮\r\n"
                  + "\t( ＊•◡•＊ )\r\n"
                  + "\t╰◟◞ ͜ ◟◞╯\n"
                  +"\t👉👉확인정보👈👈");
            System.out.println("\t人◕ ‿‿ ◕人");
            System.out.println(캐릭터정보);
         }//여자 캐릭터 if E
         
         if(x.equals("남자")||x.equals("여자")&&answer==1) {
               System.out.println("\t╯▅╰╱▔▔▔▔▔▔▔╲╯╯☼\r\n"
                     + "\t▕▕╱╱╱╱╱╱╱╱╱╲╲╭╭\r\n"
                     + "\t▕▕╱╱╱╱╱╱╱╱┛▂╲╲╭\r\n"
                     + "\t╱▂▂▂▂▂▂╱╱┏▕╋▏╲╲\r\n"
                     + "\t▔▏▂┗┓▂▕▔┛▂┏▔▂▕▔\r\n"
                     + "\t▕▕╋▏▕╋▏▏▕┏▏▕╋▏▏\r\n"
                     + "\t▕┓▔┗┓▔┏▏▕┗▏┓▔┏▏");
               System.out.println();
               System.out.println("=>마을에 오신걸 환영합니다🤚🤚");
               
               
               
               boolean 마을 = true;
               while( 마을 ) {
               
               System.out.println("\t⎛⎝(•‿•)⎠⎞⎛⎝(•‿•)⎠⎞태초마을⎛⎝(•‿•)⎠⎞⎛⎝(•‿•)⎠⎞");
               System.out.println("\t👉👉원하는 행동을 선택해주세요👈👈");
               System.out.println("\t1. 던전입장  2. 상점방문  3. 휴식 4. 상태확인"); 
              
               int home=scanner.nextInt();
	            
               
           // ------------ 던전 입장 시 시작 ----------- //
           
        if(home==1) {
          while(true) {
          
          System.out.println("\t　　　　∧_∧\r\n"
                + "\t　　　 (･ω･ )\r\n"
                + "\t　　　ｏ┳o　）\r\n"
                + "\t　　　◎┻し'◎ ≡");
          System.out.println("\t1. A던전 입장\n\t2. B던전 입장\n\t3. C던전 입장\n\t4. 마을로 돌아가기 ");int hunt=scanner.nextInt();
          
          if ( hunt == 1 ) {					// 1번 A던전 선택
        	 
        	 while ( true ) {

        	 String 몬스터_A ="몬스터A,HP:20,획득가능 경험치 5";
             System.out.println("\t  ∧ ∧\r\n"
                   + "\t (´･ω･)  =3\r\n"
                   + "\t /　 ⌒ヽ\r\n"
                   + "\t(人＿＿つ_つ");
             System.out.println("\t"+몬스터_A);
             System.out.println("\t✋날잡으러 왔나");
             System.out.println("\t사냥하시겠습니까?\n\t1. 싸우자(주먹으로싸우기)\n\t2. 숨어있기\n\t3. 필드로 돌아가기");
             
             int hunt_select = scanner.nextInt();
           	
     		if ( hunt_select == 1 ) {
     			
     			ran = 0;
     			
     			System.out.println("\t(ง •̀_•́)ง");
     			System.out.println("\t몬스터를 사냥하세요!");

     			boolean 변수 = true;
     	  		while ( 변수 ) { 
     	  			System.out.println("\t1. 공격하기\n\t2. 도망가기\t3. 스킬사용");
     	  			
     	  			int battle = scanner.nextInt();
     	  			
     	  			if( battle == 1 ) {			// 1번 공격하기 선택
     	  				System.out.println("\t✊ 몬스터A를 공격했다! ✊");
     	  				
     	  				attack++;
     	  				System.out.println("✊✊때린 횟수 : " + attack );
     	  				
 	  					// 두대 때리고 한대 맞기
 	  					if( attack % 2 == 0 ) { 
							System.out.println("몬스터A에게 공격당했다ㅠㅠ");
							
						for(int i = 1; i < 10; i++) {
							ran = (int) ((Math.random()*4)+1);								
							
						}
						System.out.println(ran);	
						
						hp -= ran;
  						
  						System.out.println("현재 HP : " + hp );						
  						
  						if ( attack == 10 ) {
  							exp += 5;
  							gold++;
  							System.out.println("몬스터A가 처치되었습니다");
 	  						System.out.println("경험치 " + exp + " 획득\n골드 " + gold + " 획득");
 	  						변수 = false;
 	  						break;
  						} // if 종료
  						
  						
  						if ( hp == 0 ) {
  							System.out.println("\t사망했습니다 마을로 돌아가자");
  							exp -= 2;
  							gold -= 1;
  													
  							마을 = false;
  							break;
  						}
  						
  					} // if 종료
 	  		
 	  				continue; // 전투를 계속할지 말지 선택할 수 있도록	
     	  				
     	  			} // battle 1번 공격하기 if 종료
     	  			
     	  			else if ( battle == 2 )	{	// 2번 도망가기 선택
     	  				System.out.println("\tᕕ( ˃̣̣̥᷄⌓˂̣̣̥᷅ )ᕗ");
     	  				System.out.println("\t필드로 도망갑니다..!\n");
     	  				break;
     	  			} // battle 2번 도망가기 else if 종료
     	  			
     	  			else {
     	  				System.out.println("\t다시 선택하세요!");
     	  				continue;
     	  			} // battle else 종료
     	  	  			
     	  	  	} // while 
       	  		
       		} // hunt_select 1번 전투 if 종료	

       	  		else if ( hunt_select == 2 ) {	// 2번 숨어있기 선택
       	  			System.out.println("\t|x･`) 무서워.. 숨어있자 ");
       	  			continue;
       	  			
       	  		} // hunt_select 2번 숨어있기 else if 종료
       	  		
       	  		else if ( hunt_select == 3 ) {	// 3번 마을로 돌아가기 선택
       	  			break;
       	  			
       	  		} // hunt_select 3번 마을로가기 else if 종료
          
           	 } // hunt 1번 A던전 if 종료
           
         	} // 전투 while 종료	
           	 
           	 else if ( hunt == 2 ) {		// 2번 B던전 선택
           		System.out.println("\t--- B 던전에 입장하였습니다 --- ");
           		System.out.println("\t[ 원하는 행동을 선택해주세요 ] ");
           		System.out.println("\t사냥하시겠습니까?\n\t1. 싸우자(주먹으로싸우기)\n\t2. 숨어있기\n\t3. 마을로 돌아가기");
           		
           		
           	 } // hunt 2번 else if 종료
           	   
           	 else if ( hunt == 3 ) {		// 3번 C던전 선택
           		System.out.println(" --- C 던전에 입장하였습니다 --- ");
           		System.out.println(" [ 원하는 행동을 선택해주세요 ] ");
           		System.out.println("\t사냥하시겠습니까?\n\t1. 싸우자(주먹으로싸우기)\n\t2. 숨어있기\n\t3. 마을로 돌아가기");
           		
           		
          	 } // hunt 3번 else if 종료
           	 
           	 else if ( hunt == 4 ) {		// 4번 마을 선택
           		System.out.println(" [ 마을로 돌아갑니다 ] ");
           	
           		break;
           		
          	 } // hunt 4번 else if 종료 
               	   
                  
                  }// 던전 if While E
                  
           
                  
               }// 던전 선택 if E 
        // ------------ 던전 입장 시 종료 ----------- //	
               
               
               
      /////////////////////////////////////////////////////////////마을선택/////////////////////////////////////////////////////////
               else if(home==2) {
               System.out.println("상점에 입장하셨습니다");
               System.out.println("　　　　　　　　　| \r\n"
                     + "　　　　　　　　　| \r\n"
                     + "　　　　　 　　　 ﾉ,,∧ \r\n"
                     + "　　　　　　　 ／/･ω･`) \r\n"
                     + "　　　　　　／　/⊂ノ \r\n"
                     + " 　　　　　　＼ /ーJ \r\n"
                     + " ￣￣￣￣￣￣￣");
                  System.out.println("어서오세옹 무엇을 원하는냐옹\n 1.물약구입");int buy=scanner.nextInt();
            
               if(buy==1) {
                  System.out.println("\t👉보유골드는:"+gold--+"💪(■_■💪)\r\n"
                        + "      \t🤞맛나게 드시게나🤞");
                  }//물약구입 if E
               
               }//상점 구매 else if E
        
               else if( home == 3 ) { // 휴식
              	 
               }
        
               else if( home == 4 ) { // 상태창
            	  
            	   캐릭터정보 = "👉성별 : " + x 
                           +"\n👉아이디: " + name  + 
                           "\n👉HP : " + hp +
                           "\n👉MP : " + mp +
                           "\n👉경험치 : " + exp + 
                           "\n👉골드 : " + gold + 
                           "\n👉직업 : " + hp;
            	   
            	   System.out.println( 캐릭터정보 );
               }
               else {
            	   System.out.println("번호재선택");
              }
        
               System.out.println("▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀");
               System.out.println("\t\t마을로 돌아왔습니다");
               continue;
               }//마을 While E
         
         }//마을 if E
         
         
   
   
   
   }//1번 선택시 if E
//   if(answer==1) {}   
   //else if(answer==2) {}
   
   else if(input==2) {
	   
	   
	   
   }
   else if(input==3) {}
      else {
         System.out.println("리스트에서 골라주세요");
      
      }
      
///////////////////////////////////////////////////////////////////////////////////////////////////////   
   

   
   
   
      }//while E
   }//main E
}//class E