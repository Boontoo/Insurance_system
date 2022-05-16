package Customer;
import java.util.ArrayList;
import java.util.Date;

import Insurance.Insurance;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:56
 */
public class CustomerListImpl implements CustomerList {

	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	public Customer m_Customer;

	public CustomerListImpl(){

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
	public ArrayList<Customer> get(int type, int key) {
		return null;
	}

	@Override
	public ArrayList<Customer> get(int type, String key) {
//		type
		ArrayList<Customer> result = new ArrayList<Customer>();
		for(Customer customer : this.customerList) {
			if(customer.getName() == key) result.add(customer);
		}
		return result;
	}

}