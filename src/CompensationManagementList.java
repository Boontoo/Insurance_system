
/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ¿ÀÈÄ 9:00:55
 */
public interface CompensationManagementList {

	/**
	 * 
	 * @param CompensationManagement
	 */
	public boolean add(CompensationManagement compensationManagement);

	/**
	 * 
	 * @param id
	 */
	public boolean delete(String id);

	/**
	 * 
	 * @param id
	 */
	public CompensationManagement get(String id);

}