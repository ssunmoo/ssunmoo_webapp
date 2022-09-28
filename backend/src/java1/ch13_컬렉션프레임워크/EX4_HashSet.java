package java1.ch13_컬렉션프레임워크;

import java.util.HashSet;
import java.util.Iterator;

public class EX4_HashSet {
	public static void main(String[] args) {
		
		
		// 1. 선언
		HashSet< String > set = new HashSet<>();
		
		// 2. 추가
		set.add("java");
		System.out.println("set 현황 : " + set.toString());
		
		set.add("jdbc");
		System.out.println("set 현황 : " + set.toString());
		
		set.add("servlet/jsp");
		System.out.println("set 현황 : " + set.toString());
		
		set.add("java");	// 중복발생 [ set 해시코드 사용 : 데이터 -> 주소값으로 변환시켜서 저장 ]
		System.out.println("set 현황 : " + set.toString());
		
		set.add("ibatis");
		System.out.println("set 현황 : " + set.toString());
		
		
		
		
		// * 해시코드 함수 확인
		System.out.printf("java 문자열의 해시코드 변환 : %x \n" , "java".hashCode() ); // %x 16진수
		System.out.printf("java 문자열의 해시코드 변환 : %x \n" , "java1".hashCode() ); // %x 16진수
		
		
		
		System.out.println("set내 객체수 ; " + set.size());	
				
		
		// .iterator() : 순회 [ 순서없는 자료들을 하나씩 순회하는 Iterator 인터페이스 ]
		// Iterator 인터페이스를 제공받은 클래스(배열, 컬렉션프레임워크)만 사용가능 
		
		Iterator< String > iterator = set.iterator();
		while( iterator.hasNext() ){					// .hasNext() : 다음 객체가 존재하면 true / false
			String element = iterator.next();			// .next() : 다음 객체로 이동[호출]
			System.out.println("\t" + element );
		}
		
			
		for ( String s : set ) {						// Iterator 인터페이스를 제공받은 클래스를 넣어줌으로써 반복가능 .next() 가 사용된 것과 같음
			System.out.println("\t" + s);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
