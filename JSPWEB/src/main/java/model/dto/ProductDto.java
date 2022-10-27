package model.dto;

public class ProductDto {
	
	private int pno;						// 제품번호
	private String pname;					// 제품명
	private String pcomment;				// 제품설명
	private int pprice; 					// 제품가격	
	private float pdiscount; 				// 제품할인율 [소수점]
	private byte pactive;   				// 제품상태 : 0[준비중], 1[판매중], 2[재고없음]으로 사용 예정
	private String pimg; 					// 썸네일 경로
	private String pdate;					// 등록 날짜
	private int pcno;						// 제품 카테고리 번호 FK		
	
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}


	public ProductDto(int pno, String pname, String pcomment, int pprice, float pdiscount, byte pactive, String pimg,
			String pdate, int pcno) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pcomment = pcomment;
		this.pprice = pprice;
		this.pdiscount = pdiscount;
		this.pactive = pactive;
		this.pimg = pimg;
		this.pdate = pdate;
		this.pcno = pcno;
	}


	public int getPno() {
		return pno;
	}


	public void setPno(int pno) {
		this.pno = pno;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getPcomment() {
		return pcomment;
	}


	public void setPcomment(String pcomment) {
		this.pcomment = pcomment;
	}


	public int getPprice() {
		return pprice;
	}


	public void setPprice(int pprice) {
		this.pprice = pprice;
	}


	public float getPdiscount() {
		return pdiscount;
	}


	public void setPdiscount(float pdiscount) {
		this.pdiscount = pdiscount;
	}


	public byte getPactive() {
		return pactive;
	}


	public void setPactive(byte pactive) {
		this.pactive = pactive;
	}


	public String getPimg() {
		return pimg;
	}


	public void setPimg(String pimg) {
		this.pimg = pimg;
	}


	public String getPdate() {
		return pdate;
	}


	public void setPdate(String pdate) {
		this.pdate = pdate;
	}


	public int getPcno() {
		return pcno;
	}


	public void setPcno(int pcno) {
		this.pcno = pcno;
	}


	@Override
	public String toString() {
		return "ProductDto [pno=" + pno + ", pname=" + pname + ", pcomment=" + pcomment + ", pprice=" + pprice
				+ ", pdiscount=" + pdiscount + ", pactive=" + pactive + ", pimg=" + pimg + ", pdate=" + pdate
				+ ", pcno=" + pcno + "]";
	}


	
	
	
	
	
}
