package dao;

import Model.contract.Contract;

public class ContractDao extends Dao {
	public ContractDao() {
		super.connect();
	}
	
	public boolean create(Contract contract) {
		// 쿼리 만들기
		String payStatus = "X"; // boolean 값 처리 방법
		String renewConsult = "X";
		if(contract.isPayStatus()) payStatus = "O";
		if(contract.isRenewConsult()) renewConsult = "O";
		String query = "insert into contract (id, customerId, insuranceId, expirationDate, totalPayAmount, payAmount, payStatus, renewConsult) values (" +
						"'" + contract.getId() + "', " +
						"'" + contract.getCustomerID() + "', " +
						"'" + contract.getInsuranceID() + "', " +
						"'" + contract.getExpirationDate() + "', " +
						"'" + contract.getTotalPayAmount() + "', " +
						"'" + contract.getPayAmount() + "', " +
						"'" + payStatus + "', " +
						"'" + renewConsult + "');";
		System.out.println(query);
		
		// 쿼리 실행하기
		return super.create(query);
	}
	
	public void updateByName(Contract contract) { // 만약에 자주 일어난다면...
		
	}
	
	public boolean delete(String id) {
		String query = "delete from contract where id=" + id;
		return super.delete(query);
	}
}
