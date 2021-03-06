package vClass;

import java.util.ArrayList;

import vExceptions.*;


public class MemoryHome extends Home{
	
	private ArrayList<User>users = new ArrayList<User>();

	@Override
	public User getUser(User user){
		for (User s : users){
			if (user.equals(s)){
				return s;
			}
		}
		throw new UserDoesNotExistException("user don't exist");		
	}
	
	private User getUser(String userName){
		
	for (User s : users){
		if (s.getUsername().equals(userName)){
			return s;
		}
	}
	throw new UserDoesNotExistException("user don't exist");		
}
	@Override
	public void saveUser(User user) {
		if (users.contains(user)){
			throw new UserAlreadyExistException("user already exist!!!");
		}
		this.users.add(user);	
	}

	@Override
	public void changePassword(String userName, String oldPassword,
			String newPassword){
         User x = this.getUser(userName);
		if (x.getPassword().equals(oldPassword)){
			x.setPassword(newPassword);
		} else {
		    throw new IncorrectPasswordException ("Wrong password!");
	       }
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
}