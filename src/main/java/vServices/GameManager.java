package vServices;



import vClass.ClassDAO;
import vClass.Game;
import vClass.Operation;
import vClass.SessionManager;


public class GameManager {

	@SuppressWarnings("unchecked")
	public <T extends Game> T executeGet(int id_game){
		return (T) SessionManager.runInSession(new AskForGame(id_game));
	}
	
	public void executeSave(Game game){
		SessionManager.runInSession(new SaveGame(game));
	}
	
	public void delete(final int id_game){
		SessionManager.runInSession(new Operation<Game>(){
			
	      public Game execute(){
	    	 new ClassDAO<Game>(Game.class).delete(id_game);
	    	 return null;
	      }
		});
	}
	
	
}
