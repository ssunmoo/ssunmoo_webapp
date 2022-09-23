package java1.ch11API클래스;

import java.io.UnsupportedEncodingException;

public class EX2_String메소드 {
	public static void main(String[] args) {
		
		
		// 1. 문자열.CharAt(인덱스) : 해당 인덱스의 문자 추출
		String ssn = "010624-3230123";	// 문자열
		char sex = ssn.charAt(7);		// 7번 인덱스의 문자 추출
		System.out.println( sex );
		switch( sex ) {
			case '1' :
			case '3' :
				System.out.println("남자입니다");
				break;
			case '2' :
			case '4' :
				System.out.println("여자입니다");
				break;
		}
		
		// 2. 문자열1.equals(문자열2) : 두 문자열 비교
		String strVar1 = new String("신문철");		
		String strVar2 = "신문철";	// String 객체인데 왜 new 를 안쓰는가? --->  " " : String 를 뜻하기 때문
		
		if( strVar1 == strVar2 ) {
			System.out.println("[ 스택 값이 같다 ] 같은 String 객체를 참조");
		} else {
			System.out.println("[ 스택 값이 다르다 ] 다른 String 객체를 참조");
		}
		
		if( strVar1.equals(strVar2)) {
			System.out.println("[ 힙 값이 같다 ] 같은 문자열을 가짐");
		}
		else {
			System.out.println("[ 힙 값이 다르다 ] 다른 문자열을 가짐");
		}
		
		
		// 3. getBytes( 인코딩타입 ) : 바이트열 변환
		String str = "안녕하세요";
		byte[] bytes1 = str.getBytes();	// 인코딩 타입 생략 시 : 1. java[JVM]버전  2. 프로젝트 설정(이클립스 등)
		System.out.println("문자열 -> 바이트열 변환, 길이 : " + bytes1.length );
		
		String str1 = new String( bytes1 );
		System.out.println("바이트열 -> 문자열 변환, 길이 : " + str1 );
		
		try {
			// EUC-KR : 한글/영문 지원 : 영문 1바이트, 한글 2바이트
			byte[] bytes2 = str.getBytes("EUC-KR");
			System.out.println("문자열 -> 바이트열(EUC-KR)변환 : " + bytes2.length );
			
			String str2 = new String(bytes2, "EUC-KR");
			System.out.println("바이트열 -> 문자열 변환 : " + str2 );
			System.out.println();
			
			// UTF-8 : 전 세계 언어 지원 : 영문 1바이트, 한글 3바이트
			byte[] bytes3 = str.getBytes("UTF-8");
			System.out.println("문자열 -> 바이트열(UTF-8) : " + bytes3.length );
			
			
			String str3 = new String(bytes3, "UTF-8");
			System.out.println("바이트멸 -> 문자열 : " + str3);
			System.out.println();
			
		} 
		catch (Exception e) {
			
		}		
		
		
		// 4. indexOf( "문자" ) : 해당 문자의 인덱스 번호 찾기
		String subject = "자바 프로그래밍";
		System.out.println( subject.indexOf("프로그래밍"));
		
		int location = subject.indexOf("프로그래밍");
		
		if( location != -1 ) {
			System.out.println("찾았다");
		}
		else {
			System.out.println("못찾았다");
		}
		

		
		// 5. length() : 문자열 길이 확인
		String ssn2 ="7306241230123";
		int length = ssn2.length();
		
		if( length == 13 ) {
			System.out.println("주민번호 자리수가 맞습니다");
		}
		else {
			System.out.println("주민번호 자리수가 틀립니다");
		}
		
		
		// 6. replace( "기존문자" , "변경할문자" ) : 치환
		String oldStr = "자바는 객체 지향 언어입니다. 자바는 풍부한 API를 지원합니다.";
		String newStr = oldStr.replace("자바", "java");
		
		System.out.println( oldStr );
		System.out.println( newStr );
		
		
		// 7. toLowerCase() : 소문자 변환 , toUpperCase() : 대문자변환
		String str2 = "Java Programming";
		System.out.println( "소문자 변환 : " + str2.toLowerCase() );		
		System.out.println( "대문자 변환 : " + str2.toUpperCase() );	
		
		
		// 8. trim() : 앞뒤 공백 제거 중간은 안됨
		String tel1 = "         02";
		String tel2 = "123        ";
		String tel3 = "    1234   ";
		System.out.println( tel1.trim() );
		System.out.println( tel2.trim() );
		System.out.println( tel3.trim() );
		
		
		// 9. valueOf() : 다른자료형 --> 문자열(String) 변환
		System.out.println(10+"");	// 숫자+스트링은 문자 : 문자열 10 출력
		System.out.println(String.valueOf(10));		// 정수형 10 -> 문자열 10 변환
		System.out.println(String.valueOf(10.5));	// 실수형 10 -> 문자열 10.5 변환
		System.out.println(String.valueOf(true)); 	// 논리형 true -> 문자열 true 변환
		
		
		// 10. substring( 시작인덱스 , 끝인덱스 ) : 문자열 자르기
		String ssn3 = "880815-1234567";
		String firstNum = ssn3.substring( 0 , 6 );	// 0번째 인덱스부터 6번째 인덱스전까지만 출력
			// 시작인덱스 0번 : 8  끝인덱스 6번 : -
		
		System.out.println(firstNum);
		
		String secondNum = ssn3.substring(7);
			// 시작인덱스 7번 : 1  끝인덱스 없음 -> 시작부터 끝까지 출력 
		System.out.println( secondNum );
		
		
		// 11. split( "자를기준문자" ) : 기준문자 기준으로 분해 → 문해진 문자열은 String 배열에 각 인덱스 저장
		String[] result = ssn3.split("-");
			// - 하이픈 기준으로 잘랐기 때문에 String 2개가 생성되고 배열에 담아줌
			// 자른 기준점 - 하이픈은 사라짐
		
		System.out.println( result[0] );
		System.out.println( result[1] );
			
		"ASD".contains("A");
		
		
		
		
		
		
		
		
		
	} 
}
