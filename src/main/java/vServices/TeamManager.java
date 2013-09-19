package vServices;

import java.util.List;
import java.util.Map;

import vClass.Player;
import vClass.SessionManager;
import vClass.Team;

public class TeamManager {
	
	public Team askForTeam(int id) {
		return SessionManager.runInSession(new AskForTeam(id));
	}

	public void createTeam(List<Player> players, Map<String, Integer> formations, 
			   List<Player> actualFormation) {
		
		SessionManager.runInSession(new CreateTeam(players, formations, actualFormation));
	}

	public Team ModifyTeam(List<Player> players, Map<String, Integer> formations, 
			   List<Player> actualFormation) {
		
		return SessionManager.runInSession(new ModifierTeam(players, formations, actualFormation));
	}
}
