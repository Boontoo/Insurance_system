package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public boolean update(InsuranceDesign insuranceDesign) {
		// 쿼리 만들기
		String company = "X";
		String confirm = "X";
		String fss = "X";
		if(insuranceDesign.isCompany()) company = "O";
		if(insuranceDesign.isConfirm()) confirm = "O";
		if(insuranceDesign.isFSS()) fss = "O";
		String query = "update insurancedesign set " + 
						"insuranceName='" + insuranceDesign.getInsuranceName() + "', " +
						"insuranceContent='" + insuranceDesign.getInsuranceContent() + "', " +
						"planningPurpose='" + insuranceDesign.getPlanningPurpose() + "', " +
						"target='" + insuranceDesign.getTarget() + "', " +
						"premiumRate='" + insuranceDesign.getPremiumRate() + "', " +
						"trialWorkHistory='" + insuranceDesign.getTrialWorkHistory() + "', " +
						"expectedProfitAndLossAnalysisPrice='" + insuranceDesign.getExpectedProfitAndLossAnalysisPrice() + "', " +
						"basicDocuments='" + insuranceDesign.getBasicDocuments() + "', " +
						"company='" + company + "', " +
						"confirm='" + confirm + "', " +
						"fss='" + fss + "', " +
						"subscriptionDesign='" + insuranceDesign.getSubscriptionDesign() + "', " +
						"subscription='" + insuranceDesign.getSubscription() + "', " +
						"contractManagementRelatedSystem='" + insuranceDesign.getContractManagementRelatedSystem() + "', " +
						"salesDepartmentData='" + insuranceDesign.getSalesDepartmentData() + "', " +
						"productEducationContent='" + insuranceDesign.getProductEducationContent() + "', " +
						"guideline='" + insuranceDesign.getGuideline() + "' " +
						"where id='" + insuranceDesign.getId() +"';";
		System.out.println(query);
		
		// 쿼리 실행하기
		return super.update(query);
	}
	
	public boolean delete(String id) {
		String query = "delete from insurancedesign where id=" + id;
		return super.delete(query);
	}
	
	public ArrayList<InsuranceDesign> retrieveAll() {
		String query = "select * from insurancedesign";
		ResultSet resultSet = super.retrieve(query);
		ArrayList<InsuranceDesign> insuranceDesignList = new ArrayList<InsuranceDesign>();
		try {
			while(resultSet.next()) {
				InsuranceDesign insuranceDesign = new InsuranceDesign();
				insuranceDesign.setId(resultSet.getString("id"));
				insuranceDesign.setInsuranceName(resultSet.getString("insuranceName"));
				insuranceDesign.setInsuranceContent(resultSet.getString("insuranceContent"));
				insuranceDesign.setPlanningPurpose(resultSet.getString("planningPurpose"));
				insuranceDesign.setTarget(resultSet.getInt("target"));
				insuranceDesign.setPremiumRate(resultSet.getInt("premiumRate"));
				insuranceDesign.setTrialWorkHistory(resultSet.getString("trialWorkHistory"));
				insuranceDesign.setExpectedProfitAndLossAnalysisPrice(resultSet.getString("expectedProfitAndLossAnalysisPrice"));
				insuranceDesign.setBasicDocuments(resultSet.getString("basicDocuments"));
				String expectedProfitAndLossAnalysisPrice = resultSet.getString("expectedProfitAndLossAnalysisPrice");
				if(expectedProfitAndLossAnalysisPrice == "X") insuranceDesign.setCompany(false);
				else if(expectedProfitAndLossAnalysisPrice == "O") insuranceDesign.setCompany(true);
				String confirm = resultSet.getString("confirm");
				if(confirm == "X") insuranceDesign.setConfirm(false);
				else if(confirm == "O") insuranceDesign.setConfirm(true);
				String fss = resultSet.getString("fss");
				if(fss == "X") insuranceDesign.setFSS(false);
				else if(fss == "O") insuranceDesign.setFSS(true);
				insuranceDesign.setSubscriptionDesign(resultSet.getString("subscriptionDesign"));
				insuranceDesign.setSubscription(resultSet.getString("subscription"));
				insuranceDesign.setContractManagementRelatedSystem(resultSet.getString("contractManagementRelatedSystem"));
				insuranceDesign.setSalesDepartmentData(resultSet.getString("salesDepartmentData"));
				insuranceDesign.setProductEducationContent(resultSet.getString("productEducationContent"));
				insuranceDesign.setGuideline(resultSet.getString("guideline"));
				insuranceDesignList.add(insuranceDesign);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insuranceDesignList;
	}
}
