package vClass;

import java.sql.Date;

public abstract class Game {

	Date d;
	private Team teamone;
	private Team teamtwo;

	public Team getTeamone() {
		return teamone;
	}


	public void setTeamone(Team teamone) {
		this.teamone = teamone;
	}


	public Team getTeamtwo() {
		return teamtwo;
	}


	public void setTeamtwo(Team teamtwo) {
		this.teamtwo = teamtwo;
	}

	public Result startGame(){
		
		double scoreLocal = this.teamone.score() * (Math.random() / 5 + 0.9);
		double scoreVisitor = this.teamtwo.score() * (Math.random() / 5 + 0.9);
		double percentLocal = scoreLocal * 1.15;
		double percentVisitor = scoreVisitor * 1.2;
		
		if((scoreLocal - scoreVisitor) >= percentLocal){
			return Result.local;
		}if((scoreVisitor - scoreLocal) >= percentVisitor){
			return Result.visitor;
		}
		return Result.draw;	
	}
	
	public abstract Team getWinner();

}
