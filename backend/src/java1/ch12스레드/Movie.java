package java1.ch12스레드;

public class Movie implements Runnable {
	
	private boolean stop = true;
	
	public void setStop( boolean stop ) {
		this.stop = stop;
	} // ----- 접근 허용때문에 이렇게 선언 ------
	
		
	@Override
	public void run() {
		while ( stop ) {
			System.out.println("영화 재생중~");
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				
			}
		}
		
	} // run 메소드 종료
	
	

}
