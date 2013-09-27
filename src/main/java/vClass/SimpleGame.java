package vClass;

import java.sql.Date;
import java.util.Calendar;

public class SimpleGame extends Game {
	
	
	

	protected SimpleGame() {
		super();
	}
	
	public SimpleGame(Calendar d,Team teamone,Team teamtwo,int id_game){
		super();
		this.setDate(d);
		this.setId_game(id_game);
		this.setTeamone(teamone);
		this.setTeamtwo(teamtwo);
	}
	
	

	@Override
	public Team getWinner() {
	
		Team winner=null;
		
		if(this.startGame() == Result.local) {
			winner = this.getTeamone();
		}
		if(this.startGame() == Result.visitor) {
			winner = this.getTeamtwo();
		}
		this.setWinner(winner);
		return winner;		
	}
}
