package vClass;

import java.util.List;

public class Match {
	
	private int date;
	private List<Game> matches;

	
	
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public List<Game> getMatches() {
		return matches;
	}
	public void setMatches(List<Game> matches) {
		this.matches = matches;
	}
}
