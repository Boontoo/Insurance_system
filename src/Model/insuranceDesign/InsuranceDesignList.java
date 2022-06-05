package Model.insuranceDesign;

public interface InsuranceDesignList {

	public boolean add(InsuranceDesign insuranceDesign);

	public boolean delete(String insuranceDesignID);

	public InsuranceDesign get(String data, int type);
	
	public boolean update(InsuranceDesign insuranceDesign);
}