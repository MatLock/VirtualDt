package vTest;

import java.util.Calendar;

import org.junit.Before;

import vClass.MemoryHome;
import vClass.User;


public class TestMemoryHome extends TestHome {
	 // a mi me comitea!!
	// a mi tambien
	@Before
	public void setUp(){
		 h = new MemoryHome();
		 c = Calendar.getInstance();
		 u = new User("MatLock", c,"Matthew" ,"Bellamy","Star@gmail.com","esdificil");
		 u2 = new User("Sherlock", c,"Charles" ,"Dawson","Child@gmail.com","esfacil");
	}
}