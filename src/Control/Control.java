package Control;
import java.util.ArrayList;

import AccidentReception.AccidentReceptionListImpl;
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

	public Control(){

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
	public void applyForMembership(String name, String wishInsurance, String phoneNum, int age, boolean gender, String jop, String citizenNum){
		// ���� ��û�� �Ѵ� - ���� ��û�ϱ�
		String genderStr = gender? "����":"����";
		System.out.println(name+", "+wishInsurance+", "+phoneNum+", "+age+", "+genderStr+", "+jop+", "+citizenNum);
		// �Է� �� ���� ������� ����
	}

	/**
	 * 
	 * @param id
	 * @param ���μ����ǹ�
	 * @param ���𵨸�����
	 * @param �ǹ���������
	 * @param ȭ�缳���������
	 * @param �ǹ���ġ����
	 * @param �ǹ���������
	 */
	public boolean automaticJudge(String id, boolean ���μ����ǹ�, boolean ���𵨸�����, int �ǹ���������, int ȭ�缳���������, int �ǹ���ġ����, int �ǹ���������){
		// �ڵ� �ɻ縦 �����Ѵ� - �μ��ɻ� �����ϱ�
		return false;
	}

	/**
	 * 
	 * @param ���Աݾ�
	 */
	public boolean checkAmountOfInsuranceFee(int ���Աݾ�){
		return false;
	}

	/**
	 * 
	 * @param �Է³�¥
	 */
	private String checkInputDateFormat(String �Է³�¥){
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
	private boolean checkInputImformation(String ������������̸�, String ����ȭ��ȣ, int ����, boolean ����, String �̸�, String ����){
		// �Է� ������ Ȯ���Ѵ� - ���� ��û�ϱ�
		return false;
	}

	public int countInsuranceFeeNotPaid(){
		// ����� �̳��� ���� ����
		return 0;
	}

	public String deleteCustomerInformation(){
		// �� ������ �����Ѵ�
		return "";
	}

	/**
	 * 
	 * @param ���԰��̸�
	 */
	public String enquireAccidentInformation(String ���԰��̸�){
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
	public String enquireEmployeeCallStatusImformation(String id, String �����ġ, String �������){
		// ������ ������ ����Ѵ�
		return "";
	}

	public String enquireExpirationContractInformation(){
		// ���� ��������� ��ȸ�Ѵ�
		return "";
	}

	public String enquireInformationAboutApplicationForMembership(){
		// ���� ��û ������ ��ȸ�Ѵ� - �μ��ɻ� �����ϱ�
		return "";
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
		return "";
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
	public String enquireUWResult(boolean �ڵ��ɻ���, boolean ���ܽɻ���, boolean �̹����ɻ���, boolean Ư�νɻ���, boolean �Ϲݽɻ���){
		// �μ��ɻ� ����� Ȯ���Ѵ� - �μ��ɻ� �����ϱ�
		// �μ��ɻ� ���� ���� ����, �ɻ� ��� ���� ���� - ���� ���� ���
		return "";
	}

	public String euqireInsuranceProductDesignForm(){
		// ���� ��ǰ ���� ��� ��ȸ�ϱ�
		return "";
	}

	/**
	 * 
	 * @param ����ȸ�����
	 */
	public String extendContract(String ����ȸ�����){
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
	public String renewExpirationDate(String ���ο����, String id){
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
	public String saveAmountOfInsuranceFee(String id, int ���Աݾ�){
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
	public void saveCompensationManagementInformation(String ����, String ���󰳹߾�, String �����ǰ�̸�, String �򰡾�){
		// ������������ �����Ѵ�
	}

	public void saveInsuranceDesignContent(){
		// ���� ���� ���� �����ϱ�
	}

	/**
	 * 
	 * @param ��ȹ�ѳ���
	 */
	public String savePlannedContents(String ��ȹ�ѳ���){
		// ��ȹ ���� �����ϱ�
		return "";
	}

	public void saveProductSalesSupportDetails(){
		// ��ǰ �Ǹ� ���� ���� ���� �����ϱ�
	}

}