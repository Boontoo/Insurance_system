package enumeration;

public enum EDesignForm {
	target("보장·판매대상"),
	premiumRate("요율"),
	trialWorkHistory("시산작업내역"),
	expectedProfitAndLossAnalysisPrice("예상손익분석가격"),
	basicDocuments("기초서류");
	private String text;
	private EDesignForm(String text) {
		this.text = text;
	}
	public String getText() {
		return this.text;
	}

}
