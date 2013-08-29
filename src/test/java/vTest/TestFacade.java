package vTest;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import vClass.Email;
import vClass.EmailSender;
import vClass.Facade;
import vClass.Home;
import vClass.User;

public class TestFacade {
	
	Facade facade;
	Email email;
	Home mHome;
	EmailSender sender;
	User user;
	
	@Before
	public void setUp(){
		mHome = mock(Home.class);
		sender = mock(EmailSender.class);
		facade = new Facade(mHome,sender);
		user = mock(User.class);
		when(user.getEmail()).thenReturn("sarasa");
		email = mock(Email.class);
		when(email.getSubject()).thenReturn("sarasa");
		
	}

	@Test
	public void testregisterUser() {
		facade.registerUser(user);
		verify(mHome).saveUser(user);
	}
	
	@Test
	public void testsendEmail(){
		facade.sendEmail(user);
		verify(sender).sendEmail(any(Email.class));
	}
	
	@Test
	public void testchangePassword() throws Exception{
		facade.changePassword("lala", "hola", "quetal");
		verify(mHome).changePassword("lala", "hola", "quetal");
	}
	
	@Test
	public void testgetUser(){
		facade.getUser(user);
		verify(mHome).getUser(user);
	}
	

}
