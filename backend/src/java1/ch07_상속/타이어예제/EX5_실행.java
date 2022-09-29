package java1.ch07_상속.타이어예제;

import java.util.Iterator;

public class EX5_실행 {

	public static void main(String[] args) {

		// 1. 자동차 객체 생성
		// Car 안에 포함된 타이어 객체 4개 함께 생성
		Car car = new Car();
		
		
//		// 2. 자동차 5번 회전
//		for( int i = 1; i <= 5; i++ ) {
//			int result = car.run();
//		// 3. 만약에 펑크이면 타이어 교체
//			if ( result == 1 ) {	// 앞 왼쪽
//				car.frontLeftTire = new HankookTire(15, "앞왼쪽");
//			}
//			if ( result == 2) {		// 앞 오른쪽
//				car.frontRightTire = new HankookTire(13, "앞오른쪽");
//			}
//			if ( result == 3 ) {	// 뒤 왼쪽
//				car.backLeftTire = new KumhoTire(14, "뒤왼쪽");
//			}
//			if ( result == 4) {		// 뒤 오른쪽
//				car.backRightTire = new KumhoTire(17, "뒤오른쪽");
//			}
//		} // for 종료
		
		
		// [ 배열로 변경하기 ]
		for( int i = 1; i <= 3; i++ ) {
			
			boolean[] result = car.run();
			if ( !result[0] ) {	// 앞 왼쪽
				car.frontLeftTire = new HankookTire(15, "앞왼쪽");
			}
			if ( !result[1]) {		// 앞 오른쪽
				car.frontRightTire = new HankookTire(13, "앞오른쪽");
			}
			if ( !result[2] ) {	// 뒤 왼쪽
				car.backLeftTire = new KumhoTire(14, "뒤왼쪽");
			}
			if ( !result[3]) {		// 뒤 오른쪽
				car.backRightTire = new KumhoTire(17, "뒤오른쪽");
			}
		} // for 종료
		
		
	} // main 종료
}
