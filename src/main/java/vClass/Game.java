package vClass;

import java.sql.Date;

public abstract class Game {

	Date d;
	private Team teamone;
	private Team teamtwo;

	private int id;
	
	
	public Date getD() {
		return d;
	}


	public void setD(Date d) {
		this.d = d;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	protected Game(){
	}
	
	
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
