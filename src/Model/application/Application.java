package Model.application;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public class Application {
	// ���� ��û �� ����
	private String age;
	// 타입 변경(int -> String)
	private boolean gender;
	private String id;
	private String insuranceName;
	private String job;
	private String customerName;
	private String phoneNum;
	private String SSN; // �ֹ� ��ȣ
	private boolean UWProceed; // �μ��ɻ� ���� ����
	private boolean UWResult; // �μ��ɻ� ���

	public Application(){

	}

	public Application(String wishInsurance, 
									String phoneNum, 
									String age, 
									boolean gender, 
									String customerName, 
									String jop, 
									String SSN) {
		this.insuranceName = wishInsurance;
		this.phoneNum = phoneNum; // 0
		this.age = age; // 0
		this.gender = gender; // 0
		this.customerName = customerName; // 0
		this.job = jop; 
		this.SSN = SSN; // 0
		this.UWProceed = false;
		this.UWResult = false;
	}

	public void finalize() throws Throwable {

	}
	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public boolean isUWProceed() {
		return UWProceed;
	}

	public void setUWProceed(boolean uWProceed) {
		UWProceed = uWProceed;
	}

	public boolean isUWResult() {
		return UWResult;
	}

	public void setUWResult(boolean uWResult) {
		UWResult = uWResult;
	}

	public String toString(){
		String genderStr = gender? "남자":"여자";
		return id + " " + customerName + " " + insuranceName + " " + phoneNum + " " + age + " " + genderStr + " " + job + " " + UWProceed + " " + UWResult;
	}

}