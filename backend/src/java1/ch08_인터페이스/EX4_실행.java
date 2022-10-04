package java1.ch08_인터페이스;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class EX4_실행 {

	public static void main(String[] args) {

		// 1. 인터페이스 변수에 구현 객체 대입
		Vehicle vehicle = new Bus();
		
		vehicle.run();
		
		// 2. 인터페이스에 없는 메소드이므로 사용불가
		// vehicle.checkFare();
		
		// 관계 확인하기 : 객체/변수명 instanceof 클래스명 = 뒤 클래스가 앞에 객체/변수명과 관계가 있는지 확인
		System.out.println("관계확인 : " + (vehicle instanceof Bus)); // 관계 있으면 true
		System.out.println("관계확인 : " + (vehicle instanceof Television)); // 관계없으면 false
		
		// 3. 강제 형 변환 [ 인터페이스 -> 객체 ]
		Bus bus = (Bus)vehicle;
		
		bus.run();
		bus.checkFare();
		
		
		
		// *** 컬렉션 프레임 워크
		List< String > list;
		// List는 인터페이스임
		
		// 1. 인터페이스 변수에 ArrayList 선언
		list = new ArrayList<>();
		
		// 2. 인터페이스 변수에 Vector 로 변경 
		list = new Vector<>();
		
		// 2. 인터페이스 변수에 LinkedList 로 변경 
		list = new LinkedList<>();
		
		list.add( "ㅎㅅㅎ" );
		System.out.println( list );
		System.out.println(list.toString());
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
