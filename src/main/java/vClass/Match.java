package vClass;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

public class Match {
	
	private int date;
	private List<Pair<Team,Team>> matches;
	
	
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public List<Pair<Team, Team>> getMatches() {
		return matches;
	}
	public void setMatches(List<Pair<Team, Team>> matches) {
		this.matches = matches;
	}
	
	public Result startGame(Team local, Team visitor){
		
		double scoreLocal = local.score() * (Math.random() / 5 + 0.9);
		double scoreVisitor = visitor.score() * (Math.random() / 5 + 0.9);
		double percentLocal = scoreLocal * 1.15;
		double percentVisitor = scoreVisitor * 1.2;
		
		if((scoreLocal - scoreVisitor) >= percentLocal){
			return Result.local;
		}if((scoreVisitor - scoreLocal) >= percentVisitor){
			return Result.visitor;
		}
		return Result.draw;	
	}
	
	
}
