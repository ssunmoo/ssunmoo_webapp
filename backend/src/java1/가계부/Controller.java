package java1.가계부;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller {
	
	
	
	// 1. 내용 추가
	boolean add ( String e_date, int e_money, String e_comment ) {
		
		// DTO에 있는 파라미터 3개를 1개로 포장함
		DTO dto = new DTO( 0, e_date, e_money, e_comment );
		
		// dto 객체 -> dao로 넘기기
		return DAO.getInstance().add( dto );
	}
	
	// 2. 내용 수정
	boolean update( int e_no, String e_date, int e_money, String e_comment ) {
		
		DTO dto = new DTO( e_no, e_date, e_money, e_comment ); 
		return DAO.getInstance().update( dto );
	}
	
	// 3. 내용 삭제
	boolean delete( int e_no ) {
		
		DTO dto = new DTO( e_no, null, 0, null ); 
		return DAO.getInstance().delete( dto );
	}
	
	// 4. 내용 검색
	ArrayList< DTO > read(){
		return DAO.getInstance().read();
	}
	
	// 5. 날짜별 금액 합계
	
	HashMap<String, Integer> date_sum() {
		return DAO.getInstance().date_sum();
	}
	
	
	
	
	
	
	
	
}
