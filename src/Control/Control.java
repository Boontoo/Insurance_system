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
		// ���� ��û�ϱ�
		String genderStr = gender? "����":"����";
		System.out.println(name+", "+wishInsurance+", "+phoneNum+", "+age+", "+genderStr+", "+jop+", "+citizenNum);
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
		return false;
	}

	public int countInsuranceFeeNotPaid(){
		return 0;
	}

	public String deleteCustomerInformation(){
		return "";
	}

	/**
	 * 
	 * @param ���԰��̸�
	 */
	public String enquireAccidentInformation(String ���԰��̸�){
		return "";
	}

	public String enquireAccidentList(){
		return "";
	}

	/**
	 * 
	 * @param choice
	 */
	public String enquireCustomerDetailInformation(int choice){
		return "";
	}

	public String enquireCustomerInformation(){
		return "";
	}

	/**
	 * 
	 * @param choice
	 */
	public String enquireEmergencyCustomerList(int choice){
		return "";
	}

	/**
	 * 
	 * @param id
	 * @param �����ġ
	 * @param �������
	 */
	public String enquireEmployeeCallStatusImformation(String id, String �����ġ, String �������){
		return "";
	}

	public String enquireExpirationContractInformation(){
		return "";
	}

	public String enquireInformationAboutApplicationForMembership(){
		return "";
	}

	public String enquireInsuranceFeePaymentStatus(){
		return "";
	}

	public String enquireInsuranceList(){
		return "";
	}

	/**
	 * 
	 * @param choice
	 */
	public String enquireInsuranceProductDetails(int choice){
		return "";
	}

	public String enquireInsuranceProductDevelopmentInformation(){
		return "";
	}

	public String enquireNewContractInformation(){
		return "";
	}

	public String enquirePassedCustomerInUW(){
		return "";
	}

	public void enquireProductSalesSupportDetails(){

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
		return "";
	}

	public String euqireInsuranceProductDesignForm(){
		return "";
	}

	/**
	 * 
	 * @param ����ȸ�����
	 */
	public String extendContract(String ����ȸ�����){
		return "";
	}

	public String initializeInsuranceFeePaymentStatus(){
		return "";
	}

	public void makeDecisionInsuranceProduct(){

	}

	/**
	 * 
	 * @param id
	 */
	public boolean makeInsuranceContract(String id){
		return false;
	}

	public String modifyCustomerInformation(){
		return "";
	}

	public String payInsuranceMoney(){
		return "";
	}

	/**
	 * 
	 * @param ���ο����
	 * @param id
	 */
	public String renewExpirationDate(String ���ο����, String id){
		return "";
	}

	public void requestAuthorizationOfCompany(){

	}

	public void requestAuthorizationOfFSS(){

	}

	/**
	 * 
	 * @param id
	 * @param ���Աݾ�
	 */
	public String saveAmountOfInsuranceFee(String id, int ���Աݾ�){
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

	}

	public void saveInsuranceDesignContent(){

	}

	/**
	 * 
	 * @param ��ȹ�ѳ���
	 */
	public String savePlannedContents(String ��ȹ�ѳ���){
		return "";
	}

	public void saveProductSalesSupportDetails(){

	}

}