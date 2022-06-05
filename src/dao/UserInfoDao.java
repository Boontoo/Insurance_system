package dao;

import Model.UserInfo.UserInfo;

public class UserInfoDao extends Dao {
	public UserInfoDao() {
		super.connect();
	}
	
	public void create(UserInfo userInfo) {
		// 쿼리 만들기
		int accepted = 0; // boolean 값 처리 방법
		if(userInfo.isAccepted()) accepted = 0;
		String query = "insert into insurance (user_name, user_phoneno, isAccepted) values (" +
						"'" + userInfo.getName() + "', " +
						"'" + userInfo.getPhoneNo() + "', " +
						accepted + "');";
		System.out.println(query);
		
		// 쿼리 실행하기
		super.create(query);
	}
	
	public void updateByName(UserInfo userInfo) { // 만약에 자주 일어난다면...
		
	}
	
	public void delete(UserInfo userInfo) {
		
	}
}
