package java1.ch5클래스.EX4;

public class EX4실행 {
	public static void main(String[] args) {
		
		// 1. 객체 선언 [ 오류 발생 : 생성자에 매개변수 생략했기 때문에 ]
		Car mycar = new Car();
			// 기본 생성자가 없기 때문에 오류 발생
			// 문제해결 : 클래스 내부에 빈생성자 생성
		
		// 직접적으로 .으로 값을 넣어줌
		mycar.color = "검정";
		mycar.cc = 3000;
		
		
		
		// 2. 객체 선언
		// 생성자를 통해서 간접적으로 값을 넣어줌
		Car mycar2 = new Car("검정", 3000);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
