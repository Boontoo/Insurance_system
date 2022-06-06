package dao;

import Model.application.Application;

public class ApplicationDao extends Dao {
	public ApplicationDao() {
		super.connect();
	}
	
	public boolean create(Application application) {
		// 쿼리 만들기
		String gender = "F"; // boolean 값 처리 방법
		String uwProceed = "X";
		String uwResult = "X";
		if(application.isGender()) gender = "M";
		if(application.isUWProceed()) uwProceed = "O";
		if(application.isUWResult()) uwResult = "O";
		String query = "insert into application (id, customerName, age, gender, job, phoneNum, ssn, insuranceName, uwProceed, uwResult) values (" +
						"'" + application.getId() + "', " +
						"'" + application.getCustomerName() + "', " +
						"'" + application.getAge() + "', " +
						"'" + gender + "', " +
						"'" + application.getJob() + "', " +
						"'" + application.getPhoneNum() + "', " +
						"'" + application.getSSN() + "', " +
						"'" + application.getInsuranceName() + "', " +
						"'" + uwProceed + "', " +
						"'" + uwResult + "');";
		System.out.println(query);
		
		// 쿼리 실행하기
		return super.create(query);
	}
	
	public void updateByName(Application application) { // 만약에 자주 일어난다면...
		
	}
	
	public boolean delete(String id) {
		String query = "delete from application where id=" + id;
		return super.delete(query);
	}
}
