package Model.InsuranceProductPlanning;

public class InsuranceProductPlanning {
	
	private String planningID;
	private String insuranceName;
	private String insuranceContent;
	private String planningPurpose;
	
	public InsuranceProductPlanning() {
		
	}
	
	public void finalize() throws Throwable {

	}
	
	public String getPlanningID() {
		return planningID;
	}

	public void setPlanningID(String planningID) {
		this.planningID = planningID;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public String getInsuranceContent() {
		return insuranceContent;
	}

	public void setInsuranceContent(String insuranceContent) {
		this.insuranceContent = insuranceContent;
	}

	public String getPlanningPurpose() {
		return planningPurpose;
	}

	public void setPlanningPurpose(String planningPurpose) {
		this.planningPurpose = planningPurpose;
	}
	
	
}
