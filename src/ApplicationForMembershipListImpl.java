import java.util.ArrayList;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ¿ÀÈÄ 9:00:55
 */
public class ApplicationForMembershipListImpl implements ApplicationForMembershipList {

	private ArrayList<ApplicationForMembership> applicationForMembershipList;
	public ApplicationForMembership m_ApplicationForMembership;

	public ApplicationForMembershipListImpl(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param applicationForMembership
	 */
	public boolean add(ApplicationForMembership applicationForMembership){
		return false;
	}

	/**
	 * 
	 * @param id
	 */
	public boolean delete(String id){
		return false;
	}

	/**
	 * 
	 * @param id
	 */
	public ApplicationForMembership get(String id){
		return null;
	}

}