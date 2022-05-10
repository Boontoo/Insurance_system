package Insurance;
import java.util.ArrayList;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ¿ÀÈÄ 9:00:56
 */
public class InsuranceImpl implements InsuranceList {

	private ArrayList<Insurance> insuranceList;
	public Insurance m_Insurance;

	public InsuranceImpl(){

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