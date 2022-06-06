package Model.insurance;
import java.util.ArrayList;

import dao.Dao;
import dao.InsuranceDao;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:56
 */
public class InsuranceListImpl implements InsuranceList {

	private ArrayList<Insurance> insuranceList;
	public Insurance m_Insurance;
//	private int size;
	// 새로 만든 속성
	private Dao dao;

	public InsuranceListImpl(){
		this.dao = new InsuranceDao();
		insuranceList = new ArrayList<Insurance>();
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param insurance
	 */
	public boolean add(Insurance insurance){
		for(Insurance exInsurance : insuranceList) {
			if(exInsurance.getInsuranceName().equals(insurance.getInsuranceName()))
				return false;
		}
		boolean result = false;
		if(((InsuranceDao) this.dao).create(insurance))
			result = insuranceList.add(insurance);
//		insuranceList.get(insuranceList.size()-1).setInsuranceID(insuranceList.size() + "");
		return result;
	}

	/**
	 * 
	 * @param insuranceID
	 */
	public boolean delete(String id){
		boolean result = false;
		if(((InsuranceDao) this.dao).delete(id)) {
			int index = indexOf(id);
			if(index != -1) {
				insuranceList.remove(index);
				result = true;
			}
		}
		return result;
	}

	/**
	 * 
	 * @param insuranceID
	 */
	public Insurance get(String insuranceID){
		int index = indexOf(insuranceID);
//		System.out.println(index);
		if(index != -1) {
//			System.out.println(index);
			return insuranceList.get(index);
		}
		return null;
	}
//	public String getIdFromName(String name) {
//		// 새로 만든 함수
//		for(Insurance insurance : insuranceList) {
//			if(insurance.getInsuranceName().equals(name))
//				return insurance.getInsuranceID();
//		}
//		return "해당 아이디를 찾지 못했습니다.";
//	}
	public int indexOf(String insuranceID) {
		for(int i = 0; i < insuranceList.size(); i++) {
//			System.out.println("i = "+i);
			if(insuranceList.get(i).getId().equals(insuranceID))
				return i;
		}
		return -1;
	}
	public int getSize() {
		// 새로 만든 함수
		return insuranceList.size();
	}
	public ArrayList<Insurance> getAll() {
		this.insuranceList = ((InsuranceDao) this.dao).retrieveAll();
		return this.insuranceList;
	}

	@Override
	public boolean update(Insurance insurance) {
		boolean result = false;
		if(((InsuranceDao) this.dao).update(insurance)) {
			int index = indexOf(insurance.getId());
			if(index != -1) {
				this.insuranceList.set(index, insurance);
				if(this.insuranceList.get(index).equals(insurance))
					result = true;
			}
		}
		return result;
	}
}