package dao;

import Model.insurance.Insurance;

public class InsuranceDao extends Dao {
	public InsuranceDao() {
		super.connect();
	}
	
	public void create(Insurance insurance) {
		// 쿼리 만들기
		int accepted = 0; // boolean 값 처리 방법
		if(insurance.isAccepted()) accepted = 0;
		String query = "insert into insurance (user_name, user_phoneno, isAccepted) values (" +
						"'" + insurance.getName() + "', " +
						"'" + insurance.getPhoneNo() + "', " +
						accepted + "');";
		System.out.println(query);
		
		// 쿼리 실행하기
		super.create(query);
	}
	
	public void updateByName(Insurance insurance) { // 만약에 자주 일어난다면...
		
	}
	
	public void delete(Insurance insurance) {
		
	}

}
