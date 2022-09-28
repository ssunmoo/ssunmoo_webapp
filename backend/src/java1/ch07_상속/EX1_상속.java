package java1.ch07_상속;

public class EX1_상속 {

	public static void main(String[] args) {

		// 1. 객체 생성 : 클래스명 객체명 = new 생성자
		DmbCellPhone dmbCellPhone = new DmbCellPhone("자바폰", "검정", 10);
		
		// 2. 자식 객체[클래스]가 상속 받은 필드 호출하기
		System.out.println("모델 : " + dmbCellPhone.model );
		System.out.println("색상 : " + dmbCellPhone.color );
		
		// 3. 자식 클래스 필드 호출
		System.out.println("채널 : " + dmbCellPhone.channel );
		
		// 4. 자식 객체[클래스]가 상속받은 메소드 호출
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("여보세요");
		dmbCellPhone.receibeVoice("안녕하세요~ 저는 홍길동입니다.");
		dmbCellPhone.sendVoice("ㄴㅔ! 반갑습니다!");
		dmbCellPhone.hangUp();
		
		// 5. 자식 클래스 호출
		dmbCellPhone.turnOnDmb();
		
		
		
		
		
	}
}
