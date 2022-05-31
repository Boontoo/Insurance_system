package Model.Authorization;

public class Authorization {

	private boolean company; //회사 인가품의
	private boolean confirm; //보험상품확정
	private boolean FSS; //금융감독원 인가품의
	
	public Authorization() {
		
	}
	
	public void finalize() throws Throwable {

	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	public boolean isCompany() {
		return company;
	}

	public void setCompany(boolean company) {
		this.company = company;
	}

	public boolean isFSS() {
		return FSS;
	}

	public void setFSS(boolean fSS) {
		FSS = fSS;
	}
	
	
}
