package enumeration;

public enum EProductSalesSupportDetails {
	subscriptionDesign("가입설계"),
	subscription("청약"),
	contractManagementRelatedSystem("계약관리 관련시스템"),
	salesDepartmentData("판매부 자료"),
	productEducationContent("상품교육내용"),
	guideline("지침");
	private String text;
	private EProductSalesSupportDetails(String text) {
		this.text = text;
	}
	public String getText() {
		return this.text;
	}
}
