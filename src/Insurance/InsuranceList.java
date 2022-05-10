package Insurance;


/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ¿ÀÈÄ 9:00:56
 */
public interface InsuranceList {

	public boolean add(Insurance insurance);

	public boolean delete(String insuranceID);

	public Insurance get(String insuranceID);

}