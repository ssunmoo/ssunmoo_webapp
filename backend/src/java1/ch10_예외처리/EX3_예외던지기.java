package java1.ch10_예외처리;

public class EX3_예외던지기 {
	public static void main(String[] args) {
		
		try {
			findClass();	
		} 
		catch (Exception e) {
			System.out.println("함수에서 온 예외 " + e);
		}
	
	}
		
	public static void findClass() throws ClassNotFoundException {
								// 예외 던지기(리턴) : 해당 메소드를 호출한 곳으로
		try {
			Class clazz = Class.forName("java.lang.String2"); // 예외 발생 시점
		}
		catch (Exception e) {
		}
		
		
	}
	
	
	
	
}
