package java1.ch07_상속.타이어예제;

public class Tire {

	// 1. 필드
	public int maxRotation; 		// 최대 회전수 ( 타이어 수명 )
	public int accumulatedRotation;	// 누적 회전수
	public String location;			// 타이어의 위치
	
	
	// 2. 생성자
	public Tire(int maxRotation, String location) {
		this.maxRotation = maxRotation;
		this.location = location;
	}
	
	
	// 3. 메소드
	public boolean roll() {
		++accumulatedRotation;		// 누적 회전수 1씩 증가
		if( accumulatedRotation < maxRotation ) {
		// 최대 회전수보다 누적 회전수가 더 작으면 [ 수명 남음 ]
			System.out.println(location + " Tire수명 : " + (maxRotation-accumulatedRotation) + " 회");
			return true; // 수명이 남아있을 경우 true
		} // if 종료
		else {
			System.out.println("*** " + location + " Tire 펑크 ***");
			return false; // 수명이 남아있지 않을 경우 false [ 펑크일 경우 ]
		} // else 종료
	} // roll 메소드 종료
	
	
	
}
