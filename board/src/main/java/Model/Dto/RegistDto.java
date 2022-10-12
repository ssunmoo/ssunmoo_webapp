package Model.Dto;

public class RegistDto {

	private int b_no; 								// 게시판 번호
	private String b_title;							// 제목
	private String b_content;						// 내용
	private String b_name;							// 이름
	private String b_pw;							// 비밀번호
	private int b_date;								// 작성일
	private int b_view;								// 조회수
	
	
	
	
	
	// 투스트링
	@Override
	public String toString() {
		return "RegistDto [b_no=" + b_no + ", b_title=" + b_title + ", b_content=" + b_content + ", b_name=" + b_name
				+ ", b_pw=" + b_pw + ", b_date=" + b_date + ", b_view=" + b_view + "]";
	}

	// 빈생성자
	public RegistDto() {
		
	}
	
	// 풀생성자
	public RegistDto(int b_no, String b_title, String b_content, String b_name, String b_pw, int b_date, int b_view) {
		super();
		this.b_no = b_no;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_name = b_name;
		this.b_pw = b_pw;
		this.b_date = b_date;
		this.b_view = b_view;
	}

	// 겟셋
	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getB_pw() {
		return b_pw;
	}

	public void setB_pw(String b_pw) {
		this.b_pw = b_pw;
	}

	public int getB_date() {
		return b_date;
	}

	public void setB_date(int b_date) {
		this.b_date = b_date;
	}

	public int getB_view() {
		return b_view;
	}

	public void setB_view(int b_view) {
		this.b_view = b_view;
	}
	
	

	
	
	
	
}
