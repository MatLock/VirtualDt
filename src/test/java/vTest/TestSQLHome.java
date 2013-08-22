package vTest;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import dExceptions.UserDoNotExistException;

import vClass.DBConnector;
import vClass.SQLHome;
import vClass.User;

public class TestSQLHome{
	
	 User u;
	 User u2;
     SQLHome h;
     Calendar c;     
     Connection conn;
    
     
	@Before
	public void setUp() throws SQLException{
	    h = new SQLHome();
		c = Calendar.getInstance();
		u = new User("Starchild", c,"Matthew" ,"Bellamy","Star@gmail.com","esdificil");
		u2 = new User("MatLock", c,"Matthew" ,"Bellamy","Star@gmail.com","esdificil");
		conn = new DBConnector().getConnection();
		
		PreparedStatement sta = conn.prepareStatement("DELETE FROM `Usuario`.`USER` WHERE `USERNAME`='MatLock'");
		sta.executeUpdate();
		
		PreparedStatement statement =
		conn.prepareStatement("INSERT INTO USER (NAME,USERNAME,EMAIL,PASSWORD,LASTNAME,BIRTH) VALUES (?,?,?,?,?,?)");
		    
		statement.setString(1,"Matthew");
		statement.setString(2,"MatLock");
		statement.setString(3,"Star@gmail.com");
		statement.setString(4,"esdificil");
		statement.setString(5,"Bellamy");
		Calendar cal = Calendar.getInstance();
		statement.setDate(6, new java.sql.Date(cal.getTime().getTime()));
		
		statement.executeUpdate();
	}
	
	@Test(expected= UserDoNotExistException.class)
	public void testfailedgetUser(){
		h.getUser(u);
  }
	@Test
	public void testgetUser(){
		User x = h.getUser(u2);
		assertEquals(x.getUsername(),"MatLock");
	}
}
	
