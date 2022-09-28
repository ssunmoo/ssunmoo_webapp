package java1.ch13_컬렉션프레임워크;

import java.util.ArrayList;

public class EX1_arraylist {

	
/*
		문자열 10개 저장
		1. String[10] 배열(객체명) = new String[10];
			- 선언된 길이는 수정 불가
		 	- 추가, 삭제, 삽입 : 직접 인덱스 사용
			 
		2. ArrayList< String > 배열(객체명) = ArrayList<>();
			- 길이 자동 설정 [ 기본값 10부터 시작 ]
			- 추가, 삭제, 삽입 : 함수 사용(미리 만들어진 기능이 있음)
			- 편리하지만 무거움(속도가 느리다)
			
			
*/	
	
	public static void main(String[] args) {
		
		
		// 1. 객체 [ 클래스명 변수명 = new 생성자();
		// 컬렉션 프레임 워크 객체[ 클래스명< 타입 파라미터 > 변수명 = new 클래스명<>();  ]
			// < > : 클래스안에 클래스를 파라미터로 넣는 방식
		
		
		// 정수 int 여러개를 저장할 수 있는 리스트 선언
		ArrayList< Integer > intlist = new ArrayList<>();
		
		// 실수 double 여러개를 저장할 수 있는 리스트 선언
		ArrayList< Double > doublelist = new ArrayList<>();
		
		// 내가 만든 자료형을 여러개 저장할 수 있는 리스트 선언
		ArrayList< Member > memberlist = new ArrayList<>();
				
		
		
		
		// String 여러개를 저장할 수 있는 리스트 선언
		ArrayList< String > list = new ArrayList<>();	
		
		
		// 1. add()
		list.add("java"); // "java" : String 타입
		System.out.println("리스트 현황 : " + list.toString());
		list.add("jdbc");
		System.out.println("리스트 현황 : " + list.toString());
		list.add("servlet.jsp");
		System.out.println("리스트 현황 : " + list.toString());
		list.add(2 , "database");
		System.out.println("리스트 현황 : " + list.toString());
		list.add("ibatis");
		System.out.println("리스트 현황 : " + list.toString());
		
		// 2. size()
		System.out.println("리스트 내 객체 수 : " + list.size());
		
		// 3. get()
		System.out.println("특정 인덱스 호출 : " + list.get(0));
		System.out.println("특정 인덱스 호출 : " + list.get(3));
		
		// 4. remove()
		System.out.println("특정 인덱스 삭제 : " + list.remove(0));
		System.out.println("리스트 현황 : " + list.toString());
		
		// 5. 리스트/배열 <----> 반복문
			// 1. 기본 for문 
		for( int i = 0; i < list.size(); i++ ) {
			System.out.println( list.get(i) );
		}
		
			// 2. 향상된 for문 
		for( String s : list ) {	// for( 타입 파라미터 객체명 : 리스트명 )
			System.out.println( s );
		}
		
//		// 6. 리스트 삭제
//		list.clear();
//		System.out.println("리스트 현황 : " + list.toString());

		
		// 7. contains() : 해당 객체가 존재하면 true
		System.out.println(list.contains("jdbc"));
		
		// 8. indexOf() : 해당 객체의 인덱스 위치 반환
		System.out.println(list.indexOf("jdbc"));
				
		// 9. isEmpty() : 리스트에 객체가 하나도 없으면 true 있으면 false
		System.out.println(list.isEmpty());
		
		// 10. iterator() : 리스트내 객체 순회  
		System.out.println(list.iterator());
		
		
		
		// 함수의 관례적인 이름 : 저장 get~, 가져오기 set~, is~ 
		
			
		
		
	} // 메인 종료
}






