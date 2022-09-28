package java1.ch11_API클래스;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EX3_Date클래스 {

	public static void main(String[] args) {
		
		
		// 1. Date 클래스 : 현재 날짜/시간 호출
		Date now = new Date();
		System.out.println( now );
		String strNow1 = now.toString();
		System.out.println( strNow1);
		
		// 2. SimpleDateFormat() : 날짜/시간 형식[모양] 문자열 변환	
			// 1. new SimpleDateFormat 객체명 = new SimpleDateFormat( "형식" )
			// 2. 객체명.format(데이터)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");		
		String strNow2 = sdf.format( new Date() );
		System.out.println( strNow2 );
		
		
		// 3. Calendar 클래스
		Calendar cal = Calendar.getInstance();	// 운영체제에서 설정되어있는 시간의 날짜와 정보 호출
		
		// 객체명.get(해당 필드명) : 해당 필드의 정보 호출
		
		int year = cal.get( Calendar.YEAR );	// 연도 호출
		System.out.println( year );
		
		int month = cal.get( Calendar.MONTH)+1;
		System.out.println( month );
		// 1월[0] 2월[1] ~ 12[11] 으로 출력되서 +1 해줘야함
		
		int day = cal.get( Calendar.DAY_OF_MONTH );
		System.out.println( day );
		
		int week = cal.get( Calendar.DAY_OF_WEEK);
		String strWeek = null;
		switch ( week ) {
			
		// 일[1] 월[2] 화[3] 수[4] 목[5] 금[6] 토[7]
		case Calendar.MONDAY : strWeek = "월";
			break;
			
			case Calendar.TUESDAY : strWeek = "화";
			break;
			
			case Calendar.WEDNESDAY : strWeek = "수";
			break;
			
			case Calendar.THURSDAY : strWeek = "목";
			break;
			
			case Calendar.FRIDAY : strWeek = "금";
			break;
			
			case Calendar.SATURDAY : strWeek = "토";
			break;
			
			default : strWeek = "일";
			break;
		}
		
		
		System.out.println( strWeek );
		
		
		int amPm = cal.get( Calendar.AM_PM );
			// 오전[0] 오후[1]
		if( amPm == Calendar.AM) {
			System.out.println("오전");
		}
		else {
			System.out.println("오후");
		}
		
		
		System.out.println( cal.get( Calendar.HOUR ));
		System.out.println(cal.get( Calendar.MINUTE ));
		System.out.println(cal.get( Calendar.SECOND ));
		
		
		
		// 다른 클래스의 메소드 호출하는 방법
		// 1. static 정적멤버일 경우 : 클래스명.메소드
		// 2. new 객체 생성 : 객체명.메소드명
		// 3. 싱글톤 : 클래스명.get싱글톤.메소드명
			// 현재 클래스에서 메소드 호출시 : 메소드명()
		
		EX4_달력 ex = new EX4_달력();
		ex.run();
		
		
		
		
		
		
		
		
		
		
	}
}
