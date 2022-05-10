package 보험사.Design;


/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 오후 9:00:56
 */
public class InsuranceList {

	public InsuranceList(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param insurance
	 */
	public boolean add(Insurance insurance){
		return false;
	}

	/**
	 * 
	 * @param insuranceID
	 */
	public boolean delete(String insuranceID){
		return false;
	}

	/**
	 * 
	 * @param insuranceID
	 */
	public Insurance get(String insuranceID){
		return null;
	}

}