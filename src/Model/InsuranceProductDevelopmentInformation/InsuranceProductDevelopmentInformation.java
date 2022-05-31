package Model.InsuranceProductDevelopmentInformation;

public class InsuranceProductDevelopmentInformation {

	private String informationID; //ID
	private String customerNeedAnalysisSurveyResults; //고객니즈분석 설문조사 결과
	private String frequencyOfRecentInsurancePurchases; //최근 보험가입 빈도
	private String competitorTrendInformation; //경쟁사의 동향 정보
	
	public InsuranceProductDevelopmentInformation() {
		
	}
	
	public void finalize() throws Throwable {

	}

	public String getInformationID() {
		return informationID;
	}

	public void setInformationID(String informationID) {
		this.informationID = informationID;
	}

	public String getCustomerNeedAnalysisSurveyResults() {
		return customerNeedAnalysisSurveyResults;
	}

	public void setCustomerNeedAnalysisSurveyResults(String customerNeedAnalysisSurveyResults) {
		this.customerNeedAnalysisSurveyResults = customerNeedAnalysisSurveyResults;
	}

	public String getFrequencyOfRecentInsurancePurchases() {
		return frequencyOfRecentInsurancePurchases;
	}

	public void setFrequencyOfRecentInsurancePurchases(String frequencyOfRecentInsurancePurchases) {
		this.frequencyOfRecentInsurancePurchases = frequencyOfRecentInsurancePurchases;
	}

	public String getCompetitorTrendInformation() {
		return competitorTrendInformation;
	}

	public void setCompetitorTrendInformation(String competitorTrendInformation) {
		this.competitorTrendInformation = competitorTrendInformation;
	}
	
	
}
