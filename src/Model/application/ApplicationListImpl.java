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

	private ArrayList<Application> applicationList;
	public Application m_ApplicationForMembership;
	private Dao dao;

	public ApplicationListImpl() {
		this.dao = new ApplicationDao();
		applicationList = new ArrayList<Application>();
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param applicationForMembership
	 */
	public boolean add(Application applicationForMembership) {
		// boolean result = applicationForMembershipList.add(applicationForMembership);
		// applicationForMembershipList.get(applicationForMembershipList.size()-1).
		// setId(applicationForMembershipList.size() + "");
		applicationForMembership.setId(applicationForMembershipList.size() + "");
		boolean result = false;
		if (((ApplicationDao) this.dao).create(applicationForMembership))
			result = applicationForMembershipList.add(applicationForMembership);
		return result;
	}

	/**
	 * 
	 * @param id
	 */
	public boolean delete(String id) {
		boolean result = false;
		if (((ApplicationDao) this.dao).delete(id)) {
			for (int i = 0; i < applicationForMembershipList.size(); i++) {
				if (applicationForMembershipList.get(i).getId() == id) {
					applicationForMembershipList.remove(i);
					initializeId();
					result = true;
					break;
				}
			}
		}
		return result;
	}

	private void initializeId() {
		// 새로 만든 함수
		for (int i = 0; i < applicationList.size(); i++)
			applicationList.get(i).setId(i + 1 + "");
	}

	public boolean checkInID(String id) {
		for (Application applicationForMembership : applicationList) {
			if (applicationForMembership.getId().equals(id))
				return true;
		}
		return false;
	}

	/**
	 * 
	 * @param id
	 */
	public Application get(String id) {
		for (int i = 0; i < applicationList.size(); i++) {
			if (applicationList.get(i).getId().equals(id))
				return applicationList.get(i);
		}
		return null;
	}

	public int getSize() {
		return applicationList.size();
	}

	public ArrayList<Application> getAll() {
		return applicationList;
	}

	@Override
	public Application get(int index) {
		if (index >= 0 && index < applicationList.size())
			return applicationList.get(index);
		return null;
	}

	@Override
	public String toString() {
		String tmp = "";
		for (Application applicationForMembership : applicationList)
			tmp += applicationForMembership + "\n";
		return tmp;
	}
}