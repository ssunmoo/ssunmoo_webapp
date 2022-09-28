package java1.ch12_스레드;

public class Music extends Thread {

	// on/off 저장하는 변수  //  run 메소드의 무한 루프를 제어하는 변수
	private boolean stop = true;
	
	// on/off 변경하는 메소드
	public void setStop( boolean stop ) {
		this.stop = stop;
	}
	
	
	@Override
	public void run() {	// ** run 꼭 구현해야함

		while ( stop ) {
			System.out.println("음악재생중~");
			try {
			Thread.sleep(1000);
			} catch (Exception e) {
			
			}
		}
	} // run 메소드 종료
}
