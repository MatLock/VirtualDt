package vClass;

import java.util.List;

public class MatchDate {
	
	private int date;
	private List<Game> matches;
	private int id;
	
	protected MatchDate(){
		
	}
	
	public MatchDate(int date,List<Game>matches){
		this.date = date;
		this.matches = matches;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
