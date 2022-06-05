package Model.contract;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public class Contract {

	private String customerID;
	private String expirationDate; // 만기일
	private String id;
	private String insuranceID;
	private int totalPayAmount; // 새로 만든 속성
	private int payAmount;
	private boolean payStatus;
	private boolean renewConsult; // 새로 만든 속성 - 갱신상담 여부
	
	public Contract(){
		
	}
	public Contract(String customerID, 
					String expirationDate, 
					String insuranceID) {
		this.customerID = customerID;
		this.expirationDate = expirationDate;
		this.insuranceID = insuranceID;
		this.payAmount = 10000; // 임시 지정
		this.totalPayAmount = 0;
		this.payStatus = false;
		this.renewConsult = false;
	}

	public void finalize() throws Throwable {

	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInsuranceID() {
		return insuranceID;
	}
	public void setInsuranceID(String insuranceID) {
		this.insuranceID = insuranceID;
	}
	public int getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(int payAmount) {
		this.payAmount = payAmount;
	}
	public boolean isPayStatus() {
		return payStatus;
	}
	public void setPayStatus(boolean payStatus) {
		this.payStatus = payStatus;
	}
	public int getTotalPayAmount() {
		return totalPayAmount;
	}
	public void setTotalPayAmount(int totalPayAmount) {
		this.totalPayAmount = totalPayAmount;
	}
	public boolean isRenewConsult() {
		return renewConsult;
	}
	public void setRenewConsult(boolean isRenewConsult) {
		this.renewConsult = isRenewConsult;
	}
	public void addPayment(int amountOfInsuranceFee) {
		// 새로 만든 함수 - 납입 보험금 추가 - 보험금 납입
		totalPayAmount += amountOfInsuranceFee;
	}
	public String toString(){
		return id + " " + 
				customerID + " " + 
				expirationDate + " " + 
				insuranceID + " " + 
				payAmount + " " + 
				payStatus;
	}

}