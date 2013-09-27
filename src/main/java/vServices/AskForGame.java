package vServices;

import java.util.List;

import vClass.ClassDAO;
import vClass.Game;
import vClass.Operation;
import vClass.SimpleGame;

public class AskForGame implements Operation<Game> {
	
	private int id;
	private int ID_GAME;
	
    public AskForGame(int id_game){
    	this.ID_GAME = id_game;
    	
    }
	public Game execute() {
		Game game =  new ClassDAO<Game>(Game.class).uniqueValue(ID_GAME);
		return game;	
	}
	
	public List<SimpleGame> askForSimpleGame(){
		List<SimpleGame> games = new ClassDAO<SimpleGame>(SimpleGame.class).getAll();
				return games;
	} 

	
}
