package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.customer.Customer;
import Model.insurance.Insurance;

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
	
	public boolean update(Customer customer) {
			// 쿼리 만들기
		String gender = "F";
		if(customer.isGender()) gender = "M";
		String query = "update customer set " + 
//							"id='" + insurance.getId() + "', " +
						"age='" + customer.getAge() + "', " +
						"gender='" + gender + "', " +
						"birthDate='" + customer.getBirthDate() + "', " +
						"customerName='" + customer.getCustomerName() + "', " +
						"phoneNum='" + customer.getPhoneNum() + "', " +
						"ssn='" + customer.getSsn() + "', " +
						"subscribedInsurance='" + customer.getSubscribedInsurance() + "', " +
						"uniqueness='" + customer.getUniqueness() + "', " +
						"accidentId='" + customer.getAccidentId() + "', " +
						"userId='" + customer.getUserId() + "', " +
						"userPw='" + customer.getUserPw() + "' " +
						"where id='" + customer.getId() +"';";
		System.out.println(query);
		// 쿼리 실행하기
		return super.update(query);
	}
	
	public boolean delete(String id) {
		String query = "delete from customer where id=" + id;
		return super.delete(query);
	}

	public ArrayList<Customer> retrieveAll() {
		String query = "select * from customer";
		ResultSet resultSet = super.retrieve(query);
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		try {
			while(resultSet.next()) {
				Customer customer = new Customer();
				customer.setId(resultSet.getString("id"));
				customer.setInsuranceName(query);
				customer.setPremiumRate(0);
				customer.setMonthlyPayAmount(0);
				customer.setTarget(resultSet.getInt("target"));
				customer.setTerm(resultSet.getInt("term"));
				customer.setReInsuranceFee(resultSet.getInt("reInsuranceFee"));
				String renew = resultSet.getString("renew");
				if(renew == "X") customer.setRenew(false);
				else if(renew == "O") customer.setRenew(true);
				customer.setId(resultSet.getString("salesPerformance"));
				customer.setId(resultSet.getString("attribute"));
				customer.setId(resultSet.getString("profitAndLoss"));
				insuranceList.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insuranceList;
	}
}
