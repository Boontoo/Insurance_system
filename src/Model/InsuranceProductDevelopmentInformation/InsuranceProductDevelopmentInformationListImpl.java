package Model.InsuranceProductDevelopmentInformation;

import java.util.ArrayList;

public class InsuranceProductDevelopmentInformationListImpl implements InsuranceProductDevelopmentInformationList {

	private ArrayList<InsuranceProductDevelopmentInformation> insuranceProductDevelopmentInformationList;
	
	public InsuranceProductDevelopmentInformationListImpl() {
		insuranceProductDevelopmentInformationList = new ArrayList<InsuranceProductDevelopmentInformation>();
	}

	public void finalize() throws Throwable {

	}
	
	@Override
	public boolean add(InsuranceProductDevelopmentInformation insuranceProductDevelopmentInformation) {
		// TODO Auto-generated method stub
		for(InsuranceProductDevelopmentInformation exInsuranceProductDevelopmentInformation : insuranceProductDevelopmentInformationList) {
			if(exInsuranceProductDevelopmentInformation.getInformationID().equals(insuranceProductDevelopmentInformation.getInformationID()))
				return false;
		}
		boolean result = insuranceProductDevelopmentInformationList.add(insuranceProductDevelopmentInformation);
		return result;
	}

	@Override
	public boolean delete(String insuranceProductDevelopmentInformationID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public InsuranceProductDevelopmentInformation get(String insuranceProductDevelopmentInformationID) {
		// TODO Auto-generated method stub
		int index = indexOf(insuranceProductDevelopmentInformationID);
		if(index != -1) return insuranceProductDevelopmentInformationList.get(index);
		return null;
	}

	private int indexOf(String insuranceProductDevelopmentInformationID) {
		for(int i = 0; i < insuranceProductDevelopmentInformationList.size(); i++) {
			if(insuranceProductDevelopmentInformationList.get(i).getInformationID().equals(insuranceProductDevelopmentInformationID))
				return i;
		}
		return -1;
	}

}
