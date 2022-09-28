package java1.ch12_스레드;

public class 스레드A extends Thread {

	// 생성자
	public 스레드A() {
		setName("스레드A");
		// setName 메소드는 부모 클래스인 Thread로 부터 물려받음
	}
	
	// 메소드
	@Override
	// 부모 클래스인 Thread 클래스의 메소드를 재정의
	// @Override : 재정의
	
	public void run() {
		for( int i = 0; i < 2; i++ ) {
			System.out.println(getName() + " 가 출력한 내용");
		}
		
		
	}
	
}
