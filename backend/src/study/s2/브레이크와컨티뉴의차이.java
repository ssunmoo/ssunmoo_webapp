package study.s2;

public class 브레이크와컨티뉴의차이 {

	public static void main(String[] args) {
		
		
		// break : 조건과 동일해지면 현재 반복문 종료 후 빠져나감 현재 반복문 재실행 x

		for ( int i = 1; i <= 10; i++){
			if ( i == 5) {
		    	break;
		    }
			System.out.println( "브레이크 + "+ i );
		}
		
		
		// continue : 조건과 동일해지면 현재 반복문 종료 후 현재 반복문 재실행 o
		
		for ( int i = 1; i <= 10; i++){
			if ( i == 5) {
		    	continue;
		    }
			System.out.println( "컨티뉴 + "+ i );
		}
		
		
		
		
		
		
		
		
	}
}
