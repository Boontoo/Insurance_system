package Model.ApplicationForMembership;
import java.util.ArrayList;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public class ApplicationForMembershipListImpl implements ApplicationForMembershipList {

	private ArrayList<ApplicationForMembership> applicationForMembershipList;
	public ApplicationForMembership m_ApplicationForMembership;
	public ApplicationForMembershipListImpl(){
		applicationForMembershipList = new ArrayList<ApplicationForMembership>();
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param applicationForMembership
	 */
	public boolean add(ApplicationForMembership applicationForMembership){
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
		for(ApplicationForMembership applicationForMembership : applicationForMembershipList) {
			if(applicationForMembership.getId().equals(id)) return true;
		}
		return false;
	}

	/**
	 * 
	 * @param id
	 */
	public ApplicationForMembership get(String id){
		for(int i = 0; i < applicationForMembershipList.size(); i++) {
			if(applicationForMembershipList.get(i).getId().equals(id)) 
				return applicationForMembershipList.get(i);
		}
		return null;
	}
	public int getSize() {
		return applicationForMembershipList.size();
	}
	public ArrayList<ApplicationForMembership> getAll() {
		return applicationForMembershipList;
	}
	@Override
	public ApplicationForMembership get(int index) {
		if(index >= 0 && index < applicationForMembershipList.size()) 
			return applicationForMembershipList.get(index);
		return null;
	}
	@Override
	public String toString() {
		String tmp = "";
		for(ApplicationForMembership applicationForMembership : applicationForMembershipList)
			tmp += applicationForMembership + "\n";
		return tmp;
	}
}