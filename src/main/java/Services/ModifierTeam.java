package Services;

import java.util.List;
import java.util.Map;

import vClass.ClassDAO;
import vClass.Operation;
import vClass.Player;
import vClass.Team;

public class ModifierTeam implements Operation<Team>{

	private List<Player> players;
	private Map<String, Integer> formations;
	private List<Player> actualFormation;
	private int id;
	
	public ModifierTeam(List<Player> players, Map<String, Integer> formations, 
			   List<Player> actualFormation){

		this.players = players;
		this.formations = formations;
		this.actualFormation = actualFormation;
	}
	
	public Team execute() {
		Team j = new ClassDAO<Team>(Team.class).get(id);
		j.setPlayers(players);
		j.setActualFormation(actualFormation);
		j.setFormations(formations);
		return j;
	}

}
