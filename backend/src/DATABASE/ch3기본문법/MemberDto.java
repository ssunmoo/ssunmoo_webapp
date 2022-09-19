package DATABASE.ch3기본문법;

public class MemberDto {
	// DB 테이블명과 동일
	
	
	String mem_id;
	String mem_name;
	int mem_nuber;
	String addr;
	String phone1;
	String phone2;
	short height;
	String debut_date;

  
	public MemberDto() {
		
	}


	public MemberDto(String mem_id, String mem_name, int mem_nuber, String addr, String phone1, String phone2,
			short height, String debut_date) {
		super();
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_nuber = mem_nuber;
		this.addr = addr;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.height = height;
		this.debut_date = debut_date;
	}
	
	


	
	
}
