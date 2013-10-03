package vServices;

import java.util.List;

import vClass.ClassDAO;
import vClass.Game;
import vClass.MatchDate;
import vClass.Operation;

public class AskForMatch implements Operation<MatchDate> {
	
	private long id;
	private int date;
	

	public AskForMatch(int date){
		this.date = date;
	}

	public MatchDate execute() {
		MatchDate m = new ClassDAO<MatchDate>(MatchDate.class).get(date);
		return m;
	}
	

}
