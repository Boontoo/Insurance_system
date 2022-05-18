package Contract;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public class Contract {

	private String customerName;
	private String expirationDate; // 만기일
	private boolean gender;
	private String id;
	private String insuranceName;
	private int paymentAmount;
	private boolean PaymentStatus;
	private String phoneNum;
	private String SSN;

	public Contract(){
		
	}
	public Contract(String customerName, 
					String expirationDate, 
					boolean gender, 
					String insuranceName, 
					String phoneNum, 
					String SSN) {
		this.customerName = customerName;
		this.expirationDate = expirationDate;
		this.gender = gender;
		this.insuranceName = insuranceName;
		this.paymentAmount = 10000; // 임시 지정
		this.phoneNum = phoneNum;
		this.SSN = SSN;
		this.PaymentStatus = false;
	}

	public void finalize() throws Throwable {

	}

	
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
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

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String toString(){
		return id + " " + 
				customerName + " " + 
				expirationDate + " " + 
				insuranceName + " " + 
				paymentAmount + " " + 
				phoneNum + " " + 
				SSN + " " + 
				gender + " " + 
				PaymentStatus;
	}

}