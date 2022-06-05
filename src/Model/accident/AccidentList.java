package Model.accident;
/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public interface AccidentList {
	/**
	 * 
	 * @param accidentReception
	 */
	public boolean add(Accident accidentReception);
	/**
	 * 
	 * @param accidentID
	 */
	public boolean delete(String accidentID);
	/**
	 * 
	 * @param accidentID
	 */
	public Accident get(String accidentID);

}