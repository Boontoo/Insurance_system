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
 * @created 10-5-2022 ¿ÀÈÄ 9:00:55
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
	// Implµé ¸ðµÎ privateÀ¸·Î ¹Ù²Ü °Í

	public Control(){
		m_ApplicationForMembershipListImpl = new ApplicationForMembershipListImpl();
		m_ApplicationForMembershipListImpl.add(new ApplicationForMembership("º¸Çã¾ö", "010-3737-2855", 24, true, "À¯¹ÎÀç", "´ëÇÐ»ý", "990713-1058827"));
		m_ApplicationForMembershipListImpl.add(new ApplicationForMembership("º¸¾û", "010-3737-2855", 24, true, "È²Çý°æ", "´ëÇÐ»ý", "990713-1058827"));
		m_ApplicationForMembershipListImpl.add(new ApplicationForMembership("º¸Çã¾î¾î", "010-3737-2855", 24, true, "À¯Ã¶¹Î", "´ëÇÐ»ý", "990713-1058827"));
		// À§ ¼¼°³´Â ÀÓ½ÃÀÓ
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param °¡ÀÔÈñ¸Áº¸Çè
	 * @param °í°´ÀüÈ­¹øÈ£
	 * @param ³ªÀÌ
	 * @param ¼ºº°
	 * @param ÀÌ¸§
	 * @param Á÷¾÷
	 * @param ÁÖ¹Î¹øÈ£
	 */
	public boolean applyForMembership(String insurance, String phoneNum, int age, boolean gender, String name, String jop, String SSN){
		// °¡ÀÔ ½ÅÃ»À» ÇÑ´Ù - °¡ÀÔ ½ÅÃ»ÇÏ±â
		// ¹ÝÈ¯Çü º¯°æ(void -> boolean)
		if(!checkInputImformation(insurance, phoneNum, age, SSN, name, jop)) return false;
		boolean result = m_ApplicationForMembershipListImpl.add(new ApplicationForMembership(insurance, phoneNum, age, gender, name, jop, SSN));
		return result;
		// ÀÔ·Â °í°´ Á¤º¸ ÀúÀå±îÁö Æ÷ÇÔ
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
		// ÀÚµ¿ ½É»ç¸¦ ÁøÇàÇÑ´Ù - ÀÎ¼ö½É»ç ÁøÇàÇÏ±â
		// id´Â Áö¿öµµ µÉ µí?? °¡ÀÔ ½ÅÃ»ÇÑ º¸Çè¿¡ µû¶ó ÀÎ¼ö½É»ç ±âÁØÀ» ´Ù¸£°Ô µÎ·Á´Â °Çµ¥ ¿ì¼± ÀÎ¼ö½É»ç ±âÁØÀÌ 70Á¡ ÀÌ»ó ÇÏ³ª¶ó¼­ ÇöÀç´Â ÀÇ¹Ì ¾øÀ½
		// ÀÎ¼ö½É»ç ±âÁØÀÌ ¿©·¯°³ »ý±â¸é °¡ÀÔ½ÅÃ» Á¤º¸ÀÇ ½ÅÃ» º¸Çë ÀÌ¸§¿¡ µû¶ó ÀÎ¼ö½É»ç ±âÁØÀ» ´Ù¸£°Ô µÎ¾î¾ß ÇÔ
		if(!isOwnedBuilding) return false;
		int remodelPoint = isOwnedBuilding? 0:20; // ¸®¸ðµ¨ Á¡¼ö ´Ù½Ã È®ÀÎÇØ º¼ °Í
		int totalPoint = remodelPoint + buildingAgeScore + fireEquipmentConditionScore + buildingLocationScore + buildingConditionScore;
		if(totalPoint < 70) return false;
		return true;
	}
	
	public boolean checkAlreadyJudged(String id) {
		return m_ApplicationForMembershipListImpl.get(id).isUWExecutionStatus();
	}
	
	public boolean checkInID(String id) {
		// »õ·Î ¸¸µç ÇÔ¼ö
		return m_ApplicationForMembershipListImpl.checkInID(id);
	}
	public boolean checkPointInput(int buildingAgeScore, int fireEquipmentConditionScore, 
			int buildingLocationScore, int buildingConditionScore) {
		// »õ·Î ¸¸µç ÇÔ¼ö
		if(!(buildingAgeScore >= 0 && buildingAgeScore <= 20)) return false;
		if(!(fireEquipmentConditionScore >= 0 && fireEquipmentConditionScore <= 20)) return false;
		if(!(buildingLocationScore >= 0 && buildingLocationScore <= 20)) return false;
		if(!(buildingConditionScore >= 0 && buildingConditionScore <= 20)) return false;
		return true;
	}
	
	/**
	 * 
	 * @param ³³ÀÔ±Ý¾×
	 */
	public boolean checkAmountOfInsuranceFee(int amountOfInsuranceFee){
		return false;
	}

	/**
	 * 
	 * @param ÀÔ·Â³¯Â¥
	 */
	private String checkInputDateFormat(String date){
		// ÀÔ·Â ³¯Â¥Çü½ÄÀ» È®ÀÎÇÏ±â
		return "";
	}

	/**
	 * 
	 * @param °¡ÀÔÈñ¸Áº¸ÇèÀÌ¸§
	 * @param °í°´ÀüÈ­¹øÈ£
	 * @param ³ªÀÌ
	 * @param ¼ºº°
	 * @param ÀÌ¸§
	 * @param Á÷¾÷
	 */
	private boolean checkInputImformation(String insurance, String phoneNum, int age, String citizenNum, String name, String jop){
		// ÀÔ·Â Á¤º¸¸¦ È®ÀÎÇÑ´Ù - °¡ÀÔ ½ÅÃ»ÇÏ±â
		// ÆÄ¶ó¹ÌÅÍ(¼ºº° -> ÁÖ¹Î¹øÈ£)
		if(!checkKoreanFormat(name)) return false;
		if(!checkKoreanFormat(insurance)) return false;
		if(!checkPhoneNumFormat(phoneNum)) return false;
		if(!(age > 0 && age < 120)) return false;
		if(!checkKoreanFormat(jop)) return false;
		if(!checkCitizenNumFormat(citizenNum)) return false;
		return true;
	}
	private boolean checkKoreanFormat(String input) {
		// »õ·Î ¸¸µç ÇÔ¼ö(ÇÑ±Û¸¸ Á¸ÀçÇÏ´ÂÁö È®ÀÎ)
		if(input.matches(".*[°¡-ÆR]+.*")
				  && !input.matches(".*[¤¡-¤¾¤¿-¤Ó]+.*")
				  && !input.matches(".*[a-zA-Z]+.*")
	              && !input.matches(".*[0-9]+.*")
	              && !input.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+.*")) 
			return true;
		return false;
	}
	private boolean checkPhoneNumFormat(String input) {
		// »õ·Î ¸¸µç ÇÔ¼ö(ÈÞ´ëÆù ¹øÈ£¸¸ À¯È¿ ex010-3737-2855)
		if(input.length() != 13) return false;
		if(input.charAt(3) != '-' || input.charAt(8) != '-') return false;
		if(!input.substring(0, 3).equals("010")) return false;
		if(input.substring(4, 8).matches(".*[°¡-ÆR]+.*")
				|| input.substring(4, 8).matches(".*[¤¡-¤¾¤¿-¤Ó]+.*")
				|| input.substring(4, 8).matches(".*[a-zA-Z]+.*")
				|| input.substring(4, 8).matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+.*")) 
			return false;
		if(input.substring(9, 13).matches(".*[°¡-ÆR]+.*")
				|| input.substring(9, 13).matches(".*[¤¡-¤¾¤¿-¤Ó]+.*")
				|| input.substring(9, 13).matches(".*[a-zA-Z]+.*")
				|| input.substring(9, 13).matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+.*")) 
			return false;
		return true;
	}
	private boolean checkCitizenNumFormat(String input) {
		// »õ·Î ¸¸µç ÇÔ¼ö
		if(input.length() != 14) return false;
		if(input.charAt(6) != '-') return false;
		if(!(input.charAt(7) == '1'
				|| input.charAt(7) == '2'
				|| input.charAt(7) == '3'
				|| input.charAt(7) == '4')) return false;
		if(input.substring(0, 6).matches(".*[°¡-ÆR]+.*")
				|| input.substring(0, 6).matches(".*[¤¡-¤¾¤¿-¤Ó]+.*")
				|| input.substring(0, 6).matches(".*[a-zA-Z]+.*")
				|| input.substring(0, 6).matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+.*"))
			return false;
		if(input.substring(7, 14).matches(".*[°¡-ÆR]+.*")
				|| input.substring(7, 14).matches(".*[¤¡-¤¾¤¿-¤Ó]+.*")
				|| input.substring(7, 14).matches(".*[a-zA-Z]+.*")
				|| input.substring(7, 14).matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+.*"))
			return false;
		return true;
	}

	public int countInsuranceFeeNotPaid(){
		// º¸Çè·á ¹Ì³³ÀÔ °í°´À» ¼¾´Ù
		return 0;
	}

	public String deleteCustomerInformation(){
		// °í°´ Á¤º¸¸¦ »èÁ¦ÇÑ´Ù
		return "";
	}
	
	public String enquireApplicationForMembership(String id) {
		// »õ·Î ¸¸µç ÇÔ¼ö
		return m_ApplicationForMembershipListImpl.get(id).toString();
	}

	/**
	 * 
	 * @param customerName
	 */
	public String enquireAccidentInformation(String customerName){
		// »ç°íÁ¢¼ö Á¤º¸¸¦ Á¶È¸ÇÑ´Ù
		return "";
	}

	public String enquireAccidentList(){
		// »ç°í ¸ñ·Ï Á¶È¸ÇÏ±â
		return "";
	}

	/**
	 * 
	 * @param choice
	 */
	public String enquireCustomerDetailInformation(int choice){
		// °í°´ ¼¼ºÎÁ¤º¸¸¦ Á¶È¸ÇÑ´Ù - º¸Çè °¡ÀÔÇÏ±â(choice : ¼±ÅÃ ¹øÈ£)
		return "";
	}

	public String enquireCustomerInformation(){
		// °í°´ Á¤º¸¸¦ Á¶È¸ÇÑ´Ù
		return "";
	}

	/**
	 * 
	 * @param choice
	 */
	public String enquireEmergencyCustomerList(int choice){
		// ±ä±Þ °í°´ ¸ñ·Ï Á¶È¸ÇÏ±â
		return "";
	}

	/**
	 * 
	 * @param id
	 * @param »ç°íÀ§Ä¡
	 * @param »ç°íÀ¯Çü
	 */
	
	public String enquireEmployeeCallStatusImformation(String id, String accidentLocation, String accidentType){
		// Á÷¿øÄÝ Á¤º¸¸¦ Ãâ·ÂÇÑ´Ù
		return "";
	}

	public String enquireExpirationContractInformation(){
		// ¸¸±â °è¾àÁ¤º¸¸¦ Á¶È¸ÇÑ´Ù
		return "";
	}

	public String enquireInformationAboutApplicationForMembership(){
		// °¡ÀÔ ½ÅÃ» Á¤º¸¸¦ Á¶È¸ÇÑ´Ù - ÀÎ¼ö½É»ç ÁøÇàÇÏ±â
		return m_ApplicationForMembershipListImpl.toString();
	}

	public String enquireInsuranceFeePaymentStatus(){
		// º¸Çè·á ³³ÀÔ Á¤º¸¸¦ Á¶È¸ÇÑ´Ù
		return "";
	}

	public String enquireInsuranceList(){
		// º¸Çè ¸®½ºÆ® Á¶È¸ÇÏ±â
		return "";
	}

	/**
	 * 
	 * @param choice
	 */
	public String enquireInsuranceProductDetails(int choice){
		// º¸Çè »óÇ° ¼¼ºÎ Á¤º¸ Á¶È¸ÇÏ±â
		return "";
	}

	public String enquireInsuranceProductDevelopmentInformation(){
		// º¸Çè »óÇ° °³¹ß Á¤º¸ Á¶È¸ÇÏ±â
		return "";
	}

	public String enquireNewContractInformation(){
		// ½Å±Ô °è¾àÁ¤º¸¸¦ Ãâ·ÂÇÑ´Ù - º¸Çè °¡ÀÔÇÏ±â(°í°´ ¼¼ºÎÁ¤º¸ Á¶È¸°úÁ¤ Æ÷ÇÔ)
		return "";
	}

	public String enquirePassedCustomerInUW(){
		// ÀÎ¼ö½É»ç ÇÕ°Ý °í°´À» Ãâ·ÂÇÑ´Ù - º¸Çè °¡ÀÔÇÏ±â
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
		// Á¦Ç° ÆÇ¸Å Áö¿ø ¼¼ºÎÁ¤º¸ Áö¿øÇÏ±â..?
	}

	/**
	 * 
	 * @param ÀÚµ¿½É»ç°á°ú
	 * @param Áø´Ü½É»ç°á°ú
	 * @param ÀÌ¹ÌÁö½É»ç°á°ú
	 * @param Æ¯ÀÎ½É»ç°á°ú
	 * @param ÀÏ¹Ý½É»ç°á°ú
	 */
	public String enquireUWResult(String id, boolean automaticExaminationResult, boolean diagnosticExaminationResult, 
			boolean imageExaminationResult, boolean specialExaminationResult, boolean generalExaminationResult){
		// ÀÎ¼ö½É»ç °á°ú¸¦ È®ÀÎÇÑ´Ù - ÀÎ¼ö½É»ç ÁøÇàÇÏ±â
		// ÀÎ¼ö½É»ç ½ÇÇà ¿©ºÎ ¼öÁ¤, ½É»ç °á°ú ¼öÁ¤ Æ÷ÇÔ - ÀÌÈÄ ¹®±¸ Ãâ·Â
		// ÆÄ¶ó¹ÌÅÍ Ãß°¡(String id)
		String result = "ÀÎ¼ö½É»ç¿¡ ºÒÇÕ°ÝÇÏ¿´½À´Ï´Ù\n»çÀ¯ : ";
		m_ApplicationForMembershipListImpl.get(id).setUWExecutionStatus(true);
		if(!automaticExaminationResult) return result += "ÀÚµ¿½É»ç";
		if(!diagnosticExaminationResult) return result += "Áø´Ü½É»ç";
		if(!imageExaminationResult) return result += "ÀÌ¹ÌÁö½É»ç";
		if(!specialExaminationResult) return result += "Æ¯ÀÎ½É»ç";
		if(!generalExaminationResult) return result += "ÀÏ¹Ý½É»ç";
		m_ApplicationForMembershipListImpl.get(id).setUWResult(true);
		result = "ÀÎ¼ö½É»ç¿¡ ÇÕ°ÝÇÏ¿´½À´Ï´Ù";
		return result;
	}

	public String euqireInsuranceProductDesignForm(){
		// º¸Çè »óÇ° ¼³°è ¾ç½Ä Á¶È¸ÇÏ±â
		return "";
	}

	/**
	 * 
	 * @param ¿¬ÀåµÈ¸¸·áÀÏ
	 */
	public String extendContract(String extendedExpirationDate){
		// °è¾à ¿¬ÀåÇÏ±â
	    return "";
	 }

	public String initializeInsuranceFeePaymentStatus(){
		// º¸Çè·á ³³ÀÔ¿©ºÎ¸¦ ÃÊ±âÈ­ÇÑ´Ù
		return "";
	}

	public void makeDecisionInsuranceProduct(){
		// º¸Çè »óÇ° °áÁ¤...?
	}

	/**
	 * 
	 * @param id
	 */
	public boolean makeInsuranceContract(String id){
		// º¸Çè °è¾àÀ» ÇÑ´Ù
		return false;
	}

	public String modifyCustomerInformation(){
		// °í°´ Á¤º¸ ¼öÁ¤ÇÏ±â
		return "";
	}

	public String payInsuranceMoney(){
		// º¸Çè±Ý Áö±ÞÇÏ±â
		return "";
	}

	/**
	 * 
	 * @param »õ·Î¿î¸¸±âÀÏ
	 * @param id
	 */
	
	public String renewExpirationDate(String newExpirationDate, String id){
		// ¸¸±âÀÏÀ» °»½ÅÇÑ´Ù
		return "";
	}

	public void requestAuthorizationOfCompany(){
		// È¸»ç ½ÂÀÎ ¿äÃ» ¹Þ±â

	}

	public void requestAuthorizationOfFSS(){
		// FSS¿¡ °üÇÑ ºÎ¿©¸¦ ¿äÃ»ÇÏ±â...?
	}

	/**
	 * 
	 * @param id
	 * @param ³³ÀÔ±Ý¾×
	 */
	
	public String saveAmountOfInsuranceFee(String id, int amountOfInsuranceFee){
		// ÀÔ·Â º¸Çè±Ý¾× ÀúÀåÇÏ±â
		return "";
	}

	/**
	 * 
	 * @param ´ë»ó°í°´
	 * @param º¸»ó°³¹ß¾È
	 * @param º¸Çè»óÇ°ÀÌ¸§
	 * @param Æò°¡¾È
	 */
	
	public void saveCompensationManagementInformation(String targetCustomer, String compensationDevelopmentPlan, 
			String InsuranceProductName, String evaluation){
		// º¸»ó¿î¿ëÁ¤º¸¸¦ ÀúÀåÇÑ´Ù
	}

	public void saveInsuranceDesignContent(){
		// º¸Çè ¼³°è ³»¿ë ÀúÀåÇÏ±â
	}
	/**
	 * 
	 * @param ±âÈ¹ÇÑ³»¿ë
	 */
	
	public String savePlannedContents(String plannedContents){
		// °èÈ¹ ³»¿ë ÀúÀåÇÏ±â
		return "";
	}

	public void saveProductSalesSupportDetails(){
		// Á¦Ç° ÆÇ¸Å Áö¿ø ¼¼ºÎ Á¤º¸ ÀúÀåÇÏ±â
	}

}