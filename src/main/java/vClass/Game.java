package vClass;

import java.sql.Date;

public class Game {

	Date d;
	
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



	public Team getWinner(Team local, Team visitor) {
		
		Team winner=null;
		
		if(this.startGame(local, visitor) == Result.local) {
			winner = local;
		}
		
		if(this.startGame(local, visitor) == Result.visitor) {
			winner = visitor;
		}
		
		return winner;
		
	}


}
