package vServices;


import vClass.ClassDAO;
import vClass.Operation;
import vClass.Tournament;

public class AskForTournament implements Operation<Tournament>{
	
	private int ID_TOURNAMENT;
	
    public AskForTournament(int id_tournament){
    	this.ID_TOURNAMENT = id_tournament;
    	
    }
    
	public Tournament execute() {
		Tournament tournament =  new ClassDAO<Tournament>(Tournament.class).uniqueValue(ID_TOURNAMENT,"id_tournament");
		return tournament;	
	}
	
}
