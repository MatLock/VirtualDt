package vTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import dExceptions.*;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import vClass.Facade;
import vClass.MemoryHome;
import vClass.User;
import dExceptions.UserAlreadyExistException;


public abstract class TestHome {
	Facade f;
	MemoryHome h;
	Calendar c;
	User u;
	User u2;

	@Before
	public abstract void setUp();

	
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
	public void testgetUser() throws Exception{
		h.saveUser(u);
		assertEquals(h.getUser(u),u);	
	}
	
	@Test
	public void testgetUserFailed() throws Exception{
		try{
			assertEquals(h.getUser(u),u);
			fail ("Exception not captured !");
		}catch (UserDoNotExistException e){
			
		}
	}
	
	@Test
	public void testchangePassword() throws Exception{
		h.saveUser(u);
		h.changePassword("MatLock", "esdificil","esmasdificil");
		assertEquals(u.getPassword(),"esmasdificil");	
	}

}