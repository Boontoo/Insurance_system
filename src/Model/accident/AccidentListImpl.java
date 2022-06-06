package Model.accident;
import java.util.ArrayList;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public class AccidentListImpl implements AccidentList {
	
	private ArrayList<Accident> accidentReceptionList = new ArrayList<>();
	public Accident m_AccidentReception;

	public AccidentListImpl(){}
	public void finalize() throws Throwable {
		
	}
	public boolean add(String contractID, String accidentLocation, String accidentType) {
		// 새로 만든 함수 - 가입 보험 아이디 받음
		// 파라미터 변경 (String -> String 3개)
		accidentReceptionList.add(new Accident(15, contractID, accidentLocation, accidentType));
		accidentReceptionList.get(accidentReceptionList.size()-1).setID(accidentReceptionList.size() + "");
		return false;
	}
	public ArrayList<Accident> getAll(){
		// 새로 만든 함수
		return accidentReceptionList;
	}
	public Accident getLast() {
		// 새로 만든 함수
		return accidentReceptionList.get(accidentReceptionList.size()-1);
	}
	/**
	 * 
	 * @param accidentReception
	 */
	public boolean add(Accident accidentReception){
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
	public Accident get(String accidentID){
		for(Accident accidentReception: accidentReceptionList) {
			if(accidentReception.getID().equals(accidentID))
			return accidentReception;
		}
		return null;
	}
}