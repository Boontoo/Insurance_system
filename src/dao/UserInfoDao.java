package dao;

import Model.userInfo.UserInfo;

public class UserInfoDao extends Dao {
	public UserInfoDao() {
		super.connect();
	}
	
	public boolean create(UserInfo userInfo) {
		// 쿼리 만들기
		String userType = "C"; // boolean 값 처리 방법
		if(userInfo.isUserType()) userType = "E";
		String query = "insert into userinfo (id, userName, userId, userPw, userType) values (" +
						"'" + userInfo.getId() + "', " +
						"'" + userInfo.getUserName() + "', " +
						"'" + userInfo.getUserId() + "', " +
						"'" + userInfo.getUserPw() + "', " +
						"'" + userType + "');";
		System.out.println(query);
		
		// 쿼리 실행하기
		return super.create(query);
	}
	
	public void updateByName(UserInfo userInfo) { // 만약에 자주 일어난다면...
		
	}
	
	public boolean delete(String id) {
		String query = "delete from userinfo where id=" + id;
		return super.delete(query);
	}
}
