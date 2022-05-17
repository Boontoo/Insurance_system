package AccidentReception;

import java.util.Scanner;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public class AccidentReception {
	
	private String accidentID;
	private String customerID;
	private String customerName;
	private boolean employeeCallStatus;
	private int remainingNumberOfTowTruckCalls;
	private boolean towTruckCallPresent;
	
	Scanner scanner = new Scanner(System.in);

	public AccidentReception(String accidentID, String customerID, String customerName, boolean employeeCallStatus, int remainingNumberOfTowTruckCalls, boolean towTruckCallPresent) {
		this.accidentID = accidentID;
		this.customerID = customerID;
		this.customerName = customerName;
		this.employeeCallStatus = employeeCallStatus;
		this.remainingNumberOfTowTruckCalls = remainingNumberOfTowTruckCalls;
		this.towTruckCallPresent = towTruckCallPresent;
	}
	
	public void finalize() throws Throwable {}
	
	public String toString(){return "";}
	public String getAccidentID() {return accidentID;}
	public String getCustomerID() {return customerID;}
	public String getCustomerName() {return customerName;}
	public boolean isEmployeeCallStatus() {return employeeCallStatus;}
	public int getRemainingNumberOfTowTruckCalls() {return remainingNumberOfTowTruckCalls;}
	public boolean isTowTruckCallPresent() {return towTruckCallPresent;}

	public void setAccidentID(String accidentID) {this.accidentID = accidentID;}
	public void setCustomerID(String customerID) {this.customerID = customerID;}
	public void setCustomerName(String customerName) {this.customerName = customerName;}
	public void setEmployeeCallStatus(boolean employeeCallStatus) {this.employeeCallStatus = employeeCallStatus;}
	public void setRemainingNumberOfTowTruckCalls(int remainingNumberOfTowTruckCalls) {this.remainingNumberOfTowTruckCalls = remainingNumberOfTowTruckCalls;}
	public void setTowTruckCallPresent(boolean towTruckCallPresent) {this.towTruckCallPresent = towTruckCallPresent;}
}