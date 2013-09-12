package Services;

import vClass.ClassDAO;
import vClass.Operation;
import vClass.Player;

public class PlayerManager implements Operation<Player> {

	private int id;
	
	public PlayerManager(int id) {
		super();
		this.id = id;
	}
	
	public Player execute() {
		Player p;
		p = new ClassDAO<Player>(Player.class).get(id);
		return p;
	}
}
