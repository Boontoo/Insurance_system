package dao;

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

}
