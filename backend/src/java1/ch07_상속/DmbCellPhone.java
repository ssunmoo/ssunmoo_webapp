package java1.ch07_상속;

// 자식 클래스
public class DmbCellPhone extends CellPhone {

	// 1. 필드
	int channel;
	
	// 2. 생성자
	public DmbCellPhone( String model, String color, int channel ) {
		this.model = model;	// 부모 클래스의 필드
		this.color = color; // 무보 클래스의 필드
		this.channel = channel; // 본인 클래스의 필드
	}	
	
	// 3. 메소드
	 void turnOnDmb() {
		 System.out.println("채널 : " + channel + "번 DMB 방송 수신을 시작합니다.");
	 }
}
