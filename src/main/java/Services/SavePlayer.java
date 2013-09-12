package Services;

import vClass.ClassDAO;
import vClass.Operation;
import vClass.Player;

public class SavePlayer implements Operation<Player> {
	private String position;
	private int score;
	private String name;
    private int id;
    

	public SavePlayer (String position, int score,String name, int id) {
		super();
		this.position=position;
		this.score=score;
		this.name=name;
		this.id=id;
	}


	public Player execute() {
		Player p = new Player(position,score,name,id);
		new ClassDAO<Player>(Player.class).save(p);
		return p;
	}






}
