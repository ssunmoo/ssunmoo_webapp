package java1.ch08_인터페이스;

public class HankookTire implements Tire {

	@Override
	public void roll() {
		System.out.println("한국 타이어가 굴러 갑니다");
	}
}
