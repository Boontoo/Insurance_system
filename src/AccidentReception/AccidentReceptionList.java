package AccidentReception;
/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public interface AccidentReceptionList {
	/**
	 * 
	 * @param accidentReception
	 */
	public boolean add(AccidentReception accidentReception);
	/**
	 * 
	 * @param accidentID
	 */
	public boolean delete(String accidentID);
	/**
	 * 
	 * @param accidentID
	 */
	public AccidentReception get(String accidentID);

}