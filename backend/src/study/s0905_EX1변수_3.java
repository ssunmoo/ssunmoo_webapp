package study;

public class s0905_EX1변수_3 {
	/*
	1. 변수 선언 
	1-1. 변수에 값을 넣기
	1-3. 출력


	2. 새로운 변수 선언하고 기존 변수값에 새로운 값을 더해서 대입
	2-1. 출력


	3. 시간, 분 변수 선언
	3-1. 출력 
	3-2. 새로운 변수 선언해서 더하기 연산자 사용
	3-3. 출력

	4. 변수 2개 생성
	4-1. 출력
	4-2. 저장할 새로운 변수 선언해서 값 돌리기
	4-3. 출력
	*/
	
	
	
	public static void main(String[] args) {
		
		
		int a;
		a = 10;
		System.out.println(a);
		
		int b = a + 10;
		System.out.println(b);
		
		int hour = 3;
		int minute = 5;
		System.out.println(hour + "시간 : " + minute + " 분");
		
		int totalMinute = (hour * 60) + minute;
		System.out.println(totalMinute + "분");
		
		int x = 3;
		int y = 5;
		System.out.println("x : " + x + ", y : " + y );
		
		int temp = 0;
		temp = x;
		x = y;
		y = temp;
		
		
		System.out.println("x : " + x + ", y : " + y);
		
	}
		
	
}
