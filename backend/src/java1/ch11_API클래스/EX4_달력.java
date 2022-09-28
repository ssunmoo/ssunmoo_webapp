package java1.ch11_API클래스;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class EX4_달력 {

	// 1. 필드
	Scanner scan = new Scanner(System.in);	// 입력객체
	Calendar cal = Calendar.getInstance();	// 달력객체
	
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH)+1;
	int day = cal.get(Calendar.DAY_OF_MONTH);
	
	
	// 2. 생성자
	
	// 3. 메소드
	void run() {
	
		while ( true ) {
			
			// ** 현재 날짜를 이용한 1일의 요일 찾기
			cal.set( year, month-1, 1 );	// 세팅값을 변경할 수 있음, 날짜를 1일로 변경해준 것
			int sweek = cal.get( Calendar.DAY_OF_WEEK ); // 현재 월의 1일의 요일
			
			// ** 현재 날짜의 마지막 일수 찾기
			int eday = cal.getActualMaximum( Calendar.DAY_OF_MONTH );
			// System.out.println("마지막 일자 : " + eday);
			
		
			
			// --- 출력 코드 시작 --- //
			
			System.out.printf( "================   %d년 %d월 달력   ================= \n" , year , month );
			System.out.println(" 일\t 월\t 화\t 수\t 목\t 금\t 토");
	
			
			// 1. 1일의 전까지 공백 반복문
			for( int i = 1; i < sweek; i++ ) {
				System.out.print("\t");
			}
			
			// 2. 1일부터 ~ 마지막 일수까지 일수를 출력하는 반복문
			for( int i = 1; i <= eday; i++ ) {
				System.out.printf( "%2d \t" , i);
				
				// 토요일 이후에 [ sweek 이 7 배수이면 ] 줄바꿈 처리
				if( sweek % 7 == 0 ) {	// 요일이 토요일이면
					System.out.println();
				}
				sweek++;	// 일수를 출력할때마다 요일 증가
			}
			
			일정출력();
			System.out.print( "\n=================================================== \n");
			System.out.println("◀ 이전[1] ▶ 다음달[2]  검색[3]  일정추가[4]");
			int btn = scan.nextInt();
			if( btn == 1 ) {
				month--;			// 이전 버튼을 누르면 월에서 -1씩
				if( month == 0 ) {	// 월이 0이되면 
					month = 12;		// 월이 12로 바뀌고
					year--;			// 년을 -1
				} // if 종료
			} // btn 1 종료
			else if ( btn == 2 ) {
				month++;			// 다음달 버튼을 누르면 월에서 +1씩
				if( month == 13 ) {	// 월이 13이되면
					month = 1;		// 월이 1월로 바뀌고
					year++;			// 년을 +1
				} // if 종료
			} // btn 2 종료
			else if ( btn == 3 ) {
				System.out.println("검색 연도 : ");
				int inyear = scan.nextInt();
				
				System.out.println("검색 월 : ");
				int inmonth = scan.nextInt();
				
				if( ( inyear < 1900 || inyear > 9999 ) || ( inmonth < 1 || inmonth > 12 ) ) {
					System.out.println("지원하지 않는 날짜 입니다");
				}
				else {
					year = inyear;
					month = inmonth;
				}
			} // btn 3 종료
			else if ( btn == 4 ) {
				일정추가();
			} // btn 4 종료
			
			// --- 출력 코드끝 --- //		
		
		} // while 끝
		
		
		
		
		
		
	} // run 메소드 종료
	
	void 일정추가() {	// 날짜 , 메모 등
		System.out.println("날짜 : ");
		String c_date = scan.next();
		System.out.println("메모 : ");
		String c_comment = scan.next();
		
		boolean result = Ex4_달력DAO.getInstance().일정추가( c_date , c_comment );
		if( result ) {
			System.out.println("일정등록 완료");
		}
		else {
			System.out.println("일정등록 실패");
		}
	} // 일정추가 메소드 종료
	
	void 일정출력() {	// 현재 월 일정 출력
		System.out.println("\n==== [  일정확인  ] ==== ");
		System.out.println("번호\t날짜\t\t메모");
		
		String strmonth = "";
		if( month < 10 ) {
			strmonth = "0"+month;
		}
		else {
			strmonth = month+"";
		}
		
		HashMap< Integer , ArrayList< String > > map
			= Ex4_달력DAO.getInstance().일정출력( String.valueOf(year) , strmonth );
		
		for( Integer key : map.keySet() ) {
							// .keySet() 모든 키 호출
			System.out.print(key + "\t");
			for( String s : map.get(key) ) {
				System.out.print( s + "\t" );
			}
			System.out.println();
		
		}
	} // 일정출력 메소드 종료
	
	
	
}
