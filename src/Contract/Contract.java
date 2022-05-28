package Contract;

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
	private int totalPaymentAmount; // 새로 만든 속성
	private int paymentAmount;
	private boolean PaymentStatus;
	
	public Contract(){
		
	}
	public Contract(String customerID, 
					String expirationDate, 
					String insuranceID) {
		this.customerID = customerID;
		this.expirationDate = expirationDate;
		this.insuranceID = insuranceID;
		this.paymentAmount = 10000; // 임시 지정
		this.totalPaymentAmount = 0;
		this.PaymentStatus = false;
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
	public int getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public boolean isPaymentStatus() {
		return PaymentStatus;
	}
	public void setPaymentStatus(boolean paymentStatus) {
		PaymentStatus = paymentStatus;
	}
	public int getTotalPaymentAmount() {
		return totalPaymentAmount;
	}
	public void setTotalPaymentAmount(int totalPaymentAmount) {
		this.totalPaymentAmount = totalPaymentAmount;
	}
	public void addPayment(int amountOfInsuranceFee) {
		// 새로 만든 함수 - 납입 보험금 추가 - 보험금 납입
		totalPaymentAmount += amountOfInsuranceFee;
	}
	public String toString(){
		return id + " " + 
				customerID + " " + 
				expirationDate + " " + 
				insuranceID + " " + 
				paymentAmount + " " + 
				PaymentStatus;
	}

}