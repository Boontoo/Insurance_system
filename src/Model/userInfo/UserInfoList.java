package Model.userInfo;

public interface UserInfoList {
	public UserInfo get(String id);
	public UserInfo get(int index);
	public boolean add(UserInfo submitUser);
	public boolean delete(UserInfo submitUser);
}
