package Services;


import vClass.Player;
import vClass.SessionManager;

public class PlayerManager{
	
	public Player executeGet(int id) {
		return SessionManager.runInSession(new AskForPlayer(id));
	}
	
	public void executeSave(String position, int score, String name, int id) {
		 SessionManager.runInSession(new SavePlayer(position, score, name, id));
		}
	

}
