package 보험사.Design;


/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 오후 9:00:56
 */
public class CustomerImpl extends CustomerList {

	private ArrayList<Customer> customerList;
	public Customer m_Customer;

	public CustomerImpl(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param customer
	 */
	public boolean add(Customer customer){
		return false;
	}

	/**
	 * 
	 * @param customerID
	 */
	public boolean delete(String customerID){
		return false;
	}

	/**
	 * 
	 * @param birthDate
	 */
	public ArrayList<Customer> get(int birthDate){
		return null;
	}

	/**
	 * 
	 * @param gender
	 */
	public ArrayList<Customer> get(boolean gender){
		return null;
	}

	/**
	 * 
	 * @param customerID
	 */
	public ArrayList<Customer> get(String customerID){
		return null;
	}

	/**
	 * 
	 * @param name
	 */
	public ArrayList<Customer> get(String name){
		return null;
	}

	/**
	 * 
	 * @param age
	 */
	public ArrayList<Customer> get(int age){
		return null;
	}

	/**
	 * 
	 * @param today
	 */
	public ArrayList<Customer> get(Date today){
		return null;
	}

}