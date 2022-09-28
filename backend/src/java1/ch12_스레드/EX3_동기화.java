package java1.ch12_스레드;

public class EX3_동기화 {

	public static void main(String[] args) {
		
		계산기 my계산기 = new 계산기(); 	// 계산기 클래스로 객체 생성
		
		사람1 user1 = new 사람1();		// 스레드 객체 생성
		user1.set계산기(my계산기);
		user1.start();
		
		사람2 user2 = new 사람2();
		user2.set계산기(my계산기);
		user2.start();
		
		// * 사람1과 사람2는 동일한 계산기 [ 객체 ] = 공유객체를 사용한다.
		

	} // 메인 종료
}

