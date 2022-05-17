package Contract;
import java.util.ArrayList;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public class ContractListImpl implements ContractList {

	private ArrayList<Contract> contractList = new ArrayList<Contract>;
	public Contract m_Contract;

	public ContractListImpl(){
		Contract contract = new Contract();
		contract.setCustomerName("문인배");
		contract.setGender(true);
		contract.setId("1");
		contract.setInsuranceName("일반화재보험");
		contract.setPaymentAmount(10000);
		contract.setPaymentStatus(true);
		contract.setPhoneNum("01068004320");
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
		return false;
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

}