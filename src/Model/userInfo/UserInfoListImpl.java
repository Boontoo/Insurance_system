package Model.userInfo;

import java.util.ArrayList;

public class UserInfoListImpl implements UserInfoList {
	// 새로 만든 클래스(22.06.03)
	private ArrayList<UserInfo> submitUserList;
	public UserInfoListImpl() {
		submitUserList = new ArrayList<UserInfo>();
	}
	
	@Override
	public UserInfo get(String id) {
		for(UserInfo submitUser : submitUserList) {
			if(submitUser.getId().equals(id)) return submitUser;
		}
		return null;
	}

	@Override
	public UserInfo get(int index) {
		if(!(index >= 0 && index < submitUserList.size())) return null;
		return submitUserList.get(index);
	}

	@Override
	public boolean add(UserInfo submitUser) {
		return submitUserList.add(submitUser);
	}

	@Override
	public boolean delete(UserInfo submitUser) {
		return submitUserList.remove(submitUser);
	}
	
	public int indexOf(String id) {
		for(int i = 0; i < submitUserList.size(); i++) {
			if(submitUserList.get(i).getId().equals(id)) return i;
		}
		return -1;
	}
	
	public ArrayList<UserInfo> getAll(){
		return submitUserList;
	}
	
	public int getSize() {
		return submitUserList.size();
	}

	@Override
	public String toString() {
		String temp = "";
		for(UserInfo submitUser : submitUserList) {
			temp += submitUser + "\n";
		}
		return temp;
	}
}
