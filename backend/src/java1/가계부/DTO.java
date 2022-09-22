package java1.가계부;

public class DTO {

	// 1. 필드
	private int e_no;
	private String e_date;
	private int e_money;
	private String e_comment;
	
	
	// 2. 생성자
	public DTO() {
		
	}
	
	
	// 3. getter setter
	
	
	public DTO(int e_no, String e_date, int e_money, String e_comment) {

		this.e_no = e_no;
		this.e_date = e_date;
		this.e_money = e_money;
		this.e_comment = e_comment;
	}

	public int getE_no() {
		return e_no;
	}

	public void setE_no(int e_no) {
		this.e_no = e_no;
	}

	public String getE_date() {
		return e_date;
	}

	public void setE_date(String e_date) {
		this.e_date = e_date;
	}

	public int getE_money() {
		return e_money;
	}

	public void setE_money(int e_money) {
		this.e_money = e_money;
	}

	public String getE_comment() {
		return e_comment;
	}

	public void setE_comment(String e_comment) {
		this.e_comment = e_comment;
	}
	
	
   
 
	
	
	
}