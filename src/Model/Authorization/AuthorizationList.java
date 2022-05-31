package Model.Authorization;

public interface AuthorizationList {

	public boolean add(Authorization authorization);

	public boolean delete(String authorizationID);

	public Authorization get(String authorizationID);
}
