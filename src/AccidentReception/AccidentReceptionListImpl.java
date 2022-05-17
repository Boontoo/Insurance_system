package AccidentReception;
import java.util.ArrayList;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public class AccidentReceptionListImpl implements AccidentReceptionList {
	
	private ArrayList<AccidentReception> accidentReceptionList = new ArrayList<>();
	public AccidentReception m_AccidentReception;

	public AccidentReceptionListImpl(){}
	public void finalize() throws Throwable {
	}
	/**
	 * 
	 * @param accidentReception
	 */
	public boolean add(AccidentReception accidentReception){return false;}
	/**
	 * 
	 * @param accidentID
	 */
	public boolean delete(String accidentID){return false;}
	/**
	 * 
	 * @param accidentID
	 */
	public AccidentReception get(String accidentID){
		for(AccidentReception accidentReception: accidentReceptionList) {
			if(accidentReception.getCustomerID().equals(accidentID))
			return accidentReception;
		}
		return null;
	}
}