package java1.ch07_상속.타이어예제;

public class HankookTire extends Tire {

	// 1. 필드
	// 2. 생성자
	public HankookTire(int maxRotation, String location) {
		super(maxRotation, location);
	}

	// 3. 메소드
		// 1. roll 재정희
	
	@Override
	public boolean roll() {

		++accumulatedRotation;		// 누적 회전수 1씩 증가
		if( accumulatedRotation < maxRotation ) {
		// 최대 회전수보다 누적 회전수가 더 작으면 [ 수명 남음 ]
			System.out.println(location + " HankookTire 수명 : " + (maxRotation-accumulatedRotation) + " 회");
			return true; // 수명이 남아있을 경우 true
		} // if 종료
		else {
			System.out.println("*** " + location + "HankookTire 펑크 ***");
			return false; // 수명이 남아있지 않을 경우 false [ 펑크일 경우 ]
		} // else 종료
	}
	
	
	
	
}
