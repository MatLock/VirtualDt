package vServices;

import vClass.ClassDAO;
import vClass.Operation;
import vClass.Player;

public class AskForPlayer implements Operation<Player> {
     private int id;
     private String name;
     
     
     public AskForPlayer(String name) {
    	 super();
    	 this.name = name;
     }
	public Player execute() {
	     Player p =  new ClassDAO<Player>(Player.class).get(name);
	     return p;	
	}

}
