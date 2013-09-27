package vClass;

import java.util.Calendar;

public class RoundTripGame extends Game {
	
	
	protected RoundTripGame() {
		super();
	}
	
	public RoundTripGame(Calendar d,Team teamone,Team teamtwo,int id_game){
		super();
		this.setDate(d);
		this.setId_game(id_game);
		this.setTeamone(teamone);
		this.setTeamtwo(teamtwo);
	}
	
	
	
public Team winnerPenalties(){
		
		double scoreT1 = this.getTeamone().score() * (Math.random() / 5 + 0.9);
		double scoreT2 = this.getTeamtwo().score() * (Math.random() / 5 + 0.9);
		
		if(scoreT1 > scoreT2)
			return this.getTeamone();
		return this.getTeamtwo();
	}
	
	@Override
    public Team getWinner(){
		
		Result resultMatch = this.startGame();
		Result resultSecondMatch = this.startGame();
		if (resultMatch == Result.local && resultMatch == resultSecondMatch ){
			this.setWinner(this.getTeamone());
			return this.getTeamone();
		}
		if(resultMatch == Result.visitor && resultMatch == resultSecondMatch ){
			this.setWinner(this.getTeamtwo());
			return this.getTeamtwo();
		}	
		this.setWinner(this.winnerPenalties());
		return this.winnerPenalties();
	}

}
