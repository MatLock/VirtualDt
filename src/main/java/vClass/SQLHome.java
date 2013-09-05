package vClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import vExceptions.IncorrectPasswordException;
import vExceptions.SamePasswordException;
import vExceptions.UserAlreadyExistException;
import vExceptions.UserDoesNotExistException;



public class SQLHome extends Home {
	
	@Override
	public User getUser(User user){
		try {
		Connection conn = new DBConnector().getConnection();
		PreparedStatement prepareStatement = conn.prepareStatement("SELECT * FROM USER WHERE USERNAME = ?");
		prepareStatement.setString(1,user.getUsername());
		ResultSet result = prepareStatement.executeQuery();

		if (result.next()){
			User x = new User();
			x.setName(result.getString("NAME"));
			x.setEmail(result.getString("EMAIL"));
			x.setPassword(result.getString("PASSWORD"));
			x.setUsername(result.getString("USERNAME"));
			Calendar cal = Calendar.getInstance();
			cal.setTime(result.getDate("BIRTH"));
			x.setBirth(cal);
			x.setLastName(result.getString("LASTNAME"));
			return x;
		   } else{
			   throw new UserDoesNotExistException("User does not exist!");
		   }
		  }  catch (SQLException e){
			  throw new RuntimeException(e);
	      }
		}
	@Override
	public void saveUser(User user){
		
		try {
			Connection conn = new DBConnector().getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO USER (NAME,USERNAME,EMAIL,PASSWORD,LASTNAME,BIRTH) VALUES (?,?,?,?,?,?)");
			preparedStatement.setString(1,user.getName());
			preparedStatement.setString(2,user.getUsername());
			preparedStatement.setString(3,user.getEmail());
			preparedStatement.setString(4,user.getPassword());
			preparedStatement.setString(5,user.getLastName());
			Calendar cal = Calendar.getInstance();
			preparedStatement.setDate(6, new java.sql.Date(cal.getTime().getTime()));
			
	     preparedStatement.executeUpdate();
		}catch (SQLException e){
			throw new RuntimeException ("Connection error!", e);
		}catch (UserAlreadyExistException e){
			throw new UserAlreadyExistException ("User already exist!");
		}
	}

	@Override
	public void changePassword(String userName, String oldPassword,String newPassword){
  // update!
	  try {
		Connection conn;
		conn = new DBConnector().getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM USER WHERE USERNAME = ?");
		preparedStatement.setString(1,userName);
		ResultSet result = preparedStatement.executeQuery();
		if (result.next()){
			
		String password = result.getString("PASSWORD");
		if (! oldPassword.equals(password)){
			throw new IncorrectPasswordException("Wrong password!!");
		}
		if (newPassword.equals(password)){
			throw new SamePasswordException("Old password and new password are equals");
		}
		Connection conn2 = new DBConnector().getConnection();
		PreparedStatement sta = conn2.prepareStatement("UPDATE USER SET PASSWORD = ? WHERE USERNAME = ? ");
		sta.setString(1,newPassword);
		sta.setString(2,userName);
		sta.executeUpdate();
		
        }
	  }catch (SQLException e) {
		throw new RuntimeException ("Connection error!!",e);
	   }
		
	}

}
