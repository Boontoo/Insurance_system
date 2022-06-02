package Model.SubmitUser;

public class SubmitUser {
	// 새로 만든 클래스(속성 : 아이디(클래스 아이디임) 이름 유저아이디 유저비번 유저 구분)(22.06.03)
	private String id;
	private String userName;
	private String userId;
	private String userPw;
	private boolean userType; // true:직원, false:고객
	
	public SubmitUser(String userName, String userId, String userPw, boolean userType) {
		this.userName = userName;
		this.userId = userId;
		this.userPw = userPw;
		this.userType = userType;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public boolean isUserType() {
		return userType;
	}
	public void setUserType(boolean userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String userTypeStr = userType? "직원":"고객";
		return userName + "    " + userId + "     " + userTypeStr;
	}
}
