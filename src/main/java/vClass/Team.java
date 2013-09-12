package vClass;

import java.util.List;
import java.util.Map;


public class Team {
	
	private List<Player> players;
	private Map<String, Integer> formations;
	private List<Player> actualFormation;
	
	public Team(){
		
	}
	
	public Team(List<Player> players, Map<String, Integer> formations,
			List<Player> actualFormation) {
		super();
		this.players = players;
		this.formations = formations;
		this.actualFormation = actualFormation;
	}

	

	public List<Player> getPlayers() {
		return players;
	}



	public void setPlayers(List<Player> players) {
		this.players = players;
	}



	public Map<String, Integer> getFormations() {
		return formations;
	}



	public void setFormations(Map<String, Integer> formations) {
		this.formations = formations;
	}



	public List<Player> getActualFormation() {
		return actualFormation;
	}



	public void setActualFormation(List<Player> actualFormation) {
		this.actualFormation = actualFormation;
	}

	public int score(){
		
		int score = 0;
		for(Player each: this.getActualFormation()){
			score += each.getScore();
		}
		return score;
	}


}
