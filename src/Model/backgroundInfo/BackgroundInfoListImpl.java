package Model.backgroundInfo;

import java.util.ArrayList;

import dao.BackgroundInfoDao;
import dao.Dao;

public class BackgroundInfoListImpl implements BackgroundInfoList {

	private ArrayList<BackgroundInfo> backgroundInformationList;
	private Dao dao;
	
	public BackgroundInfoListImpl() {
		this.dao = new BackgroundInfoDao();
		backgroundInformationList = new ArrayList<BackgroundInfo>();
	}

	public void finalize() throws Throwable {

	}
	
	@Override
	public boolean add(BackgroundInfo backgroundInformation) {
		// TODO Auto-generated method stub
		for(BackgroundInfo exInsuranceProductDevelopmentInformation : backgroundInformationList) {
			if(exInsuranceProductDevelopmentInformation.getId().equals(backgroundInformation.getId()))
				return false;
		}
		boolean result = false;
		if(((BackgroundInfoDao) this.dao).create(backgroundInformation))
			result = backgroundInformationList.add(backgroundInformation);
		return result;
	}

	@Override
	public boolean delete(String insuranceProductDevelopmentInformationID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BackgroundInfo get(String insuranceProductDevelopmentInformationID) {
		// TODO Auto-generated method stub
		int index = indexOf(insuranceProductDevelopmentInformationID);
		if(index != -1) return backgroundInformationList.get(index);
		return null;
	}

	private int indexOf(String insuranceProductDevelopmentInformationID) {
		for(int i = 0; i < backgroundInformationList.size(); i++) {
			if(backgroundInformationList.get(i).getId().equals(insuranceProductDevelopmentInformationID))
				return i;
		}
		return -1;
	}

}
