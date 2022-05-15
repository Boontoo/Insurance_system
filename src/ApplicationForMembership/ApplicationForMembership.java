package ApplicationForMembership;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 오후 9:00:55
 */
public class ApplicationForMembership {
	// 가입 신청 고객 정보
	private int age;
	private boolean gender;
	private String id;
	private String insuranceName;
	private String job;
	private String name;
	private String phoneNum;
	private String SSN; // 주민 번호
	private boolean UWExecutionStatus; // 인수심사 실행 여부
	public boolean UWResult; // 인수심사 결과

	public ApplicationForMembership(){

	}

	public ApplicationForMembership(String wishInsurance, String phoneNum, int age, boolean gender, String name, String jop) {
		this.insuranceName = wishInsurance;
		this.phoneNum = phoneNum;
		this.age = age;
		this.gender = gender;
		this.name = name;
		this.job = jop;
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
		return "";
	}

}