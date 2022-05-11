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
 * @created 10-5-2022 오후 9:00:55
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
	 * @param 가입희망보험
	 * @param 고객전화번호
	 * @param 나이
	 * @param 성별
	 * @param 이름
	 * @param 직업
	 * @param 주민번호
	 */
	public void applyForMembership(String name, String wishInsurance, String phoneNum, int age, boolean gender, String jop, String citizenNum){
		// 가입 신청하기
		String genderStr = gender? "남자":"여자";
		System.out.println(name+", "+wishInsurance+", "+phoneNum+", "+age+", "+genderStr+", "+jop+", "+citizenNum);
	}

	/**
	 * 
	 * @param id
	 * @param 본인소유건물
	 * @param 리모델링여부
	 * @param 건물연식점수
	 * @param 화재설비상태점수
	 * @param 건물위치점수
	 * @param 건물상태점수
	 */
	public boolean automaticJudge(String id, boolean 본인소유건물, boolean 리모델링여부, int 건물연식점수, int 화재설비상태점수, int 건물위치점수, int 건물상태점수){
		return false;
	}

	/**
	 * 
	 * @param 납입금액
	 */
	public boolean checkAmountOfInsuranceFee(int 납입금액){
		return false;
	}

	/**
	 * 
	 * @param 입력날짜
	 */
	private String checkInputDateFormat(String 입력날짜){
		return "";
	}

	/**
	 * 
	 * @param 가입희망보험이름
	 * @param 고객전화번호
	 * @param 나이
	 * @param 성별
	 * @param 이름
	 * @param 직업
	 */
	private boolean checkInputImformation(String 가입희망보험이름, String 고객전화번호, int 나이, boolean 성별, String 이름, String 직업){
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
	 * @param 가입고객이름
	 */
	public String enquireAccidentInformation(String 가입고객이름){
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
	 * @param 사고위치
	 * @param 사고유형
	 */
	public String enquireEmployeeCallStatusImformation(String id, String 사고위치, String 사고유형){
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
	 * @param 자동심사결과
	 * @param 진단심사결과
	 * @param 이미지심사결과
	 * @param 특인심사결과
	 * @param 일반심사결과
	 */
	public String enquireUWResult(boolean 자동심사결과, boolean 진단심사결과, boolean 이미지심사결과, boolean 특인심사결과, boolean 일반심사결과){
		return "";
	}

	public String euqireInsuranceProductDesignForm(){
		return "";
	}

	/**
	 * 
	 * @param 연장된만료일
	 */
	public String extendContract(String 연장된만료일){
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
	 * @param 새로운만기일
	 * @param id
	 */
	public String renewExpirationDate(String 새로운만기일, String id){
		return "";
	}

	public void requestAuthorizationOfCompany(){

	}

	public void requestAuthorizationOfFSS(){

	}

	/**
	 * 
	 * @param id
	 * @param 납입금액
	 */
	public String saveAmountOfInsuranceFee(String id, int 납입금액){
		return "";
	}

	/**
	 * 
	 * @param 대상고객
	 * @param 보상개발안
	 * @param 보험상품이름
	 * @param 평가안
	 */
	public void saveCompensationManagementInformation(String 대상고객, String 보상개발안, String 보험상품이름, String 평가안){

	}

	public void saveInsuranceDesignContent(){

	}

	/**
	 * 
	 * @param 기획한내용
	 */
	public String savePlannedContents(String 기획한내용){
		return "";
	}

	public void saveProductSalesSupportDetails(){

	}

}