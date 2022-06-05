package dao;

import Model.customer.Customer;

public class CustomerDao extends Dao {
	public CustomerDao() {
		super.connect();
	}
	
	public void create(Customer customer) {
		// 쿼리 만들기
		int accepted = 0; // boolean 값 처리 방법
		if(customer.isAccepted()) accepted = 0;
		String query = "insert into insurance (user_name, user_phoneno, isAccepted) values (" +
						"'" + customer.getName() + "', " +
						"'" + customer.getPhoneNo() + "', " +
						accepted + "');";
		System.out.println(query);
		
		// 쿼리 실행하기
		super.create(query);
	}
	
	public void updateByName(Customer customer) { // 만약에 자주 일어난다면...
		
	}
	
	public void delete(Customer customer) {
		
	}

}
