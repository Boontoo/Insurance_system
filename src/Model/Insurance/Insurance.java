package Model.Insurance;



/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:56
 */
public class Insurance {

	private CompensationCondition compensation;
	// int -> String
	private String content;
	private String insuranceID;
	private String InsuranceName;
	// 타입 변경 int->String
	private int insurancePremium; // 요율
	private int monthlyPaymentAmount;
	private int target;
	private int term;
	private int reInsuranceFee; // 새로 만든 변수(재보험요금)
	private boolean isRenew; // 새로 만든 변수(갱신여부)
	//////////////////////////////////////////// 20220603
	private String salesPerformance; // 새로 만든 변수(판매 실적)
	private String attribute; // 새로 만든 변수(속성)
	private int profitAndLoss; // 새로 만든 변수(손익)
	
	private enum type{};
	public CompensationCondition m_CompensationCondition;
	
	public Insurance(String id, String InsuranceName){
		this.insuranceID = id;
		this.InsuranceName = InsuranceName;
		this.reInsuranceFee = 10000;
		this.isRenew = false;
	}

	public Insurance() {

	}

	public void finalize() throws Throwable {

	}
	public CompensationCondition getCompensation() {
		return compensation;
	}
	public void setCompensation(CompensationCondition compensation) {
		this.compensation = compensation;
	}
	// int -> String
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		// int -> String
		this.content = content;
	}

	public String getInsuranceID() {
		return insuranceID;
	}
	public void setInsuranceID(String insuranceID) {
		this.insuranceID = insuranceID;
	}
	public String getInsuranceName() {
		return InsuranceName;
	}
	public void setInsuranceName(String insuranceName) {
		InsuranceName = insuranceName;
	}
	public int getInsurancePremium() {
		return insurancePremium;
	}
	public void setInsurancePremium(int insurancePremium) {
		this.insurancePremium = insurancePremium;
	}
	public int getMonthlyPaymentAmount() {
		return monthlyPaymentAmount;
	}
	public void setMonthlyPaymentAmount(int monthlyPaymentAmount) {
		this.monthlyPaymentAmount = monthlyPaymentAmount;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public CompensationCondition getM_CompensationCondition() {
		return m_CompensationCondition;
	}
	public void setM_CompensationCondition(CompensationCondition m_CompensationCondition) {
		this.m_CompensationCondition = m_CompensationCondition;
	}
	public int getReInsuranceFee() {
		return reInsuranceFee;
	}
	public void setReInsuranceFee(int reInsuranceFee) {
		this.reInsuranceFee = reInsuranceFee;
	}
	public boolean isRenew() {
		return isRenew;
	}
	public void setRenew(boolean isRenew) {
		this.isRenew = isRenew;
	}
	
	// 20220603
	public String getSalesPerformance() {
		return salesPerformance;
	}

	public void setSalesPerformance(String salesPerformance) {
		this.salesPerformance = salesPerformance;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public int getProfitAndLoss() {
		return profitAndLoss;
	}

	public void setProfitAndLoss(int profitAndLoss) {
		this.profitAndLoss = profitAndLoss;
	}
	// 20220603
	
	public void compensate(){

	}

	

}