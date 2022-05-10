import java.util.ArrayList;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ¿ÀÈÄ 9:00:55
 */
public class CompensationManagementListImpl implements CompensationManagementList {

	private ArrayList<CompensationManagement> compensationManagementList;
	public CompensationManagement m_CompensationManagement;

	public CompensationManagementListImpl(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param CompensationManagement
	 */
	public boolean add(CompensationManagement compensationManagement){
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
	public CompensationManagement get(String id){
		return null;
	}

}