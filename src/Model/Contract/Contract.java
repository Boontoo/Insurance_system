package Model.Contract;

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

	public String getinsuranceID() {
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


	public String toString(){
		return id + " " + 
				customerID + " " + 
				expirationDate + " " + 
				insuranceID + " " + 
				paymentAmount + " " + 
				PaymentStatus;
	}

}