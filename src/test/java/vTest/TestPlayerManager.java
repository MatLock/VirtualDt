package vTest;

import static org.junit.Assert.*;

import org.hibernate.classic.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vClass.Player;
import vClass.SessionManager;
import vServices.PlayerManager;
import vServices.SavePlayer;

public class TestPlayerManager {
    
	PlayerManager playerManager = new PlayerManager();
	
	@Before
	public void SetUp(){
		SessionManager.runInSession(new SavePlayer("archer",12,"Hannah"));
	}
	
	@Test
	public void testexecuteGet(){
		assertEquals("Hannah",playerManager.executeGet("Hannah").getName());
	}
	
	@After
	public void tearDown(){
		Player p = playerManager.executeGet("Hannah");
		SessionManager.getSession().delete(p);
	}

}
