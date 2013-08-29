package vTest;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dExceptions.IncorrectPasswordException;
import dExceptions.SamePasswordException;
import dExceptions.UserDoesNotExistException;

import vClass.DBConnector;
import vClass.SQLHome;
import vClass.User;

public class TestSQLHome{
	
	 User u;
	 User u2;
	 User u3;
     SQLHome h;
     Calendar c;     
     Connection conn;
    
     
	@Before
	public void setUp() throws SQLException{
	    h = new SQLHome();
		c = Calendar.getInstance();
		u = new User("Starchild", c,"Matthew" ,"Bellamy","Star@gmail.com","esdificil");
		u2 = new User("MatLock", c,"Matthew" ,"Bellamy","Star@gmail.com","esdificil");
		u3 = new User("Pepito", c,"Pepitos" ,"Sarasa","Soymuypro@gmail.com","esdificil");
		conn = new DBConnector().getConnection();
		
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
	
	@After
	public void tearDown() throws SQLException{
		
		PreparedStatement sta = conn.prepareStatement("DELETE FROM `Usuario`.`USER` WHERE `USERNAME`='MatLock'");
		sta.executeUpdate();
		
		PreparedStatement statwo = conn.prepareStatement("DELETE FROM `Usuario`.`USER` WHERE `USERNAME`='Starchild'");
		statwo.executeUpdate();
	}
	
	@Test(expected = UserDoesNotExistException.class)
	public void testfailedgetUser(){
		h.getUser(u3);
  }
	@Test
	public void testgetUser(){
		User x = h.getUser(u2);
		assertEquals(x.getUsername(),"MatLock");
	}
	
	@Test
	public void testsaveUser(){
		h.saveUser(u);
		User newUser = h.getUser(u);
		assertEquals(u.getUsername(),newUser.getUsername());
	}
	
	@Test
	public void changePassword(){
		h.saveUser(u);
		h.changePassword(u.getUsername(),u.getPassword(), "soypolenta");
		assertEquals(h.getUser(u).getPassword(),"soypolenta");
	}
	
	@Test(expected = IncorrectPasswordException.class)
	public void testfailedchangePassword(){
		h.saveUser(u);
		h.changePassword(u.getUsername(), "lapusemal", "soypolenta");
	}
	
	@Test
	public void testfailedChangePassword(){
		h.saveUser(u);
		try{
			h.changePassword(u.getUsername(), u.getPassword(), u.getPassword());
			fail ("Exception not captured");
		}catch (SamePasswordException e){
			
		}
	}
	
	
}
	
