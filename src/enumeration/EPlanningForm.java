package enumeration;

public enum EPlanningForm {
	insuranceName("보험 이름"),
	insuranceContent("보험 내용"),
	planningPurpose("기획 목적");
	private String text;
	private EPlanningForm(String text) {
		this.text = text;
	}
	public String getText() {
		return this.text;
	}
}
