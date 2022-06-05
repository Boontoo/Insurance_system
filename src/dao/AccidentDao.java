package dao;

import Model.Accident.Accident;

public class AccidentDao extends Dao {
	public AccidentDao() {
		super.connect();
	}
	
	public void create(Accident accident) {
		// 쿼리 만들기
		int accepted = 0; // boolean 값 처리 방법
		if(accident.isAccepted()) accepted = 0;
		String query = "insert into insurance (user_name, user_phoneno, isAccepted) values (" +
						"'" + accident.getName() + "', " +
						"'" + accident.getPhoneNo() + "', " +
						accepted + "');";
		System.out.println(query);
		
		// 쿼리 실행하기
		super.create(query);
	}
	
	public void updateByName(Accident accident) { // 만약에 자주 일어난다면...
		
	}
	
	public void delete(Accident accident) {
		
	}
}
