package vClass;

import java.util.Calendar;

public class Facade {

private Home Mhome;
private EmailSender sender;
	
	public Facade(Home mhome,EmailSender sender) {
		super();
		this.Mhome = mhome;
		this.sender = sender;
	}
	
	public void sendEmail(User user){
		
		double i = (Math.random() * 500);
		Email email1 = new Email(" Verification code  ",user.getEmail()," VirtualDt@EAGAMES.COM  ",
	    "Hi! this is your verification code  " + 
		i + "  please do not reply this Email...");
		
		sender.sendEmail(email1);
	}

	/* Don't use this method */
	public void registerUser(String username, Calendar birth, String name, String lastName,
			                 String email,String password) throws Exception{
		
		User x = new User(username,birth,name,lastName,email,password);
		Mhome.saveUser(x);
		this.sendEmail(x);
	}
	
	public User getUser(User u){
		return Mhome.getUser(u);
	}
	
	public void registerUser(User u){
		Mhome.saveUser(u);
		this.sendEmail(u);
	}
	
	public void changePassword(String userName,String oldPassword, String newPassword)throws Exception{
		Mhome.changePassword(userName,oldPassword,newPassword);
	}
	
	
}
