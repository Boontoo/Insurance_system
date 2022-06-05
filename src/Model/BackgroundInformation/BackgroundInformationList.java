package Model.BackgroundInformation;

public interface BackgroundInformationList {
	
	public boolean add(BackgroundInformation backgroundInformation);

	public boolean delete(String insuranceProductDevelopmentInformationID);

	public BackgroundInformation get(String insuranceProductDevelopmentInformationID);

}
