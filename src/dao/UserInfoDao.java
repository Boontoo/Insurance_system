package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.insurance.Insurance;
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
	
	public boolean update(UserInfo userInfo) {
		// 쿼리 만들기
		String userType = "C"; // boolean 값 처리 방법
		if(userInfo.isUserType()) userType = "E";
		String query = "update userinfo set " + 
						"userName='" + userInfo.getUserName() + "', " +
						"userId='" + userInfo.getUserId() + "', " +
						"userPw='" + userInfo.getUserPw() + "', " +
						"userType='" + userType + "' " +
						"where id='" + userInfo.getId() +"';";
		System.out.println(query);
		
		// 쿼리 실행하기
		return super.update(query);
	}
	
	public boolean delete(String id) {
		String query = "delete from userinfo where id=" + id;
		return super.delete(query);
	}
	
	public ArrayList<UserInfo> retrieveAll() {
		String query = "select * from insurance";
		ResultSet resultSet = super.retrieve(query);
		ArrayList<UserInfo> userInfoList = new ArrayList<UserInfo>();
		try {
			while(resultSet.next()) {
				UserInfo userInfo = new UserInfo();
				userInfo.setId(resultSet.getString("id"));
				userInfo.setUserName(resultSet.getString("userName"));
				userInfo.setUserId(resultSet.getString("userId"));
				userInfo.setUserPw(resultSet.getString("userPw"));
				String userType = resultSet.getString("userType");
				if(userType == "E") userInfo.setUserType(true);
				else if(userType == "C") userInfo.setUserType(false);
				userInfoList.add(userInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userInfoList;
	}
}
