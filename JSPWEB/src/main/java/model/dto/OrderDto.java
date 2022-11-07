package model.dto;

public class OrderDto {

	private int ono;				// 주문 번호
	private String oname;			// 수령인 이름
	private String ophone;			// 수령인 연락처
	private String oaddress;		// 수령인 주소
	private String orequest;		// 배송 메세지 
	private String odate;			// 주문 날짜
	private int mno;				// 주문자 회원 번호
	private int odno;				// 주문 상세 번호
	private int odamount;			// 수량
	private int odprice;            // 결제 금액 [ 결제 시 할인율 등이 달라질 수 있어서 넣음 ]
	private int odactive;			// 결제 상태[ 0 : 결제 완료 / 4: 취소 / 1 : 배송 준비 중 / 2: 배송 중 / 3: 배송 완료 등 ]
	private int pstno;				// 재고 번호
	
	public OrderDto() {
		// TODO Auto-generated constructor stub
	}

	public OrderDto(int ono, String oname, String ophone, String oaddress, String orequest, String odate, int mno,
			int odno, int odamount, int odprice, int odactive, int pstno) {
		super();
		this.ono = ono;
		this.oname = oname;
		this.ophone = ophone;
		this.oaddress = oaddress;
		this.orequest = orequest;
		this.odate = odate;
		this.mno = mno;
		this.odno = odno;
		this.odamount = odamount;
		this.odprice = odprice;
		this.odactive = odactive;
		this.pstno = pstno;
	}

	public int getOno() {
		return ono;
	}

	public void setOno(int ono) {
		this.ono = ono;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public String getOphone() {
		return ophone;
	}

	public void setOphone(String ophone) {
		this.ophone = ophone;
	}

	public String getOaddress() {
		return oaddress;
	}

	public void setOaddress(String oaddress) {
		this.oaddress = oaddress;
	}

	public String getOrequest() {
		return orequest;
	}

	public void setOrequest(String orequest) {
		this.orequest = orequest;
	}

	public String getOdate() {
		return odate;
	}

	public void setOdate(String odate) {
		this.odate = odate;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getOdno() {
		return odno;
	}

	public void setOdno(int odno) {
		this.odno = odno;
	}

	public int getOdamount() {
		return odamount;
	}

	public void setOdamount(int odamount) {
		this.odamount = odamount;
	}

	public int getOdprice() {
		return odprice;
	}

	public void setOdprice(int odprice) {
		this.odprice = odprice;
	}

	public int getOdactive() {
		return odactive;
	}

	public void setOdactive(int odactive) {
		this.odactive = odactive;
	}

	public int getPstno() {
		return pstno;
	}

	public void setPstno(int pstno) {
		this.pstno = pstno;
	}

	@Override
	public String toString() {
		return "OrderDto [ono=" + ono + ", oname=" + oname + ", ophone=" + ophone + ", oaddress=" + oaddress
				+ ", orequest=" + orequest + ", odate=" + odate + ", mno=" + mno + ", odno=" + odno + ", odamount="
				+ odamount + ", odprice=" + odprice + ", odactive=" + odactive + ", pstno=" + pstno + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
