package Model.userInfo;

import java.util.ArrayList;

import dao.Dao;
import dao.UserInfoDao;

public class UserInfoListImpl implements UserInfoList {
	// 새로 만든 클래스(22.06.03)
	private ArrayList<UserInfo> userInfoList;
	private Dao dao;
	
	public UserInfoListImpl() {
		this.dao = new UserInfoDao();
		userInfoList = new ArrayList<UserInfo>();
	}
	
	@Override
	public UserInfo get(String id) {
		for(UserInfo submitUser : userInfoList) {
			if(submitUser.getId().equals(id)) return submitUser;
		}
		return null;
	}

	@Override
	public UserInfo get(int index) {
		if(!(index >= 0 && index < userInfoList.size())) return null;
		return userInfoList.get(index);
	}

	@Override
	public boolean add(UserInfo userInfo) {
		for(UserInfo exUserInfo : this.userInfoList) {
			if(exUserInfo.getId().equals(userInfo.getId()))
				return false;
		}
		boolean result = false;
		if(((UserInfoDao) this.dao).create(userInfo))
			result = userInfoList.add(userInfo);
		return result;
	}

	@Override
	public boolean delete(UserInfo submitUser) {
		boolean result = false;
		if(((UserInfoDao) this.dao).delete(submitUser.getId())) {
			int index = indexOf(submitUser.getId());
			if(index != -1) {
				userInfoList.remove(index);
				result = true;
			}
		}
		return result;
	}
	
	public int indexOf(String id) {
		for(int i = 0; i < userInfoList.size(); i++) {
			if(userInfoList.get(i).getId().equals(id)) return i;
		}
		return -1;
	}
	
	public ArrayList<UserInfo> getAll(){
		this.userInfoList =((UserInfoDao) this.dao).retrieveAll();
		return userInfoList;
	}
	
	public int getSize() {
		return userInfoList.size();
	}

	@Override
	public String toString() {
		String temp = "";
		for(UserInfo submitUser : userInfoList) {
			temp += submitUser + "\n";
		}
		return temp;
	}
}
