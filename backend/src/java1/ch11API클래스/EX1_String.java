package java1.ch11API클래스;

import java.io.IOException;
import java.util.Iterator;

public class EX1_String {
	
	
	public static void main(String[] args) {
	
		// 기본 자료형에 문자열 저장 x --> String 사용
		// byte -> 문자		byte[] -> 문자열
		// 키보드 입력 --- 스트림(byte) ---> 컴퓨터
		// byte ---> String 생성자를 사용하여 문자열로 변경 후 사용하는 것
		
		
		
		byte b = 72; // 72 = 숫자
		char c = (char) b;
		System.out.println( c );
		// [ char 기능 : (java)유니코드 변환 ] 72 -> H 로 변환
		
		
		// 1. 숫자를 String에 저장해서 문자로 출력하기
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };
		String str1 = new String( bytes );	// 배열에 있는거 스트링에 담아서 문자열로 불러오기
		System.out.println("\n" + str1 );
		
		
		String str2 = new String( bytes , 6 ,4 ); // 배열에 있는 내용 중 6번째부터 4개 선택
		System.out.println("\n" + str2 );
		
		
		// 2.
		byte[] bytes2 = new byte[100];
		System.out.println("입력 : ");
		
		try {
			int readByteNo = System.in.read( bytes2 );
			// readByteNo : 읽어온 바이트수를 저장하는 변수

//			for( int i = 0; i <= bytes2.length; i++ ) {
//			System.out.println( bytes2[i] );
//			}
			
			String str3 = new String( bytes2 , 0 , readByteNo-2 );	// 엔터도 문자로 취급해서 \r\n 두개 들어가니까 -2 해줘야 함
			System.out.println( str3 );
			System.out.println("--------------------------");
			
		}
		catch (Exception e) {
			
		}
		
		
		
		
/*		
		예외처리 [ Exception ] 
		1. 일반예외 : 컴파일 전 오류 체크 [ 실행 전 자바가 알고있는 오류 발생 -> 미리 예외처리 ]
				- 외부와 연결 [ 키보드, DB, FILE , 소켓 등 ]
				
		2. 실행예외 : 컴파일 후 오류 체크 [ 실행 후 발생하는 예외 ]
		try {
			예외 발생할 것 같은 코드 / 외부연결
		}
		catch ( 예외클래스 변수명 ) {
			오류 대체 코드
		}
*/
		
		
	}
}
