package Model.Customer;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:56
 */
public class CustomerListImpl implements CustomerList {

	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private ArrayList<Customer> deletedCustomerList = new ArrayList<Customer>();
	public Customer m_Customer;

	public CustomerListImpl(){
		Customer customer = new Customer();
		customer.setId("0");
		customer.setAge(22);
		customer.setBirthDate(20010213);
		customer.setGender(true);
		customer.setName("문인배");
		customer.setPhoneNum("01068004320");
		customer.setSsn("60201672");
		ArrayList<String> subscribedInsurance = new ArrayList<String>();
		subscribedInsurance.add("일반 화재 보험");
		customer.setSubscribedInsurance(subscribedInsurance);
		customer.setUniqueness("하이");
		ArrayList<String> accidentId = new ArrayList<String>();
		accidentId.add("0");
		this.customerList.add(customer);
	}

	public void finalize() throws Throwable {

	}

	public boolean add(Customer customer){
		boolean result = customerList.add(customer);
		customerList.get(customerList.size()-1).setId(customerList.size() + "");
		return result;
	}
	public int getSize() {
		// 새로 만든 함수
		return customerList.size();
	}
	public ArrayList<Customer> getAll(){
		// 새로 만든 함수
		return customerList;
	}

	public boolean delete(String customerID){
		for(Customer customer : this.customerList) {
			if(customer.getId().equals(customerID)) {
				this.deletedCustomerList.add(customer);
				this.customerList.remove(customer);
				return true;
			}
		}
		return false;
	}

	public ArrayList<Customer> get(boolean gender){
		ArrayList<Customer> result = new ArrayList<Customer>();
		for(Customer customer : this.customerList) {
			if(customer.isGender() == gender) result.add(customer);
		}
		return result;
	}


	public ArrayList<Customer> get(Date today){
		return null;
	}

	@Override
	public ArrayList<Customer> get(int type, int key) {
		ArrayList<Customer> result = new ArrayList<Customer>();
		switch(type) {
			case 2:
				for(Customer customer : this.customerList) {
					if(customer.getAge() == key) result.add(customer);
				}
				break;
			case 4:
				for(Customer customer : this.customerList) {
					if(customer.getBirthDate() == key) result.add(customer);
				}
				break;
		}
		return result;
	}

	@Override
	public ArrayList<Customer> get(int type, String key) {
//		type : 1
		ArrayList<Customer> result = new ArrayList<Customer>();
		switch(type) {
			case 1:
				for(Customer customer : this.customerList) {
					if(customer.getName().equals(key)) result.add(customer);
				}
				break;
			case 5:
				for(Customer customer : this.customerList) {
					if(customer.getPhoneNum().equals(key)) result.add(customer);
				}
				break;
		}
		return result;
	}

}