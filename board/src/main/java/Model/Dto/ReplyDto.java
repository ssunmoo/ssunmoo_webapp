package Model.Dto;

public class ReplyDto {

	int r_no;
    String r_reply;
    int r_index;
	int b_no;
	
	public ReplyDto() {
		// TODO Auto-generated constructor stub
	}
	
	public ReplyDto(int r_no, String r_reply, int r_index, int b_no) {
		super();
		this.r_no = r_no;
		this.r_reply = r_reply;
		this.r_index = r_index;
		this.b_no = b_no;
	}

	@Override
	public String toString() {
		return "ReplyDto [r_no=" + r_no + ", r_reply=" + r_reply + ", r_index=" + r_index + ", b_no=" + b_no + "]";
	}

	
	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getR_reply() {
		return r_reply;
	}

	public void setR_reply(String r_reply) {
		this.r_reply = r_reply;
	}

	public int getR_index() {
		return r_index;
	}

	public void setR_index(int r_index) {
		this.r_index = r_index;
	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	
	
	
	
	
}
