package dao;

import Model.customer.Customer;

public class CustomerDao extends Dao {
	public CustomerDao() {
		super.connect();
	}
	
	public boolean create(Customer customer) {
		// 쿼리 만들기
		String gender = "F";
		if(customer.isGender()) gender = "M";
		String query = "insert into customer (id, age, gender, birthDate, customerName, phoneNum, ssn, subscribedInsurance, uniqueness, accidentId, userId, userPw) values (" +
						"'" + customer.getId() + "', " +
						"'" + customer.getAge() + "', " +
						"'" + gender + "', " +
						"'" + customer.getBirthDate() + "', " +
						"'" + customer.getCustomerName() + "', " +
						"'" + customer.getPhoneNum() + "', " +
						"'" + customer.getSsn() + "', " +
						"'" + customer.getSubscribedInsurance() + "', " +
						"'" + customer.getUniqueness() + "', " +
						"'" + customer.getAccidentId() + "', " +
						"'" + customer.getUserId() + "', " +
						"'" + customer.getUserPw() + "');";
		System.out.println(query);
		
		// 쿼리 실행하기
		return super.create(query);
	}
	
	public void updateByName(Customer customer) { // 만약에 자주 일어난다면...
		
	}
	
	public void delete(Customer customer) {
		
	}

}
