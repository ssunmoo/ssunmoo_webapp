package study.s1;

import java.util.Scanner;

public class s0906_EX5_입출력_3 {
	
	public static void main(String[] args) {
		
		
		int 변수 = 123;
		System.out.println(변수 + "원");
		System.out.printf("%d원", 변수);
		
		System.out.println();
		
		int i = 123;
		System.out.printf("%d원", i);
		System.out.println();
		System.out.printf("%-6d원", i);
		System.out.println();
		System.out.printf("%6d원\n", i);
		System.out.printf("%06d원\n", i);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		int 정수 = scan.nextInt();
		
		System.out.println("문자 입력 : ");
		String 문자 = scan.next();
		
		System.out.println("실수 입력 : ");
		double 실수 = scan.nextDouble();
		
		
		 System.out.printf("정수 %d , 문자 %s , %f", 정수, 문자, 실수);
		
		
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println();
		System.out.println("이름 : ");
		String 이름 = scanner.next();
		
		System.out.println("나이 : ");
		int 나이 = scanner.nextInt();
		
		System.out.println("키 : ");
		double 키 = scanner.nextDouble();
		
		
		System.out.printf(" 이름 : %s , 나이 : %d , 키 : %f ", 이름, 나이, 키);
		
		
		
		
		
		
	}
}
