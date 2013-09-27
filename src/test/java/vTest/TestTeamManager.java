package vTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vClass.Operation;
import vClass.Player;
import vClass.SessionManager;
import vClass.Team;
import vServices.CreateTeam;
import vServices.GameManager;
import vServices.TeamManager;

public class TestTeamManager {
	
      Player p;
      Player p2;
      Player p3;
      Map<String,Integer> formations = new HashMap<String, Integer>();
      ArrayList<Player> players = new ArrayList<Player>();
      ArrayList<Player> actualFormation = new ArrayList<Player>();
      TeamManager teamManager = new TeamManager();
	
	@Before
	public void setUp(){
		p = new Player("GoalKepper",12,"Smith");
		p2 = new Player("WaterBoy",1,"Riquelme");
		p3 = new Player("WaterBoy",1,"Palermo");
		String name = "Boca";
		formations.put("GoalKepper", 1);
		formations.put("WaterBoy",2);
		players.add(p);
		players.add(p2);
		players.add(p3);
		actualFormation.add(p);
		actualFormation.add(p2);
		actualFormation.add(p3);
		
		SessionManager.runInSession(new CreateTeam(players,formations,actualFormation,name));
	}
	
	@Test
	public void testexecuteGet() {
		Team team = teamManager.executeGet("Boca");
		assertEquals(team.getName(),"Boca");
		assertEquals(team.getPlayers().size(),3);
	}
	
	@After
	public void tearDown(){
		final Team team = teamManager.executeGet("Boca");
		SessionManager.runInSession(new Operation<Object>() {
			
			public Object execute(){
				SessionManager.getSession().delete(team);
				return null;
			}
		});
	}

}
