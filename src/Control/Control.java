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
		// 가입 신청을 한다 - 가입 신청하기
		String genderStr = gender? "남자":"여자";
		System.out.println(name+", "+wishInsurance+", "+phoneNum+", "+age+", "+genderStr+", "+jop+", "+citizenNum);
		// 입력 고객 정보 저장까지 포함
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
		// 자동 심사를 진행한다 - 인수심사 진행하기
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
		// 입력 날짜형식을 확인하기
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
		// 입력 정보를 확인한다 - 가입 신청하기
		return false;
	}

	public int countInsuranceFeeNotPaid(){
		// 보험료 미납입 고객을 센다
		return 0;
	}

	public String deleteCustomerInformation(){
		// 고객 정보를 삭제한다
		return "";
	}

	/**
	 * 
	 * @param 가입고객이름
	 */
	public String enquireAccidentInformation(String 가입고객이름){
		// 사고접수 정보를 조회한다
		return "";
	}

	public String enquireAccidentList(){
		// 사고 목록 조회하기
		return "";
	}

	/**
	 * 
	 * @param choice
	 */
	public String enquireCustomerDetailInformation(int choice){
		// 고객 세부정보를 조회한다 - 보험 가입하기(choice : 선택 번호)
		return "";
	}

	public String enquireCustomerInformation(){
		// 고객 정보를 조회한다
		return "";
	}

	/**
	 * 
	 * @param choice
	 */
	public String enquireEmergencyCustomerList(int choice){
		// 긴급 고객 목록 조회하기
		return "";
	}

	/**
	 * 
	 * @param id
	 * @param 사고위치
	 * @param 사고유형
	 */
	public String enquireEmployeeCallStatusImformation(String id, String 사고위치, String 사고유형){
		// 직원콜 정보를 출력한다
		return "";
	}

	public String enquireExpirationContractInformation(){
		// 만기 계약정보를 조회한다
		return "";
	}

	public String enquireInformationAboutApplicationForMembership(){
		// 가입 신청 정보를 조회한다 - 인수심사 진행하기
		return "";
	}

	public String enquireInsuranceFeePaymentStatus(){
		// 보험료 납입 정보를 조회한다
		return "";
	}

	public String enquireInsuranceList(){
		// 보험 리스트 조회하기
		return "";
	}

	/**
	 * 
	 * @param choice
	 */
	public String enquireInsuranceProductDetails(int choice){
		// 보험 상품 세부 정보 조회하기
		return "";
	}

	public String enquireInsuranceProductDevelopmentInformation(){
		// 보험 상품 개발 정보 조회하기
		return "";
	}

	public String enquireNewContractInformation(){
		// 신규 계약정보를 출력한다 - 보험 가입하기(고객 세부정보 조회과정 포함)
		return "";
	}

	public String enquirePassedCustomerInUW(){
		// 인수심사 합격 고객을 출력한다 - 보험 가입하기
		return "";
	}

	public void enquireProductSalesSupportDetails(){
		// 제품 판매 지원 세부정보 지원하기..?
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
		// 인수심사 결과를 확인한다 - 인수심사 진행하기
		// 인수심사 실행 여부 수정, 심사 결과 수정 포험 - 이후 문구 출력
		return "";
	}

	public String euqireInsuranceProductDesignForm(){
		// 보험 상품 설계 양식 조회하기
		return "";
	}

	/**
	 * 
	 * @param 연장된만료일
	 */
	public String extendContract(String 연장된만료일){
		// 계약 연장하기
		return "";
	}

	public String initializeInsuranceFeePaymentStatus(){
		// 보험료 납입여부를 초기화한다
		return "";
	}

	public void makeDecisionInsuranceProduct(){
		// 보험 상품 결정...?
	}

	/**
	 * 
	 * @param id
	 */
	public boolean makeInsuranceContract(String id){
		// 보험 계약을 한다
		return false;
	}

	public String modifyCustomerInformation(){
		// 고객 정보 수정하기
		return "";
	}

	public String payInsuranceMoney(){
		// 보험금 지급하기
		return "";
	}

	/**
	 * 
	 * @param 새로운만기일
	 * @param id
	 */
	public String renewExpirationDate(String 새로운만기일, String id){
		// 만기일을 갱신한다
		return "";
	}

	public void requestAuthorizationOfCompany(){
		// 회사 승인 요청 받기

	}

	public void requestAuthorizationOfFSS(){
		// FSS에 관한 부여를 요청하기...?
	}

	/**
	 * 
	 * @param id
	 * @param 납입금액
	 */
	public String saveAmountOfInsuranceFee(String id, int 납입금액){
		// 입력 보험금액 저장하기
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
		// 보상운용정보를 저장한다
	}

	public void saveInsuranceDesignContent(){
		// 보험 설계 내용 저장하기
	}

	/**
	 * 
	 * @param 기획한내용
	 */
	public String savePlannedContents(String 기획한내용){
		// 계획 내용 저장하기
		return "";
	}

	public void saveProductSalesSupportDetails(){
		// 제품 판매 지원 세부 정보 저장하기
	}

}