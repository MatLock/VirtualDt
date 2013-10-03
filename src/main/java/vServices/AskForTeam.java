package vServices;

import vClass.ClassDAO;
import vClass.Operation;
import vClass.Team;



public class AskForTeam implements Operation<Team> {
	
    private int id;
    private String name;     
	
	public AskForTeam(String name){
		super();
		this.name = name;
	}
	
	public Team execute() {
		Team p;
		p = new ClassDAO<Team>(Team.class).get(name);
		return p;
	}
	
	
}
