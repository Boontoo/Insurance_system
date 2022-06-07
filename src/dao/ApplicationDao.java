package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public boolean update(Application application) {
		// 쿼리 만들기
		String gender = "F"; // boolean 값 처리 방법
		String uwProceed = "X";
		String uwResult = "X";
		if(application.isGender()) gender = "M";
		if(application.isUWProceed()) uwProceed = "O";
		if(application.isUWResult()) uwResult = "O";
		String query = "update application set " + 
						"customerName='" + application.getCustomerName() + "', " +
						"age='" + application.getAge() + "', " +
						"gender='" + gender + "', " +
						"job='" + application.getJob() + "', " +
						"phoneNum='" + application.getPhoneNum() + "', " +
						"ssn='" + application.getSSN() + "', " +
						"insuranceName='" + application.getInsuranceName() + "', " +
						"uwProceed='" + uwProceed + "', " +
						"uwResult='" + uwResult + "' " +
						"where id='" + application.getId() +"';";
		System.out.println(query);
		
		// 쿼리 실행하기
		return super.update(query);
	}
	
	public boolean delete(String id) {
		String query = "delete from application where id=" + id;
		return super.delete(query);
	}
	
	public ArrayList<Application> retrieveAll() {
		String query = "select * from accident";
		ResultSet resultSet = super.retrieve(query);
		ArrayList<Application> applicationList = new ArrayList<Application>();
		try {
			while(resultSet.next()) {
				Application application = new Application();
				application.setId(resultSet.getString("id"));
				application.setCustomerName(resultSet.getString("customerName"));
				application.setAge(resultSet.getString("age"));
				String gender = resultSet.getString("gender");
				if(gender.equals("M")) application.setGender(true);
				else if(gender.equals("F")) application.setGender(false);
				application.setJob(resultSet.getString("job"));
				application.setPhoneNum(resultSet.getString("phoneNum"));
				application.setSSN(resultSet.getString("ssn"));
				application.setInsuranceName(resultSet.getString("insuranceName"));
				String uwProceed = resultSet.getString("uwProceed");
				if(uwProceed.equals("O")) application.setUWProceed(true);
				else if(uwProceed.equals("X")) application.setUWProceed(false);
				String uwResult = resultSet.getString("uwResult");
				if(uwResult.equals("O")) application.setUWResult(true);
				else if(uwResult.equals("X")) application.setUWResult(false);
				applicationList.add(application);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return applicationList;
	}
}
