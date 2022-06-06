package Model.accident;

import java.util.ArrayList;

import dao.AccidentDao;
import dao.Dao;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public class AccidentListImpl implements AccidentList {

	private ArrayList<Accident> accidentList = new ArrayList<>();
	public Accident m_AccidentReception;
	private Dao dao;

	public AccidentListImpl() {
		this.dao = new AccidentDao();
	}

	public void finalize() throws Throwable {

	}

	public boolean add(String contractID, String accidentLocation, String accidentType) {
		// 새로 만든 함수 - 가입 보험 아이디 받음
		// 파라미터 변경 (String -> String 3개)
		accidentList.add(new Accident(15, contractID, accidentLocation, accidentType));
		accidentList.get(accidentList.size() - 1).setID(accidentList.size() + "");
		return false;
	}

	public ArrayList<Accident> getAll() {
		// 새로 만든 함수
		return accidentList;
	}

	public Accident getLast() {
		// 새로 만든 함수
		return accidentList.get(accidentList.size() - 1);
	}

	/**
	 * 
	 * @param accidentReception
	 */
	public boolean add(Accident accident) {
		for (Accident exAccident : accidentList) {
			if (exAccident.getID().equals(accident.getID()))
				return false;
		}
		boolean result = false;
		if (((AccidentDao) this.dao).create(accident))
			result = accidentList.add(accident);
		return result;
	}

	/**
	 * 
	 * @param accidentID
	 */
	public boolean delete(String accidentID) {
		boolean result = false;
		if (((AccidentDao) this.dao).delete(accidentID)) {
			for (int i = 0; i < accidentList.size(); i++) {
				if (accidentList.get(i).getID() == accidentID) {
					accidentList.remove(i);
					initializeId();
					result = true;
					break;
				}
			}
		}
		return result;
	}

	private void initializeId() {
		// 새로 만든 함수
		for (int i = 0; i < accidentList.size(); i++)
			accidentList.get(i).setID(i + 1 + "");
	}

	/**
	 * 
	 * @param accidentID
	 */
	public Accident get(String accidentID) {
		for (Accident accidentReception : accidentList) {
			if (accidentReception.getID().equals(accidentID))
				return accidentReception;
		}
		return null;
	}
}