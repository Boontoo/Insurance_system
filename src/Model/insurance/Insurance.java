package Model.insurance;



/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:56
 */
public class Insurance {

	private CompensationCondition compensation;
	// int -> String
	private String content;
	private String id;
	private String insuranceName;
	// 타입 변경 int->String
	private int premiumRate; // 요율
	private int monthlyPayAmount;
	private int target;
	private int term;
	private int reInsuranceFee; // 새로 만든 변수(재보험요금)
	private boolean renew; // 새로 만든 변수(갱신여부)
	//////////////////////////////////////////// 20220603
	private String salesPerformance; // 새로 만든 변수(판매 실적)
	private String attribute; // 새로 만든 변수(속성)
	private int profitAndLoss; // 새로 만든 변수(손익)
	
//	private enum type{};
	public CompensationCondition m_CompensationCondition;
	
	public Insurance(String id, String InsuranceName){
		this.id = id;
		this.insuranceName = InsuranceName;
		this.reInsuranceFee = 10000;
		this.renew = false;
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

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInsuranceName() {
		return insuranceName;
	}
	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	public int getPremiumRate() {
		return premiumRate;
	}
	public void setPremiumRate(int preminumRate) {
		this.premiumRate = preminumRate;
	}
	public int getMonthlyPayAmount() {
		return monthlyPayAmount;
	}
	public void setMonthlyPayAmount(int monthlyPayAmount) {
		this.monthlyPayAmount = monthlyPayAmount;
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
		return renew;
	}
	public void setRenew(boolean renew) {
		this.renew = renew;
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