package dao;

import Model.application.Application;

public class ApplicationDao extends Dao {
	public ApplicationDao() {
		super.connect();
	}
	
	public void create(Application application) {
		// 쿼리 만들기
		int accepted = 0; // boolean 값 처리 방법
		if(application.isAccepted()) accepted = 0;
		String query = "insert into insurance (user_name, user_phoneno, isAccepted) values (" +
						"'" + application.getName() + "', " +
						"'" + application.getPhoneNo() + "', " +
						accepted + "');";
		System.out.println(query);
		
		// 쿼리 실행하기
		super.create(query);
	}
	
	public void updateByName(Application application) { // 만약에 자주 일어난다면...
		
	}
	
	public void delete(Application application) {
		
	}
}
