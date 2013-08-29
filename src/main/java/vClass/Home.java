package vClass;

public abstract class Home {

	public abstract User getUser(User user);
	public abstract void saveUser(User user);
	public abstract void changePassword(String userName,String oldPassword,String newPassword);
	
}
