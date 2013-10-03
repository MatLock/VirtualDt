package vClass;

import java.util.List;

public class MatchDate {
	
	private Integer date;
	private List<Game> matches;
	private Long id;
	
	public MatchDate(){
		
	}
	
	public MatchDate(int date,List<Game>matches){
		this.date = date;
		this.matches = matches;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getDate() {
		return date;
	}
	public void setDate(Integer date) {
		this.date = date;
	}
	public List<Game> getMatches() {
		return matches;
	}
	public void setMatches(List<Game> matches) {
		this.matches = matches;
	}
}
