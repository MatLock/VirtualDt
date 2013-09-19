package vTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vClass.Operation;
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
		Player player = playerManager.executeGet("Hannah");
		assertEquals("Hannah",player.getName());
	}
	
	@After
	public void tearDown(){ 
		final Player player = playerManager.executeGet("Hannah");
		SessionManager.runInSession(new Operation<Object>(){

			public Object execute() {	
				SessionManager.getSession().delete(player);
				return null;
			}
			
		});
		
	}
	

}
