package enumeration;

public enum EPlanningForm {
	insuranceName("고객니즈분석 설문조사 결과"),
	insuranceContent("최근 보험가입 빈도"),
	planningPurpose("경쟁사의 동향 정보");
	private String text;
	private EPlanningForm(String text) {
		this.text = text;
	}
	public String getText() {
		return this.text;
	}
}
