package Model.application;


/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public interface ApplicationList {

	/**
	 * 
	 * @param applicationForMembership
	 */
	public boolean add(Application applicationForMembership);
	/**
	 * 
	 * @param id
	 */
	public boolean delete(String id);

	/**
	 * 
	 * @param id
	 */
	public Application get(String id);
	public Application get(int index);
	// 새로 만든 함수

}