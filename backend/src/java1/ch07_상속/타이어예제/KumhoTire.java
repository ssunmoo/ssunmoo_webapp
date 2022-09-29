package java1.ch07_상속.타이어예제;

public class KumhoTire extends Tire {
	// 슈퍼클래스와 생성자가 다르기 때문에 빨간줄 뜸
	
	public KumhoTire(int maxRotation, String location) {
		super(maxRotation, location);
	}
	
	@Override
	public boolean roll() {

		++accumulatedRotation;		// 누적 회전수 1씩 증가
		if( accumulatedRotation < maxRotation ) {
		// 최대 회전수보다 누적 회전수가 더 작으면 [ 수명 남음 ]
			System.out.println(location + " KumhoTire 수명 : " + (maxRotation-accumulatedRotation) + " 회");
			return true; // 수명이 남아있을 경우 true
		} // if 종료
		else {
			System.out.println("*** " + location + "KumhoTire 펑크 ***");
			return false; // 수명이 남아있지 않을 경우 false [ 펑크일 경우 ]
		} // else 종료
		
	}
	
	
	
	
	
	
		
}
