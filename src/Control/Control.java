package Control;
import java.util.ArrayList;
import java.util.regex.Pattern;

import AccidentReception.AccidentReceptionListImpl;
import ApplicationForMembership.ApplicationForMembership;
import ApplicationForMembership.ApplicationForMembershipListImpl;
import CompensationManagement.CompensationManagementListImpl;
import Contract.ContractListImpl;
import Customer.Customer;
import Customer.CustomerImpl;
import Insurance.Insurance;
import Insurance.InsuranceImpl;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public class Control {

	private int customerID;
	private ArrayList<Customer> customerList;
	private ArrayList<Insurance> insuranceList;
	public CustomerImpl m_CustomerImpl;
	public InsuranceImpl m_InsuranceImpl;
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
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param �����������
	 * @param ����ȭ��ȣ
	 * @param ����
	 * @param ����
	 * @param �̸�
	 * @param ����
	 * @param �ֹι�ȣ
	 */
	public boolean applyForMembership(String insurance, String phoneNum, int age, boolean gender, String name, String jop, String SSN){
		// ���� ��û�� �Ѵ� - ���� ��û�ϱ�
		// ��ȯ�� ����(void -> boolean)
		if(!checkInputImformation(insurance, phoneNum, age, SSN, name, jop)) return false;
		boolean result = m_ApplicationForMembershipListImpl.add(new ApplicationForMembership(insurance, phoneNum, age, gender, name, jop, SSN));
		return result;
		// �Է� �� ���� ������� ����
	}
	
	

	/**
	 * 
	 * @param id
	 * @param isYourBuilding
	 * @param isRemodel
	 * @param buildingOldPoint
	 * @param preventFirePoint
	 * @param buildingPositionPoint
	 * @param buildingStatusPoint
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
	}
	
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
	 * @param ���Աݾ�
	 */
	public boolean checkAmountOfInsuranceFee(int amountOfInsuranceFee){
		return false;
	}

	/**
	 * 
	 * @param �Է³�¥
	 */
	private String checkInputDateFormat(String date){
		// �Է� ��¥������ Ȯ���ϱ�
		return "";
	}

	/**
	 * 
	 * @param ������������̸�
	 * @param ����ȭ��ȣ
	 * @param ����
	 * @param ����
	 * @param �̸�
	 * @param ����
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
		return false;
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
		// ����� �̳��� ���� ����
		return 0;
	}

	public String deleteCustomerInformation(){
		// �� ������ �����Ѵ�
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
	 * @param choice
	 */
	public String enquireCustomerDetailInformation(int choice){
		// �� ���������� ��ȸ�Ѵ� - ���� �����ϱ�(choice : ���� ��ȣ)
		return "";
	}

	public String enquireCustomerInformation(){
		// �� ������ ��ȸ�Ѵ�
		return "";
	}

	/**
	 * 
	 * @param choice
	 */
	public String enquireEmergencyCustomerList(int choice){
		// ��� �� ��� ��ȸ�ϱ�
		return "";
	}

	/**
	 * 
	 * @param id
	 * @param �����ġ
	 * @param �������
	 */
	
	public String enquireEmployeeCallStatusImformation(String id, String accidentLocation, String accidentType){
		// ������ ������ ����Ѵ�
		return "";
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
		// �ű� ��������� ����Ѵ� - ���� �����ϱ�(�� �������� ��ȸ���� ����)
		return "";
	}

	public String enquirePassedCustomerInUW(){
		// �μ��ɻ� �հ� ���� ����Ѵ� - ���� �����ϱ�
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
	 * @param �ڵ��ɻ���
	 * @param ���ܽɻ���
	 * @param �̹����ɻ���
	 * @param Ư�νɻ���
	 * @param �Ϲݽɻ���
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
	}

	public String euqireInsuranceProductDesignForm(){
		// ���� ��ǰ ���� ��� ��ȸ�ϱ�
		return "";
	}

	/**
	 * 
	 * @param ����ȸ�����
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

	public String modifyCustomerInformation(){
		// �� ���� �����ϱ�
		return "";
	}

	public String payInsuranceMoney(){
		// ����� �����ϱ�
		return "";
	}

	/**
	 * 
	 * @param ���ο����
	 * @param id
	 */
	
	public String renewExpirationDate(String newExpirationDate, String id){
		// �������� �����Ѵ�
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
	 * @param ���Աݾ�
	 */
	
	public String saveAmountOfInsuranceFee(String id, int amountOfInsuranceFee){
		// �Է� ����ݾ� �����ϱ�
		return "";
	}

	/**
	 * 
	 * @param ����
	 * @param ���󰳹߾�
	 * @param �����ǰ�̸�
	 * @param �򰡾�
	 */
	
	public void saveCompensationManagementInformation(String targetCustomer, String compensationDevelopmentPlan, 
			String InsuranceProductName, String evaluation){
		// ������������ �����Ѵ�
	}

	public void saveInsuranceDesignContent(){
		// ���� ���� ���� �����ϱ�
	}
	/**
	 * 
	 * @param ��ȹ�ѳ���
	 */
	
	public String savePlannedContents(String plannedContents){
		// ��ȹ ���� �����ϱ�
		return "";
	}

	public void saveProductSalesSupportDetails(){
		// ��ǰ �Ǹ� ���� ���� ���� �����ϱ�
	}

}