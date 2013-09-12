package vServices;

import vClass.ClassDAO;
import vClass.Operation;
import vClass.Player;

public class SavePlayer implements Operation<Player> {
	private String position;
	private int score;
	private String name;
    

	public SavePlayer (String position, int score,String name) {
		super();
		this.position=position;
		this.score=score;
		this.name=name;
	}


	public Player execute() {
		Player p = new Player(position,score,name);
		new ClassDAO<Player>(Player.class).save(p);
		return p;
	}






}
