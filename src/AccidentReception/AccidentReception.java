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
	private String accidentLocation; 
	private String accidentType;
	// 새로 추가한 속성 - 사고 위치, 사고 유형
	private boolean payedMoney;
	// 새로 추가한 속성 - 보험금 지급 여부
	private String contractID;
	
	public AccidentReception(int remainingNumberOfTowTruckCalls, String contractID , String accidentLocation, String accidentType) {
		// 파라미터 변경(int String -> int String 3개)
		this.remainingNumberOfTowTruckCalls = remainingNumberOfTowTruckCalls;
		this.contractID = contractID;
		this.accidentLocation = accidentLocation;
		this.accidentType = accidentType;
		this.payedMoney = false;
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
	public String getAccidentLocation() {
		return accidentLocation;
	}
	public void setAccidentLocation(String accidentLocation) {
		this.accidentLocation = accidentLocation;
	}
	public String getAccidentType() {
		return accidentType;
	}
	public void setAccidentType(String accidentType) {
		this.accidentType = accidentType;
	}
	public boolean isPayedMoney() {
		return payedMoney;
	}
	public void setPayedMoney(boolean payedMoney) {
		this.payedMoney = payedMoney;
	}
}