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
	private int size = 0;

	public ContractListImpl(){
		Contract contract = new Contract();
		contract.setCustomerName("문인배");
		contract.setGender(true);
		contract.setId(++size + "");
		// 인배야 이거도 바꿨다잉
		contract.setInsuranceName("일반화재보험");
		contract.setPaymentAmount(10000);
		contract.setPaymentStatus(true);
		contract.setPhoneNum("010-6800-4320");
		// 인배야 이거로 통일하자
		contract.setSSN("60201672");
		this.contractList.add(contract);
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param contract
	 */
	public boolean add(Contract contract){
		boolean result = contractList.add(contract);
		contractList.get(contractList.size()-1).setId(++size + "");
		return result;
	}

	/**
	 * 
	 * @param id
	 */
	public boolean delete(String id){
		return false;
	}

	/**
	 * 
	 * @param id
	 */
	public Contract get(String id){
		return null;
	}
	@Override
	public Contract get(int index) {
		// 새로 만든 함수 
		return contractList.get(index);
	}
	public int getSize() {
		return size;
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