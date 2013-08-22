package vClass;

import java.util.Calendar;

public class User {private String username;
private Calendar birth;
private String name;
private String lastName;
private String email;
private String password;

  
public User(String username, Calendar birth, String name, String lastName,String email,String password) {
	super();
	this.username = username;
	this.birth = birth;
	this.name = name;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
}



public User() {
	// TODO Auto-generated constructor stub
}



public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public Calendar getBirth() {
	return birth;
}
public void setBirth(Calendar birth) {
	this.birth = birth;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
	
	

}
