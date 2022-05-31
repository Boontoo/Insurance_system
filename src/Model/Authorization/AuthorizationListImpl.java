package Model.Authorization;

import java.util.ArrayList;

public class AuthorizationListImpl implements AuthorizationList{

	private ArrayList<Authorization> authorizationList;
	
	public AuthorizationListImpl() {
		authorizationList = new ArrayList<Authorization>();
	}

	public void finalize() throws Throwable {
		
	}
	
	@Override
	public boolean add(Authorization authorization) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String authorizationID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Authorization get(String authorizationID) {
		// TODO Auto-generated method stub
		return null;
	}

}
