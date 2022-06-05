package dao;

import Model.contract.Contract;

public class ContractDao extends Dao {
	public ContractDao() {
		super.connect();
	}
	
	public void create(Contract contract) {
		// 쿼리 만들기
		int accepted = 0; // boolean 값 처리 방법
		if(contract.isAccepted()) accepted = 0;
		String query = "insert into insurance (user_name, user_phoneno, isAccepted) values (" +
						"'" + contract.getName() + "', " +
						"'" + contract.getPhoneNo() + "', " +
						accepted + "');";
		System.out.println(query);
		
		// 쿼리 실행하기
		super.create(query);
	}
	
	public void updateByName(Contract contract) { // 만약에 자주 일어난다면...
		
	}
	
	public void delete(Contract contract) {
		
	}
}
