package Model.BackgroundInformation;

import java.util.ArrayList;

public class BackgroundInformationListImpl implements BackgroundInformationList {

	private ArrayList<BackgroundInformation> backgroundInformationList;
	
	public BackgroundInformationListImpl() {
		backgroundInformationList = new ArrayList<BackgroundInformation>();
	}

	public void finalize() throws Throwable {

	}
	
	@Override
	public boolean add(BackgroundInformation backgroundInformation) {
		// TODO Auto-generated method stub
		for(BackgroundInformation exInsuranceProductDevelopmentInformation : backgroundInformationList) {
			if(exInsuranceProductDevelopmentInformation.getInformationID().equals(backgroundInformation.getInformationID()))
				return false;
		}
		boolean result = backgroundInformationList.add(backgroundInformation);
		return result;
	}

	@Override
	public boolean delete(String insuranceProductDevelopmentInformationID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BackgroundInformation get(String insuranceProductDevelopmentInformationID) {
		// TODO Auto-generated method stub
		int index = indexOf(insuranceProductDevelopmentInformationID);
		if(index != -1) return backgroundInformationList.get(index);
		return null;
	}

	private int indexOf(String insuranceProductDevelopmentInformationID) {
		for(int i = 0; i < backgroundInformationList.size(); i++) {
			if(backgroundInformationList.get(i).getInformationID().equals(insuranceProductDevelopmentInformationID))
				return i;
		}
		return -1;
	}

}
