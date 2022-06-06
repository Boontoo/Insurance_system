package Model.accident;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:55
 */
public class Accident {
	private String id;
	private int towTruckCallNum;
	private String location; 
	private String accidentType;
	private boolean payed;
	private String contractID;
	
	public Accident(int towTruckCallNum, String contractID , String accidentLocation, String accidentType) {
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
	public String getID() {
		return id;
	}
	public int getTowTruckCallNum() {
		return towTruckCallNum;
	}
	public String getContractID() {
		return contractID;
	}
	public void setID(String id) {
		this.id = id;
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