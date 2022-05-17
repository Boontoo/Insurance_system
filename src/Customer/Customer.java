package Customer;
import java.util.ArrayList;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:56
 */
public class Customer {

	private int age;
	private int birthDate;
	private boolean gender;
	private String id;
	private enum job{};
	private String name;
	private String phoneNum;
	private String ssn;
	private ArrayList<String> subscribedInsurance;
	private String uniqueness;

	public Customer(){

	}

	public void finalize() throws Throwable {

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public ArrayList<String> getSubscribedInsurance() {
		return subscribedInsurance;
	}

	public void setSubscribedInsurance(ArrayList<String> subscribedInsurance) {
		this.subscribedInsurance = subscribedInsurance;
	}

	public String getUniqueness() {
		return uniqueness;
	}

	public void setUniqueness(String uniqueness) {
		this.uniqueness = uniqueness;
	}

	
}