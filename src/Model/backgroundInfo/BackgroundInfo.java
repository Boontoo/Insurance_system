package Model.backgroundInfo;

public class BackgroundInfo {

	private String id; //ID
	private String surveyResults; //고객니즈분석 설문조사 결과
	private String applyFrequency; //최근 보험가입 빈도
	private String trend; //경쟁사의 동향 정보
	
	public BackgroundInfo() {
		
	}
	
	public void finalize() throws Throwable {

	}

	public String getInformationID() {
		return id;
	}

	public void setInformationID(String informationID) {
		this.id = informationID;
	}

	public String getSurveyResults() {
		return surveyResults;
	}

	public void setSurveyResults(String surveyResults) {
		this.surveyResults = surveyResults;
	}

	public String getApplyFrequency() {
		return applyFrequency;
	}

	public void setApplyFrequency(String applyFrequency) {
		this.applyFrequency = applyFrequency;
	}

	public String getTrend() {
		return trend;
	}

	public void setTrend(String trend) {
		this.trend = trend;
	}
	
}
