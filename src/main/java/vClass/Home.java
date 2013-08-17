package vClass;

public abstract class Home {

	public abstract User getUser(User user) throws Exception;
	public abstract void saveUser(User user)throws Exception;
	public abstract void changePassword(String userName,String oldPassword,String newPassword) throws Exception;
}
