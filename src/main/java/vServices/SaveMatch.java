package vServices;

import java.util.List;

import vClass.ClassDAO;
import vClass.Game;
import vClass.MatchDate;
import vClass.Operation;

public class SaveMatch implements Operation<MatchDate>{
	
	private int date;
	private List<Game>matches;

	
	public SaveMatch (List<Game>matches,int date){
		this.date = date;
		this.matches = matches;
	}
	public MatchDate execute() {
		MatchDate m = new MatchDate(date,matches); 
		new ClassDAO<MatchDate>(MatchDate.class).save(m);
		return null;
	}

}
