package vServices;


import vClass.ClassDAO;
import vClass.Operation;
import vClass.Player;
import vClass.SessionManager;

public class PlayerManager{
	
	public Player executeGet(String name) {
		return SessionManager.runInSession(new AskForPlayer(name));
	}
	
	public void executeSave(String position, int score, String name) {
		 SessionManager.runInSession(new SavePlayer(position, score, name));
	}
	
	public void delete(final String name){
		SessionManager.runInSession(new Operation<Player>() {
			public Player execute() {
			     new ClassDAO<Player>(Player.class).delete(name);
			     return null;
			}
		});
	}
}
