package Contract;
import java.util.ArrayList;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public class ContractListImpl implements ContractList {

	private ArrayList<Contract> contractList = new ArrayList<Contract>();
	public Contract m_Contract;

	public ContractListImpl(){
		
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param contract
	 */
	public boolean add(Contract contract){
		boolean result = contractList.add(contract);
		contractList.get(contractList.size()-1).setId(contractList.size()+1 + "");
		return result;
	}

	/**
	 * 
	 * @param id
	 */
	public boolean delete(String id){
		return false;
	}
	public void addPayment(int choice, int amountOfInsuranceFee) {
		// 새로 만든 함수 - 납입 보험금 추가 - 보험금 납입
		contractList.get(choice-1).addPayment(amountOfInsuranceFee);
		contractList.get(choice-1).setPaymentStatus(true);
	}

	/**
	 * 
	 * @param id
	 */
	public Contract get(String id){
		for(Contract contract : contractList) {
			if(contract.getId().equals(id)) return contract;
		}
		return null;
	}
	public int getSize() {
		// 새로 만든 함수
		return contractList.size();
	}
	public Contract getById(String insuranceID, String id) {
		// 새로 만든 함수
		for(Contract contract : contractList) {
			if(contract.getInsuranceID().equals(insuranceID) 
					&& contract.getCustomerID().equals(id)) return contract;
		}
		return null;
	}
	public ArrayList<Contract> getAll(){
		// 새로 만든 함수
		return contractList;
	}
	@Override
	public Contract get(int index) {
		// 새로 만든 함수 
		return contractList.get(index);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String temp = "";
		for(Contract contract : contractList)
			temp += contract + "\n";
		return temp;
	}
}