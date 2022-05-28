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
	public boolean add(String contractID, String accidentLocation, String accidentType) {
		// 새로 만든 함수 - 가입 보험 아이디 받음
		// 파라미터 변경 (String -> String 3개)
		accidentReceptionList.add(new AccidentReception(15, contractID, accidentLocation, accidentType));
		accidentReceptionList.get(accidentReceptionList.size()-1).setAccidentID(accidentReceptionList.size() + "");
		return false;
	}
	public ArrayList<AccidentReception> getAll(){
		// 새로 만든 함수
		return accidentReceptionList;
	}
	public AccidentReception getLast() {
		// 새로 만든 함수
		return accidentReceptionList.get(accidentReceptionList.size()-1);
	}
	/**
	 * 
	 * @param accidentReception
	 */
	public boolean add(AccidentReception accidentReception){
		return accidentReceptionList.add(accidentReception);
	}
	/**
	 * 
	 * @param accidentID
	 */
	public boolean delete(String accidentID){
		return false;
	}
	/**
	 * 
	 * @param accidentID
	 */
	public AccidentReception get(String accidentID){
		for(AccidentReception accidentReception: accidentReceptionList) {
			if(accidentReception.getAccidentID().equals(accidentID))
			return accidentReception;
		}
		return null;
	}
}