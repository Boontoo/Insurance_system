package Model.contract;
import java.util.ArrayList;

import dao.ContractDao;
import dao.Dao;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public class ContractListImpl implements ContractList {

	private ArrayList<Contract> contractList = new ArrayList<Contract>();
	public Contract m_Contract;
	private Dao dao;

	public ContractListImpl(){
		this.dao = new ContractDao();
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param contract
	 */
	public boolean add(Contract contract){
//		boolean result = contractList.add(contract);
		contract.setId(contractList.size()+1 + "");
//		contractList.get(contractList.size()-1).setId(contractList.size()+1 + "");
		boolean result = false;
		if(((ContractDao) this.dao).create(contract))
			result = contractList.add(contract);
		return result;
	}

	/**
	 * 
	 * @param id
	 */
	public boolean delete(String id){
		boolean result = false;
		if(((ContractDao) this.dao).delete(id)) {
			int index = indexOf(id);
			if(index != -1) {
				contractList.remove(index);
				result = true;
			}
		}
		return result;
	}
	
	public void addPayment(Contract selectedContract, int amountOfInsuranceFee) {
		// 새로 만든 함수 - 납입 보험금 추가 - 보험금 납입
		// 파라미터 변경(22.06.03) (int int) -> (Contract int)
		selectedContract.addPayment(amountOfInsuranceFee);
		selectedContract.setPayStatus(true);
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
	public int indexOf(String id) {
		for(int i = 0; i < contractList.size(); i++) {
			if(contractList.get(i).getId().equals(id)) return i;
		}
		return -1;
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