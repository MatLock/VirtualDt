package vServices;

import java.util.List;
import java.util.Map;

import vClass.Player;
import vClass.SessionManager;
import vClass.Team;

public class TeamManager {
	
	public Team executeGet(String name) {
		return SessionManager.runInSession(new AskForTeam(name));
	}

	public void createTeam(List<Player> players, Map<String, Integer> formations, 
			   List<Player> actualFormation, String name) {
		
		SessionManager.runInSession(new CreateTeam(players, formations, actualFormation,name));
	}
}
