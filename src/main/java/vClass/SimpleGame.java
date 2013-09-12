package vClass;

public class SimpleGame extends Game {

	@Override
	public Team getWinner() {
	
		Team winner=null;
		
		if(this.startGame() == Result.local) {
			winner = this.getTeamone();
		}
		if(this.startGame() == Result.visitor) {
			winner = this.getTeamtwo();
		}
		return winner;		
	}
}
