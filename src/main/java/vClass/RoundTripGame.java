package vClass;

public class RoundTripGame extends Game {
	
	
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
		if (resultMatch == Result.local && resultMatch == resultSecondMatch )
			return this.getTeamone();
		if(resultMatch == Result.visitor && resultMatch == resultSecondMatch )
			return this.getTeamtwo();
		return this.winnerPenalties();
	}

}
