package Insurance;
import java.util.ArrayList;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:56
 */
public class InsuranceListImpl implements InsuranceList {

	private ArrayList<Insurance> insuranceList;
	public Insurance m_Insurance;
	private int size;
	// 새로 만든 속성

	public InsuranceListImpl(){
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
		boolean result = insuranceList.add(insurance);
		insuranceList.get(insuranceList.size()-1).setInsuranceID(insuranceList.size() + "");
		return result;
	}

	/**
	 * 
	 * @param insuranceID
	 */
	public boolean delete(String insuranceID){
		int index = indexOf(insuranceID);
		if(index != -1) {
			insuranceList.remove(index);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param insuranceID
	 */
	public Insurance get(String insuranceID){
		int index = indexOf(insuranceID);
		if(index != -1) return insuranceList.get(index);
		return null;
	}
	public int indexOf(String insuranceID) {
		for(int i = 0; i < insuranceList.size(); i++) {
			if(insuranceList.get(i).getInsuranceID().equals(insuranceID))
				return i;
		}
		return -1;
	}
	public int getSize() {
		// 새로 만든 함수
		return insuranceList.size();
	}
	public ArrayList<Insurance> getAll() {
		return insuranceList;
	}
}