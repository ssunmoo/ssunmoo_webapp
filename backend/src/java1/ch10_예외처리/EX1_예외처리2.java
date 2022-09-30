package java1.ch10_예외처리;

public class EX1_예외처리2 {
	public static void main(String[] args) {
		
		
	// 0. 
	try {
		Class clazz = Class.forName("java.lang.String2");
		// class.forName : 일반예외발생
	}
	catch ( ClassNotFoundException e ) {
		System.out.println("클래스가 존재하지 않습니다 " + e);
	}
	finally {
		System.out.println("클래스를 찾던 못 찾던 무조건 실행됩니다");
	}
		
	
		
	// 1. NullPointer
	try {
		String data = null;
		System.out.println(data.toString());
	}
	catch( NullPointerException e ) {
		System.out.println("객체의 내용이 없습니다[ 참조 없음 ] " + e);
	}
	
	
	
	 
	// 2. ArrayIndexOutOfBounds 
	try {
		String data1 = args[0];
		String data2 = args[1];
		System.out.println( "data1 : " + data1);
		System.out.println( "data2 : " + data2);
		
	}
	catch ( ArrayIndexOutOfBoundsException e ) {
		System.out.println("배열에 인덱스가 없습니다 " + e);
	}
	
	
	

	try {
		
		int[] 정수배열 = new int[3];
		for(int i = 0; i <= 정수배열.length; i++) {
			System.out.println(정수배열[i]);
		}
	}
	catch ( ArrayIndexOutOfBoundsException e ) {
		System.out.println("배열에 없는 인덱스입니다 " + e);
	}
	
	
	
	
	// 3. NumberFormat
	
	try {
		String data1 = "100";	
		String data2 = "a100";
		
		int value1 = Integer.parseInt(data1); // "100" -> 100
		int value2 = Integer.parseInt(data2); // "a100" -> x
		
		int result = value1 + value2;
		System.out.println(data1 + data2 +"="+ result);
	}
	catch ( NumberFormatException e) {
		System.out.println("정수형으로 변환 실패 " + e);
	}
	
	
	// 1. 자식 객체 선언
	try {
		Dog dog = new Dog();
		changeDog(dog);
		
		Cat cat = new Cat();
		changeDog(cat); // 예외발생 시점 --> catch
	} catch ( ClassCastException e) {
		System.out.println("클래스형 변환 실패 " + e);
	}
	 	

	} // main 종료

	
	public static void changeDog( Animal animal ) {
		
		if( animal instanceof Dog ) {
	
		Dog dog = (Dog)animal;
		System.out.println("개로 변환");
		}
	}
	
	
	

}