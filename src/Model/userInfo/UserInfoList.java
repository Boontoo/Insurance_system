package Model.userInfo;

public interface UserInfoList {
	// 새로 만든 인터페이스(22.06.03)
	public UserInfo get(String id);
	public UserInfo get(int index);
	public boolean add(UserInfo submitUser);
	public boolean delete(UserInfo submitUser);
}
