package AccidentReception;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public class AccidentReception {
	private String accidentID;
//	private String customerID;
//	private String customerName;
	// 고객 아이디, 이름 속성 또한 삭제
//	private boolean employeeCallStatus;
	// 직원콜 속성 삭제
	private int remainingNumberOfTowTruckCalls;
//	private boolean towTruckCallPresent;
	// 렉카콜 속성 삭제
	// 
	private String contractID;
	
	public AccidentReception(int remainingNumberOfTowTruckCalls, String contractID) {
		this.remainingNumberOfTowTruckCalls = remainingNumberOfTowTruckCalls;
		this.contractID = contractID;
	}
	
	public void finalize() throws Throwable {
		
	}
	
	public String toString(){
		return "";
	}
	public String getAccidentID() {
		return accidentID;
	}
	public int getRemainingNumberOfTowTruckCalls() {
		return remainingNumberOfTowTruckCalls;
	}
	public String getContractID() {
		return contractID;
	}
	

	public void setAccidentID(String accidentID) {
		this.accidentID = accidentID;
	}
	public void setRemainingNumberOfTowTruckCalls(int remainingNumberOfTowTruckCalls) {
		this.remainingNumberOfTowTruckCalls = remainingNumberOfTowTruckCalls;
	}
	public void setContractID(String contractID) {
		this.contractID = contractID;
	}
}