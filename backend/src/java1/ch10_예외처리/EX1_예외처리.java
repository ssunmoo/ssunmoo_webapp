package java1.ch10_예외처리;

public class EX1_예외처리 {
	public static void main(String[] args) {
		
//		// 1. NullPointer
//		String data = null;
//		System.out.println(data.toString());
//		
//		// 2. 
		
		
		
//		int[] 정수배열 = new int[3];
//		for(int i = 0; i <= 정수배열.length; i++) {
//			
//		}
//		
//		// 3. NumberFormat
//		String data1 = "100";	
//		String data2 = "a100";
//		
//		int value1 = Integer.parseInt(data1); // "100" -> 100
//		int value2 = Integer.parseInt(data2); // "a100" -> x
//		
//		int result = value1 + value2;
//		System.out.println(data1 + data2 +"="+ result);
		
		
		
	// 1. 자식 객체 선언
	Dog dog = new Dog();
	changeDog(dog);
	
	Cat cat = new Cat();
	changeDog(cat);
	
	
	} // main 종료

	public static void changeDog( Animal animal ) {
		
		if( animal instanceof Dog ) {
	
		Dog dog = (Dog)animal;
		System.out.println("개로 변환");
		}
	}
}
