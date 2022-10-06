package model.dto;

public class MemberDto2 {

	// DB명 jspweb
	private int	mno;							// 회원번호
	private String mid;							// 아이디
	private String mpw;							// 비밀번호
	private String mname;						// 이름
	private String mphone;						// 번호
	private String memail;						// 이메일
	private String maddress;					// 주소
	private String mdate;						// 날짜
	private int mpoint; 						// 포인트
	
	
	// 투스트링
	@Override
	public String toString() {
		return "MemberDto2 [mno=" + mno + ", mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mphone=" + mphone
				+ ", memail=" + memail + ", maddress=" + maddress + ", mdate=" + mdate + ", mpoint=" + mpoint + "]";
	}

	// 빈생성자
	public MemberDto2() {

	}

	// 풀생성자
	public MemberDto2(int mno, String mid, String mpw, String mname, String mphone, String memail, String maddress,
			String mdate, int mpoint) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mphone = mphone;
		this.memail = memail;
		this.maddress = maddress;
		this.mdate = mdate;
		this.mpoint = mpoint;
	}

	
	// 게터세터
	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMaddress() {
		return maddress;
	}

	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public int getMpoint() {
		return mpoint;
	}

	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

