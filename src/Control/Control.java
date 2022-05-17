package Control;

import java.util.ArrayList;
import java.util.regex.Pattern;

import AccidentReception.AccidentReception;
import AccidentReception.AccidentReceptionListImpl;
import ApplicationForMembership.ApplicationForMembership;
import ApplicationForMembership.ApplicationForMembershipListImpl;
import CompensationManagement.CompensationManagementListImpl;
import Contract.ContractListImpl;
import Customer.Customer;
import Customer.CustomerListImpl;
import Insurance.Insurance;
import Insurance.InsuranceListImpl;

/**
 * @author dlsqo
 * @version 1.0
 * @created 16-5-2022 ���� 2:40:57
 */
public class Control {

	private int customerID;
	private ArrayList<Customer> customerList;
	private ArrayList<Insurance> insuranceList;
	public CustomerListImpl m_CustomerListImpl;
	public InsuranceListImpl m_InsuranceListImpl;
	public AccidentReceptionListImpl m_AccidentReceptionListImpl;
	public CompensationManagementListImpl m_CompensationManagementListImpl;
	public ContractListImpl m_ContractListImpl;
	public ApplicationForMembershipListImpl m_ApplicationForMembershipListImpl;
	private ArrayList<ApplicationForMembership> enquirePassedCustomerList;
	// Impl�� ��� private���� �ٲ� ��

	public Control(){
		m_ApplicationForMembershipListImpl = new ApplicationForMembershipListImpl();
		m_ApplicationForMembershipListImpl.add(new ApplicationForMembership("�����", "010-3737-2855", 24, true, "������", "���л�", "990713-1058827"));
		m_ApplicationForMembershipListImpl.add(new ApplicationForMembership("����", "010-3737-2855", 24, true, "Ȳ����", "���л�", "990713-1058827"));
		m_ApplicationForMembershipListImpl.add(new ApplicationForMembership("������", "010-3737-2855", 24, true, "��ö��", "���л�", "990713-1058827"));
		// �� ������ �ӽ���
		this.m_CustomerListImpl = new CustomerListImpl();
	}

   public void finalize() throws Throwable {

   }

