package Model.accident;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public class Accident {
	private String accidentID;
//	private String customerID;
//	private String customerName;
	// 고객 아이디, 이름 속성 또한 삭제
//	private boolean employeeCallStatus;
	// 직원콜 속성 삭제
	private int towTruckCallNum;
//	private boolean towTruckCallPresent;
	// 렉카콜 속성 삭제
	private String location; 
	private String accidentType;
	// 새로 추가한 속성 - 사고 위치, 사고 유형
	private boolean payed;
	// 새로 추가한 속성 - 보험금 지급 여부
	private String contractID;
	
	public Accident(int towTruckCallNum, String contractID , String accidentLocation, String accidentType) {
		// 파라미터 변경(int String -> int String 3개)
		this.towTruckCallNum = towTruckCallNum;
		this.contractID = contractID;
		this.location = accidentLocation;
		this.accidentType = accidentType;
		this.payed = false;
	}
	
	public void finalize() throws Throwable {
		
	}
	
	public String toString(){
		return "";
	}
	public String getAccidentID() {
		return accidentID;
	}
	public int getTowTruckCallNum() {
		return towTruckCallNum;
	}
	public String getContractID() {
		return contractID;
	}
	public void setAccidentID(String accidentID) {
		this.accidentID = accidentID;
	}
	public void setTowTruckCallNum(int towTruckCallNum) {
		this.towTruckCallNum = towTruckCallNum;
	}
	public void setContractID(String contractID) {
		this.contractID = contractID;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String accidentLocation) {
		this.location = accidentLocation;
	}
	public String getAccidentType() {
		return accidentType;
	}
	public void setAccidentType(String accidentType) {
		this.accidentType = accidentType;
	}
	public boolean isPayed() {
		return payed;
	}
	public void setPayed(boolean payed) {
		this.payed = payed;
	}
}