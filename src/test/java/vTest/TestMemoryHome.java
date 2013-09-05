package vTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;


import vClass.MemoryHome;
import vClass.User;
import vExceptions.UserAlreadyExistException;
import vExceptions.UserDoesNotExistException;


public class TestMemoryHome{
	
	MemoryHome h;
	Calendar c;
	User u;
	User u2;
	
	@Before
	public void setUp(){
		 h = new MemoryHome();
		 c = Calendar.getInstance();
		 u = new User("MatLock", c,"Matthew" ,"Bellamy","Star@gmail.com","esdificil");
		 u2 = new User("Sherlock", c,"Charles" ,"Dawson","Child@gmail.com","esfacil");
	}
	
	@Test
	public void testsaveUser() throws Exception {
	    h.saveUser(u);
	    assertEquals(h.getUsers().size(),1);
	}
	
	@Test
	public void testsaveUserFailed()throws Exception{
		this.h.saveUser(u);
		try{
			h.saveUser(u);
			fail ("fail!");
			fail ("Exception not captured !");
		}catch (UserAlreadyExistException u){
			
		}
	}
	
	@Test
	public void testgetUser(){
		h.saveUser(u);
		assertEquals(h.getUser(u),u);	
	}
	
	@Test
	public void testgetUserFailed(){
		try{
			assertEquals(h.getUser(u),u);
			fail ("Exception not captured !");
		}catch (UserDoesNotExistException e){
			
		}
	}
	
	@Test
	public void testchangePassword(){
		h.saveUser(u);
		h.changePassword("MatLock", "esdificil","esmasdificil");
		assertEquals(u.getPassword(),"esmasdificil");	
	}
	
}