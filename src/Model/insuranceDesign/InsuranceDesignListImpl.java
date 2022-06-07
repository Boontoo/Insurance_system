package Model.insuranceDesign;

import java.util.ArrayList;

import dao.Dao;
import dao.InsuranceDesignDao;

public class InsuranceDesignListImpl implements InsuranceDesignList {

	private ArrayList<InsuranceDesign> insuranceDesignList;
	private Dao dao;
	
	public InsuranceDesignListImpl() {
		this.dao = new InsuranceDesignDao();
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
		boolean result = false;
		if(((InsuranceDesignDao) this.dao).create(insuranceDesign))
			result = insuranceDesignList.add(insuranceDesign);
		return result;
	}

	@Override
	public boolean delete(String insuranceDesignID) {
		boolean result = false;
		if(((InsuranceDesignDao) this.dao).delete(insuranceDesignID)) {
			int index = indexOf(insuranceDesignID);
			if(index != -1) {
				insuranceDesignList.remove(index);
				result = true;
			}
		}
		return result;
	}

	@Override
	public InsuranceDesign get(String data, int type) {
		switch(type) {
			case 1:
				for(InsuranceDesign insuranceDesign : this.insuranceDesignList)
					if(insuranceDesign.getId().equals(data)) return insuranceDesign;
			case 2:
				for(InsuranceDesign insuranceDesign : this.insuranceDesignList)
					if(insuranceDesign.getInsuranceName().equals(data)) return insuranceDesign;
			default:
				return null;
		}
	}
	
	public ArrayList<InsuranceDesign> getAll() {
		this.insuranceDesignList =((InsuranceDesignDao) this.dao).retrieveAll();
		return insuranceDesignList;
	}

	@Override
	public boolean update(InsuranceDesign insuranceDesign) {
		int index = indexOf(insuranceDesign.getId());
		if(index == -1)
			return false;
		this.insuranceDesignList.set(index, insuranceDesign);
		if(this.insuranceDesignList.get(index).equals(insuranceDesign)) {
			return true;
		}
		return false;
	}
	
	public int indexOf(String designID) {
		for(int i = 0; i < this.insuranceDesignList.size(); i++) {
			if(this.insuranceDesignList.get(i).getId().equals(designID))
				return i;
		}
		return -1;
	}

}
