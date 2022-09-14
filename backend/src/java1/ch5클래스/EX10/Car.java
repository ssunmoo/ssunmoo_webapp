package java1.ch5클래스.EX10;

public class Car {

	// 1. 필드
	int gas; 	// 가스 수량을 저장하는 int형 필드[변수]
	
	// 2. 생성자
	
	
	// 3. 메소드
	
	// 1. 반환값x 매개변수 1
	void setGas( int gas ) {
		this.gas = gas;
		return;
	}
	
	// 2. 반환값o 매개변수x
	boolean isLeftGas() {
		if( gas == 0 ) {
			System.out.println("가스가 없습니다.");
			return false;	// 가스가 없다는 의미 --> 함수종료
		} // if 종료
		else {
			System.out.println("가스가 있습니다. " + gas );
			return true;	// 가스가 있다는 의미 --> 함수 종료
		} // else 종료
	} // 메소드 종료 
	
	
	// 3. 반환값x 매개변수x
	void run() {
		while( true ) {
			if( gas > 0 ) {
				System.out.println("달립니다 [gas의 잔량 " + gas + " ]" );
				gas -= 1;	// 가스 1 감소
			} // if 종료
			else {
				System.out.println("멈춥니다 [gas의 잔량 " + gas + " ]");
				return;	// 함수종료 무한루프 종료
			} // else 종료
		} // while 종료
	} // 메소드 종료
	
	
	
	
	
	
	
	
	
	
	
	
}
