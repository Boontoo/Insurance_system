package Model.customer;
import java.util.ArrayList;
import java.util.Date;

import dao.CustomerDao;
import dao.Dao;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:56
 */
public class CustomerListImpl implements CustomerList {

	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private ArrayList<Customer> deletedCustomerList = new ArrayList<Customer>();
	public Customer m_Customer;
	private Dao dao;

	public CustomerListImpl(){
		this.dao = new CustomerDao();
	}

	public void finalize() throws Throwable {

	}

	public boolean add(Customer customer){
		for(Customer exCustomer : this.customerList) {
			if(exCustomer.getId().equals(customer.getId()))
				return false;
		}
		boolean result = false;
		if(((CustomerDao) this.dao).create(customer))
			result = customerList.add(customer);
		return result;
	}
	
	public int indexOf(String id) {
		// 새로 만든 함수
		for(int i = 0; i < customerList.size(); i++) {
			if(customerList.get(i).getId().equals(id)) return i;
		}
		return -1;
	}
	public int getSize() {
		// 새로 만든 함수
		return customerList.size();
	}
	public ArrayList<Customer> getAll(){
		// 새로 만든 함수
		return customerList;
	}
	public Customer getById(String id) {
		// 새로 만든 함수
		int index = indexOf(id);
		if(index != -1) return customerList.get(index);
		return null;
	}
	public Customer getBySsn(String ssn) {
		// 새로 만든 함수
		for(Customer customer : customerList) {
			if(customer.getSsn().equals(ssn)) return customer;
		}
		return null;
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
					if(customer.getCustomerName().equals(key)) result.add(customer);
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
	@Override
	public String toString() {
		// 새로 만든 함수
		String temp = "";
		for(Customer customer : customerList) 
			temp += customer + "\n";
		return temp;
	}
}