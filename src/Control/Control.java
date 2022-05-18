package Control;

import java.util.ArrayList;
import java.util.regex.Pattern;

import AccidentReception.AccidentReception;
import AccidentReception.AccidentReceptionListImpl;
import ApplicationForMembership.ApplicationForMembership;
import ApplicationForMembership.ApplicationForMembershipListImpl;
import CompensationManagement.CompensationManagementListImpl;
import Contract.Contract;
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
	// Impl들 모두 private으로 바꿀 것

	public Control(){
		this.m_CustomerListImpl = new CustomerListImpl();
		this.m_AccidentReceptionListImpl = new AccidentReceptionListImpl();
		this.m_ContractListImpl = new ContractListImpl();
		this.m_ApplicationForMembershipListImpl = new ApplicationForMembershipListImpl();
		this.m_ApplicationForMembershipListImpl.add(new ApplicationForMembership("보허엄", "010-3737-2855", 24, true, "유민재", "대학생", "990713-1058827"));
		this.m_ApplicationForMembershipListImpl.add(new ApplicationForMembership("보엉", "010-3737-2855", 24, true, "황혜경", "대학생", "990713-1058827"));
		this.m_ApplicationForMembershipListImpl.add(new ApplicationForMembership("보허어어", "010-3737-2855", 24, true, "유철민", "대학생", "990713-1058827"));
		// 위 세개는 임시임
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
		// 가입 신청을 한다 - 가입 신청하기
		// 반환형 변경(void -> boolean)
		if(!checkInputImformation(insurance, phoneNum, age, SSN, name, jop)) return false;
		boolean result = m_ApplicationForMembershipListImpl.add(new ApplicationForMembership(insurance, phoneNum, age, gender, name, jop, SSN));
		return result;
		// 입력 고객 정보 저장까지 포함
	}

	
	

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
		// 자동 심사를 진행한다 - 인수심사 진행하기
		// id는 지워도 될 듯?? 가입 신청한 보험에 따라 인수심사 기준을 다르게 두려는 건데 우선 인수심사 기준이 70점 이상 하나라서 현재는 의미 없음
		// 인수심사 기준이 여러개 생기면 가입신청 정보의 신청 보헝 이름에 따라 인수심사 기준을 다르게 두어야 함
		if(!isOwnedBuilding) return false;
		int remodelPoint = isOwnedBuilding? 0:20; // 리모델 점수 다시 확인해 볼 것
		int totalPoint = remodelPoint + buildingAgeScore + fireEquipmentConditionScore + buildingLocationScore + buildingConditionScore;
		if(totalPoint < 70) return false;
		return true;
	}
	
	public boolean checkAlreadyJudged(String id) {
		return m_ApplicationForMembershipListImpl.get(id).isUWExecutionStatus();
	}
	
	public boolean checkInID(String id) {
		// 새로 만든 함수
		return m_ApplicationForMembershipListImpl.checkInID(id);
	}
	public boolean checkPointInput(int buildingAgeScore, int fireEquipmentConditionScore, 
			int buildingLocationScore, int buildingConditionScore) {
		// 새로 만든 함수
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
		// 입력 날짜형식을 확인하기
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
		// 입력 정보를 확인한다 - 가입 신청하기
		// 파라미터(성별 -> 주민번호)
		if(!checkKoreanFormat(name)) return false;
		if(!checkKoreanFormat(insurance)) return false;
		if(!checkPhoneNumFormat(phoneNum)) return false;
		if(!(age > 0 && age < 120)) return false;
		if(!checkKoreanFormat(jop)) return false;
		if(!checkCitizenNumFormat(citizenNum)) return false;
		return true;
	}
	private boolean checkKoreanFormat(String input) {
		// 새로 만든 함수(한글만 존재하는지 확인)
		if(input.matches(".*[가-힣]+.*")
				&& !input.matches(".*[ㄱ-ㅎㅏ-ㅣ]+.*")
				&& !input.matches(".*[a-zA-Z]+.*")
				&& !input.matches(".*[0-9]+.*")
				&& !input.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+.*")) 
			return true;
		return false;
	}

	private boolean checkPhoneNumFormat(String input) {
		// 새로 만든 함수(휴대폰 번호만 유효 ex010-3737-2855)
		if(input.length() != 13) return false;
		if(input.charAt(3) != '-' || input.charAt(8) != '-') return false;
		if(!input.substring(0, 3).equals("010")) return false;
		if(input.substring(4, 8).matches(".*[가-힣]+.*")
				|| input.substring(4, 8).matches(".*[ㄱ-ㅎㅏ-ㅣ]+.*")
				|| input.substring(4, 8).matches(".*[a-zA-Z]+.*")
				|| input.substring(4, 8).matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+.*")) 
			return false;
		if(input.substring(9, 13).matches(".*[가-힣]+.*")
				|| input.substring(9, 13).matches(".*[ㄱ-ㅎㅏ-ㅣ]+.*")
				|| input.substring(9, 13).matches(".*[a-zA-Z]+.*")
				|| input.substring(9, 13).matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+.*")) 
			return false;
		return true;
	}
	private boolean checkCitizenNumFormat(String input) {
		// 새로 만든 함수
		if(input.length() != 14) return false;
		if(input.charAt(6) != '-') return false;
		if(!(input.charAt(7) == '1'
				|| input.charAt(7) == '2'
				|| input.charAt(7) == '3'
				|| input.charAt(7) == '4')) return false;
		if(input.substring(0, 6).matches(".*[가-힣]+.*")
				|| input.substring(0, 6).matches(".*[ㄱ-ㅎㅏ-ㅣ]+.*")
				|| input.substring(0, 6).matches(".*[a-zA-Z]+.*")
				|| input.substring(0, 6).matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+.*"))
			return false;
		if(input.substring(7, 14).matches(".*[가-힣]+.*")
				|| input.substring(7, 14).matches(".*[ㄱ-ㅎㅏ-ㅣ]+.*")
				|| input.substring(7, 14).matches(".*[a-zA-Z]+.*")
				|| input.substring(7, 14).matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+.*"))
			return false;
		return true;
	}


	public int countInsuranceFeeNotPaid(){
		// 보험료 미납입 고객을 센다
		return 0;
	}

	public String deleteCustomerInformation(int index, String id){
		// 고객 정보를 삭제한다
		boolean bDelete = false;
		if(this.customerList.get(index-1).getId().equals(id)) {
			// 고객ID가 확인되었습니다. 메시지 출력 필요
			String result = "고객ID가 확인되었습니다.";
			bDelete = this.m_CustomerListImpl.delete(id);
			if(bDelete) {
				// 삭제완료
				result = result + "\n" + "삭제완료되었습니다.";
				return result;
			}
		}
		
		return "고객ID와 일치하지 않습니다. 다시 입력해주세요.";
	}

	public String enquireApplicationForMembership(String id) {
		// 새로 만든 함수
		return m_ApplicationForMembershipListImpl.get(id).toString();
	}

	/**
	 * 
	 * @param customerName
	 * @param phoneNum 
	 */
	public String enquireAccidentInformation(String customerName, String phoneNum){
		// 사고접수 정보를 조회한다
		this.customerList = this.m_CustomerListImpl.get(1, customerName);
		ArrayList<String> accidentIds = new ArrayList<String>();
		Customer customer = null;
		for(Customer customer1 : this.customerList) {
			if(customer1.getPhoneNum().equals(customerName)) customer = customer1;
		}
		// customer가 null일 때 null처리
		accidentIds = customer.getAccidentId();
		String accidentId = accidentIds.get(accidentIds.size()-1);
		AccidentReception accidentReception = this.m_AccidentReceptionListImpl.get(accidentId);
		
		String contractID = accidentReception.getContractID();
		Contract contract = m_ContractListImpl.get(contractID);
		String insuranceName = contract.getInsuranceName();
		
		int remainingNumberOfTowTruckCalls = accidentReception.getRemainingNumberOfTowTruckCalls();
		
		String result = "";
		result = result + "보험이름: " + insuranceName + ", ";
		result = result + "잔여 무료 렉카 서비스 횟수: " + remainingNumberOfTowTruckCalls;
		
//		break;
//		this.m_AccidentReceptionListImpl.get
		return result;
	}

	public String enquireAccidentList(){
		// 사고 목록 조회하기
		return "";
	}

	/**
	 * 
	 * @param type
	 * @param key
	 */
	public String enquireCustomerInformation(int type, String key){
		// 고객 정보를 조회한다
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
		// 고객 세부정보를 조회한다 - 보험 가입하기(choice : 선택 번호)
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
		// 긴급 고객 목록 조회하기
		return "";
	}

	/**
	 * 
	 * @param id
	 * @param accidentLocation
	 * @param accidentType
	 */
	
	public String enquireEmployeeCallStatusInformation(String id, String accidentLocation, String accidentType){
		// 직원콜 정보를 출력한다
		AccidentReception accidentReception = m_AccidentReceptionListImpl.get(id);
		String temp =  accidentReception.getAccidentID()+" "+accidentReception.getCustomerID()
		+" "+accidentReception.getCustomerName()+" "+accidentReception.isEmployeeCallStatus()
		+" "+accidentReception.getRemainingNumberOfTowTruckCalls()+" "+accidentReception.isTowTruckCallPresent();
		return temp;
	}
	
	public void saveAccident(AccidentReception AccidentReception) {

	}

	public String enquireExpirationContractInformation(){
		// 만기 계약정보를 조회한다
		return "";
	}

	public String enquireInformationAboutApplicationForMembership(){
		 // 가입 신청 정보를 조회한다 - 인수심사 진행하기
		return m_ApplicationForMembershipListImpl.toString();
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
		// 제품 판매 지원 세부정보 지원하기..?
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
		// 인수심사 결과를 확인한다 - 인수심사 진행하기
		// 인수심사 실행 여부 수정, 심사 결과 수정 포함 - 이후 문구 출력
		// 파라미터 추가(String id)
		String result = "인수심사에 불합격하였습니다\n사유 : ";
		m_ApplicationForMembershipListImpl.get(id).setUWExecutionStatus(true);
		if(!automaticExaminationResult) return result += "자동심사";
		if(!diagnosticExaminationResult) return result += "진단심사";
		if(!imageExaminationResult) return result += "이미지심사";
		if(!specialExaminationResult) return result += "특인심사";
		if(!generalExaminationResult) return result += "일반심사";
		m_ApplicationForMembershipListImpl.get(id).setUWResult(true);
		result = "인수심사에 합격하였습니다";
		return result;
	}


	public String euqireInsuranceProductDesignForm(){
		// 보험 상품 설계 양식 조회하기
		return "";
	}

	/**
	 * 
	 * @param extendedExpirationDate
	 */
	public String extendContract(String extendedExpirationDate){
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

	public String modifyCustomerInformation(int index, int type, String newInformation){
		// 고객 정보 수정하기
		switch(type) {
		case 1:
			this.customerList.get(index-1).setName(newInformation);
			break;
		case 2:
			this.customerList.get(index-1).setAge(Integer.parseInt(newInformation));
			break;
		case 3:
//			this.customerList.get(index).setJob
			break;
		case 4:
			this.customerList.get(index-1).setPhoneNum(newInformation);
			break;
		}
//		this.customerList.get(index).set
		return "저장되었습니다!";
	}

	public String payInsuranceMoney(){
		// 보험금 지급하기
		return "";
	}


	/**
	 * 
	 * @param newExpirationDate
	 * @param id
	 */
	public String renewExpirationDate(String newExpirationDate, String id){
		// 만기일을 갱신한다
		return "";
	}

	public void requestAuthorizationOfCompany(){
		// 회사 승인 요청 받기

	}

	public void requestAuthorizationOfFSS(){
		// FSS(금융감독원)에 관한 부여를 요청하기...?
	}


	/**
	 * 
	 * @param id
	 * @param amountOfInsuranceFee
	 */
	public String saveAmountOfInsuranceFee(String id, int amountOfInsuranceFee){
		// 입력 보험금액 저장하기
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
		// 보상운용정보를 저장한다
	}

	public void saveInsuranceDesignContent(){
		// 보험 설계 내용 저장하기
	}
	/**
	 * 
	 * @param plannedContents
	 */
	public String savePlannedContents(String plannedContents){
		// 계획 내용 저장하기
		return "";
	}

	public void saveProductSalesSupportDetails(){
		// 제품 판매 지원 세부 정보 저장하기
	}



}