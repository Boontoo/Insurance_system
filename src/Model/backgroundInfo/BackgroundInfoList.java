package Model.backgroundInfo;

public interface BackgroundInfoList {
	
	public boolean add(BackgroundInfo backgroundInformation);

	public boolean delete(String insuranceProductDevelopmentInformationID);

	public BackgroundInfo get(String insuranceProductDevelopmentInformationID);

}
