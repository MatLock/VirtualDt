package Services;

import vClass.ClassDAO;
import vClass.Operation;
import vClass.Team;



public class AskForTeam implements Operation<Team> {
	
private int id;
	
	public AskForTeam(int id) {
		super();
		this.id = id;
	}
	
	public Team execute() {
		Team p;
		p = new ClassDAO<Team>(Team.class).get(id);
		return p;
	}
	
	
}
