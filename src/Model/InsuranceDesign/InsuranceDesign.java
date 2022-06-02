package Model.InsuranceDesign;

public class InsuranceDesign {
	
	private String designID; //설계ID
	
	//기획 part
	///////////////////////////////////////////////////
	private String insuranceName;
	private String insuranceContent;
	private String planningPurpose;
	///////////////////////////////////////////////////
	
	private int target; //보장,판매대상
	private int premiumRate; //요율
	private String trialWorkHistory; //시산작업내역
	private String expectedProfitAndLossAnalysisPrice; //예상손익분석가격
	private String basicDocuments; //기초서류
	
	//인가품의 part
	////////////////////////////////////////////
	private boolean company; //회사 인가품의
	private boolean confirm; //보험상품확정
	private boolean FSS; //금융감독원 인가품의
	////////////////////////////////////////////
	
	//상품판매지원자료 part
	///////////////////////////////////////////////////////////////////////
	private String subscriptionDesign; //가입설계
	private String subscription; //청약
	private String contractManagementRelatedSystem; //계약관리 관련시스템
	private String salesDepartmentData; //판매부 자료
	private String productEducationContent; //상품교육내용
	private String guideline; //지침
	////////////////////////////////////////////////////////////////////////
	
	public InsuranceDesign() {
		
	}
	
	public void finalize() throws Throwable {

	}
	
	public String getDesignID() {
		return designID;
	}

	public void setDesignID(String designID) {
		this.designID = designID;
	}
	
	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public String getInsuranceContent() {
		return insuranceContent;
	}

	public void setInsuranceContent(String insuranceContent) {
		this.insuranceContent = insuranceContent;
	}

	public String getPlanningPurpose() {
		return planningPurpose;
	}

	public void setPlanningPurpose(String planningPurpose) {
		this.planningPurpose = planningPurpose;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public int getPremiumRate() {
		return premiumRate;
	}

	public void setPremiumRate(int premiumRate) {
		this.premiumRate = premiumRate;
	}

	public String getTrialWorkHistory() {
		return trialWorkHistory;
	}

	public void setTrialWorkHistory(String trialWorkHistory) {
		this.trialWorkHistory = trialWorkHistory;
	}

	public String getExpectedProfitAndLossAnalysisPrice() {
		return expectedProfitAndLossAnalysisPrice;
	}

	public void setExpectedProfitAndLossAnalysisPrice(String expectedProfitAndLossAnalysisPrice) {
		this.expectedProfitAndLossAnalysisPrice = expectedProfitAndLossAnalysisPrice;
	}

	public String getBasicDocuments() {
		return basicDocuments;
	}

	public void setBasicDocuments(String basicDocuments) {
		this.basicDocuments = basicDocuments;
	}

	public boolean isCompany() {
		return company;
	}

	public void setCompany(boolean company) {
		this.company = company;
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	public boolean isFSS() {
		return FSS;
	}

	public void setFSS(boolean fSS) {
		FSS = fSS;
	}

	public String getSubscriptionDesign() {
		return subscriptionDesign;
	}

	public void setSubscriptionDesign(String subscriptionDesign) {
		this.subscriptionDesign = subscriptionDesign;
	}

	public String getSubscription() {
		return subscription;
	}

	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}

	public String getContractManagementRelatedSystem() {
		return contractManagementRelatedSystem;
	}

	public void setContractManagementRelatedSystem(String contractManagementRelatedSystem) {
		this.contractManagementRelatedSystem = contractManagementRelatedSystem;
	}

	public String getSalesDepartmentData() {
		return salesDepartmentData;
	}

	public void setSalesDepartmentData(String salesDepartmentData) {
		this.salesDepartmentData = salesDepartmentData;
	}

	public String getProductEducationContent() {
		return productEducationContent;
	}

	public void setProductEducationContent(String productEducationContent) {
		this.productEducationContent = productEducationContent;
	}

	public String getGuideline() {
		return guideline;
	}

	public void setGuideline(String guideline) {
		this.guideline = guideline;
	}
}
