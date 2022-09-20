package java1.ch5클래스.EX18_접근제한자.getset메소드;

public class Car {

	// 1. 필드 [ 필드 정보를 보호하기 위해 private 로 생성 권장 ]
	private int speed;		// private : 다른 클래스에서 접근 불가
	private boolean stop;	// private : 다른 클래스에서 접근 불가
	
	
	// 2. 생성자

	
	
	// 객체명.speed = 11;   --> 직접 접근이므로 지양  
	// 객체명.setSpeed( 500 ); --> 권장
	
	// 3. 메소드 [ 필드에 직접 접근이 불가능하므로 피륻에 간접 접근을 위한 메소드 선언 ] 
	public int getSpeed() {
		return speed;
	}
		
	// 안정성을 위해 필터를 거친 뒤 값을 도출해줌.......
	public void setSpeed( int speed ) {
		if( speed < 0 ) {
			this.speed = 0;
			return;
		}
		else {
			this.speed = speed;
		}
	} // 메소드 종료
	
		
	public boolean isStop() {	// is = 확인하는용으로 앞에 넣어주는 변수명
		return stop;

	} // 메소드 종료
	
	public void setStop( boolean stop ) {
		this.stop = stop;
		this.speed = 0;

	} // 메소드 종료
	
	
}
