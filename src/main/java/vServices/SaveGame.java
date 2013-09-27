package vServices;

import vClass.ClassDAO;
import vClass.Game;
import vClass.Operation;

public class SaveGame implements Operation<Game> {

	 private Game game;

	public SaveGame(Game game){
		this.game = game;
	 }
	 
	 public Game execute(){
		new ClassDAO<Game>(Game.class).save(game);
		return game;
	 }

}
