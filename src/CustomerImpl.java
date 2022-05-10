import java.util.ArrayList;
import java.util.Date;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ¿ÀÈÄ 9:00:56
 */
public class CustomerImpl implements CustomerList {

	private ArrayList<Customer> customerList;
	public Customer m_Customer;

	public CustomerImpl(){

	}

	public void finalize() throws Throwable {

	}

	public boolean add(Customer customer){
		return false;
	}

	public boolean delete(String customerID){
		return false;
	}

	public ArrayList<Customer> get(boolean gender){
		return null;
	}


	public ArrayList<Customer> get(Date today){
		return null;
	}

	@Override
	public ArrayList<Customer> get(String key, String type) {
		return null;
	}

	@Override
	public ArrayList<Customer> get(int key, String type) {
		return null;
	}

}