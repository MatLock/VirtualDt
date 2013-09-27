package vClass;

import java.sql.Date;
import java.util.Calendar;

public abstract class Game {

	Calendar date;
	private Team teamone;
	private Team teamtwo;
    private long id;
    private int id_game;
	private Team winner;
	


	public Calendar getDate() {
		return date;
	}


	public void setDate(Calendar date) {
		this.date = date;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
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

	public void setWinner(Team winner) {
		this.winner = winner;
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


	public int getId_game() {
		return id_game;
	}


	public void setId_game(int id_game) {
		this.id_game = id_game;
	}

}
