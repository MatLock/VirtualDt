package vServices;

import java.util.List;

import vClass.ClassDAO;
import vClass.MatchDate;
import vClass.Operation;
import vClass.SessionManager;
import vClass.Tournament;

public class TournamentManager {

	@SuppressWarnings("unchecked")
	public <T extends Tournament> T executeGet(int id_tournament){
		return (T) SessionManager.runInSession(new AskForTournament(id_tournament));
	}
	
	public void executeSave(List<MatchDate> fixture, int id){
		SessionManager.runInSession(new SaveTournament(fixture,id));
	}
	
	public void delete(final int id_tournament){
		SessionManager.runInSession(new Operation<Tournament>(){
			
	      public Tournament execute(){
	    	 new ClassDAO<Tournament>(Tournament.class).delete(id_tournament);
	    	 return null;
	      }
		});
	}
}
