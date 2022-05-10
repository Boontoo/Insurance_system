package Customer;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ¿ÀÈÄ 9:00:56
 */
public interface CustomerList {

	/**
	 * 
	 * @param customer
	 */
	public boolean add(Customer customer);

	/**
	 * 
	 * @param customerID
	 */
	public boolean delete(String customerID);


	/**
	 * 
	 * @param gender
	 */
	public ArrayList<Customer> get(boolean gender);

	/**
	 * 
	 * @param customerID
	 */
//	public ArrayList<Customer> get(String customerID);

	/**
	 * 
	 * @param name
	 */
	public ArrayList<Customer> get(String key, String type);

	/**
	 * 
	 * @param age
	 */
	
	/**
	 * 
	 * @param birthDate
	 */
	public ArrayList<Customer> get(int key, String type);
//	public ArrayList<Customer> get(int age);
	/**
	 * 
	 * @param today
	 */
	public ArrayList<Customer> get(Date today);

}