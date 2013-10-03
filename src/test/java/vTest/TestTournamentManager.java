package vTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vClass.Game;
import vClass.MatchDate;
import vClass.Operation;
import vClass.Player;
import vClass.RoundTripGame;
import vClass.SessionManager;
import vClass.Team;
import vClass.Tournament;
import vServices.TournamentManager;

public class TestTournamentManager {
	
	Team t1,t2;
	Calendar date = Calendar.getInstance();
	Player p1,p2,p3,p4;
	MatchDate matchDate;
	ArrayList<Player>players = new ArrayList<Player>();
	List<Player>players2;
	ArrayList<Player>formation = new ArrayList<Player>();
	ArrayList<Player>formation2= new ArrayList<Player>();
	HashMap<String,Integer> formations = new HashMap<String,Integer>();
	HashMap<String,Integer> formations2 = new HashMap<String,Integer>();
	RoundTripGame game;
	List<Game> matches = new ArrayList<Game>();
	int dateMatch = 15;
	TournamentManager tournamentManager = new TournamentManager();
	List<MatchDate> fixture = new ArrayList<MatchDate>();
	
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
		formation2.add(p3);
		formation2.add(p4);
		formations2.put("WaterBoy",1);
		formations2.put("GoalKeeper", 1);
		t1 = new Team(players,formations,formation,name);
		t2 = new Team(players2,formations2,formation2,name2);
		game = new RoundTripGame(date,t1,t2,8);
		matches.add(game);
		matchDate = new MatchDate(1, matches);
		fixture.add(matchDate);
		
		tournamentManager.executeSave(fixture, 1);
		
	}
	
	@Test
	public void testgetMatch(){
		Tournament t = tournamentManager.executeGet(1);
		assertEquals((int) t.getId_tournament(), 1);
	}
	
	@After 
	public void tearDown(){
		SessionManager.runInSession(new Operation<Object>(){
			public Tournament execute(){
				final Tournament t = tournamentManager.executeGet(1);
				SessionManager.getSession().delete(t);
				return null;
			}
		});
	}

}
