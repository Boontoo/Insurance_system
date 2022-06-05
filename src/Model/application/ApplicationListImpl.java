package Model.application;
import java.util.ArrayList;

import dao.ApplicationDao;
import dao.Dao;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public class ApplicationListImpl implements ApplicationList {

	private ArrayList<Application> applicationForMembershipList;
	public Application m_ApplicationForMembership;
	public ApplicationListImpl(){
		Dao dao = new ApplicationDao();
		applicationForMembershipList = new ArrayList<Application>();
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param applicationForMembership
	 */
	public boolean add(Application applicationForMembership){
		boolean result = applicationForMembershipList.add(applicationForMembership);
		applicationForMembershipList.get(applicationForMembershipList.size()-1).
			setId(applicationForMembershipList.size() + "");
		return result;
	}

	/**
	 * 
	 * @param id
	 */
	public boolean delete(String id){
		for(int i = 0; i < applicationForMembershipList.size(); i++) {
			if(applicationForMembershipList.get(i).getId() == id) {
				applicationForMembershipList.remove(i);
				initializeId();
				return true;
			}
		}
		return false;
	}
	
	private void initializeId() {
		// 새로 만든 함수
		for(int i = 0; i < applicationForMembershipList.size(); i++)
			applicationForMembershipList.get(i).setId(i+1+"");
	}

	public boolean checkInID(String id) {
		for(Application applicationForMembership : applicationForMembershipList) {
			if(applicationForMembership.getId().equals(id)) return true;
		}
		return false;
	}

	/**
	 * 
	 * @param id
	 */
	public Application get(String id){
		for(int i = 0; i < applicationForMembershipList.size(); i++) {
			if(applicationForMembershipList.get(i).getId().equals(id)) 
				return applicationForMembershipList.get(i);
		}
		return null;
	}
	public int getSize() {
		return applicationForMembershipList.size();
	}
	public ArrayList<Application> getAll() {
		return applicationForMembershipList;
	}
	@Override
	public Application get(int index) {
		if(index >= 0 && index < applicationForMembershipList.size()) 
			return applicationForMembershipList.get(index);
		return null;
	}
	@Override
	public String toString() {
		String tmp = "";
		for(Application applicationForMembership : applicationForMembershipList)
			tmp += applicationForMembership + "\n";
		return tmp;
	}
}