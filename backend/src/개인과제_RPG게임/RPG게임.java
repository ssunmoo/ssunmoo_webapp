package 개인과제_RPG게임;

import java.util.Scanner;

public class RPG게임 {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      while(true) {
         
      System.out.println("\t=========RPG=========");
      System.out.println("\tRPG게임에 오신것을 환영합니다");
      System.out.println("     1. 캐릭터 생성 2. 로그인 3. 회원가입 "); int input = scanner.nextInt();
      System.out.println("=====================");
      
////////////////////////////////////////////////////////////////////////////////////////////////////
   if(input==1) {
      System.out.println("▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀");
      System.out.println("       캐릭터생성");
      System.out.println("성별을 직접 입력하세요[남자/여자]");String x=scanner.next();
      System.out.println("캐릭터 아이디 입력해주세요!!");String name=scanner.next();
      System.out.println("선택하신 캐릭터의 성별은"+x+"\n이름은"+name+"로 생성하시겠습니까?\n"+"1.Y 2.N");int answer=scanner.nextInt();
      System.out.println("▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀");
         if(answer==1&&x.equals("남자")) {
            
            System.out.print("　∧ ,, ∧\r\n"
                  + " （´･ω･）　ヽヽ\r\n"
                  + "　/つ　〇━⊂二二フ\r\n"
                  + "                   ⊂(  ‘ д’)つ\n");
            System.out.println("환영합니다!!");
            System.out.println("당신의 캐릭터의 성별은"+x+"\n이름은"+name+"입니다");
         }//남자 캐릭터 if E
         else if(answer==1&&x.equals("여자")){
            System.out.print("　∧ ,, ∧\r\n"
                  + " （´･ω･）　ヽヽ\r\n"
                  + "　/つ　〇━⊂二二フ\r\n"
                  + "                   ⊂(  ‘ д’)つ\n");
            System.out.println("====환영합니다!!");
            System.out.println("당신의 캐릭터의 성별은"+x+"\n이름은"+name+"입니다");
         }//여자 캐릭터 if E
         if(x.equals("남자")||x.equals("여자")&&answer==1) {
               System.out.println("마을에 오신걸 환영합니다");
               
               while(true) {
               
            	   
            	   
            	   
            	   
            	   
            	   
            	   // ------------ 던전 입장 시 시작 ----------- //
            	   
            	   System.out.println("[ 던전에 입장하시겠습니까? ] ");
            	   
            	   
            	   
            	   
            	   
            	   
            	   // ------------ 던전 입장 시 종료 ----------- //           	   
            	   
            	   
            	   
            	   
            	   
            	   
            	   
            	   
               }//마을 While E
         
         }//마을 if E
         else  {continue;}
   
   
   
   }//1번 선택시 if E
//   if(answer==1) {}   
   //else if(answer==2) {}
   
   else if(input==2) {}
   else if(input==3) {}
      else {
         System.out.println("리스트에서 골라주세요");
      
      }
      
///////////////////////////////////////////////////////////////////////////////////////////////////////   
   

   
   
   
      }//while E
   }//main E
}//class E