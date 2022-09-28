package java1.ch07_상속;

public class EX3_상속 {
	public static void main(String[] args) {
		
		
		int r = 10;

		// 부모 클래스가 객체 직접 선언
		Calculator calculator = new Calculator();
		System.out.println("원면적 : " + calculator.areaCircle(r));
		
		System.out.println();
		
		Computer computer = new Computer();
		System.out.println("원면적 : " + computer.areaCircle(r));
		
		
		
		
		
	}
}
