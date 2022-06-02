package Model.SubmitUser;

import java.util.ArrayList;

public class SubmitUserListImpl implements SubmitUserList {
	// 새로 만든 클래스(22.06.03)
	private ArrayList<SubmitUser> submitUserList;
	public SubmitUserListImpl() {
		submitUserList = new ArrayList<SubmitUser>();
	}
	
	@Override
	public SubmitUser get(String id) {
		for(SubmitUser submitUser : submitUserList) {
			if(submitUser.getId().equals(id)) return submitUser;
		}
		return null;
	}

	@Override
	public SubmitUser get(int index) {
		if(!(index >= 0 && index < submitUserList.size())) return null;
		return submitUserList.get(index);
	}

	@Override
	public boolean add(SubmitUser submitUser) {
		return submitUserList.add(submitUser);
	}

	@Override
	public boolean delete(SubmitUser submitUser) {
		return submitUserList.remove(submitUser);
	}
	
	public int indexOf(String id) {
		for(int i = 0; i < submitUserList.size(); i++) {
			if(submitUserList.get(i).getId().equals(id)) return i;
		}
		return -1;
	}
	
	public ArrayList<SubmitUser> getAll(){
		return submitUserList;
	}
	
	public int getSize() {
		return submitUserList.size();
	}

	@Override
	public String toString() {
		String temp = "";
		for(SubmitUser submitUser : submitUserList) {
			temp += submitUser + "\n";
		}
		return temp;
	}
}
