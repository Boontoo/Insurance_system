package Model.SubmitUser;

public interface SubmitUserList {
	// 새로 만든 인터페이스(22.06.03)
	public SubmitUser get(String id);
	public SubmitUser get(int index);
	public boolean add(SubmitUser submitUser);
	public boolean delete(SubmitUser submitUser);
}
