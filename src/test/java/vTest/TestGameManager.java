package vTest;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.hibernate.mapping.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vClass.Game;
import vClass.Operation;
import vClass.Player;
import vClass.RoundTripGame;
import vClass.SessionManager;
import vClass.SimpleGame;
import vClass.Team;
import vServices.GameManager;
import vServices.SaveGame;
import vServices.SavePlayer;

public class TestGameManager {
	
	Team t1,t2;
	Calendar date = Calendar.getInstance();
	Player p1,p2,p3,p4;
	GameManager gameManager = new GameManager();
	ArrayList<Player>players = new ArrayList<Player>();
	List<Player>players2;
	ArrayList<Player>formation = new ArrayList<Player>();
	ArrayList<Player>formation2= new ArrayList<Player>();
	HashMap<String,Integer> formations = new HashMap<String,Integer>();
	HashMap<String,Integer> formations2 = new HashMap<String,Integer>();
	RoundTripGame game;
	SimpleGame game2;
	
	@Before
	public void setUp(){
		p1 = new Player("GoalKeper",12,"Smith");
		p2 = new Player("WaterBoy",1,"Riquelme");
		p3 = new Player("WaterBoy",1,"Palermo");
		p4 = new Player("GoalKeeper",3,"Pepito");
		String name = "Boca";
		String name2 = "River";
		formations.put("GoalKepper", 1);
		formations.put("WaterBoy",2);
		players.add(p1);
		players.add(p2);
		players2 = Arrays.asList(p3,p4);
		formation.add(p1);
		formation.add(p2);
		formation.add(p3);
		formation.add(p4);
		formations2.put("WaterBoy",1);
		formations2.put("GoalKeeper", 1);
		t1 = new Team(players,formations,formation,name);
		t2 = new Team(players2,formations2,formation2,name2);
	//	game2 = new SimpleGame(date,t1,t2,9);
		game = new RoundTripGame(date,t1,t2,8);
		
		SessionManager.runInSession(new SaveGame(game));
	//	SessionManager.runInSession(new SaveGame(game2));
		
	}
	
	@Test
	public void testexecuteGet(){
	//	SimpleGame game =  gameManager.executeGet(8);
		RoundTripGame gam2 = gameManager.executeGet(8);
		assertEquals(game.getId_game(),8);
		assertEquals(game.getTeamone().getName(),"Boca");
	//	assertEquals(gam2.getId_game(),8);
	//	assertEquals(gam2.getTeamtwo().getName(),"River");
	}
	
	@After
	public void tearDown(){
	//	final SimpleGame game = gameManager.executeGet(9);
		final RoundTripGame gam2 = gameManager.executeGet(8);
		SessionManager.runInSession(new Operation<Object>(){
			
			public Game execute(){
			//	SessionManager.getSession().delete(game);
				SessionManager.getSession().delete(gam2);
				return null;
			}
		});
	}

}
