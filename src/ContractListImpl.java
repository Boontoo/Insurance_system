package 보험사.Design;


/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 오후 9:00:55
 */
public class ContractListImpl extends ContractList {

	private ArrayList<Contract> contractList;
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