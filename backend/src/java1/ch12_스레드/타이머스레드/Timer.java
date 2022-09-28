package java1.ch12_스레드.타이머스레드;

public class Timer extends Thread {
	// extends : 상속[연장]
	// 자식 클래스는 부모 클래스의 멤버( 필드, 생성자, 메소드)에 접근할 수 있다.
	
	private boolean stop = true;
	// 타이머의 상태를 조작하는 변수 on/off
	
	private boolean wait = true;
		

	public void setStop( boolean stop ) {
		this.stop = stop;
	}
	public void setWait( boolean wait ) {
		this.wait = wait;
	}
	
	
	@Override	// 부모 클래스에 이미 존재하는 메소드를 재정의 하는 것
	public void run() {
		초단위();
	} // run 메소드 종료
	
	
	private void 초단위() {
		int i = 1;
		while ( stop ) { // 외부에서 stop 변수를 조작해서 함수를 종료 시킴
			
			if ( wait ) {
				System.out.println( i + "초");
				i++;
			} // if 종료
			
			try{ 
				Thread.sleep(1000);
			}
			catch (Exception e) {
			}
			System.out.println("스레드 회전중 ");
			
		} // while 종료
	} // 초단위 메소드 종료
	
	
	
} // 클래스 종료


