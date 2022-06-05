package dao;

import Model.BackgroundInformation.BackgroundInformation;

public class BackgroundInfoDao extends Dao {
	public BackgroundInfoDao() {
		super.connect();
	}
	
	public void create(BackgroundInformation backgroundInformation) {
		// 쿼리 만들기
		int accepted = 0; // boolean 값 처리 방법
		if(backgroundInformation.isAccepted()) accepted = 0;
		String query = "insert into insurance (user_name, user_phoneno, isAccepted) values (" +
						"'" + backgroundInformation.getName() + "', " +
						"'" + backgroundInformation.getPhoneNo() + "', " +
						accepted + "');";
		System.out.println(query);
		
		// 쿼리 실행하기
		super.create(query);
	}
	
	public void updateByName(BackgroundInformation backgroundInformation) { // 만약에 자주 일어난다면...
		
	}
	
	public void delete(BackgroundInformation backgroundInformation) {
		
	}
}
