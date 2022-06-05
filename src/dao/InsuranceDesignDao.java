package dao;

import Model.InsuranceDesign.InsuranceDesign;

public class InsuranceDesignDao extends Dao {
	public InsuranceDesignDao() {
		super.connect();
	}
	
	public void create(InsuranceDesign insuranceDesign) {
		// 쿼리 만들기
		int accepted = 0; // boolean 값 처리 방법
		if(insuranceDesign.isAccepted()) accepted = 0;
		String query = "insert into insurance (user_name, user_phoneno, isAccepted) values (" +
						"'" + insuranceDesign.getName() + "', " +
						"'" + insuranceDesign.getPhoneNo() + "', " +
						accepted + "');";
		System.out.println(query);
		
		// 쿼리 실행하기
		super.create(query);
	}
	
	public void updateByName(InsuranceDesign insuranceDesign) { // 만약에 자주 일어난다면...
		
	}
	
	public void delete(InsuranceDesign insuranceDesign) {
		
	}
}
