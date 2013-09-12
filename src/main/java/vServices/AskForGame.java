package vServices;

import vClass.Game;
import vClass.Operation;
import vClass.Player;

public class AskForGame implements Operation<Game> {
	
	private int id;
	
	public AskForGame(int id){
		this.id = id;
	}
	

	public Game execute() {
		 // wait!!
//		Game = new Game();
		return null;
		
	}

	
}
