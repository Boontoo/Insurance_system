package ApplicationForMembership;
import java.util.ArrayList;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 오후 9:00:55
 */
public class ApplicationForMembershipListImpl implements ApplicationForMembershipList {

	private ArrayList<ApplicationForMembership> applicationForMembershipList;
	public ApplicationForMembership m_ApplicationForMembership;
	private int size = 0;

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
		// 파라미터 길이 짧게 바꾸기
		boolean result = applicationForMembershipList.add(applicationForMembership);
		applicationForMembershipList.get(applicationForMembershipList.size()-1).setId(++size + "");
		return result;
	}

	/**
	 * 
	 * @param id
	 */
	public boolean delete(String id){
		for(int i = 0; i < size; i++) {
			if(applicationForMembershipList.get(i).getId() == id) {
				applicationForMembershipList.remove(i);
				return true;
			}
		}
		return false;
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
		for(int i = 0; i < size; i++) {
			if(applicationForMembershipList.get(i).getId() == id) return applicationForMembershipList.get(i);
		}
		return null;
	}
	
	@Override
	public String toString() {
		// 새로 만듬
		String tmp = "";
		for(ApplicationForMembership applicationForMembership : applicationForMembershipList)
			tmp += applicationForMembership + "\n";
		return tmp;
	}
}