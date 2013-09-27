package vServices;

import java.util.List;
import java.util.Map;

import vClass.ClassDAO;
import vClass.Operation;
import vClass.Player;
import vClass.Team;

public class CreateTeam implements Operation<Team>{
	private List<Player> players;
	private Map<String, Integer> formations;
	private List<Player> actualFormation;
	private String name;
	
	public CreateTeam(List<Player> players, Map<String, Integer> formations, 
					   List<Player> actualFormation, String name){
		this.players = players;
		this.formations = formations;
		this.name = name;
		this.actualFormation = actualFormation;
	}
	
	public Team execute() {
		Team j = new Team(players, formations, actualFormation,name);
		new ClassDAO<Team>(Team.class).save(j);
		return j;
	}
}
