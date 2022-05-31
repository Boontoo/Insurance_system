package Model.InsuranceDesign;

import java.util.ArrayList;

public class InsuranceDesignListImpl implements InsuranceDesignList {

	private ArrayList<InsuranceDesign> insuranceDesignList;
	
	public InsuranceDesignListImpl(){
		insuranceDesignList = new ArrayList<InsuranceDesign>();
	}

	public void finalize() throws Throwable {

	}
	
	@Override
	public boolean add(InsuranceDesign insuranceDesign) {
		for(InsuranceDesign exInsuranceDesign : insuranceDesignList) {
			if(exInsuranceDesign.getInsuranceName().equals(insuranceDesign.getInsuranceName()))
				return false;
		}
		boolean result = insuranceDesignList.add(insuranceDesign);
		return result;
	}

	@Override
	public boolean delete(String insuranceDesignID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public InsuranceDesign get(String data, int type) {
		switch(type) {
			case 1:
				for(InsuranceDesign insuranceDesign : this.insuranceDesignList)
					if(insuranceDesign.getDesignID() == data) return insuranceDesign;
			case 2:
				for(InsuranceDesign insuranceDesign : this.insuranceDesignList)
					if(insuranceDesign.getInsuranceName() == data) return insuranceDesign;
			default:
				return null;
		}
	}
	
	public ArrayList<InsuranceDesign> getAll() {
		return insuranceDesignList;
	}

}
