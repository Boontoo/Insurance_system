package Customer;

public class DeletedCustomer extends Customer {

	public DeletedCustomer(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	
}