	/**
	 * 
	 * @param insurance
	 * @param phoneNum
	 * @param age
	 * @param gender
	 * @param name
	 * @param job
	 * @param SSN
	 */
	public boolean applyForMembership(String insurance, String phoneNum, int age, boolean gender, String name, String jop, String SSN){
		// ���� ��û�� �Ѵ� - ���� ��û�ϱ�
		// ��ȯ�� ����(void -> boolean)
		if(!checkInputImformation(insurance, phoneNum, age, SSN, name, jop)) return false;
		boolean result = m_ApplicationForMembershipListImpl.add(new ApplicationForMembership(insurance, phoneNum, age, gender, name, jop, SSN));
		return result;
		// �Է� ���� ���� ������� ����

	
	

	/**
	 * 
	 * @param id
	 * @param isOwnedBuilding
	 * @param isRemodeling
	 * @param buildingAgeScore
	 * @param fireEquipmentConditionScore
	 * @param buildingLocationScore
	 * @param buildingConditionScore
	 */
	public boolean automaticJudge(String id, boolean isOwnedBuilding, boolean isRemodeling, 
			int buildingAgeScore, int fireEquipmentConditionScore, int buildingLocationScore, int buildingConditionScore){
		// �ڵ� �ɻ縦 �����Ѵ� - �μ��ɻ� �����ϱ�
		// id�� ������ �� ��?? ���� ��û�� ���迡 ���� �μ��ɻ� ������ �ٸ��� �η��� �ǵ� �켱 �μ��ɻ� ������ 70�� �̻� �ϳ��� ����� �ǹ� ����
		// �μ��ɻ� ������ ������ ����� ���Խ�û ������ ��û ���� �̸��� ���� �μ��ɻ� ������ �ٸ��� �ξ�� ��
		if(!isOwnedBuilding) return false;
		int remodelPoint = isOwnedBuilding? 0:20; // ���� ���� �ٽ� Ȯ���� �� ��
		int totalPoint = remodelPoint + buildingAgeScore + fireEquipmentConditionScore + buildingLocationScore + buildingConditionScore;
		if(totalPoint < 70) return false;
		return true;
	
	public boolean checkAlreadyJudged(String id) {
		return m_ApplicationForMembershipListImpl.get(id).isUWExecutionStatus();
	}
	
	public boolean checkInID(String id) {
		// ���� ���� �Լ�
		return m_ApplicationForMembershipListImpl.checkInID(id);
	}
	public boolean checkPointInput(int buildingAgeScore, int fireEquipmentConditionScore, 
			int buildingLocationScore, int buildingConditionScore) {
		// ���� ���� �Լ�
		if(!(buildingAgeScore >= 0 && buildingAgeScore <= 20)) return false;
		if(!(fireEquipmentConditionScore >= 0 && fireEquipmentConditionScore <= 20)) return false;
		if(!(buildingLocationScore >= 0 && buildingLocationScore <= 20)) return false;
		if(!(buildingConditionScore >= 0 && buildingConditionScore <= 20)) return false;
		return true;
	}
	
	/**
	 * 
	 * @param amountOfInsuranceFee
	 */
	public boolean checkAmountOfInsuranceFee(int amountOfInsuranceFee){
		return false;
	}

	/**
	 * 
	 * @param date
	 */
	private String checkInputDateFormat(String date){
		// �Է� ��¥������ Ȯ���ϱ�
		return "";
	}

	/**
	 * 
	 * @param insurance
	 * @param phoneNum
	 * @param age
	 * @param gender
	 * @param name
	 * @param job
	 */
	private boolean checkInputImformation(String insurance, String phoneNum, int age, String citizenNum, String name, String jop){
		// �Է� ������ Ȯ���Ѵ� - ���� ��û�ϱ�
		// �Ķ����(���� -> �ֹι�ȣ)
		if(!checkKoreanFormat(name)) return false;
		if(!checkKoreanFormat(insurance)) return false;
		if(!checkPhoneNumFormat(phoneNum)) return false;
		if(!(age > 0 && age < 120)) return false;
		if(!checkKoreanFormat(jop)) return false;
		if(!checkCitizenNumFormat(citizenNum)) return false;
		return true;
	}
	private boolean checkKoreanFormat(String input) {
		// ���� ���� �Լ�(�ѱ۸� �����ϴ��� Ȯ��)
		if(input.matches(".*[��-�R]+.*")
				  && !input.matches(".*[��-����-��]+.*")
				  && !input.matches(".*[a-zA-Z]+.*")
	              && !input.matches(".*[0-9]+.*")
	              && !input.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+.*")) 
			return true;
	}

	private boolean checkPhoneNumFormat(String input) {
		// ���� ���� �Լ�(�޴��� ��ȣ�� ��ȿ ex010-3737-2855)
		if(input.length() != 13) return false;
		if(input.charAt(3) != '-' || input.charAt(8) != '-') return false;
		if(!input.substring(0, 3).equals("010")) return false;
		if(input.substring(4, 8).matches(".*[��-�R]+.*")
				|| input.substring(4, 8).matches(".*[��-����-��]+.*")
				|| input.substring(4, 8).matches(".*[a-zA-Z]+.*")
				|| input.substring(4, 8).matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+.*")) 
			return false;
		if(input.substring(9, 13).matches(".*[��-�R]+.*")
				|| input.substring(9, 13).matches(".*[��-����-��]+.*")
				|| input.substring(9, 13).matches(".*[a-zA-Z]+.*")
				|| input.substring(9, 13).matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+.*")) 
			return false;
		return true;
	}
	private boolean checkCitizenNumFormat(String input) {
		// ���� ���� �Լ�
		if(input.length() != 14) return false;
		if(input.charAt(6) != '-') return false;
		if(!(input.charAt(7) == '1'
				|| input.charAt(7) == '2'
				|| input.charAt(7) == '3'
				|| input.charAt(7) == '4')) return false;
		if(input.substring(0, 6).matches(".*[��-�R]+.*")
				|| input.substring(0, 6).matches(".*[��-����-��]+.*")
				|| input.substring(0, 6).matches(".*[a-zA-Z]+.*")
				|| input.substring(0, 6).matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+.*"))
			return false;
		if(input.substring(7, 14).matches(".*[��-�R]+.*")
				|| input.substring(7, 14).matches(".*[��-����-��]+.*")
				|| input.substring(7, 14).matches(".*[a-zA-Z]+.*")
				|| input.substring(7, 14).matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+.*"))
			return false;
		return true;
	}

	public int countInsuranceFeeNotPaid(){
		// ����� �̳��� ������ ����
		return 0;
	}

	public String deleteCustomerInformation(){
		// ���� ������ �����Ѵ�
		return "";
	}
	
	public String enquireApplicationForMembership(String id) {
		// ���� ���� �Լ�
		return m_ApplicationForMembershipListImpl.get(id).toString();
	}

	/**
	 * 
	 * @param customerName
	 */
	public String enquireAccidentInformation(String customerName){
		// ������� ������ ��ȸ�Ѵ�
		return "";
	}

	public String enquireAccidentList(){
		// ��� ��� ��ȸ�ϱ�
		return "";
	}

	/**
	 * 
	 * @param type
	 * @param key
	 */
	public String enquireCustomerInformation(int type, String key){
		switch(type) {
			case 1: 
				this.customerList = this.m_CustomerListImpl.get(type, key);
				break;
			case 2:
			case 4:
				int keyInt = Integer.parseInt(key);
				this.customerList = this.m_CustomerListImpl.get(type, keyInt);
				break;
			case 3:
				if(key.equals("1"))
					this.customerList = this.m_CustomerListImpl.get(true);
				else if(key.equals("2"))
					this.customerList = this.m_CustomerListImpl.get(false);
				break;
		}
		String result = "";
		int index = 1;
		for (Customer customer : this.customerList) {
			result = result + index + "." + customer.getName() + customer.getAge() + customer.isGender() + customer.getBirthDate() + "\n";
			index++;
		}
		return result;
	}
	
	/**
	 * 
	 * @param choice
	 */
	public String enquireCustomerDetailInformation(int choice) {
		Customer customer = this.customerList.get(choice-1);
		String result = "";
		result = result + "이름: " + customer.getName() + ", ";
		result = result + "나이: " + customer.getAge() + ", ";
		result = result + "성별: " + customer.isGender() + ", ";
		result = result + "주민등록번호: " + customer.getSsn() + ", ";
		result = result + "직업: " + ", ";
		result = result + "전화번호: " + customer.getPhoneNum() + ", ";
		result = result + "가입보험: (";
		boolean isFirst = false;
		for(String subscribedInsurance : customer.getSubscribedInsurance()) {
			if(isFirst) {
				result = result + ", ";
				isFirst = true;
			}
			result = result + subscribedInsurance;
		}
		result = result + "), ";
		result = result + "특이사항: " + customer.getUniqueness();
		return result;
	}

	public String checkCustomerInformation(int index, int choice, String newInformation) {
		Customer customer = this.customerList.get(index-1);
		String result = "";
		result = result + "이름: " + customer.getName() + ", ";
		result = result + "나이: " + customer.getAge() + ", ";
		result = result + "직업: " + ", ";
		result = result + "전화번호: " + customer.getPhoneNum();
		result = result + " -> ";
		switch(choice) {
			case 1:
				result = result + "이름: " + newInformation + ", ";
				result = result + "나이: " + customer.getAge() + ", ";
				result = result + "직업: " + ", ";
				result = result + "전화번호: " + customer.getPhoneNum();
				break;
			case 2:
				result = result + "이름: " + customer.getName() + ", ";
				result = result + "나이: " + newInformation + ", ";
				result = result + "직업: " + ", ";
				result = result + "전화번호: " + customer.getPhoneNum();
				break;
			case 3:
				result = result + "이름: " + customer.getName() + ", ";
				result = result + "나이: " + customer.getAge() + ", ";
				result = result + "직업: " + newInformation + ", ";
				result = result + "전화번호: " + customer.getPhoneNum();
				break;
			case 4:
				result = result + "이름: " + customer.getName() + ", ";
				result = result + "나이: " + customer.getAge() + ", ";
				result = result + "직업: " + ", ";
				result = result + "전화번호: " + newInformation;
				break;
		}
		return result;
	}
	
	/**
	 * 
	 * @param choice
	 */
	public String enquireEmergencyCustomerList(int choice){
		// ��� ���� ��� ��ȸ�ϱ�
		return "";
	}

	/**
	 * 
	 * @param id
	 * @param accidentLocation
	 * @param accidentType
	 */
	
	   public String enquireEmployeeCallStatusImformation(String id, String accidentLocation, String accidentType){
	  AccidentReception accidentReception = m_AccidentReceptionListImpl.get(id);
	  String temp =  accidentReception.getAccidentID()+" "+accidentReception.getCustomerID()
	  +" "+accidentReception.getCustomerName()+" "+accidentReception.isEmployeeCallStatus()
	  +" "+accidentReception.getRemainingNumberOfTowTruckCalls()+" "+accidentReception.isTowTruckCallPresent();
      return temp;
   }

	public String enquireExpirationContractInformation(){
		// ���� ��������� ��ȸ�Ѵ�
		return "";
	}

	public String enquireInformationAboutApplicationForMembership(){
		// ���� ��û ������ ��ȸ�Ѵ� - �μ��ɻ� �����ϱ�
		return m_ApplicationForMembershipListImpl.toString();
	}

	public String enquireInsuranceFeePaymentStatus(){
		// ����� ���� ������ ��ȸ�Ѵ�
		return "";
	}

	public String enquireInsuranceList(){
		// ���� ����Ʈ ��ȸ�ϱ�
		return "";
	}

	/**
	 * 
	 * @param choice
	 */
	public String enquireInsuranceProductDetails(int choice){
		// ���� ��ǰ ���� ���� ��ȸ�ϱ�
		return "";
	}

	public String enquireInsuranceProductDevelopmentInformation(){
		// ���� ��ǰ ���� ���� ��ȸ�ϱ�
		return "";
	}

	public String enquireNewContractInformation(){
		// �ű� ��������� ����Ѵ� - ���� �����ϱ�(���� �������� ��ȸ���� ����)
		return "";
	}

	public String enquirePassedCustomerInUW(){
		// �μ��ɻ� �հ� ������ ����Ѵ� - ���� �����ϱ�
		String temp = "";
		for(int i = 0; i < m_ApplicationForMembershipListImpl.getSize(); i++) {
			if(m_ApplicationForMembershipListImpl.get(i).isUWResult())
				temp += m_ApplicationForMembershipListImpl.get(i).getId() + " " + 
						m_ApplicationForMembershipListImpl.get(i).getName() + " " + 
						m_ApplicationForMembershipListImpl.get(i).getPhoneNum() + " " +  
						m_ApplicationForMembershipListImpl.get(i).getInsuranceName()+ "\n";
		}
		return temp;
	}

	public void enquireProductSalesSupportDetails(){
		// ��ǰ �Ǹ� ���� �������� �����ϱ�..?
	}

	/**
	 * 
	 * @param automaticExaminationResult
	 * @param diagnosticExaminationResult
	 * @param imageExaminationResult
	 * @param specialExaminationResult
	 * @param generalExaminationResult
	 */
	public String enquireUWResult(String id, boolean automaticExaminationResult, boolean diagnosticExaminationResult, 
			boolean imageExaminationResult, boolean specialExaminationResult, boolean generalExaminationResult){
		// �μ��ɻ� ����� Ȯ���Ѵ� - �μ��ɻ� �����ϱ�
		// �μ��ɻ� ���� ���� ����, �ɻ� ��� ���� ���� - ���� ���� ���
		// �Ķ���� �߰�(String id)
		String result = "�μ��ɻ翡 ���հ��Ͽ����ϴ�\n���� : ";
		m_ApplicationForMembershipListImpl.get(id).setUWExecutionStatus(true);
		if(!automaticExaminationResult) return result += "�ڵ��ɻ�";
		if(!diagnosticExaminationResult) return result += "���ܽɻ�";
		if(!imageExaminationResult) return result += "�̹����ɻ�";
		if(!specialExaminationResult) return result += "Ư�νɻ�";
		if(!generalExaminationResult) return result += "�Ϲݽɻ�";
		m_ApplicationForMembershipListImpl.get(id).setUWResult(true);
		result = "�μ��ɻ翡 �հ��Ͽ����ϴ�";
		return result;


	public String euqireInsuranceProductDesignForm(){
		// ���� ��ǰ ���� ��� ��ȸ�ϱ�
		return "";
	}

	/**
	 * 
	 * @param extendedExpirationDate
	 */
	public String extendContract(String extendedExpirationDate){
		// ��� �����ϱ�
	    return "";
	}

	public String initializeInsuranceFeePaymentStatus(){
		// ����� ���Կ��θ� �ʱ�ȭ�Ѵ�
		return "";
	}

	public void makeDecisionInsuranceProduct(){
		// ���� ��ǰ ����...?
	}

	/**
	 * 
	 * @param id
	 */
	public boolean makeInsuranceContract(String id){
		// ���� ����� �Ѵ�
		return false;
	}

	public String modifyCustomerInformation(String newInformation){
		
		return "";
	}

	public String payInsuranceMoney(){
		// ����� �����ϱ�
		return "";
	}

	/**
	 * 
	 * @param newExpirationDate
	 * @param id
	 */
	public String renewExpirationDate(String newExpirationDate, String id){
		return "";
	}

	public void requestAuthorizationOfCompany(){
		// ȸ�� ���� ��û �ޱ�

   }

	public void requestAuthorizationOfFSS(){
		// FSS�� ���� �ο��� ��û�ϱ�...?
	}

	/**
	 * 
	 * @param id
	 * @param amountOfInsuranceFee
	 */
	public String saveAmountOfInsuranceFee(String id, int amountOfInsuranceFee){
		return "";
	}

	/**
	 * 
	 * @param targetCustomer
	 * @param compensationDevelopmentPlan
	 * @param InsuranceProductName
	 * @param evaluation
	 */
	public void saveCompensationManagementInformation(String targetCustomer, String compensationDevelopmentPlan, String InsuranceProductName, String evaluation){
	}

	public void saveInsuranceDesignContent(){
		// ���� ���� ���� �����ϱ�
	}
	/**
	 * 
	 * @param plannedContents
	 */
	public String savePlannedContents(String plannedContents){
		return "";
	}

	public void saveProductSalesSupportDetails(){
		// ��ǰ �Ǹ� ���� ���� ���� �����ϱ�
	}



}