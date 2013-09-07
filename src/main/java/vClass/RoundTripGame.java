package vClass;

public class RoundTripGame extends Game {


	private SimpleGame game1;
	private SimpleGame game2;
	
	public SimpleGame getGame1() {
		return game1;
	}
	public void setGame1(SimpleGame game1) {
		this.game1 = game1;
	}
	public SimpleGame getGame2() {
		return game2;
	}
	public void setGame2(SimpleGame game2) {
		this.game2 = game2;
	}
	
	public RoundTripGame(SimpleGame game1, SimpleGame game2) {
		this.game1 = game1;
		this.game2 = game2;
	}
	
	
	public Team winnerPenalties(Team t1, Team t2){
		
		double scoreT1 = t1.score() * (Math.random() / 5 + 0.9);
		double scoreT2 = t2.score() * (Math.random() / 5 + 0.9);
	
		Team winner;
		
		if(scoreT1 > scoreT2){
			winner = t1;
		}
		
		else {
				winner = t2;
			 }
		
	return winner;
	}
	
	
	
	
	
	public Team getWinner(Team t1, Team t2) {
		
		Team winner1 = this.getGame1().getWinner(t1, t2);
		Team winner2 = this.getGame2().getWinner(t2, t1);
		
		
		Team winnerAll;
		
		if(winner1 == winner2 && winner1 != null) {
		
			winnerAll = winner1;
		}
		
		else {
			
			winnerAll = this.winnerPenalties(t2, t1);
		}
	
		return winnerAll;
	
	}



}
