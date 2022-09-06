package study.s2;


import java.util.Random;
import java.util.Scanner;

public class 틱택토 {

public static void main(String[] args) {


/*
       택택토 게임
          [ 조건 ] 
           1. 게임판 6칸 사용 -> 배열[0~8]
              1. String 배열      클래스는 비교연산자 불가능
                 == : 문자열1.equals(문자열2)
                 != : 문자열1.equals(문자열2)
                 
           2. 사용자(o)가 알을 두고자 하는 위치를 [인덱스]로 입력
              1. 선택된 위치에 이미 다른 알이 존재하면 재입력[중복제거]
              
           3. 컴퓨터(x)가 난수 배열을 생성[0~8]
              1. 난수의 위치에 이미 다른 알이 존재하면 재생성
              
           4. 승리자 판단 [ 1. 가로 2. 세로 3. 대각선 4. 무승부 ]
           

           [ 출력 ]
           1. 게임판 출력 예시
           [ ] [ ] [ ]    0 1 2
           [ ] [ ] [ ]    3 4 5
           [ ] [ ] [ ]    6 7 8
           
 */
      
      
      
      
      String[] 게임판 = { "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"};
      // String형 배열 9개 생성 및 초기값 설정
      Scanner scan = new Scanner(System.in);
      Random ran = new Random();

      int count = 0;
      // conut는 사람이 o를 찍을때 컴퓨터 x를 찍기 때문에
      // x를 찍는 순간 count값을 증가시켜서 count의 값이 4가 되는 순간 무승부 출력 후 종료
      
      int userWin = 0;
      // 유저의 승리를 알기 위한 변수 1의 값이 되는 순간 break를 사용하여 유저의 승리
      
      int computerWin = 0;
      //  컴퓨터의 승리를 알기 위한 변수 1의 값이 되는 순간 break를 사용하여 유저 승리
          
      System.out.println("★ 게임시작 ★");
      
      while (true) {   // 와일1 시작
         // 무한루프 [ 종료조건 : 승리판단이 있을 경우 ]
         // 1. 게임판 출력 --> 배열내 모든 데이터 출력
         for( int i = 0; i < 게임판.length; i++ ) {
            System.out.print( 게임판[i] );
            if( i % 3 == 2 ) {
               System.out.println();
            } // if 2 끝
         } // for 1 끝
         
         
         if (count == 4 ) {
           // O와 X가 각각 4번씩 찍혀 있을 경우 count의 값이 4가 되면
            if( userWin == 1 ) {
               System.err.println("★★승리★★");
            }
            else if ( computerWin == 1 ) {
               System.err.println("★★패배★★");
            }
            else {
               System.err.println("무승부 입니다.");
            }
            break;
         }
         else {
            
            if( userWin == 1 ) {
               System.err.println("★★승리★★");
               break;
            }
 
            else if ( computerWin == 1 ) {
               System.err.println("★★패배★★");
               break;
            }
         } // else 끝
         
         
      

         // 2. 사용자 위치 선택
         while (true) {   // 와일2 시작
            // 무한루프 [ 종료조건 : 알을 두었을때 종료 break ]
            
            System.out.println("위치를 선택하세요 >> ");
            int 위치 = scan.nextInt();
            
            if( 위치 < 0 || 위치 > 8 ) {
               System.err.println("안내) 선택할 수 없는 번호입니다. ");
            }
            if( 게임판[위치].equals("[ ]") ) {
            // 해당 위치에 알이 없으면 해당위치에 알두기
               게임판[위치] = "[O]";
               break;
            }
            else {
               System.err.println("안내) 이미 알이 존재하는 위치입니다.");
            }
         
         } // 와일2 끝

         // 3. 컴퓨터 위치 선택 [ 난수 생성 ]
         while (true) {
            int 위치 = ran.nextInt(9);      	// 0 ~ 8 난수 생성
            if( 위치 < 0 || 위치 > 8 ) {      
            }
            if( 게임판[위치].equals("[ ]") ) {	// 게임판 위치가 공백일경우 
               게임판[위치] = "[X]";         	// 게임판 위치에 X로 표시
               
               count++;      // count값을 증가시켜서 종료할 구간을 설정 합니다.
               break;        // 알을 두면 무한루프 종료
            }
         } // 와일3 끝
         
         
         
         
         // 4. 승리판단   --> 가로 0 1 2, 3 4 5, 6 7 8
        for (int i = 0; i < 3; i++) {
        	if( i % 3 == 0) {      // i의 값을 3으로 나누었을때 나머지가 없는 경우 ==> 0,3,6
	            if(게임판[i].equals("[O]") && 게임판[i].equals(게임판[i+1]) && 게임판[i].equals(게임판[i+2])) {
	            				// 게임판 i가 O이면서 i와 i+1과 i+2가 모두 동일할때
	            	userWin++;	// 유저 변수에 카운트 1더하기
	            } // if 종료
	            
	            else if(게임판[i].equals("[X]") && 게임판[i].equals(게임판[i+1]) && 게임판[i].equals(게임판[i+2])) {
	            	// 게임판i O이면서 i와 i+1과 i+2가 모두 동일할때
	            	computerWin++;	// 컴퓨터 변수에 카운트 1더하기
	            } // else if 종료
        	} // if 종료
        } // for 종료
        	
         	
         // 4. 승리판단 --> 세로   0 3 6, 1 4 7, 2 5 8
        for (int i = 0; i < 3; i++) {
        	
        	if(게임판[i].equals("[O]") && 게임판[i].equals(게임판[i+3]) && 게임판[i+3].equals(게임판[i+6])) {
        					// 게임판 i가 O이면서 i와 i+3과 i+6이 모두 동일할때
        		userWin++;	// 유저 변수에 카운트 1더하기
        		
        	} // if 종료
        	
			else if(게임판[i].equals("[X]") && 게임판[i].equals(게임판[i+3]) && 게임판[i+3].equals(게임판[i+6])) {
								// 게임판 i가 X이면서 i와 i+3과 i+6이 모두 동일할때
				computerWin++;	// 컴퓨터 변수에 카운트 1더하기
			} // else if 종료
        } // for 종료

         
        // 4. 승리판단 --> 대각선 0 4 8 , 2 4 6
        
        // 대각선 승리 판단의 경우 대각선의 종류가 하나씩밖에 없기 때문에 for말고 if하기
        
        //대각선 1 검증 시작 ( 0, 4 ,8 )
        if( 게임판[0].equals("[O]") && 게임판[0].equals(게임판[4]) && 게임판[4].equals(게임판[8])) {
           userWin++;
        }   //게임판 0,4,8의 값이 O일 경우 유저의 승리
        
        else if( 게임판[0].equals("[X]") && 게임판[0].equals(게임판[4]) && 게임판[4].equals(게임판[8])) {
           computerWin++;
        }   //게임판 0,4,8의 값이 X일 경우 컴퓨터의 승리
        
         
        
        //대각선 2 검증 시작 ( 2, 4, 6 )
        if(게임판[2].equals("[O]") && 게임판[2].equals(게임판[4]) && 게임판[4].equals(게임판[6])) {
           userWin++;
        }   //게임판 2, 4, 6의 값이 O일 경우 유저의 승리
        else if(게임판[2].equals("[X]") && 게임판[2].equals(게임판[4]) && 게임판[4].equals(게임판[6])) {
           userWin++;
        }   //게임판 2, 4, 6의 값이 X일 경우 컴퓨터의 승리
        

      } // 와일1 끝
   }   // 메인 끝
}   // 클래스 끝