package vClass;

import java.util.Calendar;

public class Facade {

private Home Mhome;
	
	// FEDE GATO
	public Facade(Home mhome) {
		super();
		Mhome = mhome;
	}

	public void registerUser(String username, Calendar birth, String name, String lastName,
			                 String email,String password) throws Exception{
		
		User x = new User(username,birth,name,lastName,email,password);
		Mhome.saveUser(x);
	}
	
	public User getUser(User u) throws Exception{
		return Mhome.getUser(u);
	}
	
	public void registerUser(User u) throws Exception{
		Mhome.saveUser(u);
	}
	
	public void changePassword(String userName,String oldPassword, String newPassword)throws Exception{
		Mhome.changePassword(userName,oldPassword,newPassword);
	}
}
