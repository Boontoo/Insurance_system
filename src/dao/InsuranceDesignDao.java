package dao;

import Model.insuranceDesign.InsuranceDesign;

public class InsuranceDesignDao extends Dao {
	public InsuranceDesignDao() {
		super.connect();
	}
	
	public boolean create(InsuranceDesign insuranceDesign) {
		// 쿼리 만들기
		String company = "X";
		String confirm = "X";
		String fss = "X";
		if(insuranceDesign.isCompany()) company = "O";
		if(insuranceDesign.isConfirm()) confirm = "O";
		if(insuranceDesign.isFSS()) fss = "O";
		String query = "insert into insurancedesign (id, insuranceName, insuranceContent, planningPurpose, target, premiumRate, trialWorkHistory, expectedProfitAndLossAnalysisPrice, basicDocuments, company, confirm, fss, subscriptionDesign, subscription, contractManagementRelatedSystem, salesDepartmentData, productEducationContent, guideline) values (" +
						"'" + insuranceDesign.getId() + "', " +
						"'" + insuranceDesign.getInsuranceName() + "', " +
						"'" + insuranceDesign.getInsuranceContent() + "', " +
						"'" + insuranceDesign.getPlanningPurpose() + "', " +
						"'" + insuranceDesign.getTarget() + "', " +
						"'" + insuranceDesign.getPremiumRate() + "', " +
						"'" + insuranceDesign.getTrialWorkHistory() + "', " +
						"'" + insuranceDesign.getExpectedProfitAndLossAnalysisPrice() + "', " +
						"'" + insuranceDesign.getBasicDocuments() + "', " +
						"'" + company + "', " +
						"'" + confirm + "', " +
						"'" + fss + "', " +
						"'" + insuranceDesign.getSubscriptionDesign() + "', " +
						"'" + insuranceDesign.getSubscription() + "', " +
						"'" + insuranceDesign.getContractManagementRelatedSystem() + "', " +
						"'" + insuranceDesign.getSalesDepartmentData() + "', " +
						"'" + insuranceDesign.getProductEducationContent() + "', " +
						"'" + insuranceDesign.getGuideline() + "');";
		System.out.println(query);
		
		// 쿼리 실행하기
		return super.create(query);
	}
	
	public void updateByName(InsuranceDesign insuranceDesign) { // 만약에 자주 일어난다면...
		
	}
	
	public boolean delete(String id) {
		String query = "delete from insurancedesign where id=" + id;
		return super.delete(query);
	}
}
