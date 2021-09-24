package in.co.rays.inheritance;

public class Cheque  extends Payment{

	private int cheq_no;
	
	private String bankName;

	public int getCheq_no() {
		return cheq_no;
	}

	public void setCheq_no(int cheq_no) {
		this.cheq_no = cheq_no;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
}
