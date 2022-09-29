package java1.ch07_상속.타이어예제;

public class Car {

	// 1. 필드 [ 변수, 객체, 상수, 배열, 리스트 = 메모리가 들어가는 것 ] 
	Tire frontLeftTire = new Tire(6, "앞왼쪽");
	Tire frontRightTire = new Tire(2, "앞오른쪽");
	Tire backLeftTire = new Tire(3, "뒤왼쪽");
	Tire backRightTire = new Tire(4, "뒤오른쪽");
	
	// 2. 생성자
	
//	// 3. 메소드
//	int run() {
//		System.out.println("[ 자동차가 달립니다 ]");
//		if( frontLeftTire.roll() == false ) {
//			// 펑크가 났을 경우
//			stop();
//		}
//		if( frontRightTire.roll() == false ) {
//			// 펑크가 났을 경우
//			stop();
//		}
//		if( backLeftTire.roll() == false ) {
//			// 펑크가 났을 경우
//			stop();
//		}
//		if( backRightTire.roll() == false ) {
//			// 펑크가 났을 경우
//			stop();
//		}
//		
//		return 0;
//	}
	
	
	// [ 배열로 변경하기 ]
	// 3. 메소드
	boolean[] run() {
		System.out.println("[ 자동차가 달립니다 ]");
		boolean[] tirestate = new boolean[4];
		tirestate[0] = frontLeftTire.roll();
		tirestate[1] = frontRightTire.roll();
		tirestate[2] = backLeftTire.roll();
		tirestate[3] = backRightTire.roll();
		for( boolean b : tirestate ) {
			if ( b == false ) {
				stop();
				break;
			}
		}
		return tirestate;
	}	
	
	
	
	
	void stop() {
		System.out.println("[ 자동차가 멈춥니다 ]");
	}
	
}
