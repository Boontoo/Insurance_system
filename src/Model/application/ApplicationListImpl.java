package Model.application;
import java.util.ArrayList;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public class ApplicationListImpl implements ApplicationList {

	private ArrayList<Application> applicationList;
	public Application m_ApplicationForMembership;
	public ApplicationListImpl(){
		applicationList = new ArrayList<Application>();
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param applicationForMembership
	 */
	public boolean add(Application applicationForMembership){
		boolean result = applicationList.add(applicationForMembership);
		applicationList.get(applicationList.size()-1).
			setId(applicationList.size()-1 + "");
		return result;
	}

	/**
	 * 
	 * @param id
	 */
	public boolean delete(String id){
		for(int i = 0; i < applicationList.size(); i++) {
			if(applicationList.get(i).getId() == id) {
				applicationList.remove(i);
				initializeId();
				return true;
			}
		}
		return false;
	}
	
	private void initializeId() {
		// 새로 만든 함수
		for(int i = 0; i < applicationList.size(); i++)
			applicationList.get(i).setId(i+1+"");
	}

	public boolean checkInID(String id) {
		for(Application applicationForMembership : applicationList) {
			if(applicationForMembership.getId().equals(id)) return true;
		}
		return false;
	}

	/**
	 * 
	 * @param id
	 */
	public Application get(String id){
		for(int i = 0; i < applicationList.size(); i++) {
			if(applicationList.get(i).getId().equals(id)) 
				return applicationList.get(i);
		}
		return null;
	}
	public int getSize() {
		return applicationList.size();
	}
	public ArrayList<Application> getAll() {
		return applicationList;
	}
	@Override
	public Application get(int index) {
		if(index >= 0 && index < applicationList.size()) 
			return applicationList.get(index);
		return null;
	}
	@Override
	public String toString() {
		String tmp = "";
		for(Application applicationForMembership : applicationList)
			tmp += applicationForMembership + "\n";
		return tmp;
	}
}