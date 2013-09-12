package Services;

import vClass.ClassDAO;
import vClass.Operation;
import vClass.Player;

public class AskForPlayer implements Operation<Player> {
     private int id;
     
     
     public AskForPlayer(int id) {
    	 super();
    	 this.id =id;
     }
	public Player execute() {
	     Player p =  new ClassDAO<Player>(Player.class).get(id);
	     return p;	
	}

}
