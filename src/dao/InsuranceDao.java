package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.insurance.Insurance;

public class InsuranceDao extends Dao {
	public InsuranceDao() {
		super.connect();
	}
	
	public boolean create(Insurance insurance) {
		// 쿼리 만들기
		String renew = "X";
		if(insurance.isRenew()) renew = "O";
		String query = "insert into insurance (id, insuranceName, premiumRate, monthlyPayAmount, target, term, reInsuranceFee, renew, salesPerformance, attribute, profitAndLoss) values (" +
						"'" + insurance.getId() + "', " +
						"'" + insurance.getInsuranceName() + "', " +
						"'" + insurance.getPremiumRate() + "', " +
						"'" + insurance.getMonthlyPayAmount() + "', " +
						"'" + insurance.getTarget() + "', " +
						"'" + insurance.getTerm() + "', " +
						"'" + insurance.getReInsuranceFee() + "', " +
						"'" + renew + "', " +
						"'" + insurance.getSalesPerformance() + "', " +
						"'" + insurance.getAttribute() + "', " +
						"'" + insurance.getProfitAndLoss() + "');";
		System.out.println(query);
		
//		int accepted = 0; // boolean 값 처리 방법
//		if(insurance.isAccepted()) accepted = 0;
//		String query = "insert into insurance (user_name, user_phoneno, isAccepted) values (" +
//						"'" + insurance.getName() + "', " +
//						"'" + insurance.getPhoneNo() + "', " +
//						accepted + "');";
//		System.out.println(query);
		
		// 쿼리 실행하기
		return super.create(query);
	}
	
	public boolean update(Insurance insurance) {
		// 쿼리 만들기
		String renew = "X";
		if(insurance.isRenew()) renew = "O";
		String query = "update insurance set " + 
//						"id='" + insurance.getId() + "', " +
						"insuranceName='" + insurance.getInsuranceName() + "', " +
						"premiumRate='" + insurance.getPremiumRate() + "', " +
						"monthlyPayAmount='" + insurance.getMonthlyPayAmount() + "', " +
						"target='" + insurance.getTarget() + "', " +
						"term='" + insurance.getTerm() + "', " +
						"reInsuranceFee='" + insurance.getReInsuranceFee() + "', " +
						"renew='" + renew + "', " +
						"salesPerformance='" + insurance.getSalesPerformance() + "', " +
						"attribute='" + insurance.getAttribute() + "', " +
						"profitAndLoss='" + insurance.getProfitAndLoss() + "' " +
						"where id='" + insurance.getId() +"';";
		System.out.println(query);
		// 쿼리 실행하기
		return super.update(query);
	}
	
	public boolean delete(String id) {
		String query = "delete from insurance where id=" + id;
		return super.delete(query);
	}
	
	public ArrayList<Insurance> retrieveAll() {
		String query = "select * from insurance";
		ResultSet resultSet = super.retrieve(query);
		ArrayList<Insurance> insuranceList = new ArrayList<Insurance>();
		try {
			while(resultSet.next()) {
				Insurance insurance = new Insurance();
				insurance.setId(resultSet.getString("id"));
				insurance.setInsuranceName(query);
				insurance.setPremiumRate(0);
				insurance.setMonthlyPayAmount(0);
				insurance.setTarget(resultSet.getInt("target"));
				insurance.setTerm(resultSet.getInt("term"));
				insurance.setReInsuranceFee(resultSet.getInt("reInsuranceFee"));
				String renew = resultSet.getString("renew");
				if(renew == "X") insurance.setRenew(false);
				else if(renew == "O") insurance.setRenew(true);
				insurance.setId(resultSet.getString("salesPerformance"));
				insurance.setId(resultSet.getString("attribute"));
				insurance.setId(resultSet.getString("profitAndLoss"));
				insuranceList.add(insurance);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insuranceList;
	}
	
//	public Insurance retrieve(String id) {
//		String query = "select * from insurance" + id;
//		ResultSet resultSet = super.retrieve(query);
//		return null;
//	}
}
