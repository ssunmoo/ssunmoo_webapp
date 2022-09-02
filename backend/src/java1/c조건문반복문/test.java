package java1.c조건문반복문;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		

		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1번 : ");
		int a = scan.nextInt();
		
		System.out.println("2번: ");
		int b = scan.nextInt();
		
		System.out.println("3번: ");
		int c = scan.nextInt();
		
		
		int temp = 0;
		
		// 5 2 7
		
		if( a > b ) {
			temp = a;
			a = b;
			b = temp;
		}
		
		if(a > c) {
			temp = a;
			a = c;
			c = temp;
		}
		
		if(b > c) {
			temp = b;
			b = c;
			c = temp;
		}
		
		System.out.println(a + " " + b + " " + c);
		
		
		
		
		
		
		
		
		
	}

}
