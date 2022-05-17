package ApplicationForMembership;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public class ApplicationForMembership {
	// ���� ��û �� ����
	private int age;
	private boolean gender;
	private String id;
	private String insuranceName;
	private String job;
	private String name;
	private String phoneNum;
	private String SSN; // �ֹ� ��ȣ
	private boolean UWExecutionStatus; // �μ��ɻ� ���� ����
	private boolean UWResult; // �μ��ɻ� ���

	public ApplicationForMembership(){

	}

	public ApplicationForMembership(String wishInsurance, String phoneNum, int age, boolean gender, String name, String jop, String SSN) {
		this.insuranceName = wishInsurance;
		this.phoneNum = phoneNum;
		this.age = age;
		this.gender = gender;
		this.name = name;
		this.job = jop;
		this.SSN = SSN;
		this.UWExecutionStatus = false;
		this.UWResult = false;
	}

	public void finalize() throws Throwable {

	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public boolean isUWExecutionStatus() {
		return UWExecutionStatus;
	}

	public void setUWExecutionStatus(boolean uWExecutionStatus) {
		UWExecutionStatus = uWExecutionStatus;
	}

	public boolean isUWResult() {
		return UWResult;
	}

	public void setUWResult(boolean uWResult) {
		UWResult = uWResult;
	}

	public String toString(){
		String genderStr = gender? "남자":"여자";
		return id + " " + name + " " + insuranceName + " " + phoneNum + " " + age + " " + genderStr + " " + job + " " + UWExecutionStatus + " " + UWResult;
	}

}