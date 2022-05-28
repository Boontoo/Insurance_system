package Model.Contract;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public interface ContractList {

	/**
	 * 
	 * @param contract
	 */
	public boolean add(Contract contract);

	/**
	 * 
	 * @param id
	 */
	public boolean delete(String id);

	/**
	 * 
	 * @param id
	 */
	public Contract get(String id);
	public Contract get(int index);
	// 새로 추가한 함수
}