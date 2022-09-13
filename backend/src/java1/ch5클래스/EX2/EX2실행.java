package java1.ch5클래스.EX2;

public class EX2실행 {
	public static void main(String[] args) {
		
		// 1. 객체 선언 [ Car 클래스 ]
		Car myCar = new Car();
			// 1. Car	: 클래스명
			// 2. myCar	: 객체명 [임의]
			// 3. new	: 객체 선언 시 가용되는 키워드
			// 4. Car()	: 객체 선언시 초기값 [ 생성자 ]
		
		// 2. 필드 호출 [ 객체명.필드명 ]
			// .(도트) 연산자를 이용한 멤버 호출
		
		System.out.println( "제작회사 : " + myCar.company );
		System.out.println( "모델명 : " + myCar.model );
		System.out.println( "색상 : " + myCar.color );
		System.out.println( "최고속도 " + myCar.maxSpeed );
		System.out.println( "현재속도 " + myCar.speed );
		
		
		// 3. 필드 값 수정 [ 객체명.필드명 = 새로운 값 ]
		
		myCar.speed = 60;
		System.out.println( "수정된 현재속도 : " + myCar.speed );
		
		
	}
}
