package vServices;

import java.util.List;

import vClass.ClassDAO;
import vClass.Game;
import vClass.MatchDate;
import vClass.Operation;
import vClass.SessionManager;

public class MatchManager {
	
	@SuppressWarnings("unchecked")
	public <T extends MatchDate> T executeGet(int match){
		return (T) SessionManager.runInSession(new AskForMatch(match));
	}
	
	public void executeSave(List<Game> games, int match){
		SessionManager.runInSession(new SaveMatch(games, match));
	}
	
	public void delete(final int match){
		SessionManager.runInSession(new Operation<MatchDate>(){
			
	      public MatchDate execute(){
	    	 new ClassDAO<MatchDate>(MatchDate.class).delete(match);
	    	 return null;
	      }
		});
	}
	
}
