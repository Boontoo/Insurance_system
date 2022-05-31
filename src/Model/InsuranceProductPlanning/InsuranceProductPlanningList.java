package Model.InsuranceProductPlanning;

public interface InsuranceProductPlanningList {
	
	public boolean add(InsuranceProductPlanning insuranceProductPlanning);

	public boolean delete(String insuranceProductPlanningID);

	public InsuranceProductPlanning get(String insuranceProductPlanningID);
}
