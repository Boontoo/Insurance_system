package ApplicationForMembership;


/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public interface ApplicationForMembershipList {

	/**
	 * 
	 * @param applicationForMembership
	 */
	public boolean add(ApplicationForMembership applicationForMembership);
	/**
	 * 
	 * @param id
	 */
	public boolean delete(String id);

	/**
	 * 
	 * @param id
	 */
	public ApplicationForMembership get(String id);
	public ApplicationForMembership get(int index);
	// ���� ���� �Լ�

}